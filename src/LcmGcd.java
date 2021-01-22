import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * User: Roman V.F.
 *
 * Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
 * и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
 * Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
 */
public class LcmGcd {
    public static void main(String[] args) {
        System.out.print("Введите два целых числа через пробел: ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputNumbers = br.readLine().trim().split(" ");
            long number1;
            long number2;
            try {
                if(inputNumbers.length != 2) {
                    System.out.println("Ошибка ввода. Необходимо ввести два целых число.");
                    return;
                }
                number1 = Long.parseLong(inputNumbers[0]);
                number2 = Long.parseLong(inputNumbers[1]);
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка ввода. Необходимо ввести два целых число.");
                return;
            }

            BigInteger bigNumber1 = BigInteger.valueOf(number1);
            BigInteger bigNumber2 = BigInteger.valueOf(number2);
            System.out.println("Наименьшее общее кратное (НОК): " + lcm(bigNumber1, bigNumber2));
            System.out.println("Наибольший общий делитель (НОД): " + gcd(bigNumber1, bigNumber2));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static long gcd(BigInteger a, BigInteger b) {
        return a.gcd(b).longValue();
    }

    public static long lcm(BigInteger a, BigInteger b) {
        return Math.abs(a.multiply(b).longValue()) / gcd(a, b);
    }
}
