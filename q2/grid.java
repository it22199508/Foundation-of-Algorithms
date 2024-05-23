import java.io.BufferedReader; // read characters from the input stream
import java.io.IOException; // handling input/output exceptions
import java.io.InputStreamReader; // read bytes and decode them into characters


public class grid // count the number of ways to reach the destination
{
    public static void countWaysToReachDestination() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Read dimensions of the grid
        String[] dimensions = reader.readLine().split(" ");
        int numRows = Integer.parseInt(dimensions[0]);
        int numCols = Integer.parseInt(dimensions[1]); // Check if dimensions are valid
        if (numRows <= 0 || numCols <= 0) {
            System.out.println("Invalid input: Number of rows and columns valid numbers.");
            return;
        }

      
        boolean[][] grid = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++)   // each row of the grid
        {
            String row = reader.readLine();
            for (int j = 0; j < numCols; j++) // Mark obstacle as true and empty space as false
            {
                grid[i][j] = row.charAt(j) == '1'; 
            }
        }
        int[][] dp = new int[numRows][numCols]; // Initialize starting point
        dp[0][0] = 1; // Iterate through each cell of the grid
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (!grid[i][j])  // If cell is not an obstacle
                {   // Add number of ways from the cell above and left (if they exist)
                    if (i > 0) dp[i][j] += dp[i - 1][j]; // Adding ways from above cell
                    if (j > 0) dp[i][j] += dp[i][j - 1]; // Adding ways from left cell
                }
            }
        }
        System.out.println(dp[numRows - 1][numCols - 1]);  // Print the number of ways to reach the destination
    }

    public static void main(String[] args) throws IOException     // Call the method to count the ways to reach destination
    {
        countWaysToReachDestination();
    }
}