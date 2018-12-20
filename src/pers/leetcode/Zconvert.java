package pers.leetcode;

import java.util.ArrayList;

/**
 * @author fu
 * @date 2018/12/20 - 15:56
 */
public class Zconvert {
    public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows < 1)
            throw  new IllegalArgumentException();
        if(numRows == 1)
            return s;
        int period = 2 * numRows - 2;
        StringBuilder resString = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i, k = period -i; j < s.length(); j = j + period, k = k + period){
                resString.append(s.charAt(j));
                if(i == 0 || i ==  numRows - 1)
                    continue;
                if ((k + period) < s.length()) {
                    resString.append(s.charAt(k));
                } else if (k < s.length()) {
                    resString.append(s.charAt(k));
                }
            }
        }
        return resString.toString();
    }

    public static void main(String[] args) {
        String re = convert("LEETCODEISHIRING", 1);
        System.out.println("result:" + re);
    }
}
