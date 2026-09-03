class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if(s.length() < t.length()) return res;

        int low = 0;
        int target = t.length();
        int high = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i < target;i++) {
            char ch = t.charAt(i);
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }

        int count = 0;
        HashMap<Character, Integer> compare = new HashMap<>();

        int n = s.length();
        while(high < n) {
            char ch = s.charAt(high);
            if(map.containsKey(ch)) {
                compare.putIfAbsent(ch, 0);
                compare.put(ch, compare.get(ch) + 1);
                if(compare.get(ch) <= map.get(ch)) {
                    count++;
                }
            }
            high++;
            if(count == target) {
                char temp = s.charAt(low);
                while(!map.containsKey(temp) || (compare.get(temp) > map.get(temp))) {
                    if(compare.containsKey(temp) && compare.get(temp) > map.get(temp)) {
                        compare.put(temp, compare.get(temp) - 1);
                    }
                    low++;
                    temp = s.charAt(low);
                }
                if(res.isEmpty()) {
                    res = s.substring(low, high);
                }
                else {
                    String sub = s.substring(low, high);
                    if(sub.length() < res.length()) {
                        res = sub;
                    }
                }
            }
        }

        return res;
    }
}
