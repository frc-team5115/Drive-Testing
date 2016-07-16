package com.team5115.statemachines;

import com.team5115.robot.InputManager;
import com.team5115.robot.Robot;

public class ArcadeDrive extends StateMachineBase {
	
	double speed, turn, throttle;
	
	public void update() {
		switch (state) {
		case 1:
			
			// STATE 1 -- DRIVING
			speed = InputManager.getX();
			turn = InputManager.getY();
			throttle = InputManager.getThrottle();
			
			Robot.drivetrain.drive(speed + turn, speed - turn, throttle);
			break;
			
		}
	}

}
