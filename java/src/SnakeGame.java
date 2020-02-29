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

    public int[] findTailRecursive(){
        resetCounters();
        return findTailRecursive(headPosition, headPosition);
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] results = new int[3];

        return currentPosition;
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
