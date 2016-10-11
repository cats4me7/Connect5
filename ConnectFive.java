import java.util.Arrays;

/**
 * Created by Jason on 10/5/2016.
 */
public class ConnectFive {
    char[] data = new char[5];
    private int size=0;
    private int maxSize=5;
    char board[][][] = new char[10][10][10];
    public char[][][] createEmpty() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    board[i][j][k] = '#';
                }
            }
        }
        return board;
    }

    public char[][][] testFill(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 5; k++) {
                    board[i][j][k] = '#';
                    if (i==0 && j==0 && k==0){
                        board[i][j][k] = 'R';
                    }
                    if (i==1 && j==0 && k==0){
                        board[i][j][k] = 'R';
                    }
                    if (i==2 && j==0 && k==0){
                        board[i][j][k] = 'R';
                    }
                    if (i==3 && j==0 && k==0){
                        board[i][j][k] = 'R';
                    }
                    if (i==4 && j==0 && k==0){
                        board[i][j][k] = 'R';
                    }
                }
            }
        }
        return board;
    }

    public void stack(char c){
        if (getSize() == 0) {
            data[0] = c;
            size++;
        } else {
            data[size+1] = c;
            size++;
        }
    }

    public char lift(char c){
        char bye = data[size];
        size--;
        return bye;
    }

    public int getSize(){return size;}

    public int getArraySize(){return maxSize;}


    public boolean isAdjacent(int x, int y, int z){
        if (board[x][y][z] == 'R'){
            return true;
        }
        else return false;
    }
    public boolean check(char[][][] board){
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (board[j][k][i] == 'R'){
                        try {
                            stack(board[j][k][i]);
                        }
                        catch (ArrayIndexOutOfBoundsException ex){}
                        for(int a=1;a<=9;a++){
                            if (isAdjacent((j+a),k,i)){
                                try {
                                    stack(board[(j + a)][k][i]);
                                }
                                catch(ArrayIndexOutOfBoundsException ex){}
                            }
                        }
                    }
                    else if (board[i][j][k] == 'Y'){

                    }
                }
            }
        }
        if (getSize()==5){
            return true;
        }
        else return false;
    }
}
