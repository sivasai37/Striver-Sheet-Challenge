import java.util.*;

class Solution {
    public int countAtMostK(int[] arr, int k) {
        int left = 0, count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            int num = arr[right];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            // Shrink the window if we have more than k distinct numbers
            while (freqMap.size() > k) {
                int leftNum = arr[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                left++;
            }

            // Add all valid subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }
}
