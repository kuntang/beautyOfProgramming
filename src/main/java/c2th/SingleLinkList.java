package c2th;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangkun.tk on 2015/10/31.
 * 单链表操作
 */
public class SingleLinkList {

    /**
     * 单向链表,实现 A->B->C->D 删除C节点
     * 当前指针指向C.
     */
    public static void m1(int totalNodeNum,int deleteNodeIndex){

        Node head = init(totalNodeNum);
        Node copy = head;
        Node currentP = null;

        while(copy.next != null){
            if(copy.next.v == deleteNodeIndex){
                currentP = copy.next;
            }
            copy = copy.next;
        }

        if(currentP != null){
            if(currentP.next == null){
                throw new RuntimeException("要删除的节点是链表的最后一个节点");
            }
            // 用后一个节点的内容替换掉当前节点内容,并把 当前节点(待删除节点) 指向 后后节点
            // 狸猫换太子,精彩绝伦
            currentP.v = currentP.next.v;
            currentP.next = currentP.next.next;
        }

        while(head != null){
            System.out.println("节点: "+head.v);
            head = head.next;
        }
    }

    /**
     * 反转单向链表  只能遍历一遍链表
     * A-->B-->C--D--E  变成  E-->D-->C-->B-->A
     * @param totalNodeNum 链表长度
     */
    public static void m2(int totalNodeNum){
        Node head = init(totalNodeNum);
        Node cp = head;
        Node pp = cp.next;
        while(pp != null){
            Node temp = pp.next;
            pp.next = cp;
            cp = pp;
            pp = temp;
        }
        head.next = null;
        while(cp != null){
            System.out.println("节点: "+cp.v);
            cp = cp.next;
        }
    }

    /**
     * 判断链表是否相交
     * A-->B-->C-->D-->E
     * W-->H-->P-->J-->E
     * 空间换时间 O(A length)
     * @param head1 第一个链表
     * @param head2 第二个链表
     * @return  true=相交,false=不相交
     */
    public static boolean m3(Node head1,Node head2){
        Map<Node,Object> map1 = new HashMap<Node,Object>();

        while(head1 != null){
            map1.put(head1,Boolean.TRUE);
            head1 = head1.next;
        }

        boolean result = false;
        while(head2 != null){
            if(map1.containsKey(head2)){
                result = true;
                break;
            }
            head2 = head2.next;
        }

        String resultStr = result ? "相交" : "不相交";
        System.out.println("链表A和B "+resultStr);
        return result;
    }


    /**
     * 判断链表是否相交-->线性时间
     * A-->B-->C-->D-->E
     * W-->H-->P-->J-->E
     * 相交
     * @param head1 第一个链表
     * @param head2 第二个链表
     * @return  true=相交,false=不相交
     */
    public static boolean m4(Node head1,Node head2){
        Node aLast = head1;
        Node bLast = head2;
        while(head1.next != null){
            aLast = head1.next;
            head1 = head1.next;
        }
        while(head2.next != null){
            bLast = head2.next;
            head2 = head2.next;
        }
        String result = aLast == bLast ? "相交" : "不相交";
        System.out.println("链表A和B "+result);
        return aLast == bLast;
    }

    public static Node init(int num){
        int i=0;
        Node head = new Node();
        head.v = 1;
        Node copy = head;
        for(;i<num-1;i++){
            Node newNode = new Node();
            newNode.v = i+2;
            copy.next = newNode;
            copy = newNode;
        }
        return head;
    }

    /**
     * 构造2个相交的链表
     * @return
     */
    public static Node[] makeIntersectList(boolean intersect){
        Node head1 = init(10);
        Node head2 = init(20);
        Node[] result = new Node[2];
        result[0] = head1;
        result[1] = head2;
        if(intersect){
            Node aLast = head1;
            Node bLast = head2;
            while(head1.next != null){
                aLast = head1.next;
                head1 = head1.next;
            }
            while(head2.next != null){
                bLast = head2.next;
                head2 = head2.next;
            }
            head1.next = head2;
        }
        return result;
    }


    static class Node{
        int v;
        Node next;
    }

    public static void main(String[] args) {
        m1(10,2);
        m2(10);
        Node[] a = makeIntersectList(false);
        m3(a[0],a[1]);
        m4(a[0],a[1]);

    }
}
