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

    /*
    Creates empty board (full of '#' which are read as empty spaces) to be filled with pieces.
     */
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
    Creates board with predetermined pieces, used for testing only.
     */
    public char[][][] testFill() {
        createEmpty();
        board[1][0][0] = 'Y';
        board[2][0][0] = 'Y';
        board[2][0][1] = 'Y';
        board[3][0][0] = 'Y';
        board[3][0][1] = 'Y';
        board[3][0][2] = 'Y';
        board[4][0][0] = 'Y';
        board[4][0][1] = 'Y';
        board[4][0][2] = 'Y';
        board[4][0][3] = 'Y';
        return board;
    }

    /*
    Inserts a piece c into the lowest possible depth in the x-y coordinate given.
     */
    public boolean insert(int x, int y, char c) {
        int count = 0; //variable to determine if piece was inserted or not. If it was inserted, count will equal 1.
        for (int i = 0; i < getDepth(); i++) {
            if (board[x][y][i] == '#') { //finds the lowest empty space.
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

    /*
    Checks how high a stack of pieces is at a certain x-y coordinate.
     */
    public int checkDepth(int x, int y, char c) {
        int tempD = 0;
        for(int i = 0;i<getDepth();i++) {
            if (board[x][y][i] == c){
                tempD = i;
            }
            if (board[x][y][i] == '#') {
                if (board[x][y][(i-1)] == c){
                    tempD = (i-1);
                }
            }
        }
        return tempD;
    }

    public int getDepth(){return depth;}

    public int getSize() {return data.getSize();}

    /*
    Checks if the given coordinates in the array is the same character as the piece being checked.
     */
    public boolean isAdjacent(int x, int y, int z, char c) {
        try{
            if (board[x][y][z] == c) {
                return true;
            }
            else return false;
        }
        catch (ArrayIndexOutOfBoundsException ex){return false;}
    }

    /*
    Checks the x direction for a win condition.
     */
    public boolean checkX(int x, int y, int z, char c){
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
            for (int b = 1; b <= (5-temp); b++) {
                try {
                    if (isAdjacent((x - b), y, z, c)) {
                        data.push(board[(x - b)][y][z]);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {}
            }
            if (getSize() == 5) return true;
            else {
                data.clear();
                data.push(board[x][y][z]);
                return false;
            }
        }
    }

    /*
    Checks y direction for win condition.
     */
    public boolean checkY(int x, int y, int z, char c){
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
            for (int b = 1; b <= (5-temp); b++) {
                try {
                    if (isAdjacent(x, (y-b), z, c)) {
                        data.push(board[x][(y-b)][z]);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {}
            }
            if (getSize() == 5) return true;
            else {
                data.clear();
                data.push(board[x][y][z]);
                return false;
            }
        }
    }

    /*
    Checks z direction for win condition.
     */
    public boolean checkZ(int x, int y, int z, char c){
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
            data.push(board[x][y][z]);
            return false;
        }
    }

    /*
    Checks diagonal directions for win condition.
     */
    public boolean checkD(int x, int y, int z, char c) {
        for (int a = 1; a <= 4; a++) {
            try {
                if (isAdjacent((x + a), y, (z + a), c)) {
                    data.push(board[(x + a)][y][(z + a)]);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {}
        }
        if (getSize() == 5) return true;
        else {
            int temp = getSize();
            for (int b = 1; b <= (5-temp); b++) {
                try {
                    if (isAdjacent((x - b), y, (z-b), c)) {
                        data.push(board[(x - b)][y][(z-b)]);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {}
            }
            if (getSize() == 5) return true;
            else {
                data.clear();
                data.push(board[x][y][z]);
                for (int a = 1; a <= 4; a++) {
                    try {
                        if (isAdjacent((x + a), y, (z - a), c)) {
                            data.push(board[(x + a)][y][(z - a)]);
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {}
                }
                if (getSize() == 5) return true;
                else {
                    temp = getSize();
                    for (int b = 1; b <= (5-temp); b++) {
                        try {
                            if (isAdjacent((x - b), y, (z+b), c)) {
                                data.push(board[(x - b)][y][(z+b)]);
                            }
                        } catch (ArrayIndexOutOfBoundsException ex) {}
                    }
                    }
                    if (getSize() == 5) return true;
                    else return false;
                }
            }
        }

    /*
    Uses previous methods to check all directions for win condition.
    */
    public boolean check(int x, int y, int z, char c) {
        if (board[x][y][z] == c) {
            data.push(board[x][y][z]);
            if (checkX(x,y,z,c))return true;
            else if (checkY(x,y,z,c))return true;
            else if (checkZ(x,y,z,c))return true;
            else if (checkD(x,y,z,c))return true;
            else return false;
        }
        else return false;
    }
}