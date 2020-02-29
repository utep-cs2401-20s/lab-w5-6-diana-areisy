public class SnakeGame {

    //Attributes
    private boolean [][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //Constructors
    public SnakeGame(){
        boolean [][] emptyBoard = {};
    }
    public SnakeGame(boolean[][] board, int x, int y){
        headPosition = new int[2];
        game = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                game[i][j] = board[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }
    //Methods
    public int neighbors(int x, int y){
        int neighborCount = 0;

        if(x + 1 < game.length && game[x + 1][y]) {
            neighborCount++;
        }
        if(x - 1 >= 0 && game[x - 1][y]) {
            neighborCount++;
        }
        if(y + 1 < game[0].length && game[x][y+1]) {
            neighborCount++;
        }
        if(y - 1 >= 0 && game[x][y - 1]) {
            neighborCount++;
        }

        return neighborCount;
    }
    public int[] findTailExhaustive() {
        resetCounters();

        int x = 0;
        int y = 0;
        int length = 0;
        boolean foundTail = false;
        int[] results = new int [3];

        //Nested for loops will go through each cell of the game
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                if(!foundTail){
                    exhaustiveChecks++;
                }
                //If statement checks if there is a part of the snake on the specific cell
                if(game[i][j]) {
                    length++;
                    if(neighbors(i, j) == 1 && !(i == headPosition[0] && j == headPosition[1])) {
                        results[0] = i;
                        results[1] = j;
                        foundTail = true;
                    }
                    //If statement in case the snake is of size 1 and the head technically is the tail
                    if(neighbors(i, j) == 0 && i == headPosition[0] && j == headPosition[1]) {
                        results[0] = i;
                        results[1] = j;
                        foundTail = true;
                    }
                }
            }
        }
        results[2] = length;
        return results;
    }
    //Method that helps find the position of the neighbors faster
    //and makes findRecursiveTail cleaner
    public int[] neighborPosition(int[] previousPosition, int[] currentPosition){
        int ppZero = previousPosition[0];
        int ppOne = previousPosition[1];
        int cpZero = currentPosition[0];
        int cpOne = currentPosition[1];
        int[] nPosition = new int[2];

        if (cpZero - 1 >= 0 && cpOne - 1 < game.length) {
            if (game[cpZero - 1][cpOne] && (cpZero - 1 != ppZero || cpOne != ppOne)) {
                nPosition[0] = cpZero - 1;
                nPosition[1] = cpOne;
                return nPosition;
            }
        }
        if (cpZero + 1 >= 0 && cpZero + 1 < game.length) {
            if (game[cpZero + 1][cpOne] && (cpZero + 1 != ppZero || cpOne != ppOne)) {
                nPosition[0] = cpZero + 1;
                nPosition[1] = cpOne;
                return nPosition;
            }
        }
        if (cpOne - 1 >= 0 && cpOne - 1 < game.length) {
            if (game[cpZero][cpOne - 1] && (cpZero != ppZero || cpOne - 1 != ppOne)) {
                nPosition[0] = cpZero;
                nPosition[1] = cpOne - 1;
                return nPosition;
            }
        }
        if (cpOne + 1 >= 0 && cpOne + 1 < game.length) {
            if (game[cpZero][cpOne + 1] && (cpZero != ppZero || cpOne + 1 != ppOne)) {
                nPosition[0] = cpZero;
                nPosition[1] = cpOne + 1;
                return nPosition;
            }
        }
        return nPosition;
    }

    public int[] findTailRecursive(){
        resetCounters();
        return findTailRecursive(headPosition, headPosition);
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        int[] results = new int[3];

        //This if statement checks if you're at the tail since the tail will only have one neighbor
        if(neighbors(currentPosition[0],currentPosition[1]) == 1 &&
                !(currentPosition[0] == previousPosition[0] && currentPosition[1] == previousPosition[1])) {
            recursiveChecks++;
            results[0] = currentPosition[0]; //if it is the tail, the position gets stored in the results array
            results[1] = currentPosition[1];
            results[2] = recursiveChecks;//recursive checks should be the same as the length
                                        // since the recursive method only goes through the snake
            return results;
        }
        //Else statement takes the cells that have more than one neighbor and moves their position to previous.
        //Then uses the neighbor that and makes it the current position.
        //Lastly it returns the same method for the new cell and it will keep going until it finds the tail.

        else {
            recursiveChecks++;
            int[] neighbor = neighborPosition(previousPosition, currentPosition);
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            return findTailRecursive(neighbor ,previousPosition);
        }
    }

    private static void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public static int getRecursiveChecks() {
        return recursiveChecks;
    }
    public static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

}
