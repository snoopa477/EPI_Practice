package c07_String.p07_ComputeAllMnemonicsForAPhoneNumber;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
public class ComputeAllMnemonicsForAPhoneNumber {

	
	private static final String[] DIGIT_TO_ALPHABET = { 
		"0", 
		"1", 
		"ABC", //2 
		"DEF", //3
		"GHI", //4 
		"JKL", //5 
		"MNO", //6
		"PQRS", //7
		"TUV", //8
		"WXYZ" //9 
		};
	
	
	public static List<String> phoneMnemonic(String phoneNumber) {
		
		List<String> mnemonics = new ArrayList<>();
		char[] partialMnemonic = new char[ phoneNumber.length() ];
		phoneMnemonicHelper( phoneNumber, 0, partialMnemonic, mnemonics );
		
		return mnemonics;
	}

	
	
	//it only process the indexOfPhoneNumber th of the phone number
	/** REASONING: given method ( phoneNumber, x, ...) is called
	 *  only x th char is updated to partialMnemonic, replacing the old one
	 *  => 0th to x th chars are valid, and x + 1 th char to last(mnemonics.length() -1 ) is either empty or out-dated(invlid) value
	 * 
	 */
	private static void phoneMnemonicHelper(String phoneNumber, int indexOfPhoneNumber, char[] partialMnemonic, List<String> mnemonics) {
		
		//base case 
		if( indexOfPhoneNumber == phoneNumber.length() ) {
			mnemonics.add( new String( partialMnemonic ) );
			return;
		}
		
		//non-base case, proceed by recursive calling
		//REASONING: reaching here means 0 th to mnemonics.length() -1 th chars are valid => all valid => add to mnemonics
		
		char charDigit = phoneNumber.charAt( indexOfPhoneNumber );
		int digit = charToInt( charDigit );
		char[] mnemonicOptions = DIGIT_TO_ALPHABET[ digit ].toCharArray();
		
		for( char mnemonicValue : mnemonicOptions ) {
			
			//update indexOfPhoneNumber char value
			partialMnemonic[ indexOfPhoneNumber ] = mnemonicValue;
			
			//proceed updating next char
			phoneMnemonicHelper( phoneNumber, indexOfPhoneNumber + 1, partialMnemonic, mnemonics );
		}
		
	}
	
	
	
	private static int charToInt( char c ) {
		return c - '0';
	}
	
}


