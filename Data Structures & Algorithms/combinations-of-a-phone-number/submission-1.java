class Solution {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0) return res;
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        helper(0, new ArrayList<>(), map, digits);
        return res;
    }

    void helper(int index, List<Character> list, HashMap<Character, List<Character>> hm, String digits) {
        if(list.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for(Character c : list) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        List<Character> characterList = hm.get(digits.charAt(index));
        for(Character c : characterList) {
            list.add(c);
            helper(index + 1, list, hm, digits);
            list.remove(list.size() - 1);
        }
    }
}
