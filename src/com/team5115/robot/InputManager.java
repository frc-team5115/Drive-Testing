package com.team5115.robot;

import edu.wpi.first.wpilibj.Joystick;

import com.team5115.Constants;

public class InputManager {
	
	static Joystick joy = new Joystick(0);
	
	public static double getX() {
		double x = Math.pow(joy.getX(), 2) * Math.signum(joy.getX());
		
		if (x > Const.JOYSTICK_DEADBAND)
			return x
		
		return 0;
	}
	
	public static double getY() {
		double y = Math.pow(joy.getY(), 2) * Math.signum(joy.getY());
		
		if (y > Const.JOYSTICK_DEADBAND)
			return y
		
		return 0;
	}
	
	public static double getThrottle() {
		return (1 - joy.getThrottle()) / 2;
	}
	
	public static boolean quickTurn() {
		return joy.getRawButton(Const.BUTTON_QUICK_TURN);
	}
	
	public static boolean startCommand() {
		return false;
	}

}
