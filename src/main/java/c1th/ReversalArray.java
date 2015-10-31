package c1th;

import java.util.List;

/**
 * Created by tangkun.tk on 2015/10/29.
 * 数组循环向右移动K位
 */
public class ReversalArray {
    /**
     * 思路如下(k=4):
     * 1, 逆序排序,1,2,3,4,5,a,b,c,d ==> 5,4,3,2,1,a,b,c,d
     * 2, 逆序排序,5,4,3,2,1,a,b,c,d ==> 5,4,3,2,1,d,c,b,a
     * 3, 全部逆序,5,4,3,2,1,d,c,b,a ==> a,b,c,d,1,2,3,4,5
     * 时间复杂度: O(N),空间复杂度: O(1)
     */
    public static void m1(){
        int a[]= {1,2,3,4,5,6,7,8};
        int k = -3;
        while(k < 0){   // 负数表示向左移位
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
     * @param array  待逆序数组
     * @param start  开始位置
     * @param end    结束位置
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
            throw new IllegalArgumentException("源数组只能是2个数字");
        }
    }

    public static void main(String[] args) {
    }

}
