public class VolumeOfEarth {
    public static void main(String[] args) {
        double radius=6378;
        double volume=(4.0/3)*3.14*Math.pow(radius, 3);
        System.out.println("Volume of Earth is "+volume);
    }
}