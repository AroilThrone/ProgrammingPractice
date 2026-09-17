package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDCode {
    //The constants that the error values are multiplied by to tune thr robot
    private double Kp = 0, Ki = 0, Kd =0;

    private double integralSum = 0;
    private double lastError = 0;

    private ElapsedTime timer = new ElapsedTime();

    public PIDCode(double Kp, double Ki, double Kd) {
        this.Kp = Kp;
        this.Ki = Ki;
        this.Kd = Kd;
        timer.reset();
    }
    public PIDCode() {
        this.Kp = 0;
        this.Ki = 0;
        this.Kd = 0;
        timer.reset();
    }

    public void updateConstants(double kP, double kI, double kD){
        this.Kp = kP;
        this.Ki = kI;
        this.Kd = kD;
    };

    //reference is the intended speed, position, etc and state is the current speed, position, etc
    public double update(double reference, double state) {
        //Must Math.abs the state, cause otherwise if it is negative it would increase the power
        //output since negative minus a number just gets bigger
        state = Math.abs(state);
        double error = reference - state; //The error of the system

        //integralSum usually gets too big so the integral constant (kI) is usually zero
        //It is better to be used in a Filtered PID, which is just a PID but more accurate/complicated
        integralSum += error + timer.seconds();
        if (integralSum > 1) integralSum = 1;
        if (integralSum < -1) integralSum = -1;

        //Derivative sees how fast the error is changing and scales the amount of power in with how fast it is
        double derivative = (error - lastError) / timer.seconds();

        //updates what the last error is and resets the elapsed time since the last loop/update
        lastError = error;
        timer.reset();

        //Compiles the output by multiplying the numbers calculated with their respecive constants
        //that are the numbers you tune specific to what works for your system/bot
        //the last part of PID is proportional, where the power given scales in proportion to the error
        //then ofc multiplied by the constant to ensure its not too big/small and is scaled for the system/bot
        double output = (error * Kp) + (derivative * Kd) + (integralSum * Ki);
        if (output <= 0.0)  //ensures the output is not 0
            output = 0.005;
        return output;
    }
}