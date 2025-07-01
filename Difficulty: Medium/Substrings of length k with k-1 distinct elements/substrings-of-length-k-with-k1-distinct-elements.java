class Solution {
    public int substrCount(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;
        int l = 0, n = s.length();

        for (int r = 0; r < n; r++) {
            char rightChar = s.charAt(r);
            hm.put(rightChar, hm.getOrDefault(rightChar, 0) + 1);

            // Window of length k
            if (r - l + 1 == k) {
                if (hm.size() == k - 1) {
                    count++;
                }

                // Slide the window
                char leftChar = s.charAt(l);
                hm.put(leftChar, hm.get(leftChar) - 1);
                if (hm.get(leftChar) == 0) {
                    hm.remove(leftChar);
                }
                l++;
            }
        }

        return count;
    }
}
