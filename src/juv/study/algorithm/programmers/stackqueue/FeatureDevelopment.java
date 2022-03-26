package juv.study.algorithm.programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FeatureDevelopment {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99, 1};
        int[] speeds = {1, 1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(new Solution().solution(progresses, speeds)));
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            int max = 0;
            int deployCount = 0;
            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < progresses.length; i++) {
                int remainDays = (100 - progresses[i]) / speeds[i] + (((100 - progresses[i]) % speeds[i] > 0) ? 1 : 0);
                if (i == 0) {
                    deployCount++;
                    max = remainDays;
                    continue;
                }

                if (remainDays > max) {
                    max = remainDays;
                    answer.add(deployCount);
                    deployCount = 1;
                } else {
                    deployCount++;
                }

                if (i == progresses.length - 1) {
                    answer.add(deployCount);
                }
            }

            return answer.stream().mapToInt(it -> it).toArray();
        }
    }
}
