public class Leetcode9 {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        char[] chars = ("" + x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
