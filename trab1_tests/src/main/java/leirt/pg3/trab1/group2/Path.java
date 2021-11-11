package leirt.pg3.trab1.group2;

public abstract class Path {
    private double distance;

    public Path() {

    }
    public Path(double distance) {
        this.distance = distance;
    }

    public abstract Place getFirstPlace();

    public abstract Place getLastPlace();

    public abstract Place[] getPlaces();

    @Override
    public String toString() { return ""; }

    public static double sumDistance(int n, Path ... paths)
        throws PathException {
        double sum = 0.0;

        return sum;
    }
}
