package Plan14days;

public class Topic_11maxArea {
    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1;
        int ans = 0;
        while(i < j){
            int area = Math.min(height[i], height[j]) * (j - i);
            ans = Math.max(area,ans);

            if (height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
}
