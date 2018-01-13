import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {

        if(numbers == null || numbers.length < 3){
            return null;
        }

        //why number.length -2 ex: 12345
        //when i = 2 (number[2] = 3) left = i+1 (number[3] = 4) right = 4 (number[4] = 5)
        //Thus, there is only one combination of a+b+c which is 3,4,5
        //if i = 3 (number[3] = 4) there is no any three number combination exist ==> left has already same as right (number[4] = 5)
        //Is number[3] = 4 + other possible combination exist, sure , but it count in previous calculations

        int left;
        int right;
        int target;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(numbers);

        for(int i = 0 ; i < numbers.length - 2 ; i++){

            if(i!=0 && numbers[i-1]==numbers[i]){
                continue;
            }

            left = i + 1;
            right = numbers.length - 1;
            target = -numbers[i];

            twoPointer(numbers,target,left,right,result);

        }

        return result;

    }


    private void twoPointer(int[] number,int target,int left, int right, List<List<Integer>> result){


        while(left < right){

            if(number[left] + number[right] < target){
                left++;
            }
            else if(number[left] + number[right] > target){
                right--;
            }
            else if(number[left] + number[right] == target){
                List<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(number[left]);
                triple.add(number[right]);
                result.add(triple);
                left++;
                right--;
                while (left < right && number[left-1] == number[left] && number[right+1] == number[right]){
                    left++;
                    right--;
                }
            }
        }
    }


}