package juv.study.algorithm.programmers.unclassified;

public class Lotto {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            boolean[] winBoard = getWinBoard(win_nums);

            int matched = 0;
            int unknown = 0;
            for (int lotto : lottos) {
                if (lotto == 0) {
                    unknown++;
                    continue;
                }
                if (winBoard[lotto]) {
                    matched++;
                }
            }

            return new int[]{rank(matched + unknown), rank(matched)};
        }

        private int rank(int matched) {
            switch (matched) {
                case 6:
                    return 1;
                case 5:
                    return 2;
                case 4:
                    return 3;
                case 3:
                    return 4;
                case 2:
                    return 5;
                default:
                    return 6;
            }
        }

        private boolean[] getWinBoard(int[] win_nums) {
            boolean[] winBoard = new boolean[46];
            for (int win_num : win_nums) {
                winBoard[win_num] = true;
            }
            return winBoard;
        }
    }
}
