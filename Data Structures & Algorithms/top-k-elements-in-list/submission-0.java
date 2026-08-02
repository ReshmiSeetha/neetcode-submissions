class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;
        for(int pos = bucket.length - 1; pos >=0 && counter < k; pos--){
            if(bucket[pos] != null){
                for(Integer val : bucket[pos]){
                    res[counter++] = val;
                }
            }
        }
        return res;
    }
}
