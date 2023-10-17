package onboarding;

import java.util.List;

class Problem1 {

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    private static final int WINNER_POBI = 1;
    private static final int WINNER_CRONG = 2;
    private static final int DRAW_GAME = 0;
    private static final int EXCEPTION_NUMBER = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isWrongPageListSize(pobi) || isOverFirstPageOrLastPage(pobi) || isWrongBookPage(pobi)) {
            return EXCEPTION_NUMBER;
        }

        if (isWrongPageListSize(crong) || isOverFirstPageOrLastPage(crong) || isWrongBookPage(crong)) {
            return EXCEPTION_NUMBER;
        }

        answer = getWinnerResult(getLagerPageNumber(pobi), getLagerPageNumber(crong));

        return answer;
    }

    private static boolean isWrongBookPage(List<Integer> playerList) {
        return playerList.get(0) != playerList.get(1) - 1;
    }

    private static boolean isWrongPageListSize(List<Integer> playerList) {
        return playerList.size() != 2;
    }

    private static boolean isOverFirstPageOrLastPage(List<Integer> playerList) {
        return playerList.get(0) <= FIRST_PAGE || playerList.get(0) >= LAST_PAGE
                || playerList.get(1) <= FIRST_PAGE || playerList.get(1) >= LAST_PAGE;
    }

    private static int getPageSum(int number) {
        int result = 0;

        while (number != 0) {
            result += number % 10;
            number /= 10;
        }

        return result;
    }

    private static int getPageMultiplication(int number) {
        int result = 1;

        while (number != 0) {
            result *= number % 10;
            number /= 10;
        }

        return result;
    }

    private static int getLagerPageNumber(List<Integer> playerList) {
        int leftLagerPageNumber
                = Math.max(getPageSum(playerList.get(0)), getPageMultiplication(playerList.get(0)));
        int rightLagerPageNumber
                = Math.max(getPageSum(playerList.get(1)), getPageMultiplication(playerList.get(1)));

        return Math.max(leftLagerPageNumber, rightLagerPageNumber);
    }

    private static int getWinnerResult(int pobiNumber, int crongNumber) {
        if (pobiNumber > crongNumber) {
            return 1;
        } else if (pobiNumber < crongNumber) {
            return 2;
        }

        return 0;
    }


    public static void main(String[] args) {
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong = List.of(211, 212);

        Problem1 problem1 = new Problem1();

        System.out.println(problem1.solution(pobi,crong));
    }
}