import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by Jason on 10/5/2016.
 */
public class ConnectFive {
    private Stack data = new Stack(5);
    private Scanner myScanner = new Scanner(System.in);
    private int rows=10;
    private int col=10;
    private int depth=10;
    private boolean valid = true;
    private char[][][] board = new char[rows][col][depth];

    /*
    public ConnectFive(int rows, int col, int depth){
        this.rows=rows;
        this.col=col;
        this.depth=depth;
    }
    */

    /*
    Creates empty board (full of '#' which are read as empty spaces) to be filled with pieces.
     */
    public char[][][] createEmpty() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < depth; k++) {
                    board[i][j][k] = '#';
                }
            }
        }
        return board;
    }

    public boolean getValid(){return valid;}

    /*
    Creates board with predetermined pieces, used for testing only.
     */
    public char[][][] testFill() {
        createEmpty();
        board[1][1][0] = 'Y';
        board[2][2][0] = 'Y';
        board[2][2][1] = 'Y';
        board[3][3][0] = 'Y';
        board[3][3][1] = 'Y';
        board[3][3][2] = 'Y';
        board[9][9][0] = 'Y';
        board[9][9][1] = 'Y';
        board[9][9][2] = 'Y';
        board[9][9][3] = 'Y';
        board[9][9][4] = 'Y';
        board[9][9][5] = 'Y';
        board[9][9][6] = 'Y';
        board[9][9][7] = 'Y';
        board[9][9][8] = 'Y';
        return board;
    }

    public boolean playerTurn(char c){
        boolean win = false;
        try {
            System.out.println("Enter x-coordinate: ");
            int x = Integer.parseInt(myScanner.nextLine());
            System.out.println("Enter y-coordinate: ");
            int y = Integer.parseInt(myScanner.nextLine());
            insert(x,y,c);
            int z = checkDepth(x,y,c);
            if (check(x,y,z,c)){
                win = true;
            }
        } catch(NumberFormatException ex){System.out.println("Try again...");}
        return win;
    }

    /*
    Inserts a piece c into the lowest possible depth in the x-y coordinate given.
     */
    public boolean insert(int x, int y, char c) {
        int count = 0; //variable to determine if piece was inserted or not. If it was inserted, count will equal 1.
        int out = 0;
        for (int i = 0; i < getDepth(); i++) {
            try {
                if (board[x][y][i] == '#') { //finds the lowest empty space.
                    count++;
                    board[x][y][i] = c;
                    System.out.println(c + " inserted in coordinate " + x + y + i);
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException ex){System.out.println("Invalid move"); out = 1;break;}
        }
        if (out == 1) {
            valid = false;
            return false;
        }
        else if (count == 1) {
            valid = true;
            return true;
        }
        else {
            System.out.println("Depth full, please choose a different location.");
            valid = false;
            return false;
        }
    }

    /*
    Checks how high a stack of pieces is at a certain x-y coordinate.
     */
    public int checkDepth(int x, int y, char c) {
        int tempD = 0;
        for(int i = 0;i<getDepth();i++) {
            try {
                if (board[x][y][i] == c) {
                    tempD = i;
                }
                if (board[x][y][i] == '#') {
                    if (board[x][y][(i - 1)] == c) {
                        tempD = (i - 1);
                    }
                }
            } catch(ArrayIndexOutOfBoundsException ex){break;}
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

    public boolean isOut(int x, int y, int z){
        if (x>=rows || x<0)return true;
        else if (y>=col || y<0) return true;
        else if (z>=depth || z<0) return true;
        else return false;
    }

    /*
    Checks the x direction for a win condition.
     */
    public boolean checkX(int x, int y, int z, char c){
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent((x + a), y, z, c)) {
                data.push(board[(x + a)][y][z]);
            }
            else if (isOut((x+a),y,z)){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getSize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(t,y,z,c)){
                    data.push(board[t][y][z]);
                }
            }
        }
        if (getSize()==5) {return true;}
        else {
            int temp = getSize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent((x - b), y, z, c)) {
                    data.push(board[(x - b)][y][z]);
                }
                else if (isOut((x-b),y,z)){
                    track = 2;
                    break;
                }
                else break;
            }
            if (track==2){
                temp = getSize();
                for(int t = (rows-1); t>((rows-1)-(5-temp));t--){
                    if (isAdjacent(t,y,z,c)){
                        data.push(board[t][y][z]);
                    }
                }
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
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent(x, (y+a), z, c)) {
                data.push(board[x][(y+a)][z]);
            }
            else if (isOut(x,(y+a),z)){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getSize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(x,t,z,c)){
                    data.push(board[x][t][z]);
                }
            }
        }
        if (getSize()==5) return true;
        else {
            int temp = getSize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent(x, (y-b), z, c)) {
                    data.push(board[x][(y-b)][z]);
                }
                else if (isOut(x,(y-b),z)){
                    track = 2;
                    break;
                }
                else break;
            }
            if (track==2){
                temp = getSize();
                for(int t = (rows-1); t>((rows-1)-(5-temp));t--){
                    if (isAdjacent(x,t,z,c)){
                        data.push(board[x][t][z]);
                    }
                }
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
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent(x, y, (z-a), c)) {
                data.push(board[x][y][(z-a)]);
            }
            else break;
        }

        if (getSize()==5) return true;
        else {
            int temp = getSize();
            if (isOut(x,y,(z+1))){
                for (int b = 0; b<(5-temp); b++){
                    if (isAdjacent(x,y,b,c)){
                        data.push(board[x][y][b]);
                    }
                }
            }
            if(getSize()==5) return true;
            else{
                data.clear();
                data.push(board[x][y][z]);
                return false;
            }
        }
    }

    /*
    Checks diagonal directions for win condition.
     */
    public boolean checkXD(int x, int y, int z, char c) {
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent((x + a), y, (z + a), c)) {
                data.push(board[(x + a)][y][(z + a)]);
            }
            else if (isOut((x+a),y,z) && isOut(x,y,(z+a))){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getSize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(t,y,t,c)){
                    data.push(board[t][y][t]);
                }
                else break;
            }
        }
        if (getSize() == 5) return true;
        else {
            int temp = getSize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent((x - b), y, (z-b), c)) {
                    data.push(board[(x - b)][y][(z-b)]);
                }
                else if (isOut((x-b),y,z) && isOut(x,y,(z-b))){
                    track = 2;
                    break;
                }
                else break;
            }
            if(track==2){
                for(int t = (rows-1); t > ((rows-1)-(5-temp));t++){
                    if(isAdjacent(t,y,t,c)){
                        data.push(board[t][y][t]);
                    }
                    else break;
                }
            }
            if (getSize() == 5) return true;
            else {
                data.clear();
                data.push(board[x][y][z]);
                for (int a = 1; a <= 4; a++) {
                    if (isAdjacent((x + a), y, (z - a), c)) {
                        data.push(board[(x + a)][y][(z - a)]);
                    }
                    else if (isOut((x+a),y,z) && isOut(x,y,(z-a))){
                        track = 3;
                        break;
                    }
                    else break;
                }
                if (track == 3){
                    int tempD = getDepth();
                    for(int t = 0; t < (5-temp); t++){
                        tempD--;
                        if(isAdjacent(t,y,tempD,c)){
                            data.push(board[t][y][tempD]);
                        }
                        else break;
                    }
                }
                if (getSize() == 5) return true;
                else {
                    temp = getSize();
                    for (int b = 1; b <= (5-temp); b++) {
                        if (isAdjacent((x - b), y, (z+b), c)) {
                            data.push(board[(x - b)][y][(z+b)]);
                        }
                        else if (isOut((x-b),y,z) && isOut(x,y,(z+b))){
                            track = 4;
                            break;
                        }
                        else break;
                    }
                }
                if (track == 4){
                    int tempD = 0;
                    for(int t = (rows-1);t>((rows-1)-(5-temp));t-- ){
                        if(isAdjacent(t,y,tempD,c)){
                            data.push(board[t][y][tempD]);
                            tempD++;
                        }
                        else break;
                    }
                }
                if (getSize() == 5) return true;
                else return false;
            }
        }
    }

    public boolean checkYD(int x, int y, int z, char c) {
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent(x + a, (y+a), (z + a), c)) {
                data.push(board[x][(y+a)][(z + a)]);
            }
            else if (isOut(x,(y+a),z) && isOut(x,y,(z+a))){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getSize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(x,t,t,c)){
                    data.push(board[x][t][t]);
                }
                else break;
            }
        }
        if (getSize() == 5) return true;
        else {
            int temp = getSize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent(x, (y-b), (z-b), c)) {
                    data.push(board[x][(y-b)][(z-b)]);
                }
                else if (isOut(x,(y-b),z) && isOut(x,y,(z-b))){
                    track = 2;
                    break;
                }
                else break;
            }
            if(track==2){
                for(int t = (col-1); t< ((col-1)-(5-temp));t++){
                    if(isAdjacent(x,t,t,c)){
                        data.push(board[x][t][t]);
                    }
                    else break;
                }
            }
            if (getSize() == 5) return true;
            else {
                data.clear();
                data.push(board[x][y][z]);
                for (int a = 1; a <= 4; a++) {
                    if (isAdjacent(x, (y+a), (z - a), c)) {
                        data.push(board[x][(y+a)][(z - a)]);
                    }
                    else if (isOut(x,(y+a),z) && isOut(x,y,(z-a))){
                        track = 3;
                    }
                    else break;
                }
                if (track == 3){
                    int tempD = getDepth();
                    for(int t = 0; t < (5-temp); t++){
                        tempD--;
                        if(isAdjacent(x,t,tempD,c)){
                            data.push(board[x][t][tempD]);
                        }
                        else break;
                    }
                }
                if (getSize() == 5) return true;
                else {
                    temp = getSize();
                    for (int b = 1; b <= (5-temp); b++) {
                        if (isAdjacent(x, (y-b), (z+b), c)) {
                            data.push(board[x][(y-b)][(z+b)]);
                        }
                        else if (isOut(x,(y-b),z) && isOut(x,y,(z+b))){
                            track = 4;
                            break;
                        }
                        else break;
                    }
                }
                if (track == 4){
                    int tempD = 0;
                    for(int t = (col-1);t>((col-1)-(5-temp));t-- ){
                        if(isAdjacent(x,t,tempD,c)){
                            data.push(board[x][t][tempD]);
                            tempD++;
                        }
                        else break;
                    }
                }
                if (getSize() == 5) return true;
                else return false;
            }
        }
    }


    public boolean checkXYD(int x, int y, int z, char c){
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent((x + a), (y+a), (z + a), c)) {
                data.push(board[(x + a)][(y+a)][(z + a)]);
            }
            else if (isOut((x+a),y,z) && isOut(x,(y+a),z) && isOut(x,y,(z+a))){
                track = 1;
                break;
            }
            else break;
        }
        if (track==1){
            int temp = getSize();
            for(int t=0;t<(5-temp);t++){
                if(isAdjacent(t,t,t,c)){
                    data.push(board[t][t][t]);
                }
                else break;
            }
        }
        if (getSize() == 5) return true;
        else {
            int temp = getSize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent((x-b),(y-b),(z-b), c)) {
                    data.push(board[(x-b)][(y-b)][(z-b)]);
                }
                else if (isOut((x-b),y,z) && isOut(x,(y-b),z) && isOut(x,y,(z-b))){
                    track = 2;
                    break;
                }
                else break;
            }
            if (track == 2){
                temp = getSize();
                for(int t=(rows-1);t>((rows-1)-(5-temp));t--){
                    if(isAdjacent(t,t,t,c)){
                        data.push(board[t][t][t]);
                    }
                    else break;
                }
            }
            if (getSize() == 5) return true;
            else {
                data.clear();
                data.push(board[x][y][z]);
                for (int a = 1; a <= 4; a++) {
                    if (isAdjacent((x+a),(y+a),(z-a), c)) {
                        data.push(board[(x+a)][(y+a)][(z-a)]);
                    }
                    else if (isOut((x+a),y,z) && isOut(x,(y+a),z) && isOut(x,y,(z-a))){
                        track = 3;
                    }
                    else break;
                }
                if (track == 3){
                    temp = getSize();
                    int tempD=getDepth();
                    for(int t=0;t<(5-temp);t++) {
                        tempD--;
                        if(isAdjacent(t,t,tempD,c)){
                            data.push(board[t][t][tempD]);
                        }
                        else break;
                    }
                }
                if (getSize() == 5) return true;
                else {
                    temp = getSize();
                    for (int b = 1; b <= (5-temp); b++) {
                        if (isAdjacent((x-b),(y-b),(z+b), c)) {
                            data.push(board[(x-b)][(y-b)][(z+b)]);
                        }
                        else if (isOut((x-b),y,z) && isOut(x,(y-b),z) && isOut(x,y,(z+b))){
                            track = 4;
                            break;
                        }
                        else break;
                    }
                }
                if (track == 4){
                    int tempD = 0;
                    for(int t = (rows-1); t>((rows-1)-(5-temp));t--){
                        if(isAdjacent(t,t,tempD,c)){
                            data.push(board[t][t][tempD]);
                            tempD++;
                        }
                        else break;
                    }
                }
                if (getSize() == 5) return true;
                else {
                    data.clear();
                    data.push(board[x][y][z]);
                    for (int a = 1; a <= 4; a++) {
                        if (isAdjacent((x+a),(y-a),(z+a), c)) {
                            data.push(board[(x+a)][(y-a)][(z+a)]);
                        }
                        else if (isOut((x+a),y,z) && isOut(x,(y-a),z) && isOut(x,y,(z+a))){
                            track = 5;
                            break;
                        }
                        else break;
                    }
                    if (track == 5){
                        int tempX = 0;
                        for(int t = (col-1); t>((col-1)-(5-temp));t--){
                            if(isAdjacent(tempX,t,tempX,c)){
                                data.push(board[tempX][t][tempX]);
                                tempX++;
                            }
                            else break;
                        }
                    }
                    if (getSize() == 5) return true;
                    else {
                        temp = getSize();
                        for (int b = 1; b <= (5-temp); b++) {
                            if (isAdjacent((x-b),(y+b),(z-b), c)) {
                                data.push(board[(x-b)][(y+b)][(z-b)]);
                            }
                            else if (isOut((x-b),y,z) && isOut(x,(y+b),z) && isOut(x,y,(z-b))){
                                track = 6;
                                break;
                            }
                            else break;
                        }
                    }
                    if (track == 6){
                        int tempY = 0;
                        for(int t = (rows-1);t>((rows-1)-(5-temp));t--){
                            if(isAdjacent(t,tempY,t,c)){
                                data.push(board[t][tempY][t]);
                                tempY++;
                            }
                            else break;
                        }
                    }
                    if (getSize() == 5) return true;
                    else{
                        data.clear();
                        data.push(board[x][y][z]);
                        for (int a = 1; a <= 4; a++) {
                            if (isAdjacent((x-a),(y+a),(z+a), c)) {
                                data.push(board[(x-a)][(y+a)][(z+a)]);
                            }
                            else if (isOut((x-a),y,z) && isOut(x,(y+a),z) && isOut(x,y,(z+a))){
                                track = 7;
                                break;
                            }
                            else break;
                        }
                        if(track == 7){
                            int tempD = 0;
                            for(int t = (rows - 1);t>((rows - 1)-(5-temp));t--){
                                if(isAdjacent(t,tempD,tempD,c)){
                                    data.push(board[t][tempD][tempD]);
                                    tempD++;
                                }
                                else break;
                            }
                        }
                        if (getSize() == 5) return true;
                        else {
                            temp = getSize();
                            for (int b = 1; b <= (5-temp); b++) {
                                if (isAdjacent((x+b),(y-b),(z-b), c)) {
                                    data.push(board[(x+b)][(y-b)][(z-b)]);
                                }
                                else if (isOut((x+b),y,z) && isOut(x,(y-b),z) && isOut(x,y,(z-b))){
                                    track = 8;
                                    break;
                                }
                                else break;
                            }
                        }
                        if(track == 8){
                            int tempX=0;
                            for(int t = (col-1);t>((col-1)-(5-temp));t--){
                                if(isAdjacent(tempX,t,t,c)){
                                    data.push(board[tempX][t][t]);
                                    tempX++;
                                }
                                else break;
                            }
                        }
                        if (getSize() == 5) return true;
                        else return false;
                    }
                }
            }
        }
    }

    /*
    Uses previous methods to check all directions for win condition.
    */
    public boolean check(int x, int y, int z, char c) {
        try {
            if (board[x][y][z] == c) {
                data.push(board[x][y][z]);
                if (checkX(x, y, z, c)) return true;
                else if (checkY(x, y, z, c)) return true;
                else if (checkZ(x, y, z, c)) return true;
                else if (checkXD(x, y, z, c)) return true;
                else if (checkYD(x, y, z, c))return true;
                else if (checkXYD(x, y, z, c)) return true;
                else {
                    data.clear();
                    return false;
                }
            } else {
                data.clear();
                return false;
            }
        }catch(ArrayIndexOutOfBoundsException ex){return false;}
    }
}