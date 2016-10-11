import java.util.Arrays;

/**
 * Created by Jason on 10/5/2016.
 */
public class ConnectFive {
    Stack data = new Stack(5);
    private int size=0;
    private int maxSize=5;
    private int rows = 10;
    private int col = 10;
    private int depth = 5;
    char board[][][] = new char[rows][col][depth];

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


    public int getSize(){return data.getSize();}

    public int getArraySize(){return maxSize;}


    public boolean isAdjacent(int x, int y, int z){
        if (board[x][y][z] == 'R'){
            return true;
        }
        else return false;
    }
    public boolean check(char[][][] board) {
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < col; k++) {
                    if (board[j][k][i] == 'R') {
                        data.push(board[j][k][i]);
                        board[j][k][i] = 'C';
                    }
                    for (int a = 1; a <= 4; a++) {
                        try {
                            if (isAdjacent((j + a), k, i)) {
                                data.push(board[(j + a)][k][i]);
                                board[(j + a)][k][i] = 'C';
                            }
                        }
                        catch(ArrayIndexOutOfBoundsException ex){}
                    }
                }
            }
        }
        if (getSize() == 5) {
            return true;
        } else return false;
    }
}