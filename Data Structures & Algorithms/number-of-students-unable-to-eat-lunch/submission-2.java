class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        for(int i = sandwiches.length - 1;i >= 0;i--) {
            stack.push(sandwiches[i]);
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0;i < students.length;i++) {
            deque.addLast(students[i]);
        }

        int counter = 0;
        int res = students.length;
        while(counter < deque.size() && !stack.isEmpty()) {
            int currStud = deque.pollFirst();
            if(currStud == stack.peek()) {
                stack.pop();
                res--;
                counter = 0;
            }
            else {
                deque.addLast(currStud);
                counter++;
            }
        }
        return res;
    }
}