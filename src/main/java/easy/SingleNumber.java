package easy;

/**
 * @ClassName SingleNumber
 * @Description 只出现一次的数字
 * @Date 2019/12/3
 * @Created by lizhanxu
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        boolean flag = true;
        out:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    flag=false;
                    continue out;
                }
            }
            if (flag) {
                return nums[i];
            }
            res = i;
        }
        return nums[res];
//        int i=0;
//        for (int j = i + 1; j < nums.length; j++) {
//            if (nums[i]==nums[j]){
//                i++;
//                j=i;
//            }
//        }
//        return nums[i];
    }
}
