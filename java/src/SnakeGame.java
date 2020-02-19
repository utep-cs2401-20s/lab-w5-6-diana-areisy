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
    public int[] findTailExhaustive(){}
    private int[] findTailRecursive(){}
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){}
    private void resetCounters(){}
    private static int getRecursiveChecks(){}
    private static int getExhaustiveChecks(){}

}
