class Solution {
    public int countCharacters(String[] words, String chars) {
        int n = words.length;
        List<int[]> count = new ArrayList<>();
        for(String word : words) {
            int[] curr = new int[26];
            for(int i = 0;i < word.length();i++) {
                curr[word.charAt(i) - 'a']++;

            }
            count.add(curr);
        }

        int[] check = new int[26];
        for(int i = 0;i < chars.length();i++) {
            check[chars.charAt(i) - 'a']++;
        }

        int res = 0;
        for(int i = 0;i < words.length;i++) {
            int[] curr = count.get(i);
            boolean checkBoolean = true;
            for(int j = 0;j < 26;j++) {
                
                if(curr[j] > check[j]) {
                    checkBoolean = false;
                    continue;
                }
            }
            if(checkBoolean) {
                res += words[i].length();
            }
        }
        return res;
    }
}