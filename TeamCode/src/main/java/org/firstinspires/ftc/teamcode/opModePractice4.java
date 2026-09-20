package org.firstinspires.ftc.teamcode;
//#1: write the following imports:
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//#2: add extends OpMode
public class opModePractice4 extends OpMode{
    //#3: declare motor + servo
    private DcMotor motor;
    private Servo servo;

    //#4: initialize the variables
    public void init(){
        motor = hardwareMap.get(DcMotor.class, "motor");
        servo = hardwareMap.get(Servo.class, "servo");
        motor.setDirection(DcMotor.Direction.REVERSE);
        servo.setPosition(0.0);
    }
    public void loop(){
        if(gamepad1.a){
            motor.setPower(1.0);
        }
        else{
            motor.setPower(0.0);
        }

        if(gamepad1.b){
            servo.setPosition(1.0);
        }
        else if(gamepad.x){
            servo.setPosition(0.0);
        }
    }
}
