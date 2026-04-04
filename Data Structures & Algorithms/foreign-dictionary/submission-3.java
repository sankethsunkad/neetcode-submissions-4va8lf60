class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Boolean> visited = new HashMap<>();
        List<Character> result = new ArrayList<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() &&
                w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        
        List<Character> keys = new ArrayList<>(adj.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        for (char c : keys) {
            if (dfs(c, adj, visited, result)) {
                return "";
            }
        }

        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    boolean dfs(char ch, HashMap<Character, Set<Character>> adj, Map<Character, Boolean> visited, List<Character> result) {
        if(visited.containsKey(ch)) return visited.get(ch);

        visited.put(ch, true);
        for(char next : adj.get(ch)) {
            if(dfs(next, adj, visited, result)) return true;
        }
        visited.put(ch, false);
        result.add(ch);
        return false;
    }
}
