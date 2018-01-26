
package org.usfirst.frc.team2950.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import org.usfirst.frc.team2950.robot.subsystems.Pneumatics;
import org.usfirst.frc.team2950.robot.subsystems.GearPush;
import org.usfirst.frc.team2950.robot.subsystems.DriveTrain;

import org.usfirst.frc.team2950.robot.commands.Push;
import org.usfirst.frc.team2950.robot.commands.PushBack;
import org.usfirst.frc.team2950.robot.commands.PushAuto;
import org.usfirst.frc.team2950.robot.commands.PushBackAuto;
import org.usfirst.frc.team2950.robot.commands.Up;
import org.usfirst.frc.team2950.robot.commands.UpStop;
import org.usfirst.frc.team2950.robot.commands.CompressorOn;
import org.usfirst.frc.team2950.robot.commands.DriveForwardAuto;
import org.usfirst.frc.team2950.robot.commands.CompressorOff;

import org.usfirst.frc.team2950.robot.commands.DriveAndPushGear;
import org.usfirst.frc.team2950.robot.commands.DriveAndPushGearLeft;
import org.usfirst.frc.team2950.robot.commands.DriveAndPushGearRight;
import org.usfirst.frc.team2950.robot.commands.NoWay;

import org.usfirst.frc.team2950.robot.subsystems.Lift;


import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import org.usfirst.frc.team2950.robot.commands.ExampleCommand;
import org.usfirst.frc.team2950.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

	public static OI oi;
	
	//public static Pneumatics pneumatics;
	//public static GearPush gearPush;
	public static DriveTrain driveTrain;
	public static Lift lift;
	
	
	//CameraServer server;
	
	//Create autonomous commands.
	Command autonomousCommand;
	Command DriveForwardAuto;
	Command DriveAndPushGear;
	Command DriveAndPushGearLeft;
	Command DriveAndPushGearRight;
	Command NoWay;

	public SendableChooser autoChooser;
	public SendableChooser autonomousDirectionChooser;

	SendableChooser<Command> chooser = new SendableChooser<>();
	
	
	/**
	 * Gyro.
	 */
	public ADXRS450_Gyro gyro;
	
	//double angle = gyro.getAngle(); //get the current heading
	
	//double kp = 0.03;
	
	/*public void GyroSample(){
		
	  gyro = new ADXRS450_Gyro(); //gyro on Analog Channel 1
		
	}
	*/

	

	/** This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);

		//Initialize subsystems
		//pneumatics = new Pneumatics();
		//gearPush = new GearPush();
		driveTrain = new DriveTrain();
		lift = new Lift();
		//SmartDashboard.putData(pneumatics);
		//SmartDashboard.putData(gearPush);
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(lift);
		
		
		
		// This MUST be here. If the OI creates Commands (which it very likely
		// will), constructing it during the construction of CommandBase (from
		// which commands extend), subsystems are not guaranteed to be
		// yet. Thus, their requires() statements may grab null pointers. Bad
		// news. Don't move it.
		oi = new OI();
		
		// instantiate the command used for the autonomous period
		autoChooser = new SendableChooser();
		autoChooser.addObject("Drive Forward and Push Gear", new DriveAndPushGear());
		autoChooser.addObject("Drive Forward and Push Gear Left", new DriveAndPushGearLeft());
		autoChooser.addObject("Drive Forward and Push Gear Right", new DriveAndPushGearRight());
		autoChooser.addObject("Drive Forward", new DriveForwardAuto());
		autoChooser.addObject("No Way", new NoWay());
		
		
		SmartDashboard.putData("Aut000", autoChooser);
		
		DriveAndPushGear = new DriveAndPushGear();
		DriveAndPushGearLeft = new DriveAndPushGearLeft();
		DriveAndPushGearRight = new DriveAndPushGearRight();
		DriveForwardAuto = new DriveForwardAuto();
		NoWay = new NoWay();
		
		

		/**
		 * Initiate and calibrate Gyro.
		 */
		try
		{
		 gyro = new ADXRS450_Gyro();
		}
		catch (NullPointerException e)
		{
			gyro = null;
		}
		
		gyro.calibrate();
		
		
		
		
		//gyro.startLiveWindowMode();
		

		
		/**
		 * Use the USBCamera.
		 */
        //UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        //camera.setResolution(640, 480);
		
		/**
		 * This is code that is from the FIRST web site for the camera. It is meant to
		 * process each individual image. We don't need it, but it's nice, and could be
		 * used for furthering the use of the camera if needed.
		 * Update 2/16/2017: It works.
		 */
	   /*
		new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(640, 480);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("cam0", 640, 480);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        }).start();
        */
	    
	}
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	//@Override
	//public void disabledInit() {

	//}

	//This is called periodically while the robot is disabled
	@Override
	public void disabledPeriodic() {
		//Scheduler.getInstance().run();
		log();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		/**
		 * Gyro.
		 */
		/*
		if (Robot.isReal()){
		gyro.reset();
		}
		
		gyro.calibrate();
		
		while (isAutonomous()){
			
			double angle = gyro.getAngle(); //get the current heading
		}
		*/
		
		//autonomousCommand = chooser.getSelected();
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();

		DriveForwardAuto = (Command) autoChooser.getSelected();
		DriveForwardAuto.start();
		
		DriveAndPushGear = (Command) autoChooser.getSelected();
		DriveAndPushGear.start();
		
		DriveAndPushGearLeft = (Command) autoChooser.getSelected();
		DriveAndPushGear.start();
		
		DriveAndPushGearRight = (Command) autoChooser.getSelected();
		DriveAndPushGear.start();
		
		NoWay = (Command) autoChooser.getSelected();
		NoWay.start();
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null){
			autonomousCommand.start();
		}
		
		
		if (DriveAndPushGear != null){
			DriveAndPushGear.start();
		}
		
		
	    
	    if (DriveAndPushGearLeft != null){
		    DriveAndPushGearLeft.start();
	    }
	    
	    
		
	    if (DriveAndPushGearRight != null){
		    DriveAndPushGearRight.start();
	    }
	    
	    
		
		if (DriveForwardAuto != null){
			DriveForwardAuto.start();
		}
		
		
		if (NoWay != null){
			NoWay.start();
		}
		
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null){
			autonomousCommand.cancel();
			
		}
			
			if (DriveAndPushGear != null){
				DriveAndPushGear.cancel();
			}
			
			
			
		    if (DriveAndPushGearLeft != null){
			    DriveAndPushGearLeft.cancel();
		    }
		    
		    
			
		    if (DriveAndPushGearRight != null){
			    DriveAndPushGearRight.cancel();
		    }
		    
			
			
			if (DriveForwardAuto != null){
		       DriveForwardAuto.cancel();
			}
			 
			if (NoWay != null){
			       NoWay.cancel();
				}
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	/**
	 * Log interesting values to the SmartDashboard.
	 */
	private void log() {
		//Robot.pneumatics.writePressure();
		//Robot.pneumatics.writeStatus();
		SmartDashboard.putNumber("Angle", gyro.getAngle());
		
			
		}
	

	}
	

