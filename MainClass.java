package Main;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
        System.out.println("*** WELCOME TO PUPPY HUNT ***\n");
        System.out.println("Firstly Build the structure for game ---");
        System.out.print("Enter the No of floors -");
        int numFloors = scanner.nextInt();
        System.out.print("Enter the No of rooms -");
        int numRooms = scanner.nextInt();


    Initialize i = new Initialize(numFloors,numRooms);
    i.start();
        
    }
}
