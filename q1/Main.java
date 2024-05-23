import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n, hourValue; 
        int[] workload; //integer array workload, which will be used to store the working hours for different days.
        Rating obj = new Rating(); 


        System.out.print("Enter array size:");
        n = sc.nextInt() ; //next integer input by the user and assigns it to the variable n.

        workload = new int[n]; //workload array with a size of n

        for (int i = 0; i < n; i++) { //loop that will iterate n times, where i ranges from 0 to n-1.
            System.out.println("Enter Working Hours for Day " + (i + 1) + ":");
            hourValue = sc.nextInt(); //next integer input by the user and assigns it to hourValue.
            
            if (hourValue == -1) {
                break; 
            } else {
                workload[i] = hourValue; 
            }
        }

        int rating = obj.findRating(workload);
        
        System.out.println("Employee Rating: " + rating);
    }
}
