public class Rating {
    public int findRating(int[] workload) { //public method named findRating that takes an integer array workload as a parameter and returns an integer.
        int workingHoursCount = 0; //to keep track of the current streak of days with more than 6 working hours
        int count = 0; //to keep track of the maximum streak found

        for (int hours : workload) {
           
            if (hours > 6) {
                workingHoursCount++;
            } else {
                workingHoursCount = 0;
            }
            
            // Update max count if current streak is longer
            count = Math.max(count, workingHoursCount); //always holds the longest streak of days with more than 6 working hours.
        }

        return count;
    }
}
