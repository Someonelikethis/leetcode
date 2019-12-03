package easy;

/**
 * @ClassName LongestCommonPrefix
 * @Description  最长公共前缀
 * @Date 2019/12/3
 * @Created by lizhanxu
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

    }
    public static String longestCommonPrefix(String[] strs) {
        //特殊处理
        if (strs == null||strs.length == 0) {
            return "";
        }

        //求得字符串数组中最短的字符串长度
        int minlen=strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length()<minlen){
                minlen = strs[i].length();
            }
        }
        int end=-1;//最长公共前缀的尾下标
        char temp=' ';//存储第一个字符串指定位置的字符，给其它字符串比较
        out:
        for (int i = 0; i < minlen; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {//设置temp
                    temp = strs[j].charAt(i);
                    continue;
                }
                if (temp != strs[j].charAt(i)){//碰到第一个不同的字符，退出
                    break out;
                }
            }
            end = i;//记录最长公共前缀的尾下标
        }
        if (end == -1) {//说明没有公共前缀
            return "";
        }
        return strs[0].substring(0, end + 1);
    }
}
