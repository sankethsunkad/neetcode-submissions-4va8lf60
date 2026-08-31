class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for(String email : emails) {
            set.add(normalizeEmail(email));
        }

        return set.size();
    }

    public String normalizeEmail(String email) {
        StringBuilder result = new StringBuilder();
        int atIndex = email.indexOf('@');


        for (int i = 0;i < atIndex;i++) {
            char ch = email.charAt(i);
            if(ch == '+') {
                break;
            }
            else if(ch != '.') {
                result.append(ch);
            }
        }
        result.append(email, atIndex, email.length());
        return result.toString();
    }
}
