package frc.robot.subsystems.drive;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class SparkGroup implements SpeedController{
    private static final Logger LOGGER = Logger.getLogger(SparkGroup.class.getName());
    private Spark master;
    private Spark [] slaves;
    
    public SparkGroup(Spark master, Spark... slaves){
        this.master = master;
        this.slaves = slaves;

        for(Spark slave: slaves){}
    }

    @Override

    public void pidWrite(double output){
        master.pidWrite(output);
        for(Spark slave: slaves){
            slave.pidWrite(output);
            
        }
    }

    @Override
    public void set(double speed){
        master.set(speed);
        for(Spark slave: slaves){
            slave.set(speed);
            }
        }

    @Override
    public void setInverted(boolean isInverted){
        master.setInverted(isInverted);
        for(Spark slave: slaves){
            slave.setInverted(isInverted);
        }
    }
    @Override
    public double get(){
        return master.get();
    }

    @Override
    public boolean getInverted() {
        return master.getInverted();
    }

    @Override
    public void disable(){
        master.disable();
        for(Spark slave: slaves){
            slave.disable();
        }
    }

    @Override
    public void stopMotor(){
        master.stopMotor();
        for(Spark slave: slaves){
            slave.stopMotor();
        }
    }

    
    


}


