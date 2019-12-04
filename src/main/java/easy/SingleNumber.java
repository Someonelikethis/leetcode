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
        System.out.println(forceSingleNumber(nums));
        System.out.println(singleNumberByBit(nums));
    }

    //暴力解法  执行时间长   353ms   37.8MB
    public static int forceSingleNumber(int[] nums) {
        int res = 0;
        out:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue ;
                }
                if(nums[i]==nums[j]){
                    continue out;
                }
            }
            res=i;
        }
        return nums[res];
    }

    //

    /**
     * 位操作    1ms   38MB
     *
     * java没有同或运算符
     *
     * 异或   不同为1
     * 同或   相同为1
     *
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     *
     * 任何数与0异或为任何数 0 ^ n => n
     *
     * 相同的数异或为0: n ^ n => 0
     *
     *
     * @param nums
     * @return
     */
    public static int singleNumberByBit(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
