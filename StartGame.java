package Main;

import java.util.Scanner;
import java.util.Random;

public class StartGame {

    private char[][] building;
    private int[] player1;
    private int[] player2;
    private int puppyFloor;
    private int puppyRoom;
    private int floors;
    private int rooms;

    // initialize startGame
    public StartGame(char[][] building, int[] player1, int[] player2, int puppyFloor, int puppyRoom, int floors,
            int rooms) {
        this.building = building;
        this.player1 = player1;
        this.player2 = player2;
        this.puppyFloor = puppyFloor;
        this.puppyRoom = puppyRoom;
        this.floors = floors;
        this.rooms = rooms;
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean game = false;

        System.out.println("Here we goes.Let's start - ");
        PrintBuilding.print(building, player1, player2);
        while (!game) {
            building[puppyFloor][puppyRoom] = '*';

            {
            System.out.println("Player 1's turn :");
            char move1 = getPlayerMove(sc);
            updatePlayerPosition(move1, building, player1, floors, rooms);

            PrintBuilding.print(building, player1, player2);

            if (puppyFloor == player1[0] && puppyRoom == player1[1]) {
                System.out.println("Congratulations ! Player 1 wins");
                System.out.println("Game Over");
                game = true;
                break;
            }
        } 
            // player2's turn
            System.out.println("Player 2's turn :");
            char move2 = getPlayerMove(sc);
            updatePlayerPosition(move2, building, player2, floors, rooms);

            PrintBuilding.print(building, player1, player2);

            if (puppyFloor == player2[0] && puppyRoom == player2[1]) {
                System.out.println("Congratulations ! Player 2 wins");
                System.out.println("Game Over");
                game = true;
                break;
            }

         }
       }

    public static char getPlayerMove(Scanner scanner) {
        char move;

        while (true) {
            System.out.print("Enter your move ('U-UPWARD', 'D-DOWNWARD', 'L-LEFT', 'R-RIGHT' , X - EXIT): ");
            move = scanner.next().charAt(0);
            if (move == 'U' || move == 'D' || move == 'L' || move == 'R' || move=='X') {
                break;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        return move;
    }

    public static void updatePlayerPosition(char move, char[][] building, int[] position, int numFloors, int numRooms) {
        int floor = position[0];
        int room = position[1];
        switch (move) {
            case 'U':
                if (floor > 0) {
                    building[floor][room] = ' ';
                    floor--;
                } else {
                    // Player is on the top floor
                    System.out.println("You are already on the top floor. Try for next move ");
                }
                break;
            case 'D':
                if (floor < numFloors - 1) {
                    building[floor][room] = ' ';
                    floor++;
                } else {
                    System.out.println("You are on the ground floor. Try for the next move ");
                }
                break;
            case 'L':
                if (room > 0) {
                    building[floor][room] = ' ';
                    room--;
                } else {
                    System.out.println("You are at the leftmost position. Try for the next move ");
                }
                break;
            case 'R':
                if (room < numRooms - 1) {
                    building[floor][room] = ' ';
                    room++;
                } else {
                    System.out.println("You are at the rightmost position. Try for the next move ");
                }
                break;
            case 'X':
                System.out.println("Thank you for playing");
                System.exit(0);
        }
        position[0] = floor;
        position[1] = room;
        // Update the building with the player number ('1' or '2')
        if (move == '1') {
            building[position[0]][position[1]] = move = '1';
        } else {
            building[position[0]][position[1]] = move = '2';
        }
    }

}
