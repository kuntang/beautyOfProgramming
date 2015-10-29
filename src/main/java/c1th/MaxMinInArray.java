package c1th;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by tangkun.tk on 2015/10/27.
 * q1: 数组中的最大和最小值
 * q2: 数组中求两两相减的最大值
 * q3: 数组中查找两两相加等于给定数字的元素
 */
public class MaxMinInArray {

    /**
     * 遍历2次数组,寻找最大和最小
     * @param array 数组
     * @return 最小,最大数组
     */
    public static int[] m1(int[] array){
        if(array == null || array.length<1){
            return new int[0];
        }
        int [] minAndMax = new int[2];

        int min = array[0];
        for(int i=1;i<array.length;i++){
            min = array[i] < min ? array[i] : min;
        }
        int max = array[0];
        for(int i=1;i<array.length;i++){
            max = array[i] > max ? array[i] : max;
        }
        minAndMax[0] = min;
        minAndMax[1] = max;
        System.out.println("max="+max);
        System.out.println("min="+min);
        return minAndMax;
    }


    /**
     * 最大最小,两两比较,少一次比较.
     * 分而治之思想.
     * @param array 待比较的数组
     */
    public static void m2(int[] array){
        if(array == null || array.length<1){
            return;
        }
        int min = array[0];
        int max = array[0];
        int i= 0;
        while( i < array.length){

            int v1 = array[i];
            i++;
            // 奇偶情况
            int v2 = i<array.length ? array[i] : v1;
            i++;
            boolean rv = v1 > v2;
            if(rv){
                min = v2 < min ? v2 : min;
                max = v1 > max ? v1 : max;
            }else{
                min = v1 < min ? v1 : min;
                max = v2 > max ? v2 : max;
            }
        }

        System.out.println("max="+max);
        System.out.println("min="+min);
    }

    /**
     * 整数数组,两两相邻(相邻=[a,b]区间内没有其它数字,则ab相邻)相减的最大值
     *
     * delta = (max-min)/(n-1)
     * 平均分布在n个桶(每个桶的范围跨度为 delta)里,最大值只会出现在相邻区间里,用前一个区间的最大值和后一个区间里的最小值相减.
     * @param array 数组
     */
    public static void  m3(int[] array){
        int[] minAndMax = m1(array);
        if(minAndMax.length<1){
            return;
        }
        int min = minAndMax[0];
        int max = minAndMax[1];
        int delta = (max-min) / array.length - 1;
        Map<Integer[],TreeSet<Integer>> data = new LinkedHashMap<Integer[],TreeSet<Integer>>();
        int i=0;
        while((min+i*delta)<max){   // 初始化桶
            Integer[] v = new Integer[2];
            v[0] = min + i*delta;
            v[1] = min + ++i * delta;
            data.put(v,new TreeSet<Integer>());
        }

        for(int v : array){     // 装进桶
            for(Map.Entry<Integer[],TreeSet<Integer>> entry : data.entrySet()){
                if(entry.getKey()[0] <= v && entry.getKey()[1] >= v){   // 在此区间
                    entry.getValue().add(v);
                    break;
                }
            }
        }

        int value = 0;
        int pmax = 0;
        int nmin = 0;
        for(Map.Entry<Integer[],TreeSet<Integer>> entry : data.entrySet()){
            if(entry.getValue().size() > 0){
                nmin = entry.getValue().last();
                value = (nmin - pmax) > value ? (nmin - pmax) : value;
                pmax = nmin;
            }
        }
        System.out.println("value="+value);
    }


    /**
     * 找到数组中2个相加等于给定数的元素
     * @param array 数组
     * @param sum 给定数字
     */
    public static void m4(int[] array,int sum){
        Map<Integer,Integer> data = new HashMap<Integer, Integer>();
        for(int v : array){
            data.put(v,v);
        }

        for(int v : array){
            int v2 = sum -v;
            if(data.containsKey(v2)){
                System.out.println(sum+"="+v+"+"+v2);
            }
        }
    }

    /**
     * 2个改成三个数字相加等于sum
     * @param array 数组
     * @param sum 给定数字
     */
    public static void m5(int[] array,int sum){
        Map<Integer,Integer> data = new HashMap<Integer, Integer>();
        for(int v : array){
            data.put(v,v);
        }

        // sum -v =mid, 在 array中去掉v,并查找mid的两两组合
        for(int v : array){
            int mid = sum - v;
            if(mid > 0 ){


            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,12,23,11,34,54,323,222,111};
        m1(a);
        m2(a);
        m3(a);
        m4(a,56);

    }


}
