public class DiscountOnFees {
    public static void main(String[] args) {
        int fee = 125000 ;
        int discountPercent = 10 ;
        int discount = (fee*discountPercent)/100;
        System.out.println("The discount amount in INR is "+discount+" and final discounted fee in INR is "+(fee-discount));
    }
}
