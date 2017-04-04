package tutorial.question.theme;
import java.util.Random;

public class StringQ extends Types {
    //List to contain sample values
    public String[] sampleValues={"Hello Man!","How are you?","What is the day today?","Thanks for the invitation."};
    public String sample;
    public StringQ()
    {
        this.aggregateName="String";
        this.individualName="Character";
        this.suffix="position";
        Random rnd = new Random();
        sample=sampleValues[rnd.nextInt(sampleValues.length)];
        this.length=sample.length();
        this.aggProperties=new String[]{"Length","First index of 'a'","Last index of 'o'"};
        this.indProperties=new String[]{"ASCII Value"};
        this.aggType="String";
        this.indType="char";
    }
    public String sampleToString()
    {
        return "\""+sample.toString()+"\"";
    }
    public String aggPropertyCode(String aggProperty,String variable) {
        if (aggProperty.equals("Length"))
            return variable+".length()";
        if (aggProperty.equals("First index of 'a'"))
            return variable+".indexOf('a')";
        if (aggProperty.equals("Last index of 'o'"))
            return variable + ".lastIndexOf('o')";
        return "";
    }
    public String pickIndividual(String pos,String fromVar,String toVar,String space)
    {
        StringBuilder indText=new StringBuilder();
        indText.append(space+toVar+" = "+fromVar+".charAt("+pos+");\n");
        return indText.toString();
    }
}
