package c1th;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by tangkun.tk on 2015/10/27.
 * q1: �����е�������Сֵ
 * q2: ��������������������ֵ
 * q3: �����в���������ӵ��ڸ������ֵ�Ԫ��
 */
public class MaxMinInArray {

    /**
     * ����2������,Ѱ��������С
     * @param array ����
     * @return ��С,�������
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
     * �����С,�����Ƚ�,��һ�αȽ�.
     * �ֶ���֮˼��.
     * @param array ���Ƚϵ�����
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
            // ��ż���
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
     * ��������,��������(����=[a,b]������û����������,��ab����)��������ֵ
     *
     * delta = (max-min)/(n-1)
     * ƽ���ֲ���n��Ͱ(ÿ��Ͱ�ķ�Χ���Ϊ delta)��,���ֵֻ�����������������,��ǰһ����������ֵ�ͺ�һ�����������Сֵ���.
     * @param array ����
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
        while((min+i*delta)<max){   // ��ʼ��Ͱ
            Integer[] v = new Integer[2];
            v[0] = min + i*delta;
            v[1] = min + ++i * delta;
            data.put(v,new TreeSet<Integer>());
        }

        for(int v : array){     // װ��Ͱ
            for(Map.Entry<Integer[],TreeSet<Integer>> entry : data.entrySet()){
                if(entry.getKey()[0] <= v && entry.getKey()[1] >= v){   // �ڴ�����
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
     * �ҵ�������2����ӵ��ڸ�������Ԫ��
     * @param array ����
     * @param sum ��������
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
     * 2���ĳ�����������ӵ���sum
     * @param array ����
     * @param sum ��������
     */
    public static void m5(int[] array,int sum){
        Map<Integer,Integer> data = new HashMap<Integer, Integer>();
        for(int v : array){
            data.put(v,v);
        }

        // sum -v =mid, �� array��ȥ��v,������mid���������
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
