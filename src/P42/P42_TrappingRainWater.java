package P42;

public class P42_TrappingRainWater {
    public int trap(int[] height) {

        int[] rate = new int[height.length - 1];
        int[] parMaxMin = new int[height.length];
        for (int i = 0; i < height.length - 1; i++) {
            rate[i] = height[i + 1] - height[i];
            if (i > 0) {
                if (rate[i] > 0 && rate[i - 1] < 0) {
                    parMaxMin[i] = 2;
                }
                if (rate[i] < 0 && rate[i - 1] > 0) {
                    parMaxMin[i] = 1;
                }
            }
        }
        if(height.length>2&&height[0]>height[1]){
            parMaxMin[0] = 1;
        }
        if(height.length>2&&height[height.length-1]>height[height.length-2]){
            parMaxMin[parMaxMin.length-1] = 1;
        }
        int j = 0;
        while(j<height.length&&parMaxMin[j]==0){
            j++;
        }
        int lastIndex = -1;
        int leftIndex = 0;
        int rightIndex = height.length-1;
        int max = 0;
        while(leftIndex<rightIndex){
            while(parMaxMin[leftIndex]!=1){
                leftIndex++;
            }
            while(parMaxMin[rightIndex]!=1){
                rightIndex--;
            }
            int min = Math.min(height[leftIndex],height[rightIndex]);
            int rain = 0;
            for(int a = leftIndex+1;a<rightIndex;a++){
                rain += min - height[a]>0?min - height[a]:0;
            }
            if(rain > max){
                max = rain;
            }
            if (height[leftIndex] < height[rightIndex])
                leftIndex++;
            else
                rightIndex--;
        }
        return max;
    }
}
