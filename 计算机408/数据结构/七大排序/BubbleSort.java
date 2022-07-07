public class BubbleSort {


    public  void  bubbleSort(int[] nums){
        //双层for循环
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <i -1; j++) {
                if(nums[j]>[nums[j+1]]){
                    nums[j]=nums[j]^nums[j+1];
                    nums[j+1]=nums[j]^nums[j+1];
                    nums[j]=nums[j]^nums[j+1];
                }
            }
        }
    }
}
