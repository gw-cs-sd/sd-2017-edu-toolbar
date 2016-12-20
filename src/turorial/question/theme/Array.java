package turorial.question.theme;

import turorial.question.QA;

import static turorial.Utils.generateRandom;

public class Array extends QuestionFather {

    private int[] generateIntArr(int n, int a, int b) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = generateRandom(a, b);
        }
        return arr;
    }

    private String arrtoStr(int [] arr){
        String str = "{";
        for (int i=0; i<arr.length-1;i++){
            str = str + arr[i] + ",";
        }
        str = str + arr[arr.length-1]+"}";
        return str;
    }

    @Override
    public String[] getTagsForQuestion1() {
        return new String[]{"array", "boolean", "int", "length", "arr1"};
    }

    private String generateSolution1(int [] arr) {
        String sol;
        String str = arrtoStr(arr);
        sol = "int[] arr="+str+";\n"+
                "Boolean ans = ((arr.length >= 1) && (arr[0] == arr[arr.length - 1]));\n" +
                "return String.valueOf(ans);\n";
        return sol;
    }


    @Override
    public QA generateQuestion1() {

        int n = generateRandom(1, 8);
        int b = generateRandom(3, 10);

        int[] arr = generateIntArr(n, 0, b);
        String sol = generateSolution1(arr);
        String quest = "Given an array of ints [";
        for (int k = 0; k < n - 1; k++) {
            quest = quest + arr[k] + ",";
        }
        if (n > 0) {
            quest = quest + arr[n - 1];
        }
        quest = quest + "], return true if the array is length 1 or more, and the first element and the last element are equal.";

        String ans = String.valueOf((arr.length >= 1) && (arr[0] == arr[arr.length - 1]));

        return new QA(quest, ans, sol);
    }

    @Override
    public String[] getTagsForQuestion2() {
        return new String[]{"array", "for", "int", "sum", "length","arr2"};
    }

    private String generateSolution2(int[] arr) {
        String sol;
        String str = arrtoStr(arr);
        sol = "int[] arr="+str+";\n"+
                "int sum = 0;\n" +
                "for (int k = 0; k < arr.length; k++) {\n" +
                "\tsum = sum + arr[k];\n" +
                "}\n" +
                "return String.valueOf(sum);\n";
        return sol;
    }

    @Override
    public QA generateQuestion2() {
        int n = generateRandom(3, 5);
        int[] arr = generateIntArr(n, 0, 10);

        String sol = generateSolution2(arr);
        String quest = "Given an array of ints [";
        int sum = 0;
        for (int k = 0; k < n - 1; k++) {
            quest = quest + arr[k] + ",";
            sum = sum + arr[k];
        }
        sum = sum + arr[n - 1];
        if (n > 0) {
            quest = quest + arr[n - 1];
        }
        quest = quest + "], return the sum of all the elementsl.";


        return new QA(quest, String.valueOf(sum), sol);
    }

    @Override
    public String[] getTagsForQuestion3() {
        return new String[]{"array", "length", "if", "for", "int", "reverse","arr3"};
    }

    private String generateSolution3(int[] arr) {
        String sol;
        String str = arrtoStr(arr);
        sol = "int[] arr="+str+";\n"+
                "int left = 0;\n" +
                "int right = arr.length - 1;\n" +
                "while (left < right) {\n" +
                "\tint temp = arr[left];\n" +
                "\tarr[left] = arr[right];\n" +
                "\tarr[right] = temp;\n" +
                "\tleft++;\n" +
                "\tright--;\n" +
                "}\n" +
                "//array to String\n" +
                "String ans = \"[\";\n" +
                "for (int j = 0; j < arr.length - 1; j++) {\n" +
                "\tans = ans + arr[j] + \",\";\n" +
                "}\n" +
                "if (arr.length > 0) {\n" +
                "\tans = ans + arr[arr.length - 1];\n" +
                "}\n" +
                "ans = ans + \"]\";\n"+
                "return ans;\n";
        return sol;
    }


    @Override
    public QA generateQuestion3() {
        int n = generateRandom(3, 5);
        int[] arr = generateIntArr(n, 0, 10);

        String sol = generateSolution3(arr);
        String quest = "Given an array of ints [";
        for (int k = 0; k < n - 1; k++) {
            quest = quest + arr[k] + ",";
        }
        if (n > 0) {
            quest = quest + arr[n - 1];
        }
        quest = quest + "], return a new array with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}.";

        int right, left;
        left = 0;
        right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        String ans = "[";
        for (int j = 0; j < arr.length - 1; j++) {
            ans = ans + arr[j] + ",";
        }
        if (arr.length > 0) {
            ans = ans + arr[arr.length - 1];
        }
        ans = ans + "]";

        return new QA(quest, ans, sol);
    }

    @Override
    public String[] getTagsForQuestion4() {
        return new String[]{"array", "length", "if", "for", "int","arr4"};
    }

    private String generateSolution4(int[] arr) {
        String sol;
        String str = arrtoStr(arr);
        sol = "int[] arr="+str+";\n"+
                "int first = arr[0];\n" +
                "for (int j = 0; j < arr.length - 1; j++) {\n" +
                "\tarr[j] = arr[j + 1];\n" +
                "}\n" +
                "arr[arr.length - 1] = first;\n" +
                "//array to String\n" +
                "String ans = \"[\";\n" +
                "for (int j = 0; j < arr.length - 1; j++) {\n" +
                "\tans = ans + arr[j] + \",\";\n" +
                "}\n" +
                "if (arr.length > 0) {\n" +
                "\tans = ans + arr[arr.length - 1];\n" +
                "}\n" +
                "ans = ans + \"]\";\n"+
                "return ans;\n";

        return sol;
    }

    @Override
    public QA generateQuestion4() {
        int n = generateRandom(3, 5);
        int[] arr = generateIntArr(n, 0, 10);

        String sol = generateSolution4(arr);
        String quest = "Given an array of ints [";
        for (int k = 0; k < n - 1; k++) {
            quest = quest + arr[k] + ",";
        }
        if (n > 0) {
            quest = quest + arr[n - 1];
        }
        quest = quest + "],  return an array with the elements \"rotated left\" so for ex.: {1, 2, 3} yields {2, 3, 1}.";

        //int[] temp = new int[arr.length];
        int first = arr[0];
        for (int j = 0; j < arr.length - 1; j++) {
            arr[j] = arr[j + 1];
        }
        arr[arr.length - 1] = first;

        String ans = "[";
        for (int j = 0; j < arr.length - 1; j++) {
            ans = ans + arr[j] + ",";
        }
        if (arr.length > 0) {
            ans = ans + arr[arr.length - 1];
        }
        ans = ans + "]";

        return new QA(quest, ans, sol);

    }

    @Override
    public String[] getTagsForQuestion5() {
        return new String[]{"array", "length", "if", "for", "int", "arr5"};
    }

    private String generateSolution5(int[] arr1, int[] arr2) {
        String sol;
        String str1 = arrtoStr(arr1);
        String str2 = arrtoStr(arr2);
        sol = "int[] arr1="+str1+";\n" +
                "int[] arr2="+str2+";\n"+
                "int newSize = arr1.length + arr2.length;\n" +
                "int[] arr = new int[newSize];\n" +
                "for (int j = 0; j < newSize; j++) {\n" +
                "\tif (j < arr1.length)\n" +
                "\t\tarr[j] = arr1[j];\n" +
                "\telse\n" +
                "\t\tarr[j] = arr2[j - arr1.length];\n" +
                "}\n" +
                "//array to String\n" +
                "String ans = \"[\";\n" +
                "for (int j = 0; j < arr.length - 1; j++) {\n" +
                "\tans = ans + arr[j] + \",\";\n" +
                "}\n" +
                "if (arr.length > 0) {\n" +
                "\tans = ans + arr[arr.length - 1];\n" +
                "}\n" +
                "ans = ans + \"]\";\n"+
                "return ans;\n";
        return sol;
    }

    @Override
    public QA generateQuestion5() {
        int n = generateRandom(2, 3);
        int[] arr1 = generateIntArr(n, 0, 10);
        int m = generateRandom(2, 4);
        int[] arr2 = generateIntArr(m, 0, 10);

        String sol = generateSolution5(arr1, arr2);

        String quest = "Given 2 int arrays, [";// each length 2, ";
        //arr1
        for (int k = 0; k < n - 1; k++) {
            quest = quest + arr1[k] + ",";
        }
        if (n > 0) {
            quest = quest + arr1[n - 1];
        }
        quest = quest + "] [";
        //arr2
        for (int k = 0; k < m - 1; k++) {
            quest = quest + arr2[k] + ",";
        }
        if (m > 0) {
            quest = quest + arr2[m - 1];
        }
        quest = quest + "], return a new array containing all their elements.";

//        int newN = n + m;
        int newN = arr1.length + arr2.length;
        int[] ans = new int[newN];
        for (int j = 0; j < newN; j++) {
            if (j < n)
                ans[j] = arr1[j];
            else
                ans[j] = arr2[j - arr1.length];
        }

        String str = "[";
        for (int j = 0; j < ans.length - 1; j++) {
            str = str + ans[j] + ",";
        }
        if (ans.length > 0) {
            str = str + ans[ans.length - 1];
        }
        str = str + "]";


        return new QA(quest, str, sol);
    }
}
