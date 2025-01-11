package slidingwondow;

import java.util.HashMap;

public class LongestSubstrAfterReplacement {

        public static void main(String[] args) {
            String str = "AABABBA";
            int k = 1;
            System.out.println(countAnagrams(str, k));
        }
        /**
         * Checks to see if
         * @param
         * @return
         */
        public static int countAnagrams(String str, int k){
            HashMap<Character, Integer> mapp = new HashMap<>();
            int maxFrequnecy = 0;
            int left = 0;
            int res = 0;

            for (int right = 0; right < str.length(); right++) {
                char c = str.charAt(right);
                mapp.put(c, mapp.getOrDefault(c, 0)+1);
                maxFrequnecy = Math.max(maxFrequnecy, mapp.get(c));
                
                while((right - left+1) - maxFrequnecy > k){
                    char leftChar = str.charAt(left);
                    mapp.put(leftChar, mapp.getOrDefault(c, 0)-1);
                    left++;
                }
                res = Math.max(res, right-left+1);
            }
            return res;
        }
}
