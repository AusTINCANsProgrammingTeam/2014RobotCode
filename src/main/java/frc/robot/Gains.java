package frc.robot;

public class Gains {
    public final double kP;
    public final double kI;
    public final double kD;
    public final int kIZone;
    public final double kPeakOutput;

    public Gains(double p, double i, double d, int iZone, double peakOutput)
    {
        kP = p;
        kI = i;
        kD = d;
        kIZone = iZone;
        kPeakOutput = peakOutput;
    }
}