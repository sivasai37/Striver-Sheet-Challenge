class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int r = 0;
        int l = 0;
        int max = 0;
        while (nums.length > r) {
            if (nums[r] - nums[l] == 1) {
                max = Math.max(r - l + 1, max);
            }

            while (nums[r] - nums[l] > 1) {
                l++;
            }

            r++;
        }
        return max;
    }
}