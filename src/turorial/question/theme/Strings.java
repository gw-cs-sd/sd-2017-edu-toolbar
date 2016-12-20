package turorial.question.theme;

import turorial.question.QA;

import static turorial.Utils.generateRandom;

public class Strings extends QuestionFather {
    static String[] voc = {"alligator", "ant", "bear", "bee", "bird", "camel", "cat",
            "cheetah", "chicken", "chimpanzee", "cow", "crocodile", "deer", "dog", "dolphin",
            "duck", "eagle", "elephant", "fish", "frog", "giraffe",
            "goldfish", "hamster", "hippopotamus", "kangaroo", "lion", "monkey", "panda"};
    /*        kitten lio  lobster monkey  octopus  owl panda pig puppy    rabbit}*/


    private String generateSolution1(int n, String b) {
        String sol;
        sol = "int n=" + n + ";\n" +
                "String str=\""+ b +"\";\n" +
                "int start = str.length() - n;\n" +
                "String back = str.substring(start);\n" +
                "str = back;\n" +
                "for (int j = 0; j < n - 1; j++) {\n" +
                "\tstr = str + back;\n" +
                "}\n" +
                "return str;";
        return sol;
    }

    @Override
    public String[] getTagsForQuestion1() {
        return new String[]{"String", "substring", "length", "char", "for", "if", "int","str1"};
    }

    @Override
    public String[] getTagsForQuestion2() {
        return new String[]{"String", "substring", "length", "char", "charAt", "for", "if", "int","str2"};
    }

    @Override
    public String[] getTagsForQuestion3() {
        return new String[]{"String", "length", "char", "charAt", "for", "int","str3"};
    }

    @Override
    public String[] getTagsForQuestion4() {
        return new String[]{"String", "indexOf", "for", "int","str4"};
    }

    @Override
    public String[] getTagsForQuestion5() {
        return new String[]{"String", "substring", "length", "char", "for", "int","str5"};
    }

    @Override
    public QA generateQuestion1() {
        int i = generateRandom(0, voc.length - 1);
        int n = generateRandom(0, voc[i].length() - 1);
        String quest = "Given a string \"" + voc[i] + "\" and an int n'" + String.valueOf(n) + "', return a string made of n repetitions of the last n characters of the string. " +
                "You may assume that n is between 0 and the length of the string, inclusive.";
        String str = new String(voc[i]);
        int start = str.length() - n;
        String back = str.substring(start);
        str = back;
        for (int j = 0; j < n - 1; j++) {
            str = str + back;
        }
        String sol = generateSolution1(n, voc[i]);
        return new QA(quest, str, sol);
    }

    private String generateSolution2(String str1, String str2) {
        String sol;
        sol = "String a=\"" + str1 + "\";\n" +
                "String b=\"" + str2 + "\";\n" +
                "String ans = \"\";\n" +
                "int k;\n" +
                "for (k = 0; k < a.length() && k < b.length(); k++) {\n" +
                "\tans = ans + a.charAt(k);\n" +
                "\tans = ans + b.charAt(k);\n" +
                "}\n" +
                "if (a.length() < b.length()) {\n" +
                "\tans = ans + b.substring(k);\n" +
                "} else ans = ans + a.substring(k);\n" +
                "return ans;";
        return sol;
    }


    @Override
    public QA generateQuestion2() {
        int i = generateRandom(0, voc.length - 1);
        int j = generateRandom(0, voc.length - 1);
        String quest = "Given two strings, a=\"" + voc[i] + "\" and b=\"" + voc[j] + "\", create a bigger string made of the first char of a, the first char of b, " +
                "the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.";
        String a = new String(voc[i]);
        String b = new String(voc[j]);

        String ans = "";
        int k;
        for (k = 0; k < a.length() && k < b.length(); k++) {
            ans = ans + a.charAt(k);
            ans = ans + b.charAt(k);

        }
        if (a.length() < b.length()) {
            ans = ans + b.substring(k);
        } else ans = ans + a.substring(k);

        String sol = generateSolution2(voc[i], voc[j]);

        return new QA(quest, ans, sol);
    }

    private String generateSolution3(String str) {
        String sol;
        sol = "String str=\"" + str + "\";\n" +
                "String ans = \"\";\n" +
                "for (int k = 0; k < str.length(); k++) {\n" +
                "\tans = ans + str.charAt(k) + str.charAt(k);\n" +
                "}\n" +
                "return ans;";
        return sol;
    }


    @Override
    public QA generateQuestion3() {
        int i = generateRandom(0, voc.length - 1);
        String quest = "Given a string \"" + voc[i] + "\", return a string where for every char in the original, there are two chars.";
        String str = new String(voc[i]);
        String ans = "";
        for (int k = 0; k < str.length(); k++) {
            ans = ans + str.charAt(k) + str.charAt(k);
        }
        String sol = generateSolution3(voc[i]);
        return new QA(quest, ans, sol);
    }

    private String generateSolution4(String str) {
        String sol;
        sol = "String str=\"" + str + "\";\n" +
                "int count = 0;\n" +
                "for (int k = -1; (k = str.indexOf(\"hi\", k + 1)) != -1; ) {\n" +
                "\tcount++;\n" +
                "}\n" +
                "return String.valueOf(count);";
        return sol;
    }

    @Override
    public QA generateQuestion4() {
        String[] voc2 = {"abc hi ho", "ABChi hi", "hihi", "hi and ho", "hhhho", "hi is no ha on ahi", "hiho not hohihi",
                "cheetah", "chicken", "chimpanzee", "crocodile", "dolphin"};
        int i = generateRandom(0, voc2.length - 1);
        String quest = "Return the number of times that the string \"hi\" appears anywhere in the given string \"" + voc2[i] + "\".";
        int count = 0;
        String str = new String(voc2[i]);
        for (int k = -1; (k = str.indexOf("hi", k + 1)) != -1; ) {
            count++;
        }

        String sol = generateSolution4(voc2[i]);
        return new QA(quest, String.valueOf(count), sol);

    }

    private String generateSolution5(int n, String b) {
        String sol;
        sol = "String str=\"" + b + "\";\n" +
                "int n=" + n + ";\n" +
                "String ans = str.substring(0,n);\n" +
                "for (int j = 1; j < n; j++) {\n" +
                "\tans = ans + str.substring(0, n - j);\n" +
                "}\n" +
                "return ans;";
        return sol;
    }

    @Override
    public QA generateQuestion5() {
        int i = generateRandom(0, voc.length - 1);
        int n = generateRandom(0, voc[i].length());
        String quest = "Given a string \"" + voc[i] + "\" and an int n'" + String.valueOf(n) + "', return a string made of the first n characters of the string, " +
                "followed by the first n-1 characters of the string, and so on. " +
                "You may assume that n is between 0 and the length of the string, inclusive";
        String str = new String(voc[i]);
        String ans = str.substring(0, n);
        for (int j = 1; j < n; j++) {
            ans = ans + str.substring(0, n - j);
        }

        String sol = generateSolution5(n, voc[i]);
        return new QA(quest, ans, sol);
    }
}
