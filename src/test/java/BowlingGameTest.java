import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {
    @Test
    void not_enough_throws_prints_error() {
        int[] scoreBoard = new int[] {10,10,10,10,10,10,10,10,10,10};
        Assertions.assertThrows(NotEnoughThrowException.class, () -> BowlingGame.printScore(scoreBoard));
    }

    @Test
    void all_round_had_strike_returns_full_mark() throws NotEnoughThrowException {
        //Given
        int[] scoreBoard = new int[] {10,10,10,10,10,10,10,10,10,10,10,10};
        //When
        int totalScore = BowlingGame.printScore(scoreBoard);
        //Then
        Assertions.assertEquals(300, totalScore);
    }

    @Test
    void all_round_had_strike_except_tenth_round_had_not_strike_in_second_round() throws NotEnoughThrowException {
        //Given
        int[] scoreBoard = new int[] {10,10,10,10,10,10,10,10,10,10,6,4};
        //When
        int totalScore = BowlingGame.printScore(scoreBoard);
        //Then
        Assertions.assertEquals(286, totalScore);
    }

    @Test
    void all_round_had_strike_except_tenth_round_had_not_strike_in_all_round() throws NotEnoughThrowException {
        //Given
        int[] scoreBoard = new int[] {10,10,10,10,10,10,10,10,10,6,3};
        //When
        int totalScore = BowlingGame.printScore(scoreBoard);
        //Then
        Assertions.assertEquals(264, totalScore);
    }

    @Test
    void all_round_had_strike_except_tenth_round_had_only_spare_in_all_round() throws NotEnoughThrowException {
        //Given
        int[] scoreBoard = new int[] {10,10,10,10,10,10,10,10,10,6,4,3};
        //When
        int totalScore = BowlingGame.printScore(scoreBoard);
        //Then
        Assertions.assertEquals(269, totalScore);
    }

    @Test
    void all_round_had_no_strike_or_spare() throws NotEnoughThrowException {
        //Given
        int[] scoreBoard = new int[] {5,2,7,1,7,2,2,5,3,6,2,5,4,3,5,3,2,1,5,3};
        //When
        int totalScore = BowlingGame.printScore(scoreBoard);
        //Then
        Assertions.assertEquals(73, totalScore);
    }
}
