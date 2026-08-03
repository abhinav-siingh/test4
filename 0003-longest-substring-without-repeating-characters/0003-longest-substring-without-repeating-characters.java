import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        
        // Stores the last seen index + 1 for each character (0 means not seen yet)
        int[] lastSeen = new int[128];

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If currentChar was seen, jump left pointer to right of previous occurrence
            left = Math.max(left, lastSeen[currentChar]);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);

            // Store (index + 1) so default array value 0 correctly represents 'unseen'
            lastSeen[currentChar] = right + 1;
        }

        return maxLength;
    }
}