public class BowlingGame {
    static final int LEAST_THROW_NUM = 12;

    public static int printScore(int[] scoreBoard) throws NotEnoughThrowException {
        if(scoreBoard.length < LEAST_THROW_NUM) {
            throw new NotEnoughThrowException("You don't have enough throws.");
        }
        return 1;
    }
}
