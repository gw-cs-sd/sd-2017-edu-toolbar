package turorial.question;

import turorial.Utils;
import turorial.question.theme.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
    public QA generateQuestion(String[] tags) {
        Array array = new Array();
        Beggining beggining = new Beggining();
        Numbers numbers = new Numbers();
        Recursive recursive = new Recursive();
        Strings strings = new Strings();

        List<QA> list = new ArrayList<>();

        for (String tag : tags) {
            QA qa1 = array.getRandomQuestonForTag(tag);
            if (qa1 != null) {
                list.add(qa1);
            }

            QA qa2 = beggining.getRandomQuestonForTag(tag);
            if (qa2 != null) {
                list.add(qa2);
            }

            QA qa3 = numbers.getRandomQuestonForTag(tag);
            if (qa3 != null) {
                list.add(qa3);
            }

            QA qa4 = recursive.getRandomQuestonForTag(tag);
            if (qa4 != null) {
                list.add(qa4);
            }

            QA qa5 = strings.getRandomQuestonForTag(tag);
            if (qa5 != null) {
                list.add(qa5);
            }
        }

        if (list.isEmpty()) {
            return generateQuestion(new String[]{""});
        } else {
            int index = Utils.generateRandom(0, list.size() - 1);
            return list.get(index);
        }
    }
}
