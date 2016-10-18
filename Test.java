/**
 * Created by Jason on 10/5/2016.
 */
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Test {
    public static void main(String args[]) {
        int maxPlayers=2;
        int player = 0;
        ConnectFive five = new ConnectFive();
        five.createEmpty();
        boolean done = false;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many people are playing?");
        maxPlayers = Integer.parseInt(myScanner.nextLine());
        while (!done) {
            System.out.println("1. Add new piece.");
            System.out.println("2. Quit.");
            try{
                int choice = Integer.parseInt(myScanner.nextLine());
                if (choice == 1){
                    switch (player){
                        case 0: System.out.println("Player 1's turn (R)");
                                if(five.playerTurn('R')){
                                    System.out.println("Connect Five!");
                                    done=true;
                                    break;
                                }
                                else break;
                        case 1: System.out.println("Player 2's turn (Y)");
                                if(five.playerTurn('Y')){
                                    System.out.println("Connect Five!");
                                    done=true;
                                    break;
                                }
                                else break;
                        case 2: System.out.println("Player 3's turn (B)");
                                if(five.playerTurn('B')){
                                    System.out.println("Connect Five!");
                                    done=true;
                                    break;
                                }
                                else break;
                        case 3: System.out.println("Player 4's turn (O)");
                            if(five.playerTurn('O')){
                                System.out.println("Connect Five!");
                                done=true;
                                break;
                            }
                            else break;
                        case 4: System.out.println("Player 5's turn (P)");
                            if(five.playerTurn('P')){
                                System.out.println("Connect Five!");
                                done=true;
                                break;
                            }
                            else break;
                    }
                    if (five.getValid()) {
                        player++;
                    }
                    if (player>=maxPlayers) player=0;
                }
                if (choice == 2) done=true;
            } catch (NumberFormatException ex){System.out.println("Invalid input.");}
        }
    }
}