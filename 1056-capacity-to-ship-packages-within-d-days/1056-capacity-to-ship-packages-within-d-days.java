
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int num : weights) {
            high += num;
            low = Math.max(low, num);
        }

        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (ship(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean ship(int[] weights, int mid,int k) {
       int d =1;
       int lo =0;
       for(int i=0;i<weights.length;i++){
         if(lo+weights[i]>mid){
            d++;
            lo= weights[i];
         }else{
            lo += weights[i];
         }
       } 
       return k>=d;
    }
}
