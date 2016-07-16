package com.team5115.robot;

import edu.wpi.first.wpilibj.Joystick;

import com.team5115.Constants;

public class InputManager {
	
	static Joystick joy = new Joystick(0);
	
	public static double getX() {
		return treatAxis(joy.getX());
	}
	
	public static double getY() {
		return treatAxis(joy.getY());
	}
	
	public static double getThrottle() {
		return (1 - joy.getThrottle()) / 2;
	}
	
	public static boolean quickTurn() {
		return joy.getRawButton(Const.BUTTON_QUICK_TURN);
	}
	
	// Handles squaring and deadband to allow better driver control
	// Squaring gives finer control at low values
	// Deadband ensures a value of zero when joystick is centered
	public static treatAxis(double val) {
		if (val > 0)
			val = Math.pow(val, 2);
		else
			val = -Math.pow(val, 2);
		
		if (Math.abs(val) < Constants.JOYSTICK_DEADBAND)
			val = 0;
		
		return val;
	}

}
