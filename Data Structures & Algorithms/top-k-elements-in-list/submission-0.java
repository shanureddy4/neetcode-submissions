class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(entry.getKey());
        }

        int[] result = new int[k];
        int idx = 0;

        for (int i = nums.length; i >= 0 && idx < k; i--) {

            if (buckets[i] != null) {

                for (int num : buckets[i]) {

                    result[idx++] = num;

                    if (idx == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}