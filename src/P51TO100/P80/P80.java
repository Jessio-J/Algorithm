package P51TO100.P80;

public class P80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count = 1;
        int cur = nums[0];
        int i = 1;
        int j = 1;
        while (j<nums.length){
            if(nums[j]==cur){
                if(count<2){
                    if(i!=j){
                        swap(nums,i,j);
                    }
                    j++;
                    i++;
                    count++;
                }else {
                    while(j<nums.length&&nums[j]<=cur){
                        j++;
                    }
                    if(j<nums.length){
                        cur = nums[j];
                        swap(nums,i,j);
                        i++;
                        j++;
                        count = 1;
                    }
                }
            }else if(nums[j]>cur){
                cur = nums[j];
                swap(nums,i,j);
                i++;
                j++;
                count = 1;
            }
        }
        return i;
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
