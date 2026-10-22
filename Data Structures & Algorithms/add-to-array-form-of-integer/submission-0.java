class Solution {
    public int[] addToArrayForm(int[] num, int k) {
        List<Integer> digits=new ArrayList<>();
        int i = num.length-1, carry = k;
        while(i>=0 || carry>0) { 
            if(i>=0) carry+=num[i]; 
            digits.add(carry%10); 
            carry/=10; 
            i--; 
        } 
        int[] answer=new int[digits.size()]; 
        for(int j=0;j<answer.length;j++){         
            answer[j]=digits.get(answer.length-1-j);
        }
        return answer;
    }
}
