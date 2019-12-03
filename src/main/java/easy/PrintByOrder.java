package easy;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName PrintByOrder
 * @Description  按序打印    简单
 * @Date 2019/12/3
 * @Created by lizhanxu
 */
public class PrintByOrder {
    private CountDownLatch count1 = new CountDownLatch(1);
    private CountDownLatch count2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        count1.await();
        printSecond.run();
        count2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        count2.await();
        printThird.run();
    }

    public static void main(String[] args) {
        PrintByOrder printByOrder = new PrintByOrder();
        Foo foo = new Foo();
        int[] order = new int[]{2, 1, 3};
        for (int i = 0; i < order.length; i++) {
            switch (order[i]) {
                case 1:
                    new Thread(() -> {
                        try {
                            printByOrder.first(() -> foo.one());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    break;
                case 2:
                    new Thread(() -> {
                        try {
                            printByOrder.second(() -> foo.two());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    break;
                case 3:
                    new Thread(() -> {
                        try {
                            printByOrder.third(() -> foo.three());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    break;
                default:
                    System.out.println("error");
            }
        }
    }

    public static class Foo {
        public void one() {
            print("one");
        }

        public void two() {
            print("two");
        }

        public void three() {
            print("three");
        }

        public void print(String s) {
            System.out.print(s);
        }
    }
}
