package c1th;

import java.util.List;

/**
 * Created by tangkun.tk on 2015/10/29.
 * ����ѭ�������ƶ�Kλ
 */
public class ReversalArray {
    /**
     * ˼·����(k=4):
     * 1, ��������,1,2,3,4,5,a,b,c,d ==> 5,4,3,2,1,a,b,c,d
     * 2, ��������,5,4,3,2,1,a,b,c,d ==> 5,4,3,2,1,d,c,b,a
     * 3, ȫ������,5,4,3,2,1,d,c,b,a ==> a,b,c,d,1,2,3,4,5
     * ʱ�临�Ӷ�: O(N),�ռ临�Ӷ�: O(1)
     */
    public static void m1(){
        int a[]= {1,2,3,4,5,6,7,8};
        int k = -3;
        while(k < 0){   // ������ʾ������λ
            k +=a.length;
        }
        k %= a.length;
        reversal(a, 0, a.length - k - 1);
        reversal(a, a.length - k, a.length - 1);
        reversal(a, 0, a.length - 1);
        for(int v : a){
            System.out.print(v+",");
        }
    }

    /**
     * @param array  ����������
     * @param start  ��ʼλ��
     * @param end    ����λ��
     */
    public static void reversal(int[] array,int start,int end){
        if(array == null || array.length <= 1){
            return;
        }
        for(;start<end; start++,end--){
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
        }
    }

    public static void m2(List<Integer[]> target,int[] sourceArray){
        if(sourceArray == null || sourceArray.length != 2){
            throw new IllegalArgumentException("Դ����ֻ����2������");
        }
    }

    public static void main(String[] args) {
    }

}
