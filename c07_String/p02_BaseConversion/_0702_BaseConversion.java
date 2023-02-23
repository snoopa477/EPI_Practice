package c07_String.p02_BaseConversion;

import static java.lang.System.out;

public class _0702_BaseConversion {

	public static String convertBase(String numAsString, int bl, int b2) {
		boolean isNegative = numAsString.startsWith("-");
		int numAsInt = 0;
		for (int i = (isNegative ? 1 : 0); i < numAsString.length(); ++i) {
			numAsInt *= bl;
			numAsInt += Character.isDigit(numAsString.charAt(i)) ? numAsString.charAt(i) - '0'
					: numAsString.charAt(i) - 'A' + 10;
		}
		return (isNegative ? "-" : "") + (numAsInt == 0 ? "0" : constructFromBase(numAsInt, b2));
	}

	private static String constructFromBase(int numAsInt, int base) {
		return numAsInt == 0 ? ""
				: constructFromBase(numAsInt / base, base)
						+ (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base);
	}

}
