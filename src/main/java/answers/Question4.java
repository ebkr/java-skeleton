package answers;
import java.util.*;

public class Question4 {

    public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
        ArrayList<Integer> possibleTimes = new ArrayList();
        for (String[] row : rows) {
            try {
                int timeTaken = validRepairRow(row, numberMachines);
                if (timeTaken > 0) {
                    possibleTimes.add(timeTaken);
                }
            } catch (Exception e) {}
        }
        int time = -1;
        for (int t : possibleTimes) {
            if (t < time || time < 0) {
                time = t;
            }
        }
        if (time < 0) {
            return 0;
        }
        return time;
    }

    private static int validRepairRow(String[] row, int numberMachines) {
        if (row.length < numberMachines) {
            return 0;
        }
        int timeToComplete = 0;
        int potentialSteps = 0;
        int maxPotentialSteps = 0;
        boolean sequence = false;
        for (String s : row) {
            if (!s.equals("X")) {
                try {
                    timeToComplete += Integer.parseInt(s);
                    sequence = true;
                    potentialSteps += 1;
                    if (timeToComplete == -1) {
                        timeToComplete = 0;
                    }
                    timeToComplete += Integer.parseInt(s);
                    if (potentialSteps > maxPotentialSteps) {
                        maxPotentialSteps = potentialSteps;
                    }
                } catch(Exception e) {
                    
                }
            } else if (sequence) {
                sequence = false;
                potentialSteps = 0;
            }
        }
        if (maxPotentialSteps >= numberMachines) {
            return timeToComplete;
        }
        return 0;
    }

}
