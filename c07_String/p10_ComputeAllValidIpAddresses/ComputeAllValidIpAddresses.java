package c07_String.p10_ComputeAllValidIpAddresses;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
public class ComputeAllValidIpAddresses {

	
	private static int NUMBER_OF_IP_PARTS = 4;
	private static String IP_PART_SEPARATOR = ".";
	
	public static List<String> getValidIpAddress(String s) {
		
		List<String> ipParts = new ArrayList<>( Arrays.asList("", "", "", "") );
		List<String> results = new ArrayList<>();
		getValidIpAddressHelper(s, 0, 0, ipParts, results);
		return results;
	}
	
	
	
	public static void getValidIpAddressHelper(String s, int lengthOfprocessedIpParts, int indexOfIpParts, List<String> ipParts, List<String> results) {
		
		//Successfully reaching means none of ip parts is invalid => Ip address is valid => add to result
		if( indexOfIpParts == NUMBER_OF_IP_PARTS ) {	
			
			StringJoiner sj = new StringJoiner(IP_PART_SEPARATOR);
			for( String ipPart : ipParts ) {
				sj.add(ipPart);
			}
			
			results.add( sj.toString() );
			return;
		}
		//the last part of ip, it doesn't have length choice, but to take it all
		else if( indexOfIpParts == NUMBER_OF_IP_PARTS -1 ) {
			
			String ipPart = s.substring(lengthOfprocessedIpParts);
			
			if( isValidIpPart(ipPart) ) {
				ipParts.set(indexOfIpParts, ipPart);
				getValidIpAddressHelper( s, s.length(), indexOfIpParts + 1, ipParts, results );
			}
			return;
		}
		
		
		//the 0th, 1st, 2nd part of Ip
		//WRONG: example "1324". 0th takes length3, 1th takes length 3 => total length = 6, when you hit substring it will throw exception
		//for( int ipPartLen = 1; ipPartLen <= 3; ipPartLen++  ) {
		for( int ipPartLen = 1; ipPartLen <= 3 && lengthOfprocessedIpParts + ipPartLen <= s.length(); ipPartLen++  ) {
			String ipPart = s.substring(lengthOfprocessedIpParts, lengthOfprocessedIpParts + ipPartLen);
			if( isValidIpPart(ipPart) ) {
				ipParts.set(indexOfIpParts, ipPart);
				getValidIpAddressHelper( s, lengthOfprocessedIpParts + ipPartLen, indexOfIpParts + 1, ipParts, results );
			}
			
		}
		
	}
	
	
	
	private static boolean isValidIpPart( String s ) {
		
		if( s.length() > 3 || s.length() < 1 ) {
			return false;
		}
		
		/**
		 * e.g. allowed:
		 * x.0.x
		 * 
		 * x.1.x
		 * x.26.x
		 * 
		 * not allowed 
		 * x.01.x
		 * x.026.x
		 * 
		 */
		if( s.startsWith("0") && s.length() > 1)  {
			return false;
		}
		
		//Reaching here, s that starts with "0", only exists "0"
		
		int number = Integer.parseInt(s);
		
		//if( number  )
		//better: 
		return 0 <= number && number <= 255;
	}
	
}


