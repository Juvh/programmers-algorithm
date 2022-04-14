package juv.study.algorithm.programmers.dfsbfs;

public class Network {
    public static void main(String[] args) {

        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static class Solution {
        boolean[] visited;

        public int solution(int n, int[][] computers) {
            visited = new boolean[n];

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                traverse(i, computers);
                cnt++;
            }
            return cnt;
        }

        private void traverse(int idx, int[][] computers) {
            if (visited[idx]) {
                return;
            }

            visited[idx] = true;

            for (int i = 0; i < computers[idx].length; i++) {
                if (computers[idx][i] == 0) continue;

                traverse(i, computers);
            }
        }
    }
}
