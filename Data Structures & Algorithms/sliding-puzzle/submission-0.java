class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] adj = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        String start="";
        for(int[] row:board) {
            for(int x:row)
            {
                start+=x;
            }
        }

        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(start);

        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0;i < size;i++) {
                String curr = q.poll();
                if(curr.equals("123450")) {
                    return res;
                }
                if(seen.contains(curr)) {
                    continue;
                }
                seen.add(curr);
                int index = 0;
                while(index < curr.length() && curr.charAt(index) != '0') {
                    index++;
                }
                
                StringBuilder temp = new StringBuilder(curr);

                int[] currAdj = adj[index];

                for(int swap : currAdj) {
                    char ch = temp.charAt(swap);
                    temp.setCharAt(index, ch);
                    temp.setCharAt(swap, '0');
                    String newStr = temp.toString();
                    if(!seen.contains(newStr)) {
                        q.offer(newStr);
                    }
                    temp.setCharAt(swap, ch);
                    temp.setCharAt(index, '0');
                }

                
            }
            res++;
        }
        return -1;

    }
}
