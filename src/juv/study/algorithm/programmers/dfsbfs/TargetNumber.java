package juv.study.algorithm.programmers.dfsbfs;

import java.util.ArrayList;

public class TargetNumber {
    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    static class Solution {
        public int solution(int[] numbers, int target) {
            ArrayList<Integer> tree = new ArrayList<>();
            tree.add(0);    // first value is zero

            int length = numbers.length;

            int count = 0;

            int idx = 1;

            for (int i = 0; i < length; i++) {
                int startOfPrev = idx - (int) Math.pow(2, i);
                int endOfPrev = idx;
                int currentNumber = numbers[i];

                for (int j = startOfPrev; j < endOfPrev; j++) {
                    int plus = tree.get(j) + currentNumber;
                    tree.add(idx++, plus);
                    int minus = tree.get(j) - currentNumber;
                    tree.add(idx++, minus);

                    if (i == length - 1) {
                        if (plus == target) count++;
                        if (minus == target) count++;
                    }
                }
            }
            return count;
        }
    }
}
