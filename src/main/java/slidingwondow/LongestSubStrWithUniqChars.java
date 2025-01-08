package slidingwondow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStrWithUniqChars {
    public static void main(String[] args) {
        String str = "abbcbde";
        System.out.println(getMaxSubStrLen(str));
    }

    /**
     * Checks to see if
     *
     * @param
     * @return
     */
    public static int getMaxSubStrLen(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char temp = s.charAt(right);
            if (!set.contains(temp)) {
                set.add(temp);
                right++;
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}
