public class _004_Median_of_Two_Sorted_Arrays {
    // example in leetcode book
	// 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
	//
	//进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
	//示例 1：
	//
	//输入：nums1 = [1,3], nums2 = [2]
	//输出：2.00000
	//解释：合并数组 = [1,2,3] ，中位数 2
	//示例 2：
	//
	//输入：nums1 = [1,2], nums2 = [3,4]
	//输出：2.50000
	//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
	//示例 3：
	//
	//输入：nums1 = [0,0], nums2 = [0,0]
	//输出：0.00000
	//
	//来源：力扣（LeetCode）
	//链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
	//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	if (nums1 == null || nums2 == null) {
    		throw new IllegalArgumentException("nums1 and nums2 can't be null!");
		}
    	// 两个指针p1,p2,合并数组的位置pos
    	int p1 = 0, p2 = 0, pos = 0;
    	int m = nums1.length, n = nums2.length;
    	int size = m + n;
    	int[] all_nums = new int[size];
    	double median;
    	//双游标遍历
    	while (p1 < m && p2 < n){
    		if (nums1[p1] <= nums2[p2])
    			all_nums[pos++] = nums1[p1++];
    		else
    			all_nums[pos++] = nums2[p2++];
    	}
    	// 处理剩余数组的数据
    	while (p1 < m)
    		all_nums[pos++] = nums1[p1++];
    	while (p2 < n)
    		all_nums[pos++] = nums2[p2++];
    	if ((size) % 2 == 1)
    		median = all_nums[(size) / 2];
    	else
    		median = (all_nums[(size) / 2] + all_nums[(size) / 2 - 1]) / 2.0;
        return median;
    }
	public double findMedianSortedArrays_besst(int[] nums1, int[] nums2) {
		int mid = (nums1.length+nums2.length)/2+(nums1.length+nums2.length)%2;

		int i = 0;
		int j=0;
		int now = 0;
		int midnum=0;
		while(now!=mid){

			if(i==nums1.length){
				midnum=nums2[j];
				j++;
				now++;
				continue;
			}
			if(j==nums2.length){
				midnum=nums1[i];
				i++;
				now++;
				continue;
			}

			if(nums1[i]<nums2[j]){
				midnum=nums1[i];
				i++;
			}else {
				midnum=nums2[j];
				j++;
			}
			now++;
		}
		if((nums1.length+nums2.length)%2==1)
			return midnum;
		else{
			if(i==nums1.length){
				return ((double)midnum+(double)nums2[j])/2;
			}else if (j==nums2.length){
				return ((double)midnum+(double)nums1[i])/2;
			}
			if(nums1[i]<nums2[j]){
				return ((double)midnum+(double)nums1[i])/2;
			}else{
				return ((double)midnum+(double)nums2[j])/2;
			}
		}

	}
}
