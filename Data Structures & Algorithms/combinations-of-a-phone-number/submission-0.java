class Solution {
    List<String> res = new ArrayList<>();
    HashMap<Character, List<Character>> map;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        helper(digits, 0, new ArrayList<>());
        return res;
    }
    void helper(String digits, int index, List<Character> list) {
        if(list.size() == digits.length()) {
            String result = list.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());
            res.add(result);
            return;
        }
        List<Character> characterList = map.get(digits.charAt(index));
        for(Character ch : characterList) {
            list.add(ch);
            helper(digits, index + 1, list);
            list.remove(list.size() - 1);
        }
        return;
    }
}
