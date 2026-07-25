class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums, k) - atmostK(nums, k - 1);
    }
    public static int atmostK(int[] nums, int k) {
        int left = 0;
        int count = 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            while (freq.size() > k) {
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);

                if (freq.get(leftVal) == 0) {
                    freq.remove(leftVal);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}