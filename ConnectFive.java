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
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < depth; k++) {
                    board[i][j][k] = '#';
                }
            }
        }
        return board;
    }
/*
    public char[][][] testFill() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 5; k++) {
                    if (i == 0 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 0 && j == 1 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 0 && j == 2 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 0 && j == 3 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 0 && j == 4 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 1 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    if (i == 2 && j == 0 && k == 0) {
                        board[i][j][k] = 'R';
                    }
                    else board[i][j][k] = '#';
                }
            }
        }
        return board;
    }
    */

    public boolean insert(int x, int y, char c) {
        int count = 0;
        for (int i = 0; i < getDepth(); i++) {
            if (board[x][y][i] == '#') {
                count++;
                board[x][y][i] = c;
                System.out.println(c + " inserted in coordinate " + x + y + i);
                break;
            }
        }
        if (count == 1) return true;
        else {
            System.out.println("Depth full, please choose a different location.");
            return false;
        }
    }

    public int checkDepth(int x, int y, char c) {
        int yeet = 0;
        for(int i = 0;i<getDepth();i++) {
            if (board[x][y][i] == c){
                yeet = i;
            }
            if (board[x][y][i] == '#') {
                if (board[x][y][(i-1)] == c){
                    yeet = (i-1);
                }
            }
        }
        return yeet;
    }

    public int getDepth(){return depth;}

    public int getSize() {
        return data.getSize();
    }


    public boolean isAdjacent(int x, int y, int z, char c) {
        try{
            if (board[x][y][z] == c) {
            return true;
            }
            else return false;
        }
        catch (ArrayIndexOutOfBoundsException ex){return false;}
    }

    public boolean checkPX(int x, int y, int z, char c){
        for (int a = 1; a <= 4; a++) {
            try {
                if (isAdjacent((x + a), y, z, c)) {
                    data.push(board[(x + a)][y][z]);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {}
        }
        if (getSize()==5) {return true;}
        else {
            int temp = getSize();
            for (int b = 1; b <= 5-temp; b++) {
                try {
                    if (isAdjacent((x - b), y, z, c)) {
                        data.push(board[(x - b)][y][z]);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {}
            }
            if (getSize() == 5) return true;
            else {
                data.clear();
                return false;
            }
        }
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
        else {
            int temp = getSize();
            for (int b = 1; b <= 5-temp; b++) {
                try {
                    if (isAdjacent(x, (y-b), z, c)) {
                        data.push(board[x][(y-b)][z]);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {}
            }
            if (getSize() == 5) return true;
            else {
                data.clear();
                return false;
            }
        }
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
        else {
            data.clear();
            return false;
        }
    }

    public boolean check(int x, int y, int z, char c) {
        if (board[x][y][z] == c) {
            data.push(board[x][y][z]);
            if (checkPX(x,y,z,c))return true;
            else if (checkPY(x,y,z,c))return true;
            else if (checkNZ(x,y,z,c))return true;
            else return false;
        }
        else return false;
    }
}