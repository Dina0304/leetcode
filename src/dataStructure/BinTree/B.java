package dataStructure.BinTree;

/**
 * Created by dina on 17/10/31.
 */
public class B {
    int data;
    public B() {
        this(10);
    }
    public B(int data) {
        this.data = data;
    }
    void display() {
        System.out.println("data = "+data);
    }

    class A{
        public void decrement(double data) {
            data = data-1.0;
        }
    }

    public static void main(String[] args) throws Exception {
//        int data = 0;
//        B b =  new B(data);
//        B.A d = b.new A();
//        d.decrement(data);
//        b.display();

        int x=0, y=4, z=5;
        if (x>0)
            if (y<3)
                System.out.println("One");
            else if (y<4)
                System.out.println("Two");
            else if (z>5)
                System.out.println("Three");
        else
            System.out.println("Four");

        long a = 1000000000;
        System.out.println(a);

    }
}
