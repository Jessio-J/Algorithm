package P51TO100.P84;

public class P84 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        int maxSize = heights[0];
        int curHeight = 0;
        for(int i = 0;i<heights.length;i++){
            curHeight = heights[i];
            int max = 0;
            for(int j = i;j<heights.length;j++){
                if(heights[j]==0){
                    break;
                }
                if(heights[j]<curHeight){
                    curHeight = heights[j];
                }
                int cur = curHeight*(j-i+1);
                if(max<cur){
                    max = cur;
                }
            }
            maxSize = maxSize>max?maxSize:max;
        }
        return maxSize;
    }
}
