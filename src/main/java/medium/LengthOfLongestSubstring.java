package medium;

import java.util.HashMap;

/**
 * @ClassName LengthOfLongestSubstring
 * @Description  无重复字符的最长子串
 * @Date 2019/12/3
 * @Created by lizhanxu
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //基于滑动窗口的概念
        int start,end,ass=0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(start=0,end=0;end<s.length();end++){
            if(map.containsKey(s.charAt(end))){
                start=Math.max(start,map.get(s.charAt(end)));
            }
            ass = Math.max(ass,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ass;



        //暴力解法超时，判断每一个子串
        // byte[] bytes;
        // int i,j,k,m;
        // out1:
        // for(i=s.length();i>0;i--){
        //     out2:
        //     for(j=0;j+i<=s.length();j++){
        //         bytes = s.substring(j,j+i).getBytes();
        //         for(k=0;k<bytes.length-1;k++){
        //             for(m=k+1;m<bytes.length;m++){
        //                 if(bytes[k]==bytes[m]){
        //                     continue out2;
        //                 }
        //             }
        //         }
        //         break out1;
        //     }
        // }
        // return i;
    }
}
