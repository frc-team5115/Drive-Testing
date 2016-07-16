package com.team5115.statemachines;

import com.team5115.robot.InputManager;
import com.team5115.robot.Robot;

public class CarDrive extends StateMachineBase {
	
	double speed, turn, throttle;
	
	public void update() {
		switch (state) {
		case 1:
			
			// STATE 1 -- DRIVING
			speed = InputManager.getY();
			turn = InputManager.getX();
			throttle = InputManager.getThrottle();
			
			Robot.drivetrain.drive(speed + (speed * turn), speed - (speed * turn), throttle);
			break;
		}
	}
	
}