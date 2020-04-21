//Easy
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int center;
        while(left<=right) {
            center = left + (right - left) / 2;
            if(guess(center) == 0){
                return center;
            } else if (guess(center) == 1) {
                left = center + 1;
            } else {
                right = center - 1;
            }
        }
        return guess(n);
    }
}