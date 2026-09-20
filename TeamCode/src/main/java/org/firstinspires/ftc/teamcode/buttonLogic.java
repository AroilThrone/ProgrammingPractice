package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class buttonLogic extends OpMode {
    private DcMotorEx shooter;
    private boolean pressingDpadUp = false, pressingRightBumper = false, shooterOn = false, pressingTrigger = false, intakeOn = false, pressingDpadDown = false;
    private int velocity = 1520;
    private double shootPower = 0;
    private PIDCode controller = new PIDCode(0.004, 0, 0.0004);

    @Override
    public void init() {
        shooter = hardwareMap.get(DcMotorEx.class, "shooter");
        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooter.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        //              TURN ON CODE
        //if (the button is not being pressed, pressingDpadUp is false
        if (!gamepad1.dpad_up)
        {
            pressingDpadUp = false;
        }
        //if the button is read as currently being pressed, and was not already being pressed, pressing DpadUp is true
        //Then the previous if statement reverts pressingDpadUp back to false once the button is released
        if (gamepad1.dpad_up && !pressingDpadUp)
        {
            pressingDpadUp = true;
        }
        //In summary, if the button is pressed, turn the shooter on, the button being held affects nothing
        if (pressingDpadUp)
        {
            shooter.setPower(1);
        }


        //              ON-OFF CODE
        //if statements have the same logic as above, but just include a check to see if the shooter is on
        //the if-else if statement exists because this turns the shooter on when it is pressed and
        //then off when pressed again, thus the only difference being !shooterON
        if (!gamepad1.right_bumper)
            pressingRightBumper = false;

        if (gamepad1.right_bumper && !shooterOn && !pressingRightBumper) {
            velocity = 1240;
            shooterOn = true;
            pressingRightBumper = true;
        }
        else if (gamepad1.right_bumper && shooterOn && !pressingRightBumper)
        {
            shooterOn = false;
            pressingRightBumper = true;
        }
        //Below can be read as a simple setPower for now, there is a PID file here
        //if you want to look at it or look up stuff on it
        if (shooterOn)
            shootPower = controller.update(velocity, shooter.getVelocity());
        else
        {
            shootPower = 0;
        }
        shooter.setPower(shootPower);


        //          ON-OFF FOR DOUBLE BASED BUTTONS
        //0 is not pressed at all and 1 is pressed donw fully
        //if the trigger is pressed less than 0.5, the trigger is no longer or not being pressed
        if (gamepad1.right_trigger < 0.5)
            pressingTrigger = false;
        //This follows the same on-off principle of the previous button based on-off code
        if (gamepad1.right_trigger > 0.5 && !intakeOn && !pressingTrigger) {
            intakeOn = true;
            pressingTrigger = true;
        }
        else if (gamepad1.right_trigger > 0.5 && intakeOn && !pressingTrigger) {
            intakeOn = false;
            pressingTrigger = true;
        }

        if (intakeOn) {
            shooter.setPower(0.5);
        }
        else {
            shooter.setPower(0.0);
        }


        //          PRESS AND HOLD CODE
        //stores if dpadDown is being pressed and becomes false if released
        if (gamepad1.dpadDownWasPressed())
        {
            pressingDpadDown = true;
        }
        else if (pressingDpadDown && gamepad1.dpadDownWasReleased())
        {
            pressingDpadDown = false;
        }
        //below is a false safe (i dont remember how well this code worked so might be buggy)
        else if (gamepad1.dpadLeftWasPressed())
        {
            pressingDpadDown = false;
        }
        if (pressingDpadDown)
        {
            shooter.setPower(1);
        }
    }
}
