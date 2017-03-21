package tutorial.question.theme;

import tutorial.question.QA;

import static tutorial.Utils.generateRandom;

import java.util.Random;
import tutorial.Utils;

public class IF extends QuestionFather {

    static String[] voc = {"alligator", "ant", "bear", "bee", "bird", "camel", "cat",
            "cheetah", "chicken", "chimpanzee", "cow", "crocodile", "deer", "dog", "dolphin",
            "duck", "eagle", "elephant", "fish", "frog", "giraffe",
            "goldfish", "hamster", "hippopotamus", "kangaroo", "lion", "monkey", "panda"};
    /*        kitten lio  lobster monkey  octopus  owl panda pig puppy    rabbit}*/
    
    String [] ifarray = new String [] {
			
			
		     "Write a code to display true if var1 is greater than var2 ?",
		     "Write a code to display true if person is a var1  ",
		     "Write a code to display true if a person age is > var1",
		     "Write a code to display true if a day is var1",
		     "Write a code to display true if a given number is var1"
		       
	    };
    String [] anscodeifarray = new String[] {
        "if(var1<var2){...}",
        "if(person==\"var1\"){...}",
        "if(age>var1){...}",
        "if(day=='var1'){...}",
        "if(number%2==var1){...}"
    };

    private String generateSolution1(int n, String str) {
        String sol;
        sol = "String str =\"" + str + "\";\n" +
                "String front = str.substring(0," + n + ");\n" +
                "String back = str.substring(" + n + "+1,str.length());\n" +
                "String ans=front+back;\n" +
                "return ans;";

        return sol;
    }

    @Override
    public String[] getTagsForQuestion1() {

        return new String[]{"for"};
    }

    @Override
    public String[] getTagsForQuestion2() {
    	 return new String[]{"for"};
    }

    @Override
    public String[] getTagsForQuestion3() {
    	 return new String[]{"for"};
    }

    @Override
    public String[] getTagsForQuestion4() {
    	 return new String[]{"for"};
    }

    @Override
    public String[] getTagsForQuestion5() {
    	 return new String[]{"for"};
    }

    
    //
    public QA generateQuestion() {
    	 Random rand = new Random();
    	 int i1 = rand.nextInt(5);
    	 String quest  = ifarray[i1];
    	 String ans = anscodeifarray[i1];
     	
     	System.out.println(i1+" : numb");
     	String quests = "";
     	if(i1==0)
     	{
     	
     		int i = rand.nextInt(28);
         	String var1 = voc[i];
         	String var2 = voc[rand.nextInt(28)];
     		quests =quest.replace("var1", var1).replace("var2", var2);
         	ans = anscodeifarray[0].replace("var1", var1).replace("var2", var2);
         	
     	}
     	else if(i1==1)
     	{
     	String genders[] = {"male","female"};	
     	String gender = genders[rand.nextInt(2)];
 		quests =quest.replace("var1", gender);
 		ans = anscodeifarray[1].replace("var1", gender);
        
     	}
     	else if(i1==2)
     	{
     		int num1 = rand.nextInt(60)+5;
     		quests =quest.replace("var1", num1+"");
         	ans= anscodeifarray[2].replace("var1", num1+"");
         	
     	}
     	else if(i1==3)
     	{
     	String days[] = {"MONDAY","TUESDAY","THURSDAY","WEDNESDAY","FRIDAY","SATURDAY","SUNDAY"};	
     	String day = days[rand.nextInt(7)];
 		quests =quest.replace("var1", day);
 		ans = anscodeifarray[3].replace("var1", day);
     	
     	}
     	else if(i1==4)
     	{
     		String numbers[] = {"even","odd"};	
     		int t = rand.nextInt(2);
         	String number = numbers[t];
     		quests =quest.replace("var1", number);
     		
     		ans= anscodeifarray[4].replace("var1", t+"");
         	
     	}
     	
    	 return new QA(quests, ans," ",Utils.getCurrentDatePart());
    	
    }
    
//    
    
    
    
