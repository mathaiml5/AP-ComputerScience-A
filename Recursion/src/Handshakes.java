
/**
 * The Handshakes class has the handshake method which returns the number of 
 * handshakes between n people in a room.
 *
 * @author Vishak Srikanth
 * @version 2/23/2021
 */
public class Handshakes
{
    /**
     * handshake(): a method that returns the number of handshakes between
     * people in the room
     * 
     * @param  n, the number of people in the room
     * @return the number of handshakes between people
     * precondition: n>=1
     */
    public static int handshake(int n){
     /**
     * adding one person into the room means that that person
     * shakes hands with everyone else in the room so the number of
     * handshakes increases by n - 1
     */
        if( n >= 3) {
         return handshake(n-1) + n - 1;
        }
     else {
         //We are given handshake(1) = 0 ,and handshake(2) = 1 
         if(n==2) {
              return 1;
           }
           else {
              return 0;
            }
    }
   }
}
