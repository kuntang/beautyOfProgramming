package c2th;

/**
 * Created by tangkun.tk on 2015/10/31.
 * �ַ���������ص��㷨
 */
public class StringContains {

    /**
     * �����ַ����ܷ�ͨ����λ��������ĳ�ַ���
     * ��: s1=AABCD,s2=CDAA ����true,s1=ACDDE,s2=ABDC ����false
     * @param originStr Դ�ַ���
     * @param containStr �����ַ���
     * @return �Ƿ����
     * -todo �ܷ�ͨ���������¿ռ����ﵽ��һĿ��?
     */
    public static boolean m1(String originStr,String containStr){
        StringBuilder sb = new StringBuilder(originStr);
        sb.append(originStr);
        String result = sb.toString().contains(containStr) ? "����":"������";
        System.out.println(originStr+result+containStr);
        return sb.toString().contains(containStr);
    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "eabd";
        m1(s1,s2);
    }

}
