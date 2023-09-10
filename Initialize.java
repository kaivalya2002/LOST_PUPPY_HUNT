package Main;
import java.util.Scanner;
import java.util.Random;

public class Initialize {
 Scanner sc = new Scanner(System.in);
 Random random = new Random(); 
 int floors;
 int rooms;
 char building[][];
 int puppyFloor;
 int player1[];
 int player2[];
 int puppyRoom;

 public Initialize(int numFloors, int numRooms) {
    this.floors = numFloors;
    this.rooms = numRooms;

    building = new char[floors][rooms];
    for (int i = 0; i < floors; i++) {
        for (int j = 0; j < rooms; j++) {
            building[i][j] = ' ';
        }
    }

    puppyFloor = random.nextInt(floors);
    puppyRoom = random.nextInt(rooms);

    player1 = new int[]{random.nextInt(numFloors), random.nextInt(numRooms)};
    player2 = new int[]{random.nextInt(numFloors), random.nextInt(numRooms)};

    building[puppyFloor][puppyRoom] = '*';
    building[player1[0]][player1[1]] = '1';
    building[player2[0]][player2[1]] = '2';
 }

 public void start() {
    StartGame st = new StartGame(building, player1, player2, puppyFloor, puppyRoom, floors, rooms);
    st.playGame();
 }
}
