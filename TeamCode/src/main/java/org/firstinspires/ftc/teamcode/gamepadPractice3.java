package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class gamepadPractice3 extends OpMode {
    //to get the inputs from the controller, use gamepad1.
    //and then select the method depending on what you want to detect is pressed
    //Some of them like the triggers return a number so you have to check if its greater than
    //a double between 0 and 1
    //Note: Don't use the joysticks since they are used for drive
    //Ex: gamepad1.dpadUpWasPressed() which returns a boolean of if dpadup is currently pressed
    //Ex:
//        if (gamepad1.dpadDownWasPressed())
//        {
//            motor.setPower(0.8);
//        }
//        else
//        {
//            motor.setPower(0);
//        }
//   Ex:
//        if (gamepad1.right_trigger > 0.5)
//        {
//            motor2.setPower(0.8);
//        }
//        else
//        {
//            moto2.setPower(0);
//        }
    //TO-DO: create a continuous servo and initialize it to check if a is pressed every loop
    //      and spin clockwise while a is being pressed. Note that you cannot use while loops in loop() method
    //Note: the method only returns if it is pressed, so you have to make booleans and a way to
    //      see if its being held, as the computer runs so fast dpadUpWasPressed returns true several time
    //      in the span you press the button, check buttonLogic for help with this

    @Override
    public void init() {

    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
    }

    @Override
    public void stop() { //Code that runs when we press stop on the driver hub, not really used much

    }
}
