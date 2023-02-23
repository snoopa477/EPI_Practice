package c13_HashTable.p02_IsAnAnonymousLetterConstructible;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

public class _1302_IsAnAnonymousLetterConstructible {

	public static boolean isLetterConstructibleFromMagazine(String letterText, String magazineText) {
		Map<Character, Integer> charFrequencyForLetter = new HashMap<>();
// Compute the frequencies for all chars in letterText.
		for (int i = 0; i < letterText.length(); i++) {
			char c = letterText.charAt(i);
			if (!charFrequencyForLetter.containsKey(c)) {
				charFrequencyForLetter.put(c, 1);
			} else {
				charFrequencyForLetter.put(c, charFrequencyForLetter.get(c) + 1);
			}
		}

// Check if the characters in magazineText can cover characters in
// letterText.
		for (char c : magazineText.toCharArray()) {
			if (charFrequencyForLetter.containsKey(c)) {
				charFrequencyForLetter.put(c, charFrequencyForLetter.get(c) - 1);
				if (charFrequencyForLetter.get(c) == 0) {
					charFrequencyForLetter.remove(c);
// All characters for letterText are matched.
					if (charFrequencyForLetter.isEmpty()) {
						break;

					}

				}

			}

		}

// Empty charFrequencyForLetter means every char in letterText can be
// covered by a character in magazineText.
		return charFrequencyForLetter.isEmpty();

	}
}
