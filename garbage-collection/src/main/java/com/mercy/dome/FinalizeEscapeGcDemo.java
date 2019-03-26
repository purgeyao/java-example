package com.mercy.dome;

/**
 * 1.对象可以在被GC时自我拯救
 * 2.这种自救的机会只有一次，因为一个对象的 finalize() 方法最多被系统自动调用一次
 *
 * @author Mercy yao
 * @version 1.0
 * @date 2019/3/26
 */
public class FinalizeEscapeGcDemo {

    public static FinalizeEscapeGcDemo SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize mehtod executed!");
        FinalizeEscapeGcDemo.SAVE_HOOK = this;
    }

    public static void main(String[] args) {
        SAVE_HOOK = new FinalizeEscapeGcDemo();

        // 对象第一次成功拯救自救
        SAVE_HOOK = null;
        System.gc();

        // 因为 finalize 方法优先级很低，所以暂停0.5秒等待它
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

        // 下面和上面代码完全相同，但是这次自救失败
        SAVE_HOOK = null;
        System.gc();

        // 因为 finalize 方法优先级很低，所以暂停0.5秒等待它
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

    }
}
