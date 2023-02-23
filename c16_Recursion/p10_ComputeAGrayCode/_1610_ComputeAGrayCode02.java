package c16_Recursion.p10_ComputeAGrayCode;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1610_ComputeAGrayCode02 {

	public static List<Integer> grayCode(int numBits) {
		if (numBits == 0) {
			return new ArrayList<>(Arrays.asList(0));
		}
// These implicitly begin with 0 at bit-index (numBits - 1).
		List<Integer> grayCodeNumBitsMinus1 = grayCode(numBits - 1);
// Now, add a 1 at bit-index (numBits - 1) to all entries in
// grayCodeNumBitsMinus1.
		int leadingBitOne = 1 << (numBits - 1);
// Process in reverse order to achieve reflection of grayCodeNumBitsMinusl.

		for (int i = grayCodeNumBitsMinus1.size() - 1; i >= 0; --i) {
			grayCodeNumBitsMinus1.add(leadingBitOne | grayCodeNumBitsMinus1.get(i));
		}
		return grayCodeNumBitsMinus1;
	}
}
