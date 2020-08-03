import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    static final int LEAST_THROW_NUM = 11;
    static final int BOWLING_ROUND = 10;

    public static int printScore(int[] scoreBoard) throws NotEnoughThrowException {
        List<Integer> roundPoints = new ArrayList<>();
        if(scoreBoard.length < LEAST_THROW_NUM ) {
            throw new NotEnoughThrowException("You don't have enough throws.");
        }

        roundPoints = calculateRoundScore(roundPoints, scoreBoard);

        int totalScore = 0;
        for(Integer points: roundPoints) {
            totalScore += points;
        }
        return totalScore;
    }

    private static List<Integer> calculateRoundScore(List<Integer> roundPoints, int[] scoreBoard) {
        int currentIndex = 0;
        for(int i = 0; i < BOWLING_ROUND; i++) {
            if(!isOnLastRound(i) && isStrike(scoreBoard[currentIndex])) {
                roundPoints.add(scoreBoard[currentIndex] + scoreBoard[currentIndex+1] + scoreBoard[currentIndex+2]);
                currentIndex++;
            } else if(!isOnLastRound(i) && isSpare(scoreBoard[currentIndex],scoreBoard[currentIndex+1])) {
                    roundPoints.add(scoreBoard[currentIndex] + scoreBoard[currentIndex+1] + scoreBoard[currentIndex+2]);
                    currentIndex += 2;
            } else if(!isOnLastRound(i)){
                roundPoints.add(scoreBoard[currentIndex] + scoreBoard[currentIndex+1]);
                currentIndex += 2;
            } else if(isOnLastRound(i) && isStrike(scoreBoard[currentIndex]) ||
                isSpare(scoreBoard[currentIndex], scoreBoard[currentIndex+1])){
                roundPoints.add(scoreBoard[currentIndex] + scoreBoard[currentIndex+1] + scoreBoard[currentIndex+2]);
            } else{
                roundPoints.add(scoreBoard[currentIndex] + scoreBoard[currentIndex+1]);
            }
        }
        return roundPoints;
    }

    private static boolean isStrike(int score) {
        return score == 10;
    }

    private static boolean isSpare(int score1, int score2) {
        return score1 + score2 == 10;
    }

    private static boolean isOnLastRound (int round) {
        return round >= BOWLING_ROUND;
    }
}
