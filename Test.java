/**
 * Created by Jason on 10/5/2016.
 */
public class Test {
    public static void main(String args[]){
        ConnectFive five = new ConnectFive();
        for (int i=0;i<5;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    //System.out.printf("maze[%d][%d][%d]= %c\n",j,k,i, five.testFill()[j][k][i]);
                }
            }
        }
        if (five.check(five.testFill())==true){
            System.out.println("True");
        }
        else System.out.println("False");
    }
}
