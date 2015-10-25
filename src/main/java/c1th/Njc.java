package c1th;

/**
 * Created by tangkun.tk on 2015/10/24.
 * n 阶乘问题
 * q1: 二进制中最低1的位置
 * q2: 二进制中末尾0的个数
 * 注意: 计算N!是否会溢出
 */
public class Njc {
    /**
     * n的阶乘
     * @param cc 数值
     * @return 阶乘值
     */
    public static int jc(int cc){
        if(cc == 1){
            return 1;
        }
        return cc*jc(cc-1);
    }

    // 二进制最低1的位置
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
        System.out.println("最低位"+num);
        return num;
    }

    // 寻找最末尾二进制数字后面0的个数
    public static int jc(){
        int num = 0;
        int a = 0x011000;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Math.pow(2,1));
        // 必须从1开始,因为2的1次方=2,2的0次方=1,任何数%1 = 0边界值问题
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
        System.out.println("阶乘: "+value);
        jc();
        lowest1position();
    }

}
