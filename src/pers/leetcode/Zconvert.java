package pers.leetcode;


/**
 * @author fu
 * @date 2018/12/20 - 15:56
 * @链接：https://leetcode-cn.com/problems/zigzag-conversion/
 * 官方用时53 ms(修改时间：2018年12月20日 22:29:26)
 */
public class Zconvert {
    public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows < 2)
            return s;
        int period = 2 * numRows - 2;//Z型周期
        int sLength = s.length();//字符串长度
        StringBuilder resString = new StringBuilder();//保存要返回的string
        for (int i = 0; i < numRows; i++) {
            for (int j = i, k = period -i; j < sLength; j = j + period, k = k + period){
                resString.append(s.charAt(j));
                if(i == 0 || i == numRows - 1)//除第一行和最后一行其余每个周期都要添加两个字符（不超过s.length()）
                    continue;
                if (k < sLength)//k > j,j为周期起始位置,以j的大小判断是否退出
                    resString.append(s.charAt(k));
            }
        }
        return resString.toString();
    }

    public static void main(String[] args) {
        String re = convert("LEETCODEISHIRING", 4);
        System.out.println("result:" + re);
    }
}
