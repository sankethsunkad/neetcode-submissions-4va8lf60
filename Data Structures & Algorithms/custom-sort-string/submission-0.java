class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < order.length();i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int num = map.get(ch);
                for(int j = 0;j < num;j++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int num = map.get(ch);
            for(int j = 0;j < num;j++) {
                sb.append(ch);
            }
            
        }
        return sb.toString();
    }
}