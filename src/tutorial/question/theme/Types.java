package tutorial.question.theme;
import java.util.Random;

public class Types {
    //Name of the operand when it is aggregated
    protected String aggregateName;
    protected String aggType;
    protected String indType;
    //Name of the operand when it is singled
    protected String individualName;
    protected String suffix;
    protected int length;
    protected int rNum;


    protected String[] aggProperties;
    protected String[] indProperties;

    public String sampleToString() {
        return "";
    }

    public String generateQuestion() {
        Random rnd = new Random();
        StringBuilder questionText = new StringBuilder();
        rNum = rnd.nextInt(aggProperties.length);
        questionText.append("For the " + aggregateName + " " + sampleToString() + ", ");
        questionText.append("Print the " + aggProperties[rNum] + " of the " + aggregateName);
        return questionText.toString();
    }

    public String generateSolution() {
        StringBuilder solnText = new StringBuilder();
        solnText.append("public class MainClass{\n");
        solnText.append("    public static void main(){\n");
        String variable1 = "var1";
        solnText.append("        " + aggType + " " + variable1 + " = " + sampleToString() + ";\n");
        String variable2 = "var2";
        solnText.append("        int " + variable2 + " = " + aggPropertyCode(aggProperties[rNum], variable1) + ";\n");
        solnText.append("        System.out.println(\"" + aggProperties[rNum] + " of the " + this.aggregateName + ": \" + " + variable2 + ");\n");
        solnText.append("    }\n");
        solnText.append("}\n");
        return solnText.toString();
    }

    public String aggPropertyCode(String aggProperty, String variable) {
        return "";
    }

    public String pickIndividual(String pos, String fromVar, String toVar, String space) {
        return "";
    }

    public String indPropertyCode(String aggProperty, String variable) {
        return "";
    }

}
