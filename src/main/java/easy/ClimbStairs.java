package easy;

/**
 * @ClassName ClimbStairs
 * @Description  爬楼梯     动态规划
 * @Date 2019/12/4
 * @Created by lizhanxu
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
        //注意n>45时，最终结果超出int范围，溢出；
        System.out.println(climbStairs2(3));
    }

    //暴力递归   超时
    public static int climbStairs(int n) {
        //特殊处理
        if (n <= 2) {
            return n;
        }
        else return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * 利用斐波那契数列    一个数列当前项等于前两项之和。    例如： 1，1，2，3，5，8，13，21，......
     *
     * 设爬n阶楼梯有f(n)种方法
     * 第一次爬1个，此时剩余n-1个台阶，有f(n-1)种方法
     * 第一次爬2个，此时剩余n-2个台阶，有f(n-2)种方法
     * 固有f(n) = f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        //特殊处理
        if (n <= 2) {
            return n;
        }
        int factor1=1;//斐波那契数列的第一项
        int factor2=2;//斐波那契数列的第二项
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = factor1 + factor2;
            factor1=factor2;//右移
            factor2 = result;//右移
        }
        return result;
    }
}

