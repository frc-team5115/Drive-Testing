
package com.team5115.robot;

import com.team5115.statemachines.ArcadeDrive;
import com.team5115.systems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends IterativeRobot {
	
	public static DriveTrain drivetrain;
	
	public static StateMachine driver;
	public static ArcadeDrive ad;
	public static CarDrive cd;
	public static HoffDrive hd;
	
    public void robotInit() {
    	drivetrain = new DriveTrain();
    	
    	ad = new ArcadeDrive();
		cd = new CarDrive();
		hd = new HoffDrive();
		driver = ad;
    }
    
    public void autonomousInit() {
    	
    }

    public void autonomousPeriodic() {
    	Timer.delay(0.001);
    }
    
    public void teleopInit() {
    	driver.start();
    }
    
    public void teleopPeriodic() {
        driver.update();
        
        Timer.delay(0.001);
    }
    
    public void disabledInit() {
    	driver.end();
    }
    
    public void disabledPeriodic() {
    	Timer.delay(0.001);
    }
    
}
