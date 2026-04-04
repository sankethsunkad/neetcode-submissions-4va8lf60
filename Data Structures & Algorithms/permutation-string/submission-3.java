class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        
        int check1[] = new int[26];
        int check2[] = new int[26];
        for(int i = 0;i < s1.length();i++) {
            check1[s1.charAt(i) - 'a']++;
            check2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (check1[i] == check2[i]) {
                matches++;
            }
        }

        //if check1 and check2 match then true or just get number of matches
        int start = 0;
        int index = s1.length();
        while(index < s2.length()) {
            if(matches == 26) {
                return true;
            }
            int i = s2.charAt(index) - 'a';
            check2[i]++;
            if(check1[i] == check2[i]) {
                matches++;
            }
            else if(check1[i] + 1 == check2[i]){
                matches--;
            }
            i = s2.charAt(start) - 'a';
            check2[i]--;
            if(check1[i] == check2[i]) {
                matches++;
            }
            else if(check1[i] - 1 == check2[i]){
                matches--;
            }
            start++;
            index++;
        }
        return matches == 26;
    }
}
