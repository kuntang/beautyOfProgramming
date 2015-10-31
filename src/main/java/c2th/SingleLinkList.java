package c2th;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangkun.tk on 2015/10/31.
 * ���������
 */
public class SingleLinkList {

    /**
     * ��������,ʵ�� A->B->C->D ɾ��C�ڵ�
     * ��ǰָ��ָ��C.
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
                throw new RuntimeException("Ҫɾ���Ľڵ�����������һ���ڵ�");
            }
            // �ú�һ���ڵ�������滻����ǰ�ڵ�����,���� ��ǰ�ڵ�(��ɾ���ڵ�) ָ�� ���ڵ�
            // ��è��̫��,���ʾ���
            currentP.v = currentP.next.v;
            currentP.next = currentP.next.next;
        }

        while(head != null){
            System.out.println("�ڵ�: "+head.v);
            head = head.next;
        }
    }

    /**
     * ��ת��������  ֻ�ܱ���һ������
     * A-->B-->C--D--E  ���  E-->D-->C-->B-->A
     * @param totalNodeNum ������
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
            System.out.println("�ڵ�: "+cp.v);
            cp = cp.next;
        }
    }

    /**
     * �ж������Ƿ��ཻ
     * A-->B-->C-->D-->E
     * W-->H-->P-->J-->E
     * �ռ任ʱ�� O(A length)
     * @param head1 ��һ������
     * @param head2 �ڶ�������
     * @return  true=�ཻ,false=���ཻ
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

        String resultStr = result ? "�ཻ" : "���ཻ";
        System.out.println("����A��B "+resultStr);
        return result;
    }


    /**
     * �ж������Ƿ��ཻ-->����ʱ��
     * A-->B-->C-->D-->E
     * W-->H-->P-->J-->E
     * �ཻ
     * @param head1 ��һ������
     * @param head2 �ڶ�������
     * @return  true=�ཻ,false=���ཻ
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
        String result = aLast == bLast ? "�ཻ" : "���ཻ";
        System.out.println("����A��B "+result);
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
     * ����2���ཻ������
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
