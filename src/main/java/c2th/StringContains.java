package c2th;

/**
 * Created by tangkun.tk on 2015/10/31.
 * 字符串操作相关的算法
 */
public class StringContains {

    /**
     * 给定字符串能否通过移位操作包含某字符串
     * 如: s1=AABCD,s2=CDAA 返回true,s1=ACDDE,s2=ABDC 返回false
     * @param originStr 源字符串
     * @param containStr 包含字符串
     * @return 是否包含
     * -todo 能否通过不申请新空间来达到这一目的?
     */
    public static boolean m1(String originStr,String containStr){
        StringBuilder sb = new StringBuilder(originStr);
        sb.append(originStr);
        String result = sb.toString().contains(containStr) ? "包含":"不包含";
        System.out.println(originStr+result+containStr);
        return sb.toString().contains(containStr);
    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "eabd";
        m1(s1,s2);
    }

}
