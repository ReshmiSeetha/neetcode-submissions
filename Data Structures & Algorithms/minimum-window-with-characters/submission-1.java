class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int formed = 0;
        int required = need.size();

        int bestLen = Integer.MAX_VALUE;
        int bestLeft = 0;

        Map<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }
            while (formed == required) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestLeft = left;
                }

                char remove = s.charAt(left);
                window.put(remove, window.get(remove) - 1);

                if (need.containsKey(remove)
                    && window.get(remove).intValue() < need.get(remove).intValue()) {
                    formed--;
                }
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestLeft + bestLen);
    }
}
