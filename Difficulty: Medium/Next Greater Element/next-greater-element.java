class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller or equal elements
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            
            // If stack is empty, no greater element
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek(); // Next greater element
            }
            
            st.push(arr[i]); // Always push current element
        }
        
        // Convert array to ArrayList to match return type
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : ans) {
            result.add(num);
        }
        
        return result;
    }
}
