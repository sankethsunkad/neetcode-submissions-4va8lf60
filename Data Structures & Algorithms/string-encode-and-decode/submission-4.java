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
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
