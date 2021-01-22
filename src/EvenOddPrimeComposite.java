import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * User: Roman V.F.
 *
 * Создать программу, которая будет сообщать, является ли целое число, введенное пользователем,
 * чётным или нечётным, простым или составным.
 * Если пользователь введёт не целое число, то сообщать ему об ошибке.
 */
public class EvenOddPrimeComposite {
    public static void main(String[] args) {
        System.out.print("Введите целое число: ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputNumber = br.readLine().trim();
            long number;
            try {
                number = Long.parseLong(inputNumber);
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка ввода. Необходимо ввести целое число.");
                return;
            }
            StringBuilder resultLine = new StringBuilder();
            resultLine.append("Введённое число:");

            if (number % 2 == 0) {
                resultLine.append(" чётное,");
            } else {
                resultLine.append(" нечётное,");
            }

            BigInteger bigInteger = BigInteger.valueOf(number);
            if (bigInteger.isProbablePrime((int)Math.log(number))) {
                resultLine.append(" простое.");
            } else {
                resultLine.append(" составное.");
            }

            System.out.println(resultLine);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
