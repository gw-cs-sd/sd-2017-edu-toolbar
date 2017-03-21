package tutorial.question.theme;

import tutorial.Utils;
import tutorial.question.QA;

import static tutorial.Utils.generateRandom;

public class Recursive extends QuestionFather {
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    private String generateSolution1(int n) {
        String sol;

        sol = "return String.valueOf(fibonacci(" + n + "));\n" +
                "}\n" +
                "public static int fibonacci(int n) {\n" +
                "if (n <= 1) {\n" +
                "return n;\n" +
                "}\n" +
                "return fibonacci(n - 2) + fibonacci(n - 1);\n" +
                "\n" ;
        return sol;
    }

    @Override
    public String[] getTagsForQuestion1() {
        return new String[]{"recursive", "fibonacci", "sum", "if", "int","rec1"};
    }

    @Override
    public String[] getTagsForQuestion2() {
        return new String[]{"recursive", "sum", "if", "int","rec2"};
    }

    @Override
    public String[] getTagsForQuestion3() {
        return new String[]{"recursive", "factorial", "if", "int","rec3"};
    }

    @Override
    public String[] getTagsForQuestion4() {
        return new String[]{"recursive", "triangle", "sum", "if", "int","rec4"};
    }

    @Override
    public String[] getTagsForQuestion5() {
        return new String[]{"recursive", "digits", "sum", "if", "int","rec5"};
    }

    @Override
    public QA generateQuestion1() {

        int n = generateRandom(0, 10);
        String quest = "The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. " +
                "The first two values in the sequence are 0 and 1 (essentially 2 base cases). " +
                "Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. " +
                "Return the n=" + String.valueOf(n) + "th fibonacci number, with n=0 representing the start of the sequence.";

        int ans = fibonacci(n);
        String sol = generateSolution1(n);
        return new QA(quest, String.valueOf(ans), sol,Utils.getCurrentDatePart());
    }

    public int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return 2 + bunnyEars(bunnies - 1);
    }

    private String generateSolution2(int n) {
        String sol;

        sol = "return String.valueOf(bunnyEars(" + n + "));\n" +
                "}\n" +
                "public static int bunnyEars(int bunnies) {\n" +
                "if (bunnies == 0) {\n" +
                "return 0;\n" +
                "}\n" +
                "return 2 + bunnyEars(bunnies - 1);\n" +
                "\n";
        return sol;
    }


    @Override
    public QA generateQuestion2() {
        int n = generateRandom(0, 250);
        String quest = "We have a number of bunnies n='" + String.valueOf(n) + "' and each bunny has two big floppy ears. " +
                "We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).";

        int ans = bunnyEars(n);
        String sol = generateSolution2(n);
        return new QA(quest, String.valueOf(ans), sol,Utils.getCurrentDatePart());
    }

    public int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    private String generateSolution3(int n) {
        String sol;
        sol = "return String.valueOf(factorial(" + n + "));\n" +
                "}\n" +
                "public static int factorial(int n) {\n" +
                "if (n == 1) return 1;\n" +
                "return n * factorial(n - 1);\n" +
                "\n";
        return sol;
    }

    @Override
    public QA generateQuestion3() {
        int n = generateRandom(1, 15);
        String quest = "Return the factorial of n='" + String.valueOf(n) + "', which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).";

        int ans = factorial(n);
        String sol = generateSolution3(n);
        return new QA(quest, String.valueOf(ans), sol,Utils.getCurrentDatePart());
    }

    public int triangle(int rows) {
        if (rows == 0) {
            return 0;
        }

        return rows + triangle(rows - 1);
    }

    private String generateSolution4(int n) {
        String sol;
        sol = "return String.valueOf(triangle(" + n + "));\n" +
                "}\n"+
                "public static int triangle(int rows) {\n" +
                "if (rows == 0) {\n" +
                "\treturn 0;\n" +
                "}\n" +
                "return rows + triangle(rows - 1);\n" +
                "\n";
        return sol;
    }


    @Override
    public QA generateQuestion4() {
        int n = generateRandom(0, 8);
        String quest = "We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, " +
                "the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number " +
                "of blocks in such a triangle with the given n='" + String.valueOf(n) + "' number of rows.";

        int ans = triangle(n);
        String sol = generateSolution4(n);
        return new QA(quest, String.valueOf(ans), sol,Utils.getCurrentDatePart());
    }

    public int sumDigits(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + sumDigits(n / 10);
    }

    private String generateSolution5(int n) {
        String sol;
        sol = "return String.valueOf(sumDigits(" + n + "));\n" +
                "}\n" +
                "public static int sumDigits(int n) {\n" +
                "if (n == 0) {\n" +
                "\treturn 0;\n" +
                "}\n" +
                "return n % 10 + sumDigits(n / 10);\n" +
                "\n";
        return sol;
    }

    @Override
    public QA generateQuestion5() {
        int n = generateRandom(0, 1121);
        String quest = "Given a non-negative int n='" + String.valueOf(n) + "', return the sum of its digits recursively (no loops).";

        int ans = sumDigits(n);
        String sol = generateSolution5(n);
        return new QA(quest, String.valueOf(ans), sol,Utils.getCurrentDatePart());
    }
}
