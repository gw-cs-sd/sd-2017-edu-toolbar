package turorial.question.theme;

import turorial.question.QA;

import static turorial.Utils.generateRandom;

public class Numbers extends QuestionFather {

    static String[] voc = {"alligator", "ant", "bear", "bee", "bird", "camel", "cat",
            "cheetah", "chicken", "chimpanzee", "cow", "crocodile", "deer", "dog", "dolphin",
            "duck", "eagle", "elephant", "fish", "frog", "giraffe",
            "goldfish", "hamster", "hippopotamus", "kangaroo", "lion", "monkey", "panda"};
    /*        kitten lio  lobster monkey  octopus  owl panda pig puppy    rabbit}*/


    private String generateSolution1(int a, int b) {
        String sol;
        sol = "int a=" + a + ";\n" +
                "int b=" + b + ";\n" +
                "int c=a*b;\n" +
                "return String.valueOf(c);";
        return sol;
    }

    @Override
    public String[] getTagsForQuestion1() {
        return new String[]{"multiply", "int","num1"};
    }

    @Override
    public String[] getTagsForQuestion2() {
        return new String[]{"int", "power", "double", "pow","num2"};
    }

    @Override
    public String[] getTagsForQuestion3() {
        return new String[]{"int", "if", "for", "mod", "maximum", "divider","num3"};
    }

    @Override
    public String[] getTagsForQuestion4() {
        return new String[]{"int", "mod", "divider","num4"};
    }

    @Override
    public String[] getTagsForQuestion5() {
        return new String[]{"int", "sum","num5"};
    }

    @Override
    public QA generateQuestion1() {

        int a = generateRandom(1, 9);
        int b = generateRandom(1, 11);
        String quest = "Multiply two int: '" + String.valueOf(a) + "' and '" + String.valueOf(b) + "'.";
        int c = a * b;
        String sol = generateSolution1(a, b);
        return new QA(quest, String.valueOf(c), sol);
    }
//returns the value of the first argument raised to the power of the second argument.

    private String generateSolution2(int a, int b) {
        String sol;
        sol = "double c=Math.pow(" + a + "," + b + ");\n" +
                "return String.valueOf(c);";
        return sol;
    }

    @Override
    public QA generateQuestion2() {

        int a = generateRandom(1, 15);
        int b = generateRandom(1, 4);

        String quest = "Return the value of the first int: '" + String.valueOf(a) + "' raised to the power of the second '" + String.valueOf(b) + "'.";

        double c = Math.pow(a, b);
        String sol = generateSolution2(a, b);
        return new QA(quest, String.valueOf(c), sol);
    }

    private String generateSolution3(int a, int b) {
        String sol;
        sol = "int a=" + a + ";\n" +
                "int b=" + b + ";\n" +
                "int more = (a > b) ? a : b;\n" +
                "int less = (a <= b) ? a : b;\n" +
                "for (int i = less; i >= 1; i--) {\n" +
                "\tif (((more % i) == 0) && ((less % i) == 0)) {\n" +
                "\t\treturn String.valueOf(i);\n" +
                "\t}\n" +
                "}\n" +
                "return \"None\";";
        return sol;
    }

    @Override
    public QA generateQuestion3() {

        int a = generateRandom(20, 99);
        int b = generateRandom(40, 100);

        String quest = "Find maximum common divider of '" + String.valueOf(a) + "' and '" + String.valueOf(b) + "'.";

        String ans ="None";
        int more = (a > b) ? a : b;
        int less = (a <= b) ? a : b;
        for (int i = less; i >= 1; i--) {
            if (((more % i) == 0) && ((less % i) == 0)) {
                ans = String.valueOf(i);
                break;
            }
        }

        String sol = generateSolution3(a, b);
        return new QA(quest, ans, sol);
    }

    private String generateSolution4(int a, int b) {
        String sol;
        sol = "int c=" + a + "%" + b + ";\n" +
                "return String.valueOf(c);";
        return sol;
    }

    @Override
    public QA generateQuestion4() {

        int a = generateRandom(10, 100);
        int b = generateRandom(2, 5);

        String quest = "Find the remainder of division of '" + String.valueOf(a) + "' by '" + String.valueOf(b) + "'.";

        int c = a % b;
        String sol = generateSolution4(a, b);
        return new QA(quest, String.valueOf(c), sol);
    }


    private String generateSolution5(int a, int b, int c) {
        String sol;
        sol = "int sum=" + a + "+" + b + "+" + c + ";\n" +
                "return String.valueOf(sum);";
        return sol;
    }

    @Override
    public QA generateQuestion5() {

        int a = generateRandom(1, 25);
        int b = generateRandom(2, 15);
        int c = generateRandom(0, 10);
        String quest = "Find sum of numbers: " + String.valueOf(a) + "," + String.valueOf(b) + "," + String.valueOf(c) + ".";

        int summ = a + b + c;
        String sol = generateSolution5(a, b, c);
        return new QA(quest, String.valueOf(summ), sol);
    }
}
