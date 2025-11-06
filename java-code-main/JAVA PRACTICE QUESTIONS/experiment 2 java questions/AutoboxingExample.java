import java.util.Scanner;

public class AutoboxingExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total numbers: ");
        int n = sc.nextInt();

        Integer sum = 0;  // Autoboxing for primitive int

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();   // primitive input
            sum += num;               // Autoboxing/Unboxing happens here
        }

        System.out.println("Sum of integers = " + sum);
        sc.close();
    }
}
