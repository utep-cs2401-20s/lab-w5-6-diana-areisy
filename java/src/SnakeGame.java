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

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                exhaustiveChecks ++;
                System.out.print(exhaustiveChecks);
                if (game[i][j]) {
                    length++;
                    if (neighbors(i, j) == 1) {
                        System.out.println("hi");
                        if (i == headPosition[0] && j == headPosition[1]) {
                            continue;
                        }
                        else {
                            x = i;
                            y = j;
                            foundTail = true;
                            System.out.print(foundTail);
                        }
                    }
                else if (neighbors(i, j) >= 2) {
                        continue;
                }
                }
                if(foundTail){
                    exhaustiveChecks--;
                }
            }
        }
        return new int[]{x, y, length};
    }

    private int[] findTailRecursive(){
        resetCounters();

        return new int[0];
    }
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
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
