package juv.study.algorithm.programmers.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneNumberList {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }

    public static boolean solution(String[] phone_book) {

        Map<String, Integer> byValue = new HashMap<>();
        Set<Integer> lengthSet = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            byValue.put(phone_book[i], i);
            lengthSet.add(phone_book[i].length());
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (Integer len : lengthSet) {
                if (phone_book[i].length() < len) continue;
                Integer targetIndex = byValue.get(phone_book[i].substring(0, len));
                if (targetIndex != null && targetIndex != i) {
                    return false;
                }
            }

        }
        return true;
    }
}
