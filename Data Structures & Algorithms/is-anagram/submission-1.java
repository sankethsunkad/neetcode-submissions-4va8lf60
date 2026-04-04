class Solution {
    public boolean isAnagram(String s, String t) {
        int res[]=new int[256];
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0;i<s.length();i++)
        {
            res[s.charAt(i)]++;
            res[t.charAt(i)]--;
        }
        for(int i =0;i<res.length;i++){
            if(res[i]!=0){
                return false;
            }
        }
        return true;
    }
}
