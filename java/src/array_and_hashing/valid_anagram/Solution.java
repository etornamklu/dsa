package array_and_hashing.valid_anagram;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[26];

        for(char c : s.toCharArray()){
            letters[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            letters[c - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(letters[i] != 0) return false;
        }
        return true;
    }
}