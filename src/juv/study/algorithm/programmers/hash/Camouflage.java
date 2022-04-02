package juv.study.algorithm.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

    class Solution {
        private static final int CLOTH_NAME_INDEX = 0;
        private static final int CLOTH_TYPE_INDEX = 1;

        public int solution(String[][] clothes) {
            Map<String, Integer> countByType = new HashMap<>();
            for (String[] cloth : clothes) {
                String type = cloth[CLOTH_TYPE_INDEX];
                Integer count = countByType.getOrDefault(type, 0);
                countByType.put(type, ++count);
            }

            int numOfCase = 1;
            for (Integer count : countByType.values()) {
                numOfCase *= (count + 1);
            }
            return --numOfCase;
        }
    }
}
