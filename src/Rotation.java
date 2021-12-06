public class Rotation extends Matrix22{

    private double angle;

    Rotation(double a) {
        super(Math.sin(a), Math.cos(a), -Math.cos(a), Math.sin(a));
        angle = a;
    }

    public double getAngle(){
        return angle;
    }
}
