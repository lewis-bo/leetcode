public class Leetcode8 {


    /**
     * 1.判断首字符是否是符号, 获取迭代的起始位置
     * 2.判断是否是负号
     * 3.上次迭代的结果数乘以10 然后加上 对应字符数字乘以符号基础数(1 or -1)
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (null == str ) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char firstChar = str.charAt(0);
        //是否符号
        boolean isSign = false;
        //是否负号
        boolean isNeg = false;
        if ((isNeg = ('-' == firstChar)) || '+' == firstChar) {
            isSign = true;
        }


        long result = 0;
        //起始位置
        int index = isSign ? 1 : 0;
        //基础数
        int neg = isNeg ? -1 : 1;
        char[] chars = str.toCharArray();
        for (int i = index; i < chars.length; i++) {
            char tmp = chars[i];
            if (tmp < 48 || tmp > 57) {
                break;
            }
            result = result * 10 + Long.valueOf(String.valueOf(tmp)) * neg;
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
    }
}
