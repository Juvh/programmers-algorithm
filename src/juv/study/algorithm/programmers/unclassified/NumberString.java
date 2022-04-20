package juv.study.algorithm.programmers.unclassified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("one4seveneight"));
        System.out.println(solution.solution("23four5six7"));
        System.out.println(solution.solution("2three45sixseven"));
        System.out.println(solution.solution("123"));

        System.out.println(solution.solution2("one4seveneight"));
        System.out.println(solution.solution2("23four5six7"));
        System.out.println(solution.solution2("2three45sixseven"));
        System.out.println(solution.solution2("123"));
    }

    static class Solution {
        private final Map<Character, List<Number>> NUMBERS_BY_START = new HashMap<>();
        private final String[] STRING_NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        public Solution() {
            for (int i = 0; i < STRING_NUMBERS.length; i++) {
                String val = STRING_NUMBERS[i];
                List<Number> numbers = NUMBERS_BY_START.getOrDefault(val.charAt(0), new ArrayList<>());
                numbers.add(new Number(i, val));
                NUMBERS_BY_START.put(val.charAt(0), numbers);
            }
        }

        public int solution2(String s) {
            for (int i = 0; i < STRING_NUMBERS.length; i++) {
                s = s.replaceAll(STRING_NUMBERS[i], String.valueOf(i));
            }
            return Integer.parseInt(s);
        }

        public int solution(String s) {
            int startIdx = 0;
            StringBuilder result = new StringBuilder();
            while (true) {
                if (startIdx >= s.length()) {
                    break;
                }
                char first = s.charAt(startIdx);
                List<Number> numbers = NUMBERS_BY_START.get(first);

                if (numbers == null || numbers.size() == 0) {
                    result.append(first);
                    startIdx++;
                    continue;
                }

                for (Number number : numbers) {
                    String numberString = number.val;
                    int endIndex = startIdx + numberString.length();

                    if (numberString.equalsIgnoreCase(s.substring(startIdx, endIndex))) {
                        result.append(number.num);
                        startIdx = endIndex;
                        break;
                    }
                }
            }
            return Integer.parseInt(result.toString());
        }

        class Number {
            int num;
            String val;

            public Number(int num, String val) {
                this.num = num;
                this.val = val;
            }
        }
    }
}
