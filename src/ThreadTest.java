public class ThreadTest {
public static void main(String[] args) {
	
try {
new ThreadTest().go();
} catch (Exception e ) {
System.out.println("thrown to main");
}
}
synchronized void go() throws InterruptedException {
Thread t1 = new Thread();
t1.start();
System.out.print("1 ");
t1.wait(5000);
System.out.print("2 ");
}
}




