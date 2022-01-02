
/**
 * The Contains class contains the method contains, which returns true if a
 * string contains another string and false otherwise.
 * @author Vishak Srikanth
 * @version 2/23/2021
 */
public class Contains
{
    /**
     * contains(): calls the helper method contains helper
     *
     * @param haystack, a String
     * @param needle, a String
     * @return calls containsHelper(haystack, 0, needle, 0)(which returns an
     *  integer)
     */
   public static boolean contains(String haystack, String needle)
    {
        return containsHelper(haystack, 0, needle, 0);
    }
    /**
     * containsHelper(): returns whether the string haystack contains the
     * string needle
     * note: advancing a character in haystack means adding 1 to haystart
     * ,and advancing one character in needle means adding 1 to needStart
     * @param haystack, a String
     * @param hayStart(an integer), the index of the character in the 
     * haystack currently being examined
     * @param needle, a String
     * @param needStart(an integer), the index of the character in the 
     * needle currently being examined
     * @return a boolean, whether the String haystack contains the string
     * needle
     */
   public static boolean containsHelper(String haystack, int hayStart,
   String needle, int needStart){
            /**     
            * if the index currently being examined in the haystack is
            * greater than the length of the haystack, the whole string 
            * haystack has been examined and we must return false
            */
           if(hayStart >= haystack.length()){
                return false;
              }  
           else if(needStart == 0){
                /** 
                * if needle has length 0 then the haystack contains the
                * needle
                */ 
                if(needle.length()==0) {
                  return true;
                }
                else { 
                  if(haystack.charAt(hayStart)==needle.charAt(needStart)){
                    /** 
                    * if the characters beeing compared in needle and 
                    * haystack are the same and needle has a length of 
                    * 1(and needStart = 0), then haystack contains needle
                    */
                      if(needle.length()==1) {
                        return true;
                    }
                    /** 
                    * if the characters beeing compared in needle and 
                    * haystack are the same and needle has a length 
                    * greater than 1, then advance one character in both
                    * haystack and needle(assuming needStart = 0)
                    */
                    else {
                        return containsHelper(haystack,hayStart+1,needle,
                        1);
                    }
                     }
                    /** 
                    * if the characters beeing compared in needle and 
                    * haystack are not the same then advance one character
                    * in haystack
                    */
                   else {
                      return containsHelper(haystack,hayStart+1,needle,
                        0);
                    }
                }
            }
           else {
               if(haystack.charAt(hayStart)==needle.charAt(needStart)) {
                /** 
                * if the characters being compared in haystack and needle
                * are the same and needStart is not the index of the last
                * character in needle, then advance one character in both
                * haystack and needle
                */  
                   if(needStart!=needle.length() - 1){
                   return containsHelper(haystack,hayStart+1,needle,
                   needStart +1);
                 }
                 /** 
                * if the characters being compared in haystack and needle
                * are the same and needStart is the index of the last
                * character in needle, then haystack contains needle
                */ 
                   else {
                     return true;
                }
               }
                /** 
                * if the characters being compared in haystack and needle
                * are not the same, then advance one character in haystack(
                * increase hayStart by one)
                */
               else {
                   return containsHelper(haystack,hayStart+1,needle,
                   0);
                 }
              }  
   }
}      