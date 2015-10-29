package c1th;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangkun.tk on 2015/10/29.
 * 求递增子数组
 */
public class IncrementSeq {


    public static void incrementSubSeq(int[] array){
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for(int v :array){
           for(List<Integer> item : resultList){
               int vv = item.get(item.size()-1);
               if(v>vv){
                   item.add(v);
               }
           }
            List<Integer> list = new ArrayList<Integer>();
            list.add(v);
            resultList.add(list);
        }

        for(List<Integer> item : resultList){
            System.out.println(item);
        }


    }


    public static void main(String[] args) {
        int a[] = {1,-1,2,-3,4,-5,6,-7};
        incrementSubSeq(a);
    }


}
