package juv.study.algorithm.programmers.fullsearch;

import java.util.stream.IntStream;

public class MockExam {
    private static class Solution {
        public int[] solution(int[] answers) {
            int[] first = {1, 2, 3, 4, 5};
            int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int[] scores = new int[]{0, 0, 0};

            for (int number = 0; number < answers.length; number++) {
                if (first[number % first.length] == answers[number]) scores[0]++;
                if (second[number % second.length] == answers[number]) scores[1]++;
                if (third[number % third.length] == answers[number]) scores[2]++;
            }

            int max = Math.max(Math.max(scores[0], scores[1]), scores[2]);
            return IntStream.range(0, scores.length)
                    .filter(idx -> scores[idx] == max)
                    .map(idx -> idx + 1)
                    .toArray();
        }
    }
}
