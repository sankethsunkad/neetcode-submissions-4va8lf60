class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 0;

        int n = arr.length;
        for(int i = 0;i < n;i++) {
            int low = arr[i];
            int count = 1;

            boolean strictIncrease = true;
            boolean check = true;
            if((i + 1) < n && arr[i] == arr[i + 1]) {
                check = false;
                continue;
            }
            if((i + 1) < n && arr[i + 1] > arr[i]) {
               strictIncrease = false;
               count = 2;
            }
            else if((i + 1) < n && arr[i + 1] < arr[i]){
                count = 2;
            }

            low = i + 1;
            res = Math.max(res, count);
            while(check && (low + 1) < n) {
                if(arr[low + 1] == arr[low]) {
                    check = false;
                    continue;
                }
                if(strictIncrease) {
                    if(arr[low + 1] > arr[low]) {
                        count++;
                        strictIncrease = false;
                    }
                    else {
                        check = false;
                    }
                }
                else {
                    if(arr[low + 1] < arr[low]) {
                        count++;
                        strictIncrease = true;
                    }
                    else {
                        check = false;
                    }
                }
                res = Math.max(res, count);
                low++;
            }
        }
        return res;
    }
}