class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < firstList.length && j < secondList.length) {
            if(firstList[i][0] == secondList[j][0]) {
                int x = firstList[i][0];
                if(firstList[i][1] == secondList[j][1]) {
                    res.add(firstList[i]);
                    i++;
                    j++;
                }
                else if(firstList[i][1] < secondList[j][1]) {
                    res.add(new int[]{x, firstList[i][1]});
                    i++;
                }
                else {
                    res.add(new int[]{x, secondList[j][1]});
                    j++;
                }
            }
            else {
                if(firstList[i][0] > secondList[j][0]) {
                    if(firstList[i][0] > secondList[j][1]) {
                        j++;
                    }
                    else {
                        int x = firstList[i][0];
                        if(firstList[i][1] < secondList[j][1]) {
                            int y = firstList[i][1];
                            res.add(new int[]{x, y});
                            i++;
                        }
                        else {
                            res.add(new int[]{x, secondList[j][1]});
                            j++;
                        }
                    }
                }
                else {
                    if(secondList[j][0] > firstList[i][1]) {
                        i++;
                    }
                    else {
                        int x = secondList[j][0];
                        if(firstList[i][1] < secondList[j][1]) {
                            int y = firstList[i][1];
                            res.add(new int[]{x, y});
                            i++;
                        }
                        else {
                            res.add(new int[]{x, secondList[j][1]});
                            j++;
                        }
                    }
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}