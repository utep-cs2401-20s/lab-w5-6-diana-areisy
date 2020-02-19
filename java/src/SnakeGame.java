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
        }
        if(game[x-1][y]){
            neighborCount++;
        }
        if(game[x][y+1]){
            neighborCount++;
        }
        if(game[x][y-1]){
            neighborCount++;
        }
        return neighborCount;
    }
    public int[] findTailExhaustive(){
        int checks = 0;
        int length = 0;
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game.length; i++){
                if(game[i][j]){
                    length++;
                    if(neighbors(i,j) == 1){
                        if(i == headPosition[0] && j == headPosition[1] ){
                            continue;
                        }
                        else if()
                    }
                    else if(neighbors(i,j) >= 2)
                }
                checks++;
            }
        }
    }
    private int[] findTailRecursive(){}
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){}
    private void resetCounters(){}
    private static int getRecursiveChecks(){}
    private static int getExhaustiveChecks(){}

}
