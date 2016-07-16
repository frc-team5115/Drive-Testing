package com.team5115.statemachines;

import com.team5115.robot.InputManager;
import com.team5115.robot.Robot;

public class CarDrive extends StateMachineBase {
	
	double speed, turn, throttle;
	double turnPower;
	
	public void update() {
		switch (state) {
		case 1:
			
			// STATE 1 -- DRIVING
			speed = InputManager.getY();
			turn = InputManager.getX();
			throttle = InputManager.getThrottle();
			
			// Keep in mind speed will always be in [-1, 1]
			// Use abs of speed for turn rate to turn in same direction forward or backward
			turnPower = Math.abs(speed) * turn;
			
			Robot.drivetrain.drive(speed + turnPower, speed - turnPower, throttle);
			
			break;
		}
	}
	
}