import java.util.Arrays;

public class OTPGenerator {
    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }
        
        System.out.println("Generated OTPs: " + Arrays.toString(otps));
        if (areUnique(otps)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Duplicate OTPs found.");
        }
    }

    public static int generateOTP() {
        // Generate random number between 100000 and 999999
        return 100000 + (int)(Math.random() * 900000);
    }

    public static boolean areUnique(int[] otps) {
        // Simple O(N^2) check for small array
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) return false;
            }
        }
        return true;
    }
}