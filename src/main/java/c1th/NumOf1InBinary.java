package c1th;

/**
 * Created by tangkun.tk on 2015/10/24.
 * 题目: 二进制1的个数
 */
public class NumOf1InBinary {
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
        while(v > 0){
            count += v & 0x01;
            v = (byte)(v >> 1);
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


    /**
     * 逆转整数的二进制表示
     * 思路:
     * 思路：相邻两位互调位置（即一位换一位），再相邻的两位换两位，
     * 在相邻的四位与四位互调位置，再八位与八位互调位置，最后前十六位和后十六位互换位置，完成32位整数逆转。思路与归并排序相似。
     * @return
     */
    public static int m7(int x){
        x=(x&0x55555555)<<1|(x>>1)&0x55555555;
        x=(x&0x33333333)<<2|(x>>2)&0x33333333;
        x=(x&0x0f0f0f0f)<<4|(x>>4)&0x0f0f0f0f;
        x=(x&0x00ff00ff)<<8|(x>>8)&0x00ff00ff;
        x=x<<16|x>>16;
        return x;
    }

    public static void main(String[] args) {
        byte v = 99;
        System.out.println(m1(v));
        System.out.println(m2(v));
        System.out.println(m3(v));
        System.out.println(m4(v));
        System.out.println(m5(v));
        byte a = 123;
        byte b = 23;
        System.out.println(m6(a,b));
    }

}
