package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class gamepadPractice3 extends OpMode {
    //to get the inputs from the controller, use gamepad1.
    //then, select the method depending on what you want to detect is pressed
    //Some of them (like the triggers) return a number so you have to check if it's greater than
    //a double between 0 and 1

    //Note: Don't use the joysticks since they are used for drive
    //Ex: gamepad1.dpadUpWasPressed() returns a boolean of whether dpadup is currently pressed
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

    //TO-DO: Create & initialize a continuous servo. Then, in the loop method, check if a is being pressed.
    // When a is pressed, the servo should spin clockwise.
    //Note #1: you cannot use while loops in the loop() method.
    //Note #2: the method only returns something if a is pressed. So, you must create booleans to see if it's being held down.
    // This is because the computer runs so fast that dpadUpWasPressed returns true several times (check buttonLogic more details on this)
    private CRServo continuousServo = null;
    private boolean aWasPressed = false;
    @Override
    public void init() {
        continuousServo = hardwareMap.get(CRServo.class, "cr_servo");
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        boolean aIsPressed = gamepad1.a;
        if(aIsPressed && !aWasPressed){
            intakeServo.setPower(1.0);
        }
        else if(!aIsPressed && aWasPressed){
            intakeServo.setPower(0.0);
        }
        aWasPressed = aIsPressed;
    }

    @Override
    public void stop() { //Code that runs when we press stop on the driver hub, not really used much

    }
}