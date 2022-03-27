package juv.study.algorithm.programmers.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepresentationWithN {

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(5, 5));
        System.out.println(new Solution().solution(5, 12));
        System.out.println(new Solution().solution(5, 1212121212));
        System.out.println(new Solution().solution(2, 11));
        System.out.println(new Solution().solution(2, 111));
    }

    private static class Solution {
        private static final int MIN_LEVEL = 1;
        private static final int MAX_LEVEL = 8;

        public int solution(int N, int number) {
            if (N == number) {
                return MIN_LEVEL;
            }

            List<Set<Integer>> memo = initializeMemo(N);

            for (int currentLevel = MIN_LEVEL + 1; currentLevel <= MAX_LEVEL; currentLevel++) {
                int appended = append(N, currentLevel);
                if (appended == number) {
                    return currentLevel;
                }

                Set<Integer> dataSet = new HashSet<>();
                memo.add(currentLevel, dataSet);

                dataSet.add(appended);

                for (int j = MIN_LEVEL; j < currentLevel; j++) {
                    Set<Integer> previous1 = memo.get(j);
                    Set<Integer> previous2 = memo.get(currentLevel - j);

                    for (Integer p1 : previous1) {
                        for (Integer p2 : previous2) {
                            dataSet.add(p1 + p2);
                            dataSet.add(p1 - p2);
                            dataSet.add(p1 * p2);
                            if (p1 != 0 && p2 != 0) {
                                dataSet.add(p1 / p2);
                            }
                        }
                    }
                }

                // System.out.println("LEVEL " + currentLevel + " : " + dataSet);

                if (dataSet.contains(number)) {
                    return currentLevel;
                }
            }
            return -1;
        }

        private int append(int number, int level) {
            int result = number;
            for (int i = MIN_LEVEL; i < level; i++) {
                result = result * 10 + number;
            }
            return result;
        }

        private List<Set<Integer>> initializeMemo(int N) {
            List<Set<Integer>> memo = new ArrayList<>();
            memo.add(0, new HashSet<>());
            Set<Integer> minLevelSet = new HashSet<>();
            minLevelSet.add(N);
            memo.add(MIN_LEVEL, minLevelSet);
            return memo;
        }
    }
}
