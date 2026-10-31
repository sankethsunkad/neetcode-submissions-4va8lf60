class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length) {
            while(index1 > 0 && index1 < nums1.length && nums1[index1] == nums1[index1 - 1]) {
                index1++;
            }
            while(index2 > 0 && index2 < nums2.length && nums2[index2] == nums2[index2 - 1]) {
                index2++;
            }
            if(index1 == nums1.length || index2 == nums2.length) {
                return res.stream()
                  .mapToInt(Integer::intValue) 
                  .toArray();
            }
            if(nums1[index1] < nums2[index2]) {
                index1++;
            }
            else if(nums1[index1] > nums2[index2]) {
                index2++;
            }
            else {
                res.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        return res.stream()
                  .mapToInt(Integer::intValue) 
                  .toArray();
    }
}