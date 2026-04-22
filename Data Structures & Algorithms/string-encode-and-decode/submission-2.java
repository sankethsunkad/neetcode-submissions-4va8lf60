class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(int i = 0;i < strs.size();i++) {
            str.append(strs.get(i).length());
            str.append("#");
            str.append(strs.get(i));
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            res.add(str.substring(j, j + length));
            j = j + length;
            i = j;
        }
        return res;
    }
}
