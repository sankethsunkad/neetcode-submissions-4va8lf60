class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) {
            return res;
        }
        HashMap<List<Character>, List<String>> hm = new HashMap<>();
        for(int i = 0;i < strs.length;i++) {
            List<String> values = new ArrayList<>();
            List<Character> list = strs[i].chars() // Convert String to IntStream (stream of chars)
                               .mapToObj(c -> (char) c) // Map each int (char) to Character
                               .collect(Collectors.toList());
            //List<Character> list = str[i].toCharArray[]();
            Collections.sort(list);
            if(hm.containsKey(list)) {
                values = hm.get(list);
            }
            values.add(strs[i]);
            hm.put(list, values);
        }
        for(Map.Entry<List<Character>, List<String>> entry : hm.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
