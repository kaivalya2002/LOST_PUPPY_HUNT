package Main;

public class PrintBuilding{
public static void print(char[][] building, int[] player1Position, int[] player2Position) {
        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                char room = building[i][j];
                if (i == player1Position[0] && j == player1Position[1] && i == player2Position[0]
                        && j == player2Position[1]) {
                    // Both players are in the same room
                    System.out.print("| M ");
             
                } else if (i == player1Position[0] && j == player1Position[1]) {
                    // Player 1's position
                    System.out.print("| 1 ");
                } else if (i == player2Position[0] && j == player2Position[1]) {
                    // Player 2's position
                    System.out.print("| 2 ");
                } else {
                    System.out.print("| " + room + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }
}