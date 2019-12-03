package medium;

/**
 * @ClassName LongestPalindrome
 * @Description  最长回文子串
 * @Date 2019/12/3
 * @Created by lizhanxu
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s="bb";
        System.out.println(longestPlaindromeByCenterExpand(s));
//        System.out.println(longestPalindromeBylongestCommonSubString(s));
//        System.out.println(forcelongestPalindrome("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"));
    }

    //中心扩展法   8ms   36.5MB
    //单字符中心n个，两字符中心n-1个，共计2n-1个中心
    public static String longestPlaindromeByCenterExpand(String s){
        //特殊处理
        if(s==null||s.length()==0){
            return "";
        }
        //记录最长回文子串的起始下标
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1 = expandAroundCenter(s, i, i);//单字符中心
            int len2 = expandAroundCenter(s, i, i + 1);//两字符中心
            int len = Math.max(len1, len2);
            if (len > end - start) {//如果找到更长的回文子串，更新start和end
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     *
     * @param s
     * @param left
     * @param right
     * @return 以i下标字符为中心的最长回文子串长度
     */
    public static int expandAroundCenter(String s,int left,int right) {
        int L=left,R=right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {//如果相等则继续扩展
            L--;
            R++;
        }
        return R-L-1;
    }

    //最大公共子串     85ms   49.2MB
    public static String longestPalindromeBylongestCommonSubString(String s){
        int len = s.length();

        //特殊处理
        if(s==null||s.length()==0){
            return "";
        }

        //求得反序串
        char[] chars = s.toCharArray();
        char[] reverse = new char[len];
        for(int i=len-1;i>=0;i--){
            reverse[len-i-1] = chars[i];
        }

        //m为该公共子串在原串中的末尾下标
        //max为最大公共子串的长度
        int m=0,max=0;
        //二维矩阵
        int[][] arrays = new int[len][len];
        for(int i=0;i<len;i++){//原始串
            for(int j=0;j<len;j++){//反序串
                if(reverse[j]==chars[i]){
                    if(i>0&&j>0){
                        if(reverse[j-1]!=chars[i-1]){
                            arrays[i][j]=1;
                        }else
                            arrays[i][j]=arrays[i-1][j-1]+1;//填充最大公共子串长度
                    }
                    if(i==0||j==0){
                        arrays[i][j]=1;
                    }
                }
                //增加(len-1-j + arrays[i][j] - 1 == i)判断，目的是过滤最大公共子串中的非回文串；
                //len-1-j 为反序子串末尾下标在原始串中的对应位置，即公共子串在原始串中的首位
                // i 为该子串在原始串中的末尾下标
                //len-1-j 应该与 i 回文对应
                //首位（len-1-j）+长度（arrays[i][j]）-1应该等于末位（i）
                if(arrays[i][j]>max&&(len-1-j + arrays[i][j] - 1 == i)){
                    m=i;
                    max=arrays[i][j];
                }
            }
        }
        return s.substring(1+m-max,m+1);
    }

    //暴力解法
    public static String forcelongestPalindrome(String s){
        String res = "";
        if(s==null||s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        int len = s.length();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                if(judge(s.substring(i,j))&&(s.substring(i,j).length()>res.length())){
                    res=s.substring(i,j);
                }
            }
        }
        return res;
    }

    //判断是否为回文串
    public static boolean judge(String s){
        int len=s.length();
        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
