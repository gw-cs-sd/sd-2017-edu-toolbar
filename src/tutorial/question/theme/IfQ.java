package tutorial.question.theme;
import java.util.Random;

public class IfQ extends Question{

    public IfQ(Types operandType,String comparison,int compareTo)
    {
        questionStr="if";
        this.operandType=operandType;
        this.comparison=comparison;
        this.compareTo=compareTo;
    }
    public IfQ(String comparison,int compareTo)
    {
        questionStr="if";
        this.operandType=new NumberQ();
        this.comparison=comparison;
        this.compareTo=compareTo;
    }

    public String generateQuestion()
    {
        StringBuilder questionText=new StringBuilder();
        Random rnd=new Random();
        if(isAggregate)
        {
            rNum = rnd.nextInt(operandType.aggProperties.length);
            questionText.append("For the " + operandType.aggregateName + " " + operandType.sampleToString() + ", ");
            questionText.append("Check and print whether the "+ operandType.aggProperties[rNum]+" of the "+operandType.aggregateName);
        }
        else {
            rNum = rnd.nextInt(operandType.indProperties.length);
            questionText.append("If the "+ operandType.indProperties[rNum]+" of the "+operandType.individualName);
        }
        questionText.append(getComparisonString(comparison)+compareTo+".");
        return questionText.toString();
    }
    public String generateSolution() {
        StringBuilder solnText = new StringBuilder();
        if(isAggregate) {
            solnText.append("public class MainClass{\n");
            solnText.append("    public static void main(){\n");
            String variable1 = "var1";
            solnText.append("        " + operandType.aggType + " " + variable1 + " = " + operandType.sampleToString() + ";\n");
            String variable2 = "var2";
            solnText.append("        int " + variable2 + " = " + operandType.aggPropertyCode(operandType.aggProperties[rNum], variable1) + ";\n");
            solnText.append("        " + this.questionStr + "( " + variable2 + " " + comparison.replace("=", "==") + " " + compareTo + ")\n");
            solnText.append("            System.out.println(\"" + operandType.aggProperties[rNum] + " of the " + operandType.aggregateName + getComparisonString(comparison) + compareTo + "\");\n");
            solnText.append("    }\n");
            solnText.append("}\n");
        }
        return solnText.toString();
    }
    public String getComparisonString(String comparison)
    {
        if(comparison.equals("<"))
            return " is less than ";
        else if(comparison.equals(">"))
            return " is more than ";
        else if(comparison.equals("="))
            return " is equal to ";
        return "";
    }
}