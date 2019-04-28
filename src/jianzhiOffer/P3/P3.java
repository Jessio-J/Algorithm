package jianzhiOffer.P3;
// Parameters:
//    numbers:     an array of integers
//    length:      the length of array numbers
//    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
//                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
//    这里要特别注意~返回任意重复的一个，赋值duplication[0]
// Return value:       true if the input is valid, and there are some duplications in the array number
//                     otherwise false

import java.util.Arrays;

public class P3 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0){
            duplication[0]=-1;
            return false;
        }
        Arrays.sort(numbers);
        for(int i = 1;i<length;i++){
            if(numbers[i-1]==numbers[i]){
                duplication[0]=numbers[i];
                return true;
            }
        }
        duplication[0]=-1;
        return false;
    }
}
