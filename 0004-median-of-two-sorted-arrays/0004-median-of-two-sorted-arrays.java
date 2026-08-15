class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] result = new double[nums1.length + nums2.length];
        int k = 0;
        for(int i = 0; i < nums1.length; i++){
            result[k] = nums1[i];
            k++;
        }
        for(int i = 0; i < nums2.length; i++){
            result[k] = nums2[i];
            k++;
        }
        Arrays.sort(result);
        int n = result.length;
        if(n % 2 == 0){
            return (result[n / 2 - 1] + result[n / 2]) / 2.0;
        }else { 
            return result[n / 2];
        }
        
            
        
    }
}