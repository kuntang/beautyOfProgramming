package c1th;

/**
 * Created by tangkun.tk on 2015/10/24.
 * 题目: 二进制1的个数
 */
public class numOf1 {

    public static void main(String[] args) {

        byte v = 99;
        System.out.println(m1(v));
        System.out.println(m2(v));
        System.out.println(m3(v));
        System.out.println(m4(v));
        int v1 = 12345;
        System.out.println(m5(v1));
        byte a = 123;
        byte b = 23;
        System.out.println(m6(a,b));
    }


    /**
     * 方法1: 取于,除法
     * @param v 值
     * @return 个数
     */
    public static int m1(byte v){
        int count = 0;
        while(v > 0){
            if( v%2 == 1){
                count++;
            }
            v/=2;
        }
        return count;
    }

    /**
     * 移位 求与法
     * @param v 值
     * @return 数量
     */
    public static int m2(Byte v){
        int count = 0;
        for(int i=0;i<8;i++){
            count+=v & 0x01;
            v = (byte)(v >> 1);     // byte操作后转为int,需强制转换.
        }
        return count;
    }


    /**
     * 抹掉最后一个1.
     * v&(v-1)
     * 01000 & 00111 = 0
     * @param v 值
     * @return 个数
     */
    public static int m3(Byte v){
        int num = 0;
        while(v > 0){
            v= (byte) (v & (v-1));
            num++;
        }
        return num;
    }

    /**
     * 穷举法(空间换时间)
     * @param v 值
     * @return 个数
     */
    public static int m4(Byte v){
        int[] array = new int[128];
        array[0] = 0;
        array[1] = 1;
        return array[v];
    }

    /**
     * http://blog.csdn.net/justpub/article/details/2292823 解法
     * @param x 值
     * @return 个数
     */
    public static int m5(int x) {

        System.out.println(0x55555555);
        System.out.println(0x33333333);
        System.out.println(0x0F0F0F0F);
        System.out.println(0x0000003F);

        x = (x - ((x >> 1) & 0x55555555));
        x = ((x & 0x33333333) + ((x >> 2) & 0x33333333));
        x = ((x + (x >> 4)) & 0x0F0F0F0F);
        x = x + (x >> 8);
        x = x + (x >> 16);
        return x & 0x0000003F;
    }


    /**
     * 求 AB 位数不同的个数
     * 异或后求1的个数.
     * @param a 数1
     * @param b 数2
     * @return 个数
     */

    public static int m6(Byte a,Byte b){
        Byte c = (byte) (a ^ b);
        return m3(c);
    }




}
