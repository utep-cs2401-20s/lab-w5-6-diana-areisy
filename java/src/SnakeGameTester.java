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

    //Test to make sure method works
    //PASSED

    @Test
    public void findTailRecursive1() {
        boolean t = true;
        boolean f = false;

        boolean[][] A = {{f, f, f, f},
                         {f, t, t, t},
                         {f, f, f, t},
                         {f, f, f, f}};

        int[] B = {2, 3, 4};
        int x = 1;
        int y = 1;

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailRecursive());
        assertEquals(4, snake.getRecursiveChecks());
    }

    //Testing method when snake is all on the edge
    //PASSED
    @Test
    public void findTailRecursive2() {
        boolean t = true;
        boolean f = false;

        boolean [][] A = {{t, f, f, f, f},
                          {t, f, f, f, f},
                          {t, f, f, f, f},
                          {t, f, f, f, f}} ;
        int [] B = {3, 0, 4};
        int x = 0;
        int y = 0;

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailRecursive());
        assertEquals(4, snake.getRecursiveChecks());
    }
    //Testing if the method works when there is no snake
    //PASSED

    @Test
    public void findTailRecursive3() {
        boolean t = true;
        boolean f = false;

        boolean [][] A = {{t,t,t,t},
                          {f,f,f,f}};

        int [] B = {0, 0, 2};
        int x = 0;
        int y = 3;

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailRecursive());
        assertEquals(2, snake.getRecursiveChecks());
    }

    //Testing when the snake starts on one end of the board
    // and ends on the other to make sure it works on longer
    //snakes

    @Test
    public void findTailRecursive4() {
        boolean t = true;
        boolean f = false;

        boolean [][] A = {{t, f, t, t, t},
                          {t, f, t, f, t},
                          {t, f, t, f, t},
                          {t, f, t, f, t},
                          {t, f, t, f, t},
                          {t, f, t, f, t},
                          {t, f, t, f, t},
                          {t, t, t, f, t}} ;
        int [] B = {7, 4, 26};
        int x = 0;
        int y = 0;

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailRecursive());
        assertEquals(26, snake.getRecursiveChecks());
    }
    //Edge case testing what will happen when the
    // game board isn't a rectangle
    //FAILED (since each inside array had a different length)
    @Test
    public void findTailRecursive5() {
        boolean t = true;
        boolean f = false;

        boolean [][] A = {{t},
                          {t, f},
                          {t, t, f},
                          {f, t, t, f}};
        int [] B = {0, 0, 6};
        int x = 3;
        int y = 2;

        SnakeGame snake = new SnakeGame(A, x, y);
        assertArrayEquals(B, snake.findTailRecursive());
        assertEquals(6, snake.getRecursiveChecks());
    }
}
