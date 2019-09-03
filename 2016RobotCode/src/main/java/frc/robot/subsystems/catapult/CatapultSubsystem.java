package frc.robot.subsystems.catapult;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CatapultSubsystem extends Subsystem{
    private static final Logger LOGGER = Logger.getLogger(CatapultSubsystem.class.getName());

    private Spark CatMotor;
    private DoubleSolenoid CatPiston;
    public enum CatPDirection{RELEASE, CLOSE}

    @Override
    public void initDefaultCommand(){}


    public CatapultSubsystem(Spark CatMotor, DoubleSolenoid CatPiston){
        this.CatMotor = CatMotor;
        this.CatPiston = CatPiston;
        
    }

    public void TogglePiston(){
        switch(CatPiston.get()){
            case kForward:
                CatPiston.set(DoubleSolenoid.Value.kReverse);
                break;
            case kReverse:
                CatPiston.set(DoubleSolenoid.Value.kForward);
                break;
            case kOff:
                break;

        }

    }

    public void loadCat(){
        CatMotor.set(.3);
    }
}