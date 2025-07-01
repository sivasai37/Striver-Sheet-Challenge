class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int c = 1;
        for (int i = n - 2; i >= 0; i--) {

            char c1 = word.charAt(i);
            char c2 = word.charAt(i + 1);
            if (c1 == c2) {
                c++;
            }

        }
        return c;
    }
}