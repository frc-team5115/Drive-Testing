package com.team5115.statemachines;

import com.team5115.robot.InputManager;
import com.team5115.robot.Robot;
import com.team5115.Constants;

public class HoffDrive extends StateMachineBase {
	
	double speed, turn, throttle;
	double lastTurn = 0;
	
	public void update() {
		switch (state) {
		case 1:
			
			// STATE 1 -- DRIVING
			speed = InputManager.getY();
			turn = InputManager.getX();
			throttle = InputManager.getThrottle();
			
			// Negative intertia. Increasing sensitivity makes it more "repsonsive"
			turn += Const.NEG_INERTIA_SENSITIVITY * (turn - lastTurn);
			
			// Turning in place and quickturn button
			// Keep in mind speed will always be in [-1, 1]
			if (speed == 0 || InputManager.quickTurn())
				Robot.drivetrain.drive(speed + turn, speed - turn, throttle);
			else
				Robot.drivetrain.drive(speed + (speed * turn), speed - (speed * turn), throttle);
			
			break;
		}
	}
	
}