import java.util.Arrays;

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int l = 1;
        int r = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canPlace(stalls, k, m)) {
                ans = m;       
                l = m + 1;     
            } else {
                r = m - 1;     
            }
        }

        return ans;
    }

    static boolean canPlace(int[] stalls, int cows, int minDist) {
        int count = 1;  
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= minDist) {
                count++;
                lastPos = stalls[i];
            }
        }

        return count >= cows;
    }
}
