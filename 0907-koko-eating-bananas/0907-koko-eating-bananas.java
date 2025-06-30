class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles);

        while (right>left) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;

            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; 
        }
        return hours <= h;
    }

    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
           max = Math.max(pile,max);
        }
        return max;
    }
}
