class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int counter = 0;
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                nums[counter] = nums1[i];
                i++;
            }
            else {
                nums[counter] = nums2[j];
                j++;
            }
            counter++;
        } 
        while(i < nums1.length) {
            nums[counter++] = nums1[i++];
        }
        while(j < nums2.length) {
            nums[counter++] = nums2[j++];
        }

        if(nums.length % 2 == 0) {
            return ((double)nums[(nums.length / 2)] + nums[(nums.length / 2) - 1]) / 2;
        }
        else {
            return nums[(nums.length / 2)];
        }
    }
}
