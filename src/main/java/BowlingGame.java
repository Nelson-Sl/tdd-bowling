import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    static final int LEAST_THROW_NUM = 11;
    static final int BOWLING_ROUND = 10;

    public static int printScore(int[] scoreBoard) throws NotEnoughThrowException {
        List<Integer> roundPoints = new ArrayList<>();
        if(scoreBoard.length < LEAST_THROW_NUM) {
            throw new NotEnoughThrowException("You don't have enough throws.");
        }

        roundPoints = calculateScore(roundPoints, scoreBoard);

        int totalScore = 0;
        for(Integer points: roundPoints) {
            totalScore += points;
        }
        return totalScore;
    }

    private static List<Integer> calculateScore(List<Integer> roundPoints, int[] scoreBoard) {
        for(int i = 0; i < BOWLING_ROUND; i++) {
            if(i < BOWLING_ROUND - 1) {
                if(scoreBoard[i] == 10){
                    roundPoints.add(scoreBoard[i] + scoreBoard[i+1] + scoreBoard[i+2]);
                }
            }else{
                roundPoints.add(scoreBoard[i] + scoreBoard[i+1] + scoreBoard[i+2]);
            }
        }
        return roundPoints;
    }
}
