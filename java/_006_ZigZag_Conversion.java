import java.util.ArrayList;
import java.util.List;

public class _006_ZigZag_Conversion {
    //将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    //
    //比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    //
    //L   C   I   R
    //E T O E S I I G
    //E   D   H   N
    //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
    //
    //请你实现这个将字符串进行指定行数变换的函数：
    //
    //string convert(string s, int numRows);
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/zigzag-conversion
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            // 行数
            rows.get(i).append(c);
            // 转折处，Z字形转折
            if(i == 0 || i == numRows -1) {
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public String convert_best(String s, int numRows) {
        //周期变换（相邻间距2*numRows-2）;
        //0_____6
        //1___5_7
        //2_4___8
        //3_____9
        int length = s.length();
        if (numRows == 1 || numRows >= length) {
            return s;
        }
        char[] chars = new char[length];
        //每列的间距
        int colLen = 2 * numRows - 2;
        //共有多少完整列
        int minCol = length / colLen;
        // 字符索引
        int ci = 0;
        //二维数组第i行j列所对应字符在s中的位置
        int index;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < minCol + 1; j++) {
                index = j * colLen + i;
                if (index < length) {
                    chars[ci++] = s.charAt(index);
                }
                // 除了第一行和最后一行相邻两元素所处的列的间距为2(numRows-1)外
                // 中间行非最长列的相邻2个元素的间距为2 * (numRows - i - 1)
                if (i != 0 && i != numRows - 1) {
                    index = j * colLen + (i + 2 * (numRows - i - 1));
                    if (index < length)
                        chars[ci++] = s.charAt(index);
                }
            }
        }
        return String.valueOf(chars);
    }
}