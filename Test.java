/**
 * Created by Jason on 10/5/2016.
 */
public class Test {
    public static void main(String args[]){
        ConnectFive five = new ConnectFive();
        five.testFill();
        if (five.check(2,0,0,'R')){
            System.out.println("True");
        }
        else System.out.println("False");
        System.out.println(five.getSize());
    }
}
