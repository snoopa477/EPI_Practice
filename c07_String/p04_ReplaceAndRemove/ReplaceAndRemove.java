package c07_String.p04_ReplaceAndRemove;
import static java.lang.System.out;
public class ReplaceAndRemove {
	
	
	final private static char CHAR_TO_DELETE = 'b';
	final private static char CHAR_TO_REPLACE = 'a';
	final private static char REPLACEMENT_CHAR = 'd';

	
	private static class Result{
		
		public int writeIdx;
		public int countOfReplacement;
		
		public Result(int writeIdx, int countOfReplacement) {
			super();
			this.writeIdx = writeIdx;
			this.countOfReplacement = countOfReplacement;
		}
	}
	
	
	
	public static String replaceAndRemove( char[] str, int strSize ) {
		
		/**
		 * PURPOSE:
		 * 'a' will be replaced with 'dd'
		 * 'b' will be deleted 
		 */
		
		/**
		 * REASONING:
		 * writeIndex and readIndex Both shares the same str; however, conceptually they process the same string
		 * We can maintain this concept as long as writeIndex doesn't exceed readIndex
		 * ; However, replacing 'a' with 'dd' might lead to violation, so replacing 'a' operation is saved for later
		 * 
		 * only chars written by writeIndex will be kept, others won't be kept 
		 * 
		 */
		
		Result result = delete_countThoseToBeReplaced_keepOtherChars( str, strSize );
		
		//REASONING: now that str doesn't have 'b'. Given that we have info of having how many counts to replace, we can now process it.
		//DETAIL: writeIdx = next stage old str last index  
		int newStrSize = replace( str, result.writeIdx, result.countOfReplacement );
		
		
		return new String( str, 0, newStrSize );
	}
	
	
	
	/**
	 * 3 responsibilities:
	 * ( to make it in one iteration, we sacrifice readability, integrate 3 tasks into one go )
	 * 1. delete B by not written by writeIndex
	 * 2. if 'a', we record how many of 'a's
	 * 3. otherwise, just keep them by getting them written by writeIndex (including 'a')
	 * 
	 * return: how many of 'a's, writeIdx
	 */
	private static Result delete_countThoseToBeReplaced_keepOtherChars( char[] str, int strSize ) {
		
		int countOfReplacement = 0;
		
		int writeIdx = 0;
		//we will unconditionally increment readIdx; however, writeIdx might not be the case
		for( int readIdx = 0; readIdx < strSize; readIdx++ ) {
			
			//2. if 'a', we record how many of 'a's
			if( str[ readIdx ] == CHAR_TO_REPLACE ) {
				//since there's chance to make writeIdex exceed readIndex if replace, we only count at this stage
				countOfReplacement++;
			}
			
			//1. delete B by not written by writeIndex
			//3. otherwise, just keep them by getting them written by writeIndex 
			if( str[ readIdx ] != CHAR_TO_DELETE) {
				str[ writeIdx ] = str[ readIdx ];
				writeIdx++;
			}
		}
		
		return new Result(writeIdx, countOfReplacement);
	}
	
	
	
	/**
	 * since new str might longer than old str
	 * we need to start with right hand side, iterating to left, so writeIdx will always no exceed readIdx 
	 */
	//private static int replace( char[] str, int lastWriteIdx, int countOfReplacement) {
	/**
	 * DETAIL: 
	 * if "bbb" => "", writeIndex at 0, countOfReplacement = 0
	 * if calling this method, what would happen? 
	 */
	private static int replace( char[] str, int oldStrSize, int countOfReplacement) {
		
		int lastIndxOf_oldStr = oldStrSize -1;
		
		/**
		 * EXAMPLE:
		 * countOfReplacement = 3
		 * lastIdx = 2
		 * aaa
		 * 
		 * lastIdx = 2 + 3
		 * dddddd 
		 */
		int newStrSize = oldStrSize + countOfReplacement;
		int lastIndexOf_newStr = oldStrSize -1 + countOfReplacement;
		int writeIdx = lastIndexOf_newStr;
		
		//go right to left
		for( int readIdx = lastIndxOf_oldStr; readIdx >= 0; readIdx-- ) {
			
			if( str[ readIdx ] == CHAR_TO_REPLACE ) {
				
				str[ writeIdx ] = REPLACEMENT_CHAR;
				writeIdx--;
				str[ writeIdx ] = REPLACEMENT_CHAR;
				writeIdx--;
				
			}
			//keep them 
			else{
				str[ writeIdx ] = str[ readIdx ];
				writeIdx--;
			}
			
		}
		
		
		return newStrSize;
	}
	
	
}


