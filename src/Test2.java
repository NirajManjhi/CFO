
public class Test2 extends Test{

    @Override
    public void myMethod() {
        System.out.println("class test2");
    }

    @Override
    public void someMethod(){
        System.out.println("some method in class test2");
    }

    public static void main(String[] args) {
        Test t = new Test2();
        t.myMethod();
    }
}