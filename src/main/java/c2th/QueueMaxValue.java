package c2th;

/**
 * Created by tangkun.tk on 2015/11/1.
 * ���е����ֵ,Ҫ��:
 * 1, enQueue(v),��v�������
 * 2, deQueue(v),��v����
 * 3, max(),ȡ���е����ֵ
 * �豣�� ���Ƚ��ȳ�������
 */
public class QueueMaxValue {

    private  StackA a = new StackA();   // ����ǰN��Ԫ�ص����ֵ,�ҵ������Ԫ��
    private  StackA b = new StackA();   // ����N��Ԫ��֮���M��ֵ,�ҵ��������ЩԪ��. ��¼�����ֵ��ϵ,2��stack��ʵ��queue����.

    public static int max(int x,int y){
        return x>y ? x : y;
    }

    public  int max(){
        return max(a.max(),b.max());
    }

    public  void enQueue(int x){
        b.push(x);
    }

    public  int deQueue(){
        if(a.stackTop == -1){   // û��Ԫ����
            while(b.stackTop != -1){
                a.push(b.pop());
            }
        }
        return a.pop();
    }

    static class StackA{
        int stackTop ;
        int maxL = 10;
        int[] stackItem = new int[maxL];
        int[] link2NextMaxItem = new int[maxL];
        int maxStackItemIndex = -1;

        public StackA(){
            stackTop = -1;
            maxStackItemIndex = -1;
            for(int i=0;i<maxL;i++){
                link2NextMaxItem[i] = -1;
            }
        }

        public void push(int x){
            stackTop++;
            if(stackTop > maxL){
                System.out.println("����ջ�ĳ���");
            }else {
                stackItem[stackTop] = x;
                if( x > max()){
                    link2NextMaxItem[stackTop] = maxStackItemIndex;
                    maxStackItemIndex = stackTop;
                }else{
                    link2NextMaxItem[stackTop] = -1;
                }
            }
        }

        public int pop(){
            int ret = 0;
            if(stackTop < 0){
                System.out.println("�Ѿ�û��Ԫ����,����pop");
            }else{
                ret = stackItem[stackTop];
                if(stackTop == maxStackItemIndex){
                    maxStackItemIndex = link2NextMaxItem[stackTop];
                }
                stackTop--;
            }
            return ret;
        }

        public int max(){
            if(maxStackItemIndex >= 0){
                return stackItem[maxStackItemIndex];
            }else{
                return -1;
            }

        }
    }


    public static void main(String[] args) {
        QueueMaxValue queueMaxValue = new QueueMaxValue();

        int a[] = {1,12,21,2,33,3,17,11,6,21};

        for(int v:a){
            queueMaxValue.enQueue(v);
        }

        System.out.println("���ֵ: "+queueMaxValue.max());
        for(int i=0;i<5;i++){
            System.out.println("����: "+queueMaxValue.deQueue());
            System.out.println("���ֵ: "+queueMaxValue.max());
        }

    }




}
