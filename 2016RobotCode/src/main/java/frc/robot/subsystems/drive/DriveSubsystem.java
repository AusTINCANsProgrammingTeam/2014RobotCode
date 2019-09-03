package frc.robot.subsystems.drive;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GearTooth;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DriveSubsystem extends Subsystem{
    private final Logger LOGGER = Logger.getLogger(DriveSubsystem.class.getName());

    private DifferentialDrive differentialDrive;
    private DoubleSolenoid gearDoubleSolenoid;
    private GearMode gearMode;

    //initialize drive subsystem

    @Override
    protected void initDefaultCommand(){ }

    public DriveSubsystem(SpeedController leftSpeedController, SpeedController rightSpeedController, DoubleSolenoid gearboxSolenoid){
        this.differentialDrive = new DifferentialDrive(leftSpeedController, rightSpeedController);
        differentialDrive.setSafetyEnabled(false);
        this.gearDoubleSolenoid = gearboxSolenoid;
        LOGGER.info("DriveSubsystem Initialized");

    }

    public void arcadeDrive(double velocity, double heading){
        differentialDrive.arcadeDrive(velocity, heading);
    }

    public GearMode getGearMode(){
        return gearMode;
    }

    public void toggleGearMode(){
        switch(gearDoubleSolenoid.get()){
            case kReverse:
                gearDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
                break;
            case kForward:
                gearDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
                break;
            case kOff:
                break;
        }
    }


}