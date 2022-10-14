import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class FirstAndLastWord {

    List<String> stringList;

    public FirstAndLastWord(List<String> stringList) {
        this.stringList = stringList;
    }

    public void sort() {
        Collections.sort(stringList);
    }

    public void sortIgnoreCase() {
        Collections.sort(stringList, String.CASE_INSENSITIVE_ORDER);
    }

    public String getFirst() {
        return stringList.get(0);
    }

    public String getLast() {
        return stringList.get(stringList.size() - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        System.out.println("Dammi il numero di parole da analizzare: ");
        int numberOfWords = in.nextInt();
        in.nextLine();

        System.out.println("Dimmi se vuoi ignorare la differenza tra maiuscole e minuscole: S/N");
        String ignoreCase = in.nextLine();

        for (int i = 0; i < numberOfWords; i++) {
            System.out.println("Dammi una stringa: ");
            stringList.add(in.nextLine());
        }

        FirstAndLastWord firstAndLastWord = new FirstAndLastWord(stringList);

        switch (ignoreCase) {
            case "S" -> firstAndLastWord.sortIgnoreCase();
            case "s" -> firstAndLastWord.sortIgnoreCase();

            case "N" -> firstAndLastWord.sort();
            case "n" -> firstAndLastWord.sort();
        }

        System.out.println("The first word is " + firstAndLastWord.getFirst());
        System.out.println("The last word is " + firstAndLastWord.getLast());
    }
}