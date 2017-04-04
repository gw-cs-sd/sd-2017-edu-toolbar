package tutorial.question.theme;
import java.util.Random;

public class NumberQ extends Types {
    int sample;
    public NumberQ()
    {
        this.aggregateName="Number";
        this.individualName="Digit";
        this.suffix="position";
        Random rnd=new Random();
        sample=1+rnd.nextInt(10000);
        this.length= Integer.toString( sample).length();
        this.aggProperties=new String[]{"Double","Triple","Square"};
        this.indProperties=new String[]{"Square","Double","Half"};
        this.aggType="int";
        this.indType="int";
    }
    public String sampleToString()
    {
        return Integer.toString(sample);
    }
    public String aggPropertyCode(String aggProperty,String variable) {
        if (aggProperty.equals("Double"))
            return "2 * " + variable;
        if (aggProperty.equals("Triple"))
            return "3 * " + variable;
        if (aggProperty.equals("Square"))
            return variable + " * " + variable;
        return "";
    }
    public String indPropertyCode(String indProperty,String variable) {
        if (indProperty.equals("Square"))
            return variable +" * " + variable;
        if (indProperty.equals("Double"))
            return "2 * " + variable;
        if (indProperty.equals("Half"))
            return variable + " / " + 2;
        return "";
    }
    public String pickIndividual(String pos,String fromVar,String toVar,String space)
    {
        StringBuilder indText=new StringBuilder();
        indText.append(space+toVar+" = Character.getNumericValue(Integer.toString("+fromVar+").charAt("+pos+"));\n");
        return indText.toString();
    }
}
