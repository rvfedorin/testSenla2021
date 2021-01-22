import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: Roman V.F.
 *
 * Создать программу, которая в последовательности от 0 до N,
 * находит все числа-палиндромы (зеркальное значение равно оригинальному).
 * Длина последовательности N вводится вручную и не должна превышать 100.
 */
public class Palindromes {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину последовательности от 0 до 100: ");
            String inputNumber = br.readLine().trim();
            int number;
            try {
                number = Integer.parseInt(inputNumber);
                if(number < 0 || number > 100) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка ввода. Необходимо ввести целое число число от 0 до 100.");
                return;
            }
            boolean notFirst = false;
            for (int i = 0; i <= number; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                String numString = sb.toString();
                String reverse = sb.reverse().toString();
                if(reverse.equals(numString)) {
                    if (notFirst) {
                        System.out.print(" ");
                    } else {
                        notFirst = true;
                    }
                    System.out.print(i);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
