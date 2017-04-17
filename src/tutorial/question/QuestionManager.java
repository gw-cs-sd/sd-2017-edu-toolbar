package tutorial.question;

import tutorial.Utils;
import tutorial.question.theme.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
    public List generateQuestion(String[] tags) {
    //	System.out.println("Questionmanager: in generateQuestion method");

        List<QA> list = new ArrayList<>();

        if(tags.length==1)
        {
            if(tags[0].equalsIgnoreCase("number"))
            {
                NumberQ numberQ = new NumberQ();
                list.add(new QA(numberQ.generateQuestion(),"",numberQ.generateSolution()));
            }
            if(tags[0].equalsIgnoreCase("array"))
            {
                ArrayQ arrayQ = new ArrayQ();
                list.add(new QA(arrayQ.generateQuestion(),"",arrayQ.generateSolution()));
            }
            if(tags[0].equalsIgnoreCase("string"))
            {
                StringQ stringQ = new StringQ();
                list.add(new QA(stringQ.generateQuestion(),"",stringQ.generateSolution()));
            }
            if(tags[0].equalsIgnoreCase("if"))
            {
                IfQ ifQ = new IfQ(">",10);
                list.add(new QA(ifQ.generateQuestion(),"",ifQ.generateSolution()));
            }
            if(tags[0].equalsIgnoreCase("for"))
            {
                ForQ forQ = new ForQ();
                list.add(new QA(forQ.generateQuestion(),"",forQ.generateSolution()));
            }
            if(tags[0].equalsIgnoreCase("while"))
            {
                WhileQ whileQ = new WhileQ();
                list.add(new QA(whileQ.generateQuestion(),"",whileQ.generateSolution()));
            }
        }
        else if(tags.length==2)
        {
            if((tags[0].equalsIgnoreCase("string")&&tags[1].equalsIgnoreCase("number"))||(tags[1].equalsIgnoreCase("string")&&tags[0].equalsIgnoreCase("number")))
            {
                StringQ stringQ = new StringQ();
                list.add(new QA(stringQ.generateQuestion(),"",stringQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("string")&&tags[1].equalsIgnoreCase("array"))||(tags[1].equalsIgnoreCase("string")&&tags[0].equalsIgnoreCase("array")))
            {
                StringQ stringQ = new StringQ();
                list.add(new QA(stringQ.generateQuestion(),"",stringQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("number")&&tags[1].equalsIgnoreCase("array"))||(tags[1].equalsIgnoreCase("number")&&tags[0].equalsIgnoreCase("array")))
            {
                NumberQ numberQ = new NumberQ();
                list.add(new QA(numberQ.generateQuestion(),"",numberQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("if")&&tags[1].equalsIgnoreCase("number"))||(tags[1].equalsIgnoreCase("if")&&tags[0].equalsIgnoreCase("number")))
            {
                NumberQ numberQ = new NumberQ();
                IfQ ifQ = new IfQ(numberQ, "<", 4);
                list.add(new QA(ifQ.generateQuestion(),"",ifQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("if")&&tags[1].equalsIgnoreCase("string"))||(tags[1].equalsIgnoreCase("if")&&tags[0].equalsIgnoreCase("string")))
            {
                StringQ stringQ = new StringQ();
                IfQ ifQ = new IfQ(stringQ, "=", 8);
                list.add(new QA(ifQ.generateQuestion(),"",ifQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("if")&&tags[1].equalsIgnoreCase("array"))||(tags[1].equalsIgnoreCase("if")&&tags[0].equalsIgnoreCase("array")))
            {
                ArrayQ arrayQ = new ArrayQ();
                IfQ ifQ = new IfQ(arrayQ, ">", 8);
                list.add(new QA(ifQ.generateQuestion(),"",ifQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("for")&&tags[1].equalsIgnoreCase("number"))||(tags[1].equalsIgnoreCase("for")&&tags[0].equalsIgnoreCase("number")))
            {
                NumberQ numberQ = new NumberQ();
                ForQ forQ = new ForQ(numberQ);
                list.add(new QA(forQ.generateQuestion(),"",forQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("for")&&tags[1].equalsIgnoreCase("string"))||(tags[1].equalsIgnoreCase("for")&&tags[0].equalsIgnoreCase("string")))
            {
                StringQ stringQ = new StringQ();
                ForQ forQ = new ForQ(stringQ);
                list.add(new QA(forQ.generateQuestion(),"",forQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("for")&&tags[1].equalsIgnoreCase("array"))||(tags[1].equalsIgnoreCase("for")&&tags[0].equalsIgnoreCase("array")))
            {
                ArrayQ arrayQ = new ArrayQ();
                ForQ forQ = new ForQ(arrayQ);
                list.add(new QA(forQ.generateQuestion(),"",forQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("for")&&tags[1].equalsIgnoreCase("if"))||(tags[1].equalsIgnoreCase("for")&&tags[0].equalsIgnoreCase("if")))
            {
                IfQ ifQ = new IfQ(">",6);
                ForQ forQ = new ForQ(ifQ);
                list.add(new QA(forQ.generateQuestion(),"",forQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("while")&&tags[1].equalsIgnoreCase("number"))||(tags[1].equalsIgnoreCase("while")&&tags[0].equalsIgnoreCase("number")))
            {
                NumberQ numberQ = new NumberQ();
                WhileQ whileQ = new WhileQ(numberQ);
                list.add(new QA(whileQ.generateQuestion(),"",whileQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("while")&&tags[1].equalsIgnoreCase("string"))||(tags[1].equalsIgnoreCase("while")&&tags[0].equalsIgnoreCase("string")))
            {
                StringQ stringQ = new StringQ();
                WhileQ whileQ = new WhileQ(stringQ);
                list.add(new QA(whileQ.generateQuestion(),"",whileQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("while")&&tags[1].equalsIgnoreCase("array"))||(tags[1].equalsIgnoreCase("while")&&tags[0].equalsIgnoreCase("array")))
            {
                ArrayQ arrayQ = new ArrayQ();
                WhileQ whileQ = new WhileQ(arrayQ);
                list.add(new QA(whileQ.generateQuestion(),"",whileQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("while")&&tags[1].equalsIgnoreCase("if"))||(tags[1].equalsIgnoreCase("while")&&tags[0].equalsIgnoreCase("if")))
            {
                IfQ ifQ = new IfQ(">",6);
                WhileQ whileQ = new WhileQ(ifQ);
                list.add(new QA(whileQ.generateQuestion(),"",whileQ.generateSolution()));
            }
            if((tags[0].equalsIgnoreCase("while")&&tags[1].equalsIgnoreCase("for"))||(tags[1].equalsIgnoreCase("while")&&tags[0].equalsIgnoreCase("for")))
            {
                WhileQ whileQ = new WhileQ();
                list.add(new QA(whileQ.generateQuestion(),"",whileQ.generateSolution()));
            }
        }

        if (list.isEmpty()) {
            return generateQuestion(new String[]{""});
        } else {
            int index = Utils.generateRandom(0, list.size() - 1);
            return list;
        }
    }
}