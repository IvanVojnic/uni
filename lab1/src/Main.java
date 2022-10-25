
import com.sun.media.sound.InvalidFormatException;
import com.sun.media.sound.InvalidFormatException;
import org.jetbrains.annotations.Contract;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter k: ");
            int k = scanner.nextInt();
            System.out.println("Enter x (-1, 1): ");
            double x = scanner.nextDouble();
            if (x <= -1 || x >= 1) {
                throw new InvalidFormatException("X should be in (-1, 1)");
            }

            double eps = Math.pow(10, -k);
            double actualValue = calculateActualValue(x);
            double calculatedValue = calculateTailorSeries(eps, x);

            System.out.println("Actual value: " + formattedNumericValue(actualValue));
            System.out.println("Calculated value: " + formattedNumericValue(calculatedValue));
        } catch (Exception ex) {
            System.out.println("Error while reading value: " + ex);
        }
    }

  //  @Contract(pure = true)
    static double calculateActualValue(double x) {
        return 1 / Math.sqrt(1+x);
    }

    static double calculateTailorSeries(double eps, double x) {
        int n = 3;
        double numerator = 1.0;
        double denuminator = 2.0;
        double element = 0.5;
        double elem = element*x;
        double calculatedValue = 1 - elem;
        while (Math.abs(elem) >= Math.abs(eps)) {
            element = (numerator+2)/(denuminator+2);
            elem = elem * element * x;
            numerator += 2;
            denuminator += 2;
            if(n%2==0){
                calculatedValue -= elem;
            }
            else {
                calculatedValue += elem;
            }
            n++;
        }
        return calculatedValue;
    }

    private static String formattedNumericValue(double value) {
        return String.format("%.7f", value);
    }
}