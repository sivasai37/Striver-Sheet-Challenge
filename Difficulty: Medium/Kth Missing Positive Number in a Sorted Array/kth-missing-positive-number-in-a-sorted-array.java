class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int l =0;
        int h = arr.length-1;
        while(h>=l){
            int m = l + (h-l)/2;
            int missing = arr[m] - (m+1);
            if(missing<k){
                l = m +1;
            }else{
                h = m-1;
            }
        }
        return l +k;
    }
}