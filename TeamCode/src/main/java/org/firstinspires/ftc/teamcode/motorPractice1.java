package org.firstinspires.ftc.teamcode;

// These are the "Main" imports. There will be more in the future
import com.qualcomm.robotcore.eventloop.opmode.OpMode; // this is the type of operation
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // this is the telop operation


@TeleOp (name = "Motor Practice")  // this is the name foud in the driver station
public class motorPractice1 extends OpMode {
    // we put all motor declerations in here:
    // private or public DcMotor motorName = null; (yes it has to be null)  try to have the name to be actually useful and not jeff or steve
    // TODO: create a motor and name it
    @Override
    public void init(){ // this will tell the control hub what to do on init also known as initialize
        // We call all init methods here (like a regular method)
    }

    public void initMotors(){
        /*
        this is were we instantiate the motors
        motorName = hardwareMap.get(DcMotorEx.class,"name");
        The name MUST match what you put on the driver hub, if you do not
        know this yet then we will teach it later on, but please keep note of this

        The main usage of these motors is to set the power to the motor.
        motor power uses a binary system 0 being no power and 1 being max power
        all numbers in between are like % of power. By default the motor will spin
        CounterClockwise, however you can also set direction either when initialize it or you can set negative power
        an example of seting power looks like this:
        motorName.setPower(double powerLevel);

        Main things done in init:
            1. instantiate motors
            2. Set motor direction: motor.setDirection(DcMotorEx.Direction.FORWARD); //could be REVERSE too
            3. Set the RunMode (being using an encoder or not): motor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER)
                //other runMode exist too
            4. Set the zeroPowerBehavior (what happens when the motor has no power): motor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE;
                //Can also be FLOAT (motor will not oppose motion)
         */
        // TODO: instantiate the motors
    }
    @Override
    public void start(){ // this is our start method it will be called when the start button is pressed on the driver hub
        /*
        this tells the controller what to do during the op mode
        TODO: make the motor spin a max speed
         */
    }


    @Override
    public void loop() // this is a loop function it loops things we will use this when we use the game pad
    {
        // we will use this later
    }
}

