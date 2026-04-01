package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class servoPractice extends OpMode {
    /*
    Types of Servos:
        Continuous:
            can turn a full 360 degrees continuously
            use CRServo variable

        Regular(forgot name tbh):
            Servo turns 300 degrees in either direction befor stopping
            use Servo variable

     To switch a servo between modes, you have to use a servo programmer which has its own instruction
     manual put with it (this is a physical thing btw not something in code)
     */

    //Create and Initialize Servos the same as motors, just replace each instance of the DcMotorEx with Servo
    //TO-DO:Create a servo and continuous servo


    @Override
    public void init() {
        //There is less stuff to init for servos, all you need to do is set the direction, so like
        //servo.setDirection(Servo.Direction.FORWARD);
        //hardware map

        // FOR SERVOS:
        //set starting position using servo.setPosition(position) with position being
        //a double between 0 to 1 representing the amount it can turn
        //You can change the maximum and minimum amount it can turn by using Servo.scaleRange(min, max)
        //It will change that original 0 to 1 range into that range, so when you call .setPosition()
        //The double will also be a double that represents a portion of that new range

        //FOR CRServos:
        //set the power using .setPower(num)

        //You can also set negative position or power just like you can for motors
        //TO-DO: init the servos you made
    }

    @Override
    public void init_loop() { //keeps running this between init being pressed and before start is pressed

    }

    @Override
    public void start() {
        //TO-DO: set the position to 0.8 and power to 1 for the respective servos
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {
        //TO-DO: set position to 0 and power to 0 for respective servos
    }
}
