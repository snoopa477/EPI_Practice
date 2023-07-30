package c05_PrimitiveTypes.p01_ComputingTheParityOfAword;
import static java.lang.System.out;

import util.BitPrinter;
public class Test_LeadingBit {

	public static void main(String[] args) {
		
		out.println("\n\n---------------0xFF");
		out.println( BitPrinter.toBitStringWithHeader(0xFF) );
		out.print(0xFF);
		
		out.println("\n\n---------------0xFFFFFFFF");
		out.println( BitPrinter.toBitStringWithHeader(0xFFFFFFFF) );
		out.print(0xFFFFFFFF);
		
		{
		out.println("\n\n---------------byte01 0xFF");
		//COMPILE ERROR: cannot convert from int to byte
		//byte byte01 = 0xFF;
		byte byte01 = (byte) 0xFF;
		out.println( byte01 );
		out.println( BitPrinter.toBitStringWithHeader(byte01) );
		}
		
		{
		out.println("\n\n---------------short01 0xFFFF");
		//Type mismatch: cannot convert from int to short
		//short short01 = 0xFFFF;
		short short01 = (short) 0xFFFF;
		out.println( short01 );
		}
		
		
		{
		out.println("\n\n---------------int01 0xFFFFFFFF");
		int int01 = 0xFFFFFFFF;
		out.println( int01 );
		}
		
		{
		out.println("\n\n---------------long000 0xFFFF");
		long long000 = 0xFFFF;
		out.println( long000 );
		}
		{
		out.println("\n\n---------------long00 0xFFFF");
		long long00 = (short) 0xFFFF;
		out.println( long00 );
		}
		{
		out.println("\n\n---------------long01 0xFFFFFFFF");
		//The literal 0xFFFFFFFFFFFFFFFF of type int is out of range
		//long long01 = 0xFFFFFFFFFFFFFFFF;
		long long01 = (int) 0xFFFFFFFF;
		out.println( long01 );
		
		out.println( BitPrinter.toBitStringWithHeader(long01) );
		
		out.println("long01 << 32");
		out.println( BitPrinter.toBitStringWithHeader(long01 << 32) );
		out.println( long01 << 32);
		
		out.println("(long)long01 << 32");
		out.println( BitPrinter.toBitStringWithHeader((long)long01 << 32) );
		
		long01 = long01 << 32 + 0xFFFFFFFF;
		out.println("long01 = long01 << 32 + 0xFFFFFFFF");
		out.println( long01 );
		out.printf("%d\n", long01);
		out.println( BitPrinter.toBitStringWithHeader(long01) );
		}
		{
		out.println("1 << 2");
		out.println( BitPrinter.toBitStringWithHeader( 1 << 2 ) );
		
		out.println("(short)1 << (short)2");
		out.println( BitPrinter.toBitStringWithHeader( (short)1 << (short)2 ) );
		
		out.println("(long)1 << (long)2");
		out.println( BitPrinter.toBitStringWithHeader( (long)1 << (long)2 ) );
		
		out.println("(short)1 << (long)2");
		out.println( BitPrinter.toBitStringWithHeader( (short)1 << (long)2 ) );
		
		out.println("(long)1 << (short)2");
		out.println( BitPrinter.toBitStringWithHeader( (long)1 << (short)2 ) );
		
		out.println("(byte)1 << 2");
		out.println( BitPrinter.toBitStringWithHeader( (byte)-1 << 2 ) );
		}
		
		{
		out.println("\n\n---------------long02 0xFF");
		long long02 = 0xFF;
		out.println( long02 );
		}
		{
		out.println("\n\n---------------int02 0xFF");
		int int02 = 0xFF;
		out.println( int02 );
		}
		{
		out.println("\n\n---------------short02 (short) (int) 0xFFFF");
		//Type mismatch: cannot convert from int to short
		//short short01 = 0xFFFF;
		short short02 = (short) (int) 0xFFFF;
		out.println( short02 );
		}
		{
		out.println( "\n\n---------------int03" );
		short short03 = -1;
		int int03 = short03;
		out.println( BitPrinter.toBitStringWithHeader( int03 ));
		}
		{
		out.println( "\n\n---------------int04" );
		long long04 = -1;
		long04 -=3;
		out.println( BitPrinter.toBitStringWithHeader( long04 ));
		}
		{
		out.println( "\n\n---------------int05" );
		long long05 = -1;
		long05 -=4;
		out.println( BitPrinter.toBitStringWithHeader( long05 ));
		
		
		out.println( Long.toBinaryString(long05) );
		}
		{
		long long06 = 10000000000L;
		int int06 = (int)long06;
		out.println( "\n\n---------------int06" );
		out.println( int06 );
		}
		{
		long long07 = 1L << 60;
		out.println( "\n\n---------------long07" );
		out.println( long07 );
		int int07 = (int)long07;
		out.println( "\n\n---------------int07" );
		out.println( int07 );
		}
		{
		out.println( "\n\n---------------int08" );
		long long08 = 1 << (32 + 2);
		out.println( long08 );
		}
		{
		out.println( "\n\n---------------int09" );
		long long09 = 1 << (32 + 32 + 2);
		out.println( long09 );
		}
		
		
		out.println("\n\n---------------minus one");
		{
			out.println("\n\n---------------int int01 = (short)0xFFFF ");
			int int01 = (short)0xFFFF;
			out.println( int01 );
			
			out.println("\n\n---------------int int01 = (byte)0xFFFF ");
			int01 = (byte)0xFF;
			out.println( int01 );
			
			out.println("\n\n---------------long long01 = (short)0xFFFF ");
			long long01 = (short)0xFFFF;
			out.println( long01 );
			
			out.println("\n\n---------------long long01 = (byte)0xFFFF ");
			long01 = (byte)0xFF;
			out.println( long01 );
		}
		
		
		out.println("\n\n---------------minus twenty two");
		{
			out.println("\n\n---------------int int01 = (short)0xFFFF ");
			int int01 = (short)0xFFEA;
			out.println( int01 );
			out.println( BitPrinter.toBitStringWithHeader( int01 ));
			
			out.println("\n\n---------------int int01 = (byte)0xFFFF ");
			int01 = (byte)0xEA;
			out.println( int01 );
			out.println( BitPrinter.toBitStringWithHeader( int01 ));
			
			out.println("\n\n---------------long long01 = (short)0xFFFF ");
			long long01 = (short)0xFFEA;
			out.println( long01 );
			out.println( BitPrinter.toBitStringWithHeader( long01 ));
			
			out.println("\n\n---------------long long01 = (byte)0xFFFF ");
			long01 = (byte)0xEA;
			out.println( long01 );
			out.println( BitPrinter.toBitStringWithHeader( long01 ));
		}
		
	}

}


