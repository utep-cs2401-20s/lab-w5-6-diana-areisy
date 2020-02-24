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
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                game[i][j] = board[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }
    //Methods
    public int neighbors(int x, int y){
        int neighborCount = 0;
        if(game[x + 1][y]){
            neighborCount++;
            boolean n = game[x+1][y];
        }
        if(game[x-1][y]){
            neighborCount++;
            boolean n = game[x-1][y];
        }
        if(game[x][y+1]){
            neighborCount++;
            boolean n = game[x][y+1];
        }
        if(game[x][y-1]){
            neighborCount++;
            boolean n = game[x][y-1];
        }
        return neighborCount;
    }
    public int[] findTailExhaustive() {
        resetCounters();

        int x = 0;
        int y = 0;
        int length = 0;
        int[] taiLocation = new int[0];
        boolean foundTail = false;

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; i++) {
                if (game[i][j]) {
                    length++;
                    if (neighbors(i, j) == 1) {
                        if (i == headPosition[0] && j == headPosition[1]) {
                            continue;
                        } else {
                            x = i;
                            y = j;
                            foundTail = true;
                        }
                    }
                } else if (neighbors(i, j) >= 2) {
                    continue;

                }
                if(foundTail == true){
                    exhaustiveChecks--;
                }

            }
            exhaustiveChecks++;

        }

        return new int[]{x, y, length};
    }

    private int[] findTailRecursive(){
        return new int[0];
    }
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        return currentPosition;
    }

    private void resetCounters(){
        int exhaustiveChecks = 0;
        int recursiveChecks = 0;
    }
    private static int getRecursiveChecks(){
        return 0;
        //NEEDS FIXING
    }
    private static int getExhaustiveChecks(){
        return 0;
        //NEEDS FIXING
    }

}
