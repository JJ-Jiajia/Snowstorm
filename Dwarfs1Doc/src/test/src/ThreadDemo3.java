package src;

//饿汉式
class Single2 {
    private Single2() {
    }

    private static final Single2 s = null;

    public static Single2 getInstance() {
        return s;
    }
}

//懒汉式
class Single {
    private Single() {
    }

    private static Single s = null;

    public static Single getInstance() {
        if (null == s) {
            synchronized (Single.class) {
                if (null == s)
                    s = new Single();
            }
        }
        return s;
    }
}

public class ThreadDemo3 {
}
