package tutorial.question.theme;
import java.util.Random;

public class ForQ extends Question{
    Question questionType=new Question();
    int start;
    int end;
    public ForQ()
    {
        questionStr="for";
        this.operandType=new NumberQ();
    }
    public ForQ(Types operandType)
    {
        questionStr="for";
        this.operandType=operandType;
    }
    public ForQ(Question questionType)
    {
        questionStr="for";
        this.questionType=questionType;
        this.operandType=questionType.operandType;
    }
    public void setStartEnd()
    {
        Random rnd=new Random();
        start=rnd.nextInt(operandType.length);
        end=start+rnd.nextInt(operandType.length-start);
    }
    public String generateQuestion()
    {
        setStartEnd();
        StringBuilder questionText=new StringBuilder();
        questionText.append("In the "+operandType.aggregateName+" "+operandType.sampleToString()+", ");
        questionText.append("For all "+operandType.individualName+"s between "+start);
        if(operandType.suffix!="")
            questionText.append(" "+operandType.suffix);
        questionText.append(" and "+end);
        if(operandType.suffix!="")
            questionText.append(" "+operandType.suffix);
        questionText.append(", Print the "+operandType.individualName+" ");
        if(questionType.questionStr=="if") {
            questionType.isAggregate=false;
            questionText.append(questionType.generateQuestion());
        }
        return questionText.toString();
    }
    public String generateSolution() {
        StringBuilder solnText = new StringBuilder();
        solnText.append("public class MainClass{\n");
        solnText.append("    public static void main(){\n");
        String variable1 = "var1";
        if(isAggregate) {
            solnText.append("        " + operandType.aggType + " " + variable1 + " = " + operandType.sampleToString() + ";\n");
            solnText.append("        "+this.questionStr+"(int i="+start+";i<="+end+";i++){\n");
            String variable2 = "var2";
            solnText.append("            " + operandType.indType + " " + variable2 + ";\n");
            solnText.append(operandType.pickIndividual("i",variable1,variable2,"            "));
            if(questionType.questionStr=="if") {
                String variable3 = "var3";
                solnText.append("            int " + variable3 + " = "+operandType.indPropertyCode(operandType.indProperties[questionType.rNum],variable2)+";\n");
                solnText.append("            if(" + variable3 + " " + questionType.comparison.replace("=", "==") + " " + questionType.compareTo + ")\n    ");
            }
            solnText.append("            System.out.println("+ variable2 + ");\n");
            solnText.append("        }\n");
        }
        solnText.append("    }\n");
        solnText.append("}\n");
        return solnText.toString();
    }

}