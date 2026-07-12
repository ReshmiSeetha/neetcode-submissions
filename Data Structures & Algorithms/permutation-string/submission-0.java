class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n)
            return false;
        
        int[] need = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < m; i++){
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if(matches(need, window))
            return true;

        for(int right = m; right < n; right++){
            window[s2.charAt(right) - 'a']++;
            window[s2.charAt(right - m) - 'a']--;

            if(matches(need, window))
                return true;
        }
        return false;
    }

    public static boolean matches(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
}
