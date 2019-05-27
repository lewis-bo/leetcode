public class Leetcode7 {

    //转化成字符串->cha[], 进行位置互换

    public static int reverse(int x) {
        boolean isNeg = x < 0;
        String str = "" + Math.abs(x);
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        long value = Long.valueOf(new String(chars));
        if (isNeg) {
            value = -value;
        }
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) value;
    }

    /**
     * x%10 获取最小位的数值
     * 同时 x/10获取到下一进位的数据.
     * 循环迭代，然后将每次获取的最小进位 *10, 然后加和
     *
     * ps: 因为每次只对数据进行进位加和， 或者减位操作
     * 负数的加和还是负数
     *
     * 所以不用对符号处理。
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                //溢出
                return 0;
            }
            //x 缩小一个进位
            x = x/10;
        }
        return (int) result;
    }


    public static void main(String[] args) {
        System.out.println(reverse2(3048343));
    }
}
