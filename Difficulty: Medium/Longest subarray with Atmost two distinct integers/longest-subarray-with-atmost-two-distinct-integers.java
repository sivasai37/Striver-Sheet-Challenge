class Solution {
    public int totalElements(int[] arr) {
        // code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        int maxlen =0;
        int l =0,r=0;
        int n = arr.length;
        while(n>r){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            while(hm.size()>2){
                 hm.put(arr[l],hm.getOrDefault(arr[l],0)-1);
                 if(hm.get(arr[l])==0){
                     hm.remove(arr[l]);
                 }
                 l++;
            }
            maxlen = Math.max(r-l+1,maxlen);
            r++;
        }
        return maxlen;
    }
}