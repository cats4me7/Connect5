/**
 * Created by Jason on 10/5/2016.
 */
import java.util.Scanner;
public class Test {
    public static void main(String args[]) {
        ConnectFive five = new ConnectFive();
        five.createEmpty();
        boolean done = false;
        Scanner myScanner = new Scanner(System.in);
        while (!done) {
            System.out.println("1. Add new piece.");
            System.out.println("2. Quit.");
            int choice = Integer.parseInt(myScanner.nextLine());
            if (choice == 1){
                System.out.println("Enter x-coordinate: ");
                int x = Integer.parseInt(myScanner.nextLine());
                System.out.println("Enter y-coordinate: ");
                int y = Integer.parseInt(myScanner.nextLine());
                five.insert(x,y,'R');
                int z = five.checkDepth(x,y,'R');
                if (five.check(x,y,z,'R')){
                    System.out.println("Connect five!");
                    done = true;
                }
                else System.out.println("R inserted into coordinate" + x + "" + y + "" + z);
            }
            else if (choice == 2){
                done = true;
            }
        }
    }
}
