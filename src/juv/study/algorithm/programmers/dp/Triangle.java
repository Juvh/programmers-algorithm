package juv.study.algorithm.programmers.dp;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    static class Solution {
        int[][] memo;

        public int solution(int[][] triangle) {
            int depth = triangle.length;
            int leafLength = triangle[depth - 1].length;
            memo = new int[depth][leafLength];

            int answer = 0;
            for (int i = 0; i < depth; i++) {
                int len = triangle[i].length;
                for (int j = 0; j < len; j++) {
                    memoize(triangle, i, j);

                    if (answer < memo[i][j]) {
                        answer = memo[i][j];
                    }
                }
            }

            return answer;
        }

        private void memoize(int[][] triangle, int i, int j) {
            if (i == 0) {
                memo[i][j] = triangle[i][j];
                return;
            }

            if (j == 0) {
                memo[i][j] = triangle[i][j] + memo[i - 1][j];
                return;
            }

            if (j == triangle[i].length - 1) {
                memo[i][j] = triangle[i][j] + memo[i - 1][j - 1];
                return;
            }

            memo[i][j] = Math.max(memo[i - 1][j - 1], memo[i - 1][j]) + triangle[i][j];
        }
    }
}
