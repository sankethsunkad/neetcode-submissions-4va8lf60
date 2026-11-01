class Solution {
    public String getHappyString(int n, int k) {

        int totalHappyStrings = 0;
        if(n > 0) {
            totalHappyStrings = 3 *(int) (Math.pow(2, n - 1));
        }
        
        if (k > totalHappyStrings) {
            return "";
        }

        List<String> happyStrings = new ArrayList<>();
        listAllHappyStrings(new StringBuilder(), happyStrings, 0, n, 'd');
        return happyStrings.get(k - 1);
    }

    void listAllHappyStrings(StringBuilder str,List<String> happyStrings, int index, int n, char prev) {
        if(index == n) {
            happyStrings.add(str.toString());
            return;
        }

        for(int i = 0;i < 3;i++) {
            char ch = (char)('a' + i);
            if(prev != ch) {
                str.append(ch);
                listAllHappyStrings(str, happyStrings, index + 1, n, ch);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}
