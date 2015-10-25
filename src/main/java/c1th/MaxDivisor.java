package c1th;

/**
 * Created by tangkun.tk on 2015/10/25.
 * 最大公约数问题,辗转相除法
 */
public class MaxDivisor {


    /// v1 > v2
    public static int m1(int v1,int v2){

        if( v2 > v1){
            return m1(v2,v1);
        }

        if(v2 == 0 ){
            return v1;
        }
        return m1(v1-v2,v2);
    }

    /// v1 > v2
    public static int m2(int v1,int v2){

        if( v2 > v1){
            return m1(v2,v1);
        }

        if(v2 == 0 ){
            return v1;
        }
        return m1(v1%v2,v2);
    }


    public static void main(String[] args) {
        System.out.println(m1(42, 11));
        System.out.println(m2(42,11));
    }

    //

}
