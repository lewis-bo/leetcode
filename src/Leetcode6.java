import java.util.Map;
import java.util.TreeMap;

public class Leetcode6 {


    /**
     * 方法一
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        int len = s.length();
        int cell = cell(len, numRows);
        char[][] result = new char[numRows][cell];

        for (int i = 0; i < len; i++) {
            int row = getRow(i, numRows);
            int cel = cell(i + 1, numRows) - 1;
            result[row][cel] = s.charAt(i);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            char[] arr = result[i];
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j]);
            }
        }

        return sb.toString();
    }

    private static int getRow(int index, int num) {
        int mod = index % (num + num - 2);
        return mod < num ? mod : Math.abs(mod - num - num + 2);
    }

    private static int cell(int len , int mum) {
        int cellMod = len % (mum + mum - 2);
        int cell = len / (mum + mum - 2);
        if (0 == cellMod) {
            cell = cell * (mum - 2 + 1);
        } else {
            cell = cell * (mum - 2 + 1) + ((cellMod - mum) > 0 ? (1 + cellMod - mum) : 1);
        }
        return cell;
    }


    /**
     * 方法二
     * 重新分析这个问题, 其实只要考虑每个字符行所在行的位置即可
     * 因为是对整个字符串进行迭代， 即每行的子串本身已有顺序
     * @param s
     * @param numRows
     * @return
     */
    public static String convertOther(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        Map<Integer, StringBuffer> params = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            int row = row(i, numRows);
            StringBuffer sb = params.get(row);
            if (null == sb) {
                sb = new StringBuffer();
                params.put(row, sb);
            }
            sb.append(s.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Integer, StringBuffer> entry : params.entrySet()) {
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    //根据下标获取该字符转化之后所在的行
    private static int row(int index, int num) {
        //一个标准子串对应的长度
        int mod = (num + num - 2);
        int modResult = index % mod;
        return modResult < num ? modResult : Math.abs(modResult - mod);
    }

    public static void main(String[] args) {
        System.out.println(convertOther("ADLJFDO4E534DFGFG", 3));
    }
}
