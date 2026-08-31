class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);

            switch (direction) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            String position = x + "," + y;

            if (!visited.add(position)) {
                return true;
            }
        }

        return false;
    }
}