public class PensDistribution {
    public static void main(String[] args) {
        int pens = 14 ;
        int students = 3 ;
        int equalPens = pens/students ;
        int remainingPens = pens%students ;
        System.out.println("The Pen per Student is "+equalPens+" and the remaining pen not distributed is "+remainingPens);
    }
}
