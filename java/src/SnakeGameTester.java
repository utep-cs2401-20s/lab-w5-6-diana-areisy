import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeGameTester {

    // EXHAUSTIVE TEST CASES //

    // Test that make sure method is working
    //PASSED AND CHECKS WERE CORRECT
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
        assertEquals(12, snake.getExhaustiveChecks());
    }

    //Testing that method finds tail regardless
    // of being on the first row
    //PASSED AND CHECKS WERE CORRECT
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
        assertEquals(5, snake.getExhaustiveChecks());
    }

    //Tests that method works when the snake is only of length ONE
    //PASSED AND CHECKS WERE CORRECT
    @Test
    public void findTailExhaustive3() {
        boolean t = true;
        boolean f = false;

        boolean[][] A = {{f, t, f},
                         {f, f, f},
                         {f, f, f}};
        int x = 0;
        int y = 1;
        int[] B = {0, 1, 1};

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailExhaustive());
        assertEquals(2, snake.getExhaustiveChecks());
    }
    //Edge case which should fail since snake body
    // will be next to each other
    // FAILED PASS (technically this is good)
    @Test
    public void findTailExhaustive4() {
        boolean t = true;
        boolean f = false;

        boolean[][] A = {{f, f, t},
                         {f, t, t},
                         {f, t, t}};
        int x = 0;
        int y = 2;
        int[] B = {1, 1, 5};

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailExhaustive());
        assertEquals(9, snake.getExhaustiveChecks());
    }
    //Testing that method works with a 1d array
    //TEST PASSED AND CHECKS WERE CORRECT
    @Test
    public void findTailExhaustive5() {
        boolean t = true;
        boolean f = false;

        boolean[][] A = {{f, t, t, f}};
        int x = 0;
        int y = 1;
        int[] B = {0, 2, 2};

        SnakeGame snake = new SnakeGame(A, x, y);
        snake.getExhaustiveChecks();
        assertArrayEquals(B, snake.findTailExhaustive());
        assertEquals(3, snake.getExhaustiveChecks());
    }

    /*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*/

    // NEIGHBORS TEST CASE //

    //Checking if neighbors method works
    // TEST: PASSED

    @Test
    public void neighbors() {
        boolean f = false;
        boolean t = true;

        boolean[][] A = {{f, f, f, f},
                         {f, t, t, t},
                         {f, f, f, t},
                         {f, f, f, f}};
        int x = 1;
        int y = 1;
        int[] B = {2, 3, 4};
        int n = 1;

        SnakeGame snake  = new SnakeGame(A, x, y);
        System.out.print(snake.neighbors(2,3)) ;
        snake.neighbors(2, 3);
        assertEquals(n, snake.neighbors(2,3));
    }

    /* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*/

    // RECURSIVE TEST CASES //
}
