package com.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_3 
{
    /* 
     * Remove all non matching characters from the given index. 
     * Exit out once we find the matching character. 
     */
    private int removeNonMatchingCharecters(int lowIdx, Character ch, Set<Character> set, String s) {
        /* Remove all non matching characters from the given index. */
        while(lowIdx < s.length() && s.charAt(lowIdx) != ch) {
            set.remove(s.charAt(lowIdx++));
        }
        
        return lowIdx;
    }
    
    public int lengthOfLongestSubstring(String s) 
    {
        int lowIdx = 0;
        int highIdx = 0;
        int longestLength = 0;
        Set<Character> longestSubString = new HashSet<Character>();
        
        /* Return 0 if string is null or empty. */
        if (s == null || s.isEmpty()) {
            return longestLength;
        }
        
        /* 
         * Loop over the entire string. 
         * 
         * o If we have already seen the character we have to discard all the 
         *   characters till the last occurrence of this character. As we might
         *   have max length from now on so we can't include any characters
         *   previous to last occurrence and last occurrence as well. 
         *   
         *   0  1  2  3  4
         *   x  x  x  x  x
         *   ^           ^ 
         *   |           |
         *   + - - - - - +
         *   
         *   Have to ignore occurrence at offset [0] and then consider longest length. 
         *   
         *   0  1  2  3  4
         *   x  x  x  x  x
         *      ^        ^ 
         *      |        |
         *      + - - -  +
         *      
         *   Have to ignore occurrence till offset [1] and then consider longest length. 
         *   
         *   
         * o Set should contain longest sub string seen so far. Cache its length. 
         * 
         */
        while (highIdx < s.length()) {
            /* 
             * Remove all characters before the last occurrence of this character 
             * including last occurrence to calculate for longest substring. 
             */
            if (longestSubString.contains(s.charAt(highIdx))) {
                lowIdx = removeNonMatchingCharecters(lowIdx, s.charAt(highIdx), longestSubString, s);
                longestSubString.remove(s.charAt(lowIdx++));
            }
            
            /* Add the new character to the set. Set should always contain largest substring. */
            longestSubString.add(s.charAt(highIdx++));
            
            /* Calculate the max we have seen so far. */
            longestLength = Math.max(longestLength, longestSubString.size());
        }
        
        return longestLength;
    }
    
    
    public static void main(String[] args) 
    {
        String s = "abcbefh";
        
        System.out.println(new LeetCode_3().lengthOfLongestSubstring(s));
    }
}
