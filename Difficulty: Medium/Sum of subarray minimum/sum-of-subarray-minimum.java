class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        
       int[] pse = fpse(arr);
       int[] nse = fnse(arr);
       
        int l =0;
        int r =0;
        int mod = (int)1e9 + 7;
        long total =0;
        for(int i=0;i<n;i++){
            l = i - pse[i];
            r = nse[i] - i;
            total = (total + (long)l * r * arr[i])%mod ;
            
            
        }
        return (int)total;
    }
    int[] fpse(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
         int[]  pse = new int[n];
        for(int i=0;i<n;i++){
             while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                 st.pop();
             }
             pse[i] = st.isEmpty() ? -1:st.peek();
             st.push(i);
             
        }
        return pse;
    }
    
     int[] fnse(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
         int[]  nse = new int[n];
        for(int i=n-1;i>=0;i--){
             while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                 st.pop();
             }
             nse[i] = st.isEmpty() ? n:st.peek();
             st.push(i);
             
        }
        return nse;
    }
    
}