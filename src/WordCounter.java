import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: Roman V.F.
 *
 * Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
 * Текст и слово вводится вручную.
 */
public class WordCounter {
    public static void main(String[] args) {
        int wordsCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите текст: ");
            String text = br.readLine();
            System.out.print("Введите слово для поиска: ");
            String word = br.readLine().trim().toLowerCase();
            String onlyWords = text
                    .trim()
                    .replaceAll("[^\\w\\p{InCyrillic} ]", "")
                    .replaceAll(" +", " ")
                    .toLowerCase();
            String[] sentenceByWords = onlyWords.split(" ");
            for (String oneOfWords : sentenceByWords) {
                if(word.equals(oneOfWords)) {
                    wordsCount++;
                }
            }
            System.out.printf("Слово '%s' употреблено в тексте %d раз.", word, wordsCount);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
