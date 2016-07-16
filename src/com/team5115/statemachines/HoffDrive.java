package com.team5115.statemachines;

import com.team5115.robot.InputManager;
import com.team5115.robot.Robot;
import com.team5115.Constants;

public class HoffDrive extends StateMachineBase {
	
	double speed, turn, throttle;
	double turnPower;
	double lastSpeed = 0, lastTurn = 0;
	
	public void update() {
		switch (state) {
		case 1:
			
			// STATE 1 -- DRIVING
			speed = InputManager.getY();
			turn = InputManager.getX();
			throttle = InputManager.getThrottle();
			
			// Negative intertia. Increasing constants makes it more "repsonsive"
			speed += Constants.NEG_INTERTIA_SPEED * (speed - lastSpeed);
			turn += Constants.NEG_INERTIA_TURN * (turn - lastTurn);
			
			lastSpeed = speed;
			lastTurn = turn;
			
			// Keep in mind speed and turn will always be in [-1, 1]
			// Use abs of speed for turn rate to turn in same direction forward or backward
			turnPower = Math.abs(speed) * turn;
			
			// Turning in place and quickturn button
			if (speed == 0 || InputManager.quickTurn())
				Robot.drivetrain.drive(speed + turn, speed - turn, throttle);
			else
				Robot.drivetrain.drive(speed + Math.abs(speed) * turn, speed - Math.abs(speed) * turn, throttle);
			
			break;
		}
	}
	
}