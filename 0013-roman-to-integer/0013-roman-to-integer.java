import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int total = 0;
        int maxSeen = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = map.get(s.charAt(i));

            if (current < maxSeen) {
                total -= current;
            } else {
                total += current;
                maxSeen = current;
            }
        }

        return total;
    }
}