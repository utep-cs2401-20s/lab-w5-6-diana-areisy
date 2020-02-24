import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {

@Test
public void findTailExhaustive1() {
    boolean t = true;
    boolean f = false;

    boolean[][] A = {{f, f, f, f},
            {f, t, t, t}, {f, f, f, t}, {f, f, f, f}};

    int x = 1;
    int y = 1;
    int[] B = {2, 3, 4};
    SnakeGame snake = new SnakeGame(A, x, y);
    assertArrayEquals(B, snake.findTailExhaustive());

}

}
