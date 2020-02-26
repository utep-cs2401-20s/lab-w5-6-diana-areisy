import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {

    // Test that make sure method is working
    @Test
    public void findTailExhaustive1() {
        boolean t = true;
        boolean f = false;

        boolean[][] A = {{f, f, f, f},
                         {f, t, t, t},
                         {f, f, f, t},
                         {f, f, f, f}};
        int x = 1;
        int y = 1;
        int[] B = {2, 3, 4};

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailExhaustive());
    }
    //Testing that method finds tail regardless
    // of being on the first row
    @Test
    public void findTailExhaustive2() {
        boolean T = true;
        boolean F = false;

        boolean[][] A = {{T, T, T, T, T},
                         {T, F, F, F, F},
                         {T, T, T, T, T},
                         {F, F, F, F, T}};
        int x = 3;
        int y = 4;
        int[] B = {0, 4, 12};

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailExhaustive());
    }
    //Test that it works when the snake is only of length one
    @Test
    public void findTailExhaustive3() {
        boolean t = true;
        boolean f = false;

        boolean[][] A = {{t, f, f},
                         {f, f, f}};
        int x = 0;
        int y = 0;
        int[] B = {0, 0, 1};

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailExhaustive());
    }
    @Test
    public void findTailExhaustive4() {
        boolean t = true;
        boolean f = false;

        boolean[][] A = {{t, f, f},
                         {f, f, f}};
        int x = 0;
        int y = 0;
        int[] B = {0, 0, 1};
        int checks = 1;

        SnakeGame snake = new SnakeGame(A, x, y);
        assertEquals(checks, snake.getExhaustiveChecks());
    }
    @Test
    public void findTailExhaustive5() {
        boolean t = true;
        boolean f = false;

        boolean[][] A = {{f, f, f, f},
                         {f, t, t, t},
                         {f, f, f, t},
                         {f, f, f, f}};
        int x = 1;
        int y = 1;
        int[] B = {2, 3, 4};
        int checks = 12;

        SnakeGame snake = new SnakeGame(A, x, y);
        snake.getExhaustiveChecks();
        assertEquals(checks, snake.getExhaustiveChecks());
    }

}
