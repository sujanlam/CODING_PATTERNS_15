package slidingwondow;

import utilities.PrintData;

import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        String mainStr = "caabab";
        String str = "aba";
        System.out.println(countAnagrams(mainStr, str));
    }
    /**
     * Checks to see if
     * @param
     * @return
     */
    public static int countAnagrams(String mainStr, String str){
        if(str.length() >= mainStr.length()){
            return 0;
        }
        int count = 0;

        int[] mainStrCount = new int[26];
        int[] strCount = new int[26];

        for (char c: str.toCharArray()) {
            strCount[c-'a']++;
        }
        PrintData.printArray(strCount);
        System.out.println("mainStr arr:");;
        for (int i = 0; i < mainStr.length(); i++) {
            mainStrCount[mainStr.charAt(i) - 'a']++;
            if(i >= str.length()){
                mainStrCount[mainStr.charAt(i-str.length()) - 'a']--;
            }

            PrintData.printArray(mainStrCount);
            if(Arrays.equals(mainStrCount, strCount)){
                count++;
            }
        }

        return count;
    }
}
