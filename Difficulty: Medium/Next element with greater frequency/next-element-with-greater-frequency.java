class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> ls = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int n:arr){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        
        for(int i = arr.length-1;i>=0;i--){
            while(!st.isEmpty() && hm.get(arr[i])>=hm.get(st.peek())){
                st.pop();
            }
            
            if(st.isEmpty()){
                ls.add(-1);
            }else{
                ls.add(st.peek());
            }
            st.push(arr[i]);
        }
        Collections.reverse(ls);
        return ls;
    }
}