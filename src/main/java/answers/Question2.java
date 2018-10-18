package answers;
import java.util.*;

public class Question2 {

    public static int equallyBalancedCashFlow(int[] cashflowIn, int[] cashflowOut) {

        int bestOutput = -1;

        int[] in = getSubsetsOf(cashflowIn);
        int[] out = getSubsetsOf(cashflowOut);

        for (int n: in) {
            for (int n2: out) {
                if (n - n2 >= 0) {
                    if (bestOutput < 0 || n - n2 < bestOutput) {
                        bestOutput = n-n2;
                    }
                    if (bestOutput == 0) {
                        return 0;
                    }
                }
            }
        }

        return bestOutput;
    }

    private static int[] getSubsetsOf(int[] subset) {
        ArrayList<int[]> arr = genSubsets(subset);
        int[] counted = new int[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            int count = 0;
            for (int n : arr.get(i)) {
                count += n;
            }
            counted[i] = count;
        }
        return counted;
    }

    private static ArrayList<int[]> genSubsets(int[] arr) {
        int binaryLimit = (1 << arr.length) - 1;
        ArrayList<int[]> subsets = new ArrayList<>();
        for (int i = 1; i <= binaryLimit; i++) {
            int index = arr.length - 1;
            int num = i;
            int[] hold = new int[num];
            while (num > 0) {
                if ((num & 1) == 1) {
                    hold[num-1] = arr[index];
                }
                index--;
                num >>= 1;
            }
            subsets.add(hold);
        }
        return subsets;
    }

}
