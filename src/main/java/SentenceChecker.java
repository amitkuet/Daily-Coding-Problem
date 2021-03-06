/*
*This problem was asked by Nest.
* Create a basic sentence checker that takes in a stream of characters and determines whether they form valid sentences.
*
* If a sentence is valid, the program should print it out.
*
* We can consider a sentence valid if it conforms to the following rules:
*
* The sentence must start with a capital letter, followed by a lowercase letter or a space.
* All other characters must be lowercase letters, separators (,,;,:) or terminal marks (.,?,!,‽).
* There must be a single space between each word.
* The sentence must end with a terminal mark immediately following a word.
* */

import java.util.*;

public class SentenceChecker {

    public static List<String> sentenceCheckerImpl(char[] characters) {
        List<String> list = new ArrayList<>();
        Set<Character> separator = new HashSet<>(Arrays.asList(',', ';', ':'));
        Set<Character> terminal = new HashSet<>(Arrays.asList('.', '?', '!', '‽'));

        StringBuilder sb = new StringBuilder();
        for (char character : characters) {
            if (separator.contains(character)) {
                if (sb.length() == 0) {
                    continue;
                }

                sb.append(character);
            } else if (terminal.contains(character)) {
                if (sb.length() > 0) {
                    sb.append(character);
                    list.add(sb.toString());

                    sb.setLength(0);
                }
            } else {
                if (Character.isUpperCase(character)) {
                    if (sb.length() != 0) {
                        sb.setLength(0);
                    }

                    sb.append(character);
                } else {
                    if (sb.length() == 0) {
                        continue;
                    }

                    sb.append(character);
                }
            }
        }

        return list;
    }
}
