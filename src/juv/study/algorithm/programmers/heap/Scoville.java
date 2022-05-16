package juv.study.algorithm.programmers.heap;

import java.util.*;

public class Scoville {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    static class Solution {
        public int solution(int[] scoville, int K) {

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int s : scoville) {
                priorityQueue.add(s);
            }

            int cnt = 0;
            while (true) {
                Integer first = priorityQueue.poll();
                if (first > K) {
                    return cnt;
                }
                if (priorityQueue.size() == 0) {
                    return -1;
                }
                Integer second = priorityQueue.poll();

                int calculated = calculate(first, second);
                priorityQueue.add(calculated);
                cnt++;
            }
        }

        private int calculate(int a, int b) {
            if (a > b) {
                return b + (a * 2);
            }
            return a + (b * 2);
        }
    }
}
