
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map stores the "signature" (e.g., "1#0#2...") as the key
        // and the list of anagrams as the value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            int[] alphs = new int[26];
            for (char c : str.toCharArray()) {
                alphs[c - 'a']++;
            }
            
            // Convert the array to a String to use as a Map key
            String key = Arrays.toString(alphs);
            
            // If the key isn't in the map, add a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            // Add the string to the list corresponding to this signature
            map.get(key).add(str);
        }
        
        // Return the values of the map as a List of Lists
        return new ArrayList<>(map.values());
    }
}