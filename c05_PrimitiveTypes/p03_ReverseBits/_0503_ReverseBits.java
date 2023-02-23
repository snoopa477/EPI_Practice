package c05_PrimitiveTypes.p03_ReverseBits;
import static java.lang.System.out;
public class _0503_ReverseBits {

public static long reverseBits(long x) {
final int W0RD_SIZE = 16;
final int BIT_MASK = 0xFFFF;
return precomputedReverse [(int)(x & BIT_MASK)] << (3 * W0RD_SIZE)
| precomputedReverse [(int)((x >>> W0RD_SIZE) & BIT_MASK)]

<<(2 * WORD_SIZE)
|precomputedReverse[(int)((x >>> (2 * W0RD_SIZE)) & BIT_MASK)]
<< W0RD_SIZE
|precomputedReverse[(int)((x >>> (3 * W0RD_SIZE)) & BIT_MASK)];
}


