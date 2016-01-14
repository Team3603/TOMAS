
package org.usfirst.frc.team3603.robot; //SAFE WITH BUTTONS, PLEASE DO NOT MESS WITH

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Joystick xbox = new Joystick(0);
	Joystick otherstick = new Joystick(2);
	Victor frontLeft = new Victor(1);
	Victor frontRight = new Victor(2);
	Victor rearLeft = new Victor(3);
	Victor rearRight = new Victor(4);
	RobotDrive maindrive = new RobotDrive(frontLeft,rearLeft,frontRight,rearRight);
	int autoLoopCounter = 0;
	
	
	
	
    
    public void robotInit() {
    	//maindrive.setInvertedMotor(MotorType.kFrontLeft, true);	
    	//maindrive.setInvertedMotor(MotorType.kRearLeft, true);

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	if(autoLoopCounter <1000) {
    		maindrive.mecanumDrive_Polar(.5, 0, 0);
    	}

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	
    	
    	while (isOperatorControl() && isEnabled()) {
    		double xboxmagnitude0 = xbox.getRawAxis(0);
    		double xboxmagnitude1 = xbox.getRawAxis(1);
    		double xboxmagnitude5 = xbox.getRawAxis(5);
    		
    		double all = xboxmagnitude0 + xboxmagnitude1 + xboxmagnitude5;
    		
    		if( all > .2 || all < -.2) { // ||
    		
    		maindrive.mecanumDrive_Cartesian( -xboxmagnitude1, -xboxmagnitude5, xboxmagnitude0, 0);
    		}
    	
    		//maindrive.mecanumDrive_Cartesian(xbox.getRawAxis(1), xbox.getRawAxis(5), xbox.getRawAxis(0), 0);
    		//RobotDrive.mecanumDrive_Cartesian(xbox.getY(), otherstick.getY(), xbox.getX(), 0);
    		
    	
    	if(xbox.getRawButton(4)) { //forward - y button
    		frontLeft.set(.25);
    		frontRight.set(-.25);
    		rearLeft.set(-.25);
    		rearRight.set(.25);
    	}
    	if(xbox.getRawButton(2)) { //strafe right b-button
    		frontLeft.set(-.25);
    		frontRight.set(.25);
    		rearLeft.set(-.25);
    		rearRight.set(.25);
    	}
    	if(xbox.getRawButton(3)) { //strafe left-x button
    		frontLeft.set(.25);
    		frontRight.set(-.25);
    		rearLeft.set(.25);
    		rearRight.set(-.25);
    	}
    	if(xbox.getRawButton(1)) { //backwards - a button
    		frontLeft.set(-.25);
    		frontRight.set(.25);
    		rearLeft.set(.25);
    		rearRight.set(-.25);
    	}
    	if(xbox.getRawButton(5)) {
    		frontLeft.set(.5);
    		frontRight.set(-.5);
    		rearLeft.set(.5);
    		rearRight.set(-.5);
    	}
    	if(xbox.getRawButton(6)) {
    		frontLeft.set(-.5);
    		frontRight.set(.5);
    		rearLeft.set(-.5);
    		rearRight.set(.5);
    	}
     	
    }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
