package c1th;

/**
 * Created by tangkun.tk on 2015/10/24.
 * n �׳�����
 * q1: �����������1��λ��
 * q2: ��������ĩβ0�ĸ���
 * ע��: ����N!�Ƿ�����
 */
public class Njc {
    /**
     * n�Ľ׳�
     * @param cc ��ֵ
     * @return �׳�ֵ
     */
    public static int jc(int cc){
        if(cc == 1){
            return 1;
        }
        return cc*jc(cc-1);
    }

    // ���������1��λ��
    public static int lowest1position(){
        int a = 0x011000;
        System.out.println(Integer.toBinaryString(a));
        if( a % 2 == 1){
            return 1;
        }
        int i=1;
        int num = 1;
        //
        System.out.println(a % ((int)Math.pow(2,i++)) == 0 );
        while( a % ((int)Math.pow(2,i++)) == 0 ){
            num++;
        }
        num++;
        System.out.println("���λ"+num);
        return num;
    }

    // Ѱ����ĩβ���������ֺ���0�ĸ���
    public static int jc(){
        int num = 0;
        int a = 0x011000;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Math.pow(2,1));
        // �����1��ʼ,��Ϊ2��1�η�=2,2��0�η�=1,�κ���%1 = 0�߽�ֵ����
        int i=1;
        while(a % Math.pow(2,i) == 0 ){
            num++;
            i++;
        }
        System.out.println(num);
        return num;
    }

    public static void main(String[] args) {
        int value = jc(5);
        System.out.println("�׳�: "+value);
        jc();
        lowest1position();
    }

}
