package c07_String.p10_ComputeAllValidIpAddresses;
import static java.lang.System.out;
public class Test_ComputeAllValidIpAddresses {

	public static void main(String[] args) {
		
		{
			String s = "19216811";
			out.println(s);
			out.println( _0710_ComputeAllValidIpAddresses.getValidIpAddress(s) );
			out.println( ComputeAllValidIpAddresses.getValidIpAddress(s) );
		}
		
		
		{
			String s = "101101";
			out.println(s);
			out.println( _0710_ComputeAllValidIpAddresses.getValidIpAddress(s) );
			out.println( ComputeAllValidIpAddresses.getValidIpAddress(s) );
		}
		
		
		{
			String s = "0000";
			out.println(s);
			out.println( _0710_ComputeAllValidIpAddresses.getValidIpAddress(s) );
			out.println( ComputeAllValidIpAddresses.getValidIpAddress(s) );
		}
		
		
		{
			String s = "1111";
			out.println(s);
			out.println( _0710_ComputeAllValidIpAddresses.getValidIpAddress(s) );
			out.println( ComputeAllValidIpAddresses.getValidIpAddress(s) );
		}
	}

}


