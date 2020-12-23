import java.util.Arrays;

public class _003_Longest_Substring_Without_Repeating_Characters {
    // example in leetcode book
    // public int lengthOfLongestSubstring(String s) {
    // 	boolean[] exist = new boolean[256];
    // 	int i = 0, maxLen = 0;
    // 	for (int j = 0; j < s.length(); j++) {
    // 		while (exist[s.charAt(j)]){
    // 			exist[s.charAt(i)] = false;
    // 			i++;
    // 		}
    // 		exist[s.charAt(j)] = true;
    // 		maxLen = Math.max(j - i + 1, maxLen);
    // 	}
    // 	return maxLen; 
    // }
	//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	//示例 1:
	//
	//输入: s = "abcabcbb"
	//输出: 3
	//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	//示例 2:
	//
	//输入: s = "bbbbb"
	//输出: 1
	//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
	//示例 3:
	//
	//输入: s = "pwwkew"
	//输出: 3
	//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
	//示例 4:
	//
	//输入: s = ""
	//输出: 0
	//
	//来源：力扣（LeetCode）
	//链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
	//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int lengthOfLongestSubstring(String s) {
    	//ASCII码有7位码和8位码两种形式,按照最大的8位最多2^8,256
    	int[] charMap = new int[128];
    	// 填充标志位 -1
    	Arrays.fill(charMap, -1);
    	// i记录当前字符重复前距离上一次该字符重复的游标值
    	int lastDuplicateIndex = 0, maxLen = 0;
    	for (int i = 0; i < s.length(); i++) {
    		int currentIndex = i;
    		//当前游标字符
    		char c = s.charAt(i);
    		if (charMap[c] >= lastDuplicateIndex) {
    			// 如果当前字符所在的位置的值大于或等于上次该字符所在的索引值则表明当前字符重复
				lastDuplicateIndex = charMap[c] + 1;
    		}
    		//当前游标字符的数值为起始字符到当前游标的字符总长度，包括重复的字符
    		charMap[c] = currentIndex;
    		// 更新至当前字符为止时最大不重复的字符数目
    		maxLen = Math.max(currentIndex - lastDuplicateIndex + 1, maxLen);
    	}
    	return maxLen;
    }
	public int lengthOfLongestSubstring_best(String s) {
		// 记录字符上一次出现的位置
		int[] last = new int[128];
		for(int i = 0; i < 128; i++) {
			last[i] = -1;
		}
		int n = s.length();

		int res = 0;
		int start = 0;
		for(int i = 0; i < n; i++) {
			int index = s.charAt(i);
			start = Math.max(start, last[index] + 1);
			res   = Math.max(res, i - start + 1);
			last[index] = i;
		}

		return res;
	}
}
