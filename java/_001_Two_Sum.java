import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _001_Two_Sum {
    // example in leetcode book
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    //
    //给定 nums = [2, 7, 11, 15], target = 9
    //
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/two-sum
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //1.hash O(n) and O(n) space
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // 2.sort and search O(n) and O(1) space
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x), i};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        _001_Two_Sum two_sum = new _001_Two_Sum();
        long start = System.currentTimeMillis();
        int[] result = two_sum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("cost: " + (System.currentTimeMillis() - start) + "ms");
        Arrays.stream(result).forEach(System.out::println);
    }
}
