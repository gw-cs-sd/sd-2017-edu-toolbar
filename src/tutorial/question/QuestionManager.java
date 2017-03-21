package tutorial.question;
import tutorial.Utils;
import tutorial.question.theme.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
    public List generateQuestion(String[] tags) {
    //	System.out.println("Questionmanager: in generateQuestion method");
        Array array = new Array();
        For  forobj = new For();
        IF ifobj = new IF();
        While whileobj = new While();
        Strings strings = new Strings();
        Numbers numobj=new Numbers();

        List<QA> list = new ArrayList<>();

        for (String tag : tags) {
        	//System.out.println("Questionmanager: "+tag);
        	if(tag.equalsIgnoreCase("array")){
               QA qa1 = array.generateQuestion();
               if (qa1 != null) {
            	//  System.out.println("Questionmanager: question added for tag "+tag);
                  list.add(qa1);
                  }
        	    }

        	
        	if(tag.equalsIgnoreCase("for")){
                QA qa2 = forobj.generateQuestion();
                if (qa2 != null) {
                 	//System.out.println("Questionmanager: question added for tag "+tag);
                   list.add(qa2);
                }
        	  }
        	
        	if(tag.equalsIgnoreCase("if")){
               QA qa3 = ifobj.generateQuestion();
               if (qa3 != null) {
              //	 System.out.println("Questionmanager: question added for tag "+tag);
                  list.add(qa3);
               }
        	   }
        	
        	if(tag.equalsIgnoreCase("string")){
               QA qa4 = strings.generateQuestion();
               if (qa4 != null) {
            	//  System.out.println("Questionmanager: question added for tag "+tag);
                  list.add(qa4);
               }
        	  }
        	if(tag.equalsIgnoreCase("while")){
                QA qa5 = whileobj.generateQuestion();
                if (qa5 != null) {
              	//  System.out.println("Questionmanager: question added for tag "+tag);
                   list.add(qa5);
                 }
        	}
        	if(tag.equalsIgnoreCase("math")){
                QA qa5 = numobj.generateQuestion1();
                if (qa5 != null) {
              	//  System.out.println("Questionmanager: question added for tag "+tag);
                   list.add(qa5);
                 }
        	}
        }

        if (list.isEmpty()) {
            return generateQuestion(new String[]{""});
        } else {
           //jnnunujnjnjunj
            return list;
        }
    }
}