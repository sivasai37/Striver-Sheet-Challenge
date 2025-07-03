class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm = new HashMap<>();
        
        
        int n = s.length();
        int r =0,l=0;
        int len =0;
        
        while(n>r){
            char c1 = s.charAt(r);
            hm.put(c1,hm.getOrDefault(c1,0)+1);
            while(hm.size()>k){
                char c2 = s.charAt(l);
                hm.put(c2,hm.getOrDefault(c2,0)-1);
                if(hm.get(c2)==0){
                    hm.remove(c2);
                }
                l++;
            }
            len =  Math.max(len,r-l+1);
            r++;
        }
        if(k>hm.size()){
            return -1;
        }
        return len;
    }
}