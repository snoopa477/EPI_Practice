package c07_String.p13_FindTheFirstOccurrenceOfASubstring;
import static java.lang.System.out;
public class FindTheFirstOccurrenceOfASubstring {
	
	private static final int BASE = 26;
	
	public static boolean IS_DEBUG = false;
	
	//assumption: strings are made of A-Z
	public static int rabinKarp(String targetStr, String searchStr) {
		
		/**
		 * PURPOSE: 
		 * by comparing hash values of strings, we can know if they are equal.
		 * If both hash values are equal, there's a very high chance there are equal, except that they are collided
		 * ; In that case we need further check by using substring to compare  
		 * 
		 * step01: build initial hash values for both targetStr and searchStr
		 * 
		 * step02:
		 * 	if both initial hash values don't match, traverse through targetStr and updating rolling hash value of it, comparing with searchStr hashValue
		 * 
		 */
		
		if( searchStr.length() > targetStr.length() ) {
			return -1;
		}
		
		//now that searchStr.length() <= targetStr.length()
		
		//step01: build initial hash values for both targetStr and searchStr, and updateMask
		int hash_searchStr = 0;
		int hash_targetStr = 0;
		int updateMask = 1;
		
		for( int indexOfSearchStr = 0; indexOfSearchStr < searchStr.length(); indexOfSearchStr++) {
			
			//Wrong if I didn't - 'A' when I later on try to update hash_targetStr by using modulo operation cuz the value would be too large for updateMask
			//this
			//hash_searchStr = hash_searchStr * BASE + searchStr.charAt( indexOfSearchStr ) - 'A';
			//works with the update with modulo operation
			//hash_targetStr = ( hash_targetStr % updateMask /*get rid of most significant bit*/ ) * BASE /*left shift*/ + targetStr.charAt(end_IndexOfTargetHash) - 'A' ;\
			
			hash_searchStr = hash_searchStr * BASE + searchStr.charAt( indexOfSearchStr );
			hash_targetStr = hash_targetStr * BASE + targetStr.charAt( indexOfSearchStr );
			
			//get BASE to the power of searchStr.length() - 1
			updateMask = updateMask * ( indexOfSearchStr != 0 ? BASE : 1 );
		}
		
		
		//RENAME: end_IndexOfTargetHash -> end_tHash
		
		//step02: traverse through targetStr and updating rolling hash value of it, comparing with searchStr hashValue
		//initial value setting kinda confusing to me
		//DETAIL: first iteration: just use the hash we just initialized
		for( int start_tHash = 0, end_tHash = searchStr.length(); 
				end_tHash < targetStr.length();
				start_tHash++, end_tHash++) {
			
			
			if( hash_searchStr == hash_targetStr && 
				targetStr.substring(start_tHash, end_tHash).equals(searchStr) ) {
				return start_tHash;
			}
			
			
			//reaching here means current hash doesn't match, proceed to next index, and update new hash value

			/*CONFUSING:
			 *  current hash 
			 *  [start, start+1 ... tail], end
			 *  ---
			 *  next hash
			 *  start, [start+1 ... tail, end]
			 */
			
			//Understanding Better
			//hash_targetStr = ( hash_targetStr % updateMask /*get rid of most significant bit*/ ) * BASE /*left shift*/ + targetStr.charAt(end_IndexOfTargetHash) - 'A' ;
			//https://stackoverflow.com/questions/24114778/performance-of-modulus-operator-in-c
			
			//Performance Better, since subtract operator is better than modulo operator, and no conversion - 'A' is needed
			//REASONING: start_IndexOfTargetHash is most significant bit, which will be removed
			//REASONING: end_tHash was exclusive;  for the next round it is tail, so end_tHash will be included as Least significant bit
			hash_targetStr = ( hash_targetStr - targetStr.charAt(start_tHash) * updateMask /*get rid of most significant bit*/ ) * BASE /*left shift*/ + targetStr.charAt(end_tHash) /*add new hash part*/;
		}
		
		
		//DETAIL: do it for last part
		if( hash_searchStr == hash_targetStr && 
				targetStr.substring(targetStr.length() - searchStr.length()).equals(searchStr) ) {
				return targetStr.length() - searchStr.length();
		}
		
		
		return -1;
	}

}


