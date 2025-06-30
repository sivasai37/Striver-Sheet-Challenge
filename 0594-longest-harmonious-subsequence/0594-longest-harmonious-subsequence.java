class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check num + 1 existence
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int sum = map.get(key) + map.get(key + 1);
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
