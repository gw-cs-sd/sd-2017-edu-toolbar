package tutorial;

import tutorial.code.ConsoleOutputCapturer;
import tutorial.code.JavaCodeRunner;

public class MainForTest {
    public static void main(String... args) {
    	ConsoleOutputCapturer coc=new ConsoleOutputCapturer();
    	JavaCodeRunner javaCodeRunner=new JavaCodeRunner();
    	String program="public class MainClass{public static void main(){System.out.print(2);}}";
    	coc.start();
    	javaCodeRunner.runCode("public class MainClass\n{public static void main()\n{System.out.print(\"2\");}}");
    	String res=coc.stop();
        System.out.println("Res = " + res);        
        coc.start();
    	javaCodeRunner.runCode(program);
    	res=coc.stop();
    	System.out.println(res);
        int a=69;
        int b=46;
        int more = (a > b) ? a : b;
        int less = (a <= b) ? a : b;
        for (int i = less; i >= 1; i--) {
            if (((more % i) == 0) && ((less % i) == 0)) {
                System.out.print( String.valueOf(i));
                return;
            }
        }
    }

    public static String main() {
        int a=69;
        int b=46;
        int more = (a > b) ? a : b;
        int less = (a <= b) ? a : b;
        for (int i = less; i >= 1; i--) {
            if (((more % i) == 0) && ((less % i) == 0)) {
                return String.valueOf(i);
            }
        }
        return "";
    }

}
