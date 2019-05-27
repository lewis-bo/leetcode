public class Leetcode5 {
    /**
     * 直接迭代判断每个子串是否是回文。
     * 从每个字符向后迭代,时间复杂度0(n^2)
     * 判断每个子串是否是回文,时间复杂度O(n)
     * 该实现整个时间复杂度0(n^3)
     * @param str
     * @return
     */
    public static String longestPalindromeN3(String str) {
        if (null == str) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }

        //回文最长值
        int maxLen = 0;
        //当前最长值的下表索引值
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String tmp = str.substring(i, j);
                if (isPalindrome(tmp)) {
                    if (j - i > maxLen) {
                        maxLen = j - i;
                        index = i;
                    }
                }
            }
        }
        return str.substring(index, index + maxLen);
    }

    /**
     * 判断是否是回文
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }



    /**
     * 中心扩展法
     * 从某一点向2边扩展
     * 时间复杂度0(n^2)
     * 则arr[i] == arr[i+1] (长度为偶数）
     * 或者 arr[i-1] = arr[i+1] (长度为奇数）
     * @param str
     * @return
     */
    public static String longestPalindromeN2(String str) {
        if (null == str || str.length() <= 0) {
            return null;
        }
        if (str.length() == 1) {
            return str;
        }

        //索引位置
        int index = 0;
        //最大回文文场长度
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            //回文为奇数
            int len1 = maxLen(str, i, i);
            //回文为偶数
            int len2 = maxLen(str, i, i+1);

            //取长度最大的
            int len = len1 > len2 ? len1 : len2;
            boolean isOdd = len1 > len2;
            if (len > maxLen) {
                maxLen = len;
                if (isOdd) {
                    index = i - maxLen / 2;
                } else {
                    index = i  - maxLen / 2 + 1;
                }
            }
        }

        return str.substring(index, index + maxLen);
    }


    /**
     * 获取最大长度
     * @param str
     * @param left
     * @param right
     * @return
     */
    public static int maxLen(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left --;
            right ++;
        }
        /**
         * 上面迭代不相等的时候，向外多扩展了一次
         * 故左侧加一, 右侧减一, 又因为left, right全是下标值，默认从0开始, 故默在加上一
         * (-- right) - (++ left) + 1 = (right - 1) - (left + 1) + 1 = right - left - 1;
         */
        return right - left - 1;
    }

    public static void main(String[] args) {

    }

}
