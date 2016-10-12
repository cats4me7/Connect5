import java.util.Arrays;

/**
 * Created by Jason on 10/5/2016.
 */
public class ConnectFive {
    Stack data = new Stack(5);
    private int size = 0;
    private int maxSize = 5;
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

    public char[][][] testFill() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 5; k++) {
                    board[i][j][k] = '#';
                    if (i == 0 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 1 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 2 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i ==3 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 4 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 0 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 0 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                }
            }
        }
        return board;
    }


    public int getSize() {
        return data.getSize();
    }

    public int getArraySize() {
        return maxSize;
    }


    public boolean isAdjacent(int x, int y, int z, char c) {
        if (board[x][y][z] == c) {
            return true;
        } else return false;
    }

    public boolean checkPX(int x, int y, int z, char c){
        for (int a = 1; a <= 4; a++) {
            try {
                if (isAdjacent((x + a), y, z, c)) {
                    data.push(board[(x + a)][y][z]);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {}
        }
        if (getSize()==5) return true;
        else return false;
            /* Working on checking both sides
            for(int b=1;b<=(5-getSize());b++){
                try {
                    if (isAdjacent((x - b), y, z, c)) {
                        data.push(board[(x - b)][y][z]);
                    }
                } catch (ArrayIndexOutOfBoundsException ex){}
            }
            if (getSize()==5) return true;
            else {
                data.clear();
                return false;
            }
            */
    }

    public boolean checkNX(int x, int y, int z, char c){
        for (int a = 1; a <= 4; a++) {
            try {
                if (isAdjacent((x - a), y, z, c)) {
                    data.push(board[(x - a)][y][z]);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {}
        }
        if (getSize()==5) return true;
        else return false;
    }
    public boolean checkPY(int x, int y, int z, char c){
        for (int a = 1; a <= 4; a++) {
            try {
                if (isAdjacent(x, (y+a), z, c)) {
                    data.push(board[x][(y+a)][z]);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {}
        }
        if (getSize()==5) return true;
        else return false;
    }
    public boolean checkNY(int x, int y, int z, char c){
        for (int a = 1; a <= 4; a++) {
            try {
                if (isAdjacent(x, (y-a), z, c)) {
                    data.push(board[x][(y-a)][z]);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {}
        }
        if (getSize()==5) return true;
        else return false;
    }

    public boolean checkPZ(int x, int y, int z, char c){
        for (int a = 1; a <= 4; a++) {
            try {
                if (isAdjacent(x, y, (z+a),c)) {
                    data.push(board[x][y][(z+a)]);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {}
        }
        if (getSize()==5) return true;
        else return false;
    }

    public boolean checkNZ(int x, int y, int z, char c){
        for (int a = 1; a <= 4; a++) {
            try {
                if (isAdjacent(x, y, (z-a), c)) {
                    data.push(board[x][y][(z-a)]);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {}
        }
        if (getSize()==5) return true;
        else return false;
    }

    public boolean check(int x, int y, int z, char c) {
        if (board[x][y][z] == c) {
            data.push(board[x][y][z]);
            if (checkPX(x,y,z,c))return true;
            else if (checkNX(x,y,z,c))return true;
            else if (checkPY(x,y,z,c))return true;
            else if (checkNY(x,y,z,c))return true;
            else if (checkPZ(x,y,z,c))return true;
            else if (checkNZ(x,y,z,c))return true;
            else return false;
        }
        else return false;
    }
}