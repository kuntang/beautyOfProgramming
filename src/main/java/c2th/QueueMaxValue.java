package c2th;

/**
 * Created by tangkun.tk on 2015/11/1.
 * 队列的最大值,要求:
 * 1, enQueue(v),将v加入队列
 * 2, deQueue(v),将v弹出
 * 3, max(),取队列的最大值
 * 需保持 【先进先出】特性
 */
public class QueueMaxValue {

    private  StackA a = new StackA();   // 保持前N个元素的最大值,且倒叙放置元素
    private  StackA b = new StackA();   // 保持N个元素之后的M个值,且倒叙放置这些元素. 记录了最大值关系,2个stack来实现queue操作.

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
        if(a.stackTop == -1){   // 没有元素了
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
                System.out.println("超出栈的长度");
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
                System.out.println("已经没有元素了,不能pop");
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

        System.out.println("最大值: "+queueMaxValue.max());
        for(int i=0;i<5;i++){
            System.out.println("弹出: "+queueMaxValue.deQueue());
            System.out.println("最大值: "+queueMaxValue.max());
        }

    }




}
