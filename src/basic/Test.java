package basic;

/**
 * Created by yuhp@terminus.io on 2017/7/21.
 * Desc:
 */
public class Test {

    public static void main(String[] args) {
        String a = 1+"";
        Number b = 0;
        System.out.println(compare(a, b));
    }

    private static <T>  int compare(T t1,T t2) {
        return t1.hashCode() - t2.hashCode();
    }

}
