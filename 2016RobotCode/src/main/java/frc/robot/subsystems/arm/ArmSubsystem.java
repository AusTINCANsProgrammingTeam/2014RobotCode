package frc.robot.subsystems.arm;


import java.util.logging.Logger;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem{
    private static final Logger LOGGER = Logger.getLogger(ArmSubsystem.class.getName());
    DoubleSolenoid leftPiston;
    DoubleSolenoid rightPiston;
    Spark intakeMotor;
    public enum IntakeDirection{IN, OUT}

    @Override
    protected void initDefaultCommand(){}

    public ArmSubsystem(DoubleSolenoid leftPiston, DoubleSolenoid rightPiston, Spark intakeMotor){
        this.leftPiston = leftPiston;
        this.rightPiston = rightPiston;
        this.intakeMotor = intakeMotor;        
        rightPiston.set(Value.kForward);
        leftPiston.set(Value.kForward);
    }

    public void toggleArm(){
        switch(leftPiston.get()){
            case kForward:
                rightPiston.set(Value.kForward);
                leftPiston.set(Value.kForward);
                break;
            case kReverse:
                rightPiston.set(Value.kReverse);
                leftPiston.set(Value.kReverse);
                break;
            case kOff:
                break;
        }
    }
    public void runInake(IntakeDirection direction){
        switch(direction){
            case IN:
                intakeMotor.set(-1);
                break;
            case OUT:
                intakeMotor.set(.75);
                break;
            
        }


    }
}