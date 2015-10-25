package c1th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tangkun.tk on 2015/10/25.
 * 十进制中1的个数
 */
public class NumOf1InDecimal {




    /**
     * 复杂度=O(N*lgN)
     * @param v 值
     * @return 1出现的次数
     */
    public static int m1(int v){
        int count = 0;
        int i=0;
        while(i <= v){
            int copy = i;
            while(copy > 0){
                count += (copy % 10 == 1 ? 1 : 0);
                copy/=10;
            }
            i++;
        }
        return count;
    }


    /**
     * 个位出现次数+十位出现次数+百位出现次数+....N位出现次数 = 1的总出现次数
     * @param v 值
     * @return 1出现的次数
     */
    public static int m2(int v){
        int count = 0;
        // 数的位数
        int copyV = v;

        List<Integer> valueList = new ArrayList<Integer>();

        while(copyV>0){
            valueList.add(copyV % 10);
            copyV/=10;

        }

        int[] valueArray = new int[valueList.size()];
        System.arraycopy(valueList.toArray(), 0, valueArray,0,valueList.size());



        copyV = v;
        int totalCount = 0;

        int i=0;
        while( i < valueArray.length ){

            if(valueArray[i] > 0 ){
                totalCount += copyV/10 ;

            }

        }





        return count;
    }

    public static void main(String[] args) {

        int v = 121;
        System.out.println(m1(v));

        // todo ----


    }




}
