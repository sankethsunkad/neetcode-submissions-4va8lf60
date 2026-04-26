class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int slide = 0;
        while(start < s.length() && slide < s.length()) {
            char c = s.charAt(slide);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            maxCount = Math.max(maxCount, hm.get(c));
            if((slide - start + 1) > (maxCount + k)) {
                char remove = s.charAt(start);
                hm.put(remove, hm.get(remove) - 1);
                start++;
            }
            slide++;
        }
        return slide - start;
    }
}
