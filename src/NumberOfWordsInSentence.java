import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User: Roman V.F.
 *
 * Создать программу, которая будет:
 * подсчитывать количество слов в предложении
 * выводить их в отсортированном виде
 * делать первую букву каждого слова заглавной.
 * Предложение вводится вручную. (Разделитель пробел (“ ”)).
 */
public class NumberOfWordsInSentence {
    public static void main(String[] args) {
        System.out.print("Введите предложение: ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String sentence = br.readLine()
                    .trim()
                    .replaceAll("[^\\w\\p{InCyrillic} ]", "")
                    .replaceAll(" +", " ");
            String[] sentenceByWords = sentence.split(" ");

            int len = sentenceByWords.length == 1 && sentenceByWords[0].equals("") ? 0 : sentenceByWords.length;

            System.out.println("Количество слов в предложении: " + len);
            if (len != 0) {
                String result = Stream.of(sentenceByWords)
                        .sorted()
                        .map(e -> e.substring(0, 1).toUpperCase() + e.substring(1))
                        .collect(Collectors.joining(" "));

                System.out.println(result);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
