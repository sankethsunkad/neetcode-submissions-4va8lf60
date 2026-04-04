class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0;i < s1.length();i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int start = 0;
        int slide = 0;
        while(slide < s2.length()) {
            char c = s2.charAt(slide);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if(slide - start + 1 > s1.length()) {
                char s = s2.charAt(start);
                windowMap.put(s, windowMap.get(s) - 1);
                if(windowMap.get(s) == 0) {
                    windowMap.remove(s);
                }
                start++;
            }

            if (windowMap.equals(hm)) {
                return true;
            }
            slide++;
        }
        return false;
    }
}
