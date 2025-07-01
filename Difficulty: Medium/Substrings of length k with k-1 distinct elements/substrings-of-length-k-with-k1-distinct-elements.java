class Solution {
    public int substrCount(String s, int k) {
        // code here
        HashMap<Character, Integer> map= new HashMap<>();
        int n= s.length();
        int cnt=0;
        
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(i > k-1){
                if(map.size()==k-1){
                    cnt++;
                }
                char lc= s.charAt(i-k);
                map.put(lc, map.get(lc)-1);
                if(map.get(lc)==0){
                    map.remove(lc);
                }
            }
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        if(map.size()==k-1){
            cnt++;
        }
        return cnt;
    }
}