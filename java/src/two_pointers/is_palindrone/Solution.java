package two_pointers.is_palindrone;

public class Solution {
    public static boolean isPalindrone(String s) {

        char[] arr = s.toLowerCase().toCharArray();
        int l = 0;
        int r = arr.length - 1;

        while (l < r){

            if(!Character.isLetterOrDigit(arr[l])) {
                l++;
                continue;
            }

            if(!Character.isLetterOrDigit(arr[r])) {
                r--;
                continue;
            }

            if(arr[l] != arr[r]) return false;

            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(Solution.isPalindrone("tacocat"));
    }
    
}
