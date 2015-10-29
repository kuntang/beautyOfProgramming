package c1th;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangkun.tk on 2015/10/27.
 * 斐波那契数列
 */
public class Fibonacci {

    public static int m1(int v){

        if(v == 0){
            return 0;
        }
        if(v == 1){
            return 1;
        }

        return m1(v-1)+m1(v-2);
    }

    /**
     * 缓存结果
     */
    static Map<Integer,Integer> vv = new HashMap<Integer,Integer>();
    public static int m2(int v){
        if(v-1 > 0 && v-2 > 0){
            vv.put(v,vv.get(v-1)+vv.get(v-2));
        }
        int rv = m1(v);
        vv.put(v,rv);
        return rv;
    }


    /**
     * A(0) = 1, A(1) = 2,A(2) = 2 对n>2,都有A(K)=A(K-1)+A(K-2)+A(K-3)
     * @param v 值
     * @return 结果
     */
    public static int m3(int v){

        if(v == 0){
            return 1;
        }
        if(v == 1){
            return 2;
        }
        if(v == 2){
            return 2;
        }

        return m3(v-3) + m3(v-2) + m3(v-1);
    }



    public static void main(String[] args) {

        int v = 10;
        for(int i=0;i<v;i++){
            System.out.print(m1(i)+",");
        }
        System.out.println();

        for(int i=0;i<v;i++){
            System.out.print(m2(i)+",");
        }
        System.out.println();

        System.out.println(m3(10));

        // todo -- 计算n=2^60的数

    }

}
