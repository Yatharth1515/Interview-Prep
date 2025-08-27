package strategy;

public class NormalDS implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal Drive Strategy");
    }
}
