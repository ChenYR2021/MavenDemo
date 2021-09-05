package interview;

public class MeaningOfThis {
    public final int value = 4;
    public void doIt() {
        int value = 6;

        // this表示new出来的Runnable对象实例
        Runnable runnable = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        runnable.run();
    }

    public static void main(String[] args) {
        MeaningOfThis meaning = new MeaningOfThis();
        meaning.doIt();
    }
}
