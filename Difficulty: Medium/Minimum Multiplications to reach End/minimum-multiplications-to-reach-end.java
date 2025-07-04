// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if(start==end){
            return 0;
        }
        int mod = 100000;

        boolean[] vis = new boolean[mod];
         Queue<int[]> q = new LinkedList<>();
         q.add(new int[]{0,start});
          vis[start] = true;
         while(!q.isEmpty()){
             int[] a = q.poll();
             int steps  = a[0];
             int val = a[1];
             
             for(int num:arr){
                 int value = (num* val)%mod;
                 if(value==end){
                     return steps+1;
                 }
                 if(!vis[value]){
                     q.add(new int[]{steps+1,value});
                     vis[value] = true;
                 }
             }
         }
        return -1;
    }
}
