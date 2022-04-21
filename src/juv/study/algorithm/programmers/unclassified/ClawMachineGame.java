package juv.study.algorithm.programmers.unclassified;

public class ClawMachineGame {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int rowLength = board.length;
            int colLength = board[0].length;

            int[] startRow = getStartRowIndexes(board, rowLength, colLength);

            int idx = -1;
            int[] basket = new int[rowLength * colLength];

            int removed = 0;
            for (int move : moves) {

                int moveCol = move - 1;
                int targetRow = startRow[moveCol]++;
                if (targetRow >= rowLength) continue;
                int picked = board[targetRow][moveCol];
                if (idx == -1) {
                    basket[++idx] = picked;
                    continue;
                }
                if (basket[idx] == picked) {
                    basket[idx--] = 0;
                    removed += 2;
                } else {
                    basket[++idx] = picked;
                }
            }

            return removed;
        }

        private int[] getStartRowIndexes(int[][] board, int rowLength, int colLength) {
            int[] startRow = new int[colLength];

            for (int col = 0; col < colLength; col++) {
                for (int row = 0; row < rowLength; row++) {
                    if (board[row][col] > 0) {
                        startRow[col] = row;
                        break;
                    }
                }
            }
            return startRow;
        }
    }
}
