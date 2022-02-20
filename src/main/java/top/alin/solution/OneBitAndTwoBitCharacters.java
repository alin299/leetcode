package top.alin.solution;

/**
 * 717. 1-bit and 2-bit Characters
 */
public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}
