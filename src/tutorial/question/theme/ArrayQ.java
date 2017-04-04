package tutorial.question.theme;
import java.util.Random;

public class ArrayQ extends Types {
    //List to contain sample values
    public int[][] sampleValues={{3,10,37,23,59},{10,24,243,234,423,23},{32,24,5,887,4,5,78},{78,86,85,57,85}};
    public int[] sample;
    public ArrayQ()
    {
        this.aggregateName="Array";
        this.individualName="Array Element";
        this.suffix="position";
        Random rnd=new Random();
        sample=sampleValues[rnd.nextInt(sampleValues.length)];
        this.length= sample.length;
        this.aggProperties=new String[]{"Length","First Element","Last Element","Middle Element"};
        this.indProperties=new String[]{"Double","Triple","Square"};
        this.aggType="int[]";
        this.indType="int";
    }
    public String sampleToString()
    {
        StringBuilder sampleString=new StringBuilder();
        sampleString.append("{ ");
        for(int i=0;i<sample.length;i++)
            sampleString.append(sample[i]+ " , ");
        sampleString.append("}");
        return sampleString.toString().replace(", }","}");
    }
    public String aggPropertyCode(String aggProperty,String variable) {
        if (aggProperty.equals("Length"))
            return variable+".length";
        if (aggProperty.equals("First Element"))
            return variable+"[0]";
        if (aggProperty.equals("Last Element"))
            return variable + "["+variable+".length-1]";
        if (aggProperty.equals("Middle Element"))
            return variable + "[("+variable+".length-1)/2]";
        return "";
    }
    public String indPropertyCode(String indProperty,String variable) {
        if (indProperty.equals("Double"))
            return "2 * " + variable;
        if (indProperty.equals("Triple"))
            return "3 * " + variable;
        if (indProperty.equals("Square"))
            return variable + " * " + variable;
        return "";
    }
    public String pickIndividual(String pos,String fromVar,String toVar,String space)
    {
        StringBuilder indText=new StringBuilder();
        indText.append(space+toVar+" = "+fromVar+"["+pos+"];\n");
        return indText.toString();
    }

}
