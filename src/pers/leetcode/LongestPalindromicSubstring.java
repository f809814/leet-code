package pers.leetcode;

/**
 * @author fu
 * @date 2018/12/14 - 21:05
 * 暴力法
 */
public class LongestPalindromicSubstring {
    public  static boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        for (int start = 0, end = s.length() - 1; start < end  ; start++, end--) {
            //System.out.println("start.at[" + start + "]:" + s.charAt(start) +"; end.at[" + end + "]:" + s.charAt(end) );
            if(s.charAt(start) == s.charAt(end)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        if(s == null)
            return null;
        if(s.length() == 1)
            return s;
        String temp = "";
        int step;
        for (int start = 0; start < s.length() - 1 ; start++) {
            for (step = s.length() - start; step > 1; step--) {
                System.out.println("step:" + step);
                if(isPalindrome(s.substring(start, start + step)))
                    break;
            }
            if (step  > temp.length())
                temp = s.substring(start, start + step);
            //System.out.println("temp:" + temp);
            if(s.length() - start <= temp.length())
                break;
        }

        if(temp.length() == 1)
            return s.substring(0, 1);
        return temp;
    }
    public static void main(String[] args) {
        String test = "abcdefggfea";
        String t2 = "1283794496219837565";
        String t2is = longestPalindrome(t2);
        System.out.println("t2:" + t2is);
       //longestPalindrome(test);
    }
}
