package pers.leetcode;

import java.math.BigInteger;

/**
 * @author fu
 * @date 2018/12/20 - 22:29
 * @链接：https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        String strHandle = str.trim();
        if(strHandle.length() == 0)
            return 0;
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < strHandle.length(); i++) {
            if(strHandle.charAt(i) >= '0' && strHandle.charAt(i) <= '9') {
                temp.append(strHandle.charAt(i));
            } else if(temp.length() == 0 && strHandle.charAt(i) == '-') {
                temp.append(strHandle.charAt(i));
            }else if(temp.length() != 0) {
                break;
            }
        }
        if(temp.length() == 0 || temp.equals("-"))
            return 0;
//        String tempWithoutNe = "";
//        if(temp.charAt(0) == '-')
//            tempWithoutNe = temp.substring(1);
//        else
//            tempWithoutNe = temp.toString();
        return new BigInteger(temp.toString(),10).intValue();
    }
    public static void main(String[] args) {
        System.out.println("42:" + myAtoi("42"));
        System.out.println("4193 with words:" + myAtoi("4193 with words"));
        System.out.println("words and -987:" + myAtoi("words and -987"));
        System.out.println("  -987  :" + myAtoi("  -987  "));
    }
}
