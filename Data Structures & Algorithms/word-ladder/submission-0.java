class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || endWord.equals(beginWord)) return 0;

        List<List<Integer>> adjList = new ArrayList<>();
        int n = wordList.size();
        int m = beginWord.length();

        for(int i = 0;i < n;i++) {
            adjList.add(new ArrayList<>());
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            map.put(wordList.get(i), i);
        }

        for(int i = 0;i < n;i++) {
            for(int j = i + 1;j < n;j++) {
                int count = 0;
                for(int k = 0;k < m;k++) {
                    if(wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        count++;
                    }
                }
                if(count == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < m;i++) {
            for(char c = 'a';c < 'z' + 1;c++) {
                if (c == beginWord.charAt(i)) {
                    continue;
                }
                String word = beginWord.substring(0, i) + c + beginWord.substring(i + 1, m);
                if(map.containsKey(word) && !visited[map.get(word)]) {
                    q.add(map.get(word));
                    visited[map.get(word)] = true;
                }
            }
        }

        int res = 1;
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i = 0;i < size;i++) {
                int node = q.poll();
                if(wordList.get(node).equals(endWord)){
                    return res;
                }
                for(int neighbour : adjList.get(node)) {
                    if(!visited[neighbour]) {
                        q.add(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
        }
        return 0;
    }
}