    @Override
    public QA generateQuestion1() {

        int i = generateRandom(0, voc.length - 1);
        int n = generateRandom(0, voc[i].length() - 1);
        String quest = "Return a new string where the char at index n='" + String.valueOf(n) + "' has been removed from string \"" + voc[i] + "\".";

        String str = new String(voc[i]);
        String front = str.substring(0, n);
        String back = str.substring(n + 1, str.length());

        String ans = front + back;
        String sol = generateSolution1(n, voc[i]);
        return new QA(quest, ans, sol,Utils.getCurrentDatePart());
    }

    private String generateSolution2(String str) {
        String sol;
        sol = "String str =\"" + str + "\";\n" +
                "if (str.length() <= 1) return str;\n" +
                "String mid = str.substring(1, str.length()-1);\n" +
                "String ans = str.charAt(str.length()-1) + mid + str.charAt(0);\n" +
                "return ans;";

        return sol;
    }

    @Override
    public QA generateQuestion2() {

        int i = generateRandom(0, voc.length - 1);
        String quest = "Given a string=\"" + voc[i] + "\", return a new string where the first and last chars have been exchanged.";

        String sol = generateSolution2(voc[i]);

        String str = new String(voc[i]);
        if (str.length() <= 1) return new QA(quest, str, sol,Utils.getCurrentDatePart());

        String mid = str.substring(1, str.length() - 1);
        // last + mid + first
        String ans = str.charAt(str.length() - 1) + mid + str.charAt(0);

        return new QA(quest, ans, sol,Utils.getCurrentDatePart());
    }

    private String generateSolution3(int n) {
        String sol;
        sol = "int n=" + n + ";\n" +
                "Boolean ans=(n % 3 == 0) || (n % 5 == 0);\n" +
                "return String.valueOf(ans);";
        return sol;
    }

    @Override
    public QA generateQuestion3() {

        int n = generateRandom(0, 250);
        String quest = "Return true if the given non-negative number='" + String.valueOf(n) + "' is a multiple of 3 or a multiple of 5. Use the % \"mod\" operator.";
        String ans = String.valueOf((n % 3 == 0) || (n % 5 == 0));
        String sol = generateSolution3(n);

        return new QA(quest, ans, sol,Utils.getCurrentDatePart());
    }

    private String generateSolution4(String str) {
        String sol;
        sol = "String str =\"" + str + "\";\n" +
                "int take = 2;\n" +
                "if (take > str.length())\n" +
                "\ttake = str.length();\n" +
                "String front = str.substring(0, take);\n" +
                "String ans = front + str + front;\n" +
                "return ans;";
        return sol;
    }

    @Override
    public QA generateQuestion4() {

        int i = generateRandom(0, voc.length - 1);
        String quest = "Given a string=\"" + voc[i] + "\", take the first 2 chars and return the string with the 2 chars added at both the front and back." +
                " If the string length is less than 2, use whatever chars are there.";

        String str = new String(voc[i]);

        int take = 2;
        if (take > str.length()) {
            take = str.length();
        }
        String front = str.substring(0, take);
        String ans = front + str + front;
        String sol = generateSolution4(voc[i]);

        return new QA(quest, ans, sol,Utils.getCurrentDatePart());
    }

    private String generateSolution5(int n, int m) {
        String sol;
        sol = "int n=" + n + ";\n" +
                "int m=" + m + ";\n" +
                "Boolean ans = ((n >= 10) && (n <= 20)) || ((m >= 10) && (m <= 20));\n" +
                "return String.valueOf(ans);";
        return sol;
    }

    @Override
    public QA generateQuestion5() {

        int n1 = generateRandom(0, 100);
        int n2 = generateRandom(0, 100);
        String quest = "Given 2 int values n='" + String.valueOf(n1) + "' and m='" + String.valueOf(n2) + "', " +
                "return true if either of them is in the range 10..20 inclusive.";

        String ans = String.valueOf((n1 >= 10 && n1 <= 20) || (n2 >= 10 && n2 <= 20));
        String sol = generateSolution5(n1, n2);

        return new QA(quest, ans, sol,Utils.getCurrentDatePart());
    }
}