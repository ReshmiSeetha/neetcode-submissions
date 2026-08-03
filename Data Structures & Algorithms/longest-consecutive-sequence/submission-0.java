class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num, Boolean.FALSE);
        }

        for(int num : nums){
            int currentValue = 1;

            int nextNum = num + 1;
            while(map.containsKey(nextNum) && map.get(nextNum) == Boolean.FALSE){
                currentValue++;
                map.put(nextNum, Boolean.TRUE);
                nextNum++;
            }

            int prevNum = num - 1;
            while(map.containsKey(prevNum) && map.get(prevNum) == Boolean.FALSE){
                currentValue++;
                map.put(prevNum, Boolean.TRUE);
                prevNum--;
            }
            longestLength = Math.max(currentValue, longestLength);
        }
        return longestLength;
    }
}
