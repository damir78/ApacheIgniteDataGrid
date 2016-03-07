import java.lang.ref.WeakReference;

/**
 * Created by damir on 04.03.16.
 */
public class Request {
    private long a;
    private long b;

    private long[]c;

    private WeakReference <long[]> d;
    public Request(long a, long b) {
        this.a = a;
        this.b = b;
        c = new long[]{a,b};

        d = new WeakReference<>(c);


    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }

    public long getB() {
        return b;
    }

    public void setB(long b) {
        this.b = b;
    }

    public long[] getC() {
        //return c;
        return d.get();
    }



    public void setC(long[] c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Request{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
