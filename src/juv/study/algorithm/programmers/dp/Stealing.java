package juv.study.algorithm.programmers.dp;

public class Stealing {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 1}));
        System.out.println(solution.solution(new int[]{1, 1, 4, 1, 4}));
    }

    static class Solution {
        public int solution(int[] money) {
            int length = money.length;
            int[] firstToPrevLast = new int[length];
            int[] secondToLast = new int[length];

            firstToPrevLast[0] = money[0];
            firstToPrevLast[1] = money[0];

            secondToLast[0] = 0;
            secondToLast[1] = money[1];

            for (int i = 2; i < length - 1; i++) {
                firstToPrevLast[i] = Math.max(firstToPrevLast[i - 2] + money[i], firstToPrevLast[i - 1]);
                secondToLast[i] = Math.max(secondToLast[i - 2] + money[i], secondToLast[i - 1]);
            }
            firstToPrevLast[length - 1] = firstToPrevLast[length - 2];
            secondToLast[length - 1] = Math.max(secondToLast[length - 3] + money[length - 1], secondToLast[length - 2]);

            return Math.max(firstToPrevLast[length - 1], secondToLast[length - 1]);
        }
    }
}