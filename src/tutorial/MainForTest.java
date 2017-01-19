package tutorial;

public class MainForTest {
    public static void main(String... args) {
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
