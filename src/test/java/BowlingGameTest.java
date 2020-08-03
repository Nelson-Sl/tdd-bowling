import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {
    @Test
    void not_enough_throws_prints_error() {
        int[] scoreBoard = new int[] {10,10,10,10,10,10,10,10,10,10};
        Assertions.assertThrows(NotEnoughThrowException.class, () -> BowlingGame.printScore(scoreBoard));
    }
}
