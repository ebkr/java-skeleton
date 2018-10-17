package answers;

public class Question1 {

    public static int bestMergedPortfolio(int[] portfolios) {
        short[][] bits = new short[portfolios.length][1];
        for (int i=0; i<portfolios.length; i++) {
            bits[i] = to16bit(portfolios[i]);
        }
        short[] combo1 = new short[1];
        short[] combo2 = new short[1];
        short maxReal = -1;
        for (int i=0; i<bits.length; i++) {
            for (int j=0; j<bits.length; j++) {
                if (i != j) {
                    short combineValue = toReal(combineStocks(bits[i], bits[j]));
                    if (combineValue > maxReal) {
                        maxReal = combineValue;
                        combo1 = bits[i];
                        combo2 = bits[j];
                    }
                }
            }
        }
        return maxReal;
    }
    
    private static short[] to16bit(int num) {
        short total = (short) num;
        short[] bit = new short[16];
        
        for (int i=15; i>=0; i--) {
            if (total - (Math.pow(2,i)) >= 0) {
                bit[15-i] = 1;
                total -= Math.pow(2,i);
            } else {
                bit[15-i] = 0;
            }
        }
        return bit;
    }

    private static short toReal(short[] num) {
        short total = 0;
        for (int i=0; i<num.length; i++) {
            if (num[i] != 0) {
                total += (Math.pow(2, (num.length-1)-i));
            }
        }
        return total;
    }
    
    private static short[] combineStocks(short[] x, short[] y) {
        short[] clone = new short[x.length];
        for (int i=0; i<x.length; i++) {
            clone[i] = (short)((int) (x[i] + y[i]) % 2);
        }
        return clone;
    }

}
