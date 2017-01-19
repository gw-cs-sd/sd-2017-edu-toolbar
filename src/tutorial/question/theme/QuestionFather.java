package tutorial.question.theme;

import tutorial.Utils;
import tutorial.question.QA;

import java.util.ArrayList;
import java.util.List;

public abstract class QuestionFather {
    public QA getRandomQuestonForTag(String tag) {
        tag = tag.toLowerCase();
        System.out.println("Questionfather:getRand: tag:"+tag);
        List<QA> list = new ArrayList<QA>();

        for (String tags : getTagsForQuestion1()) {
            if (tags.toLowerCase().contains(tag)) {
                list.add(generateQuestion1());
            }
        }

        for (String tags : getTagsForQuestion2()) {
            if (tags.toLowerCase().contains(tag)) {
                list.add(generateQuestion2());
            }
        }

        for (String tags : getTagsForQuestion3()) {
            if (tags.toLowerCase().contains(tag)) {
                list.add(generateQuestion3());
            }
        }

        for (String tags : getTagsForQuestion4()) {
            if (tags.toLowerCase().contains(tag)) {
                list.add(generateQuestion4());
            }
        }

        for (String tags : getTagsForQuestion5()) {
            if (tags.toLowerCase().contains(tag)) {
                list.add(generateQuestion5());
            }
        }

        if (list.isEmpty()) {
            return null;
        } else {
            int index = Utils.generateRandom(0, list.size() - 1);
            return list.get(index);
        }
    }

    public abstract String[] getTagsForQuestion1();

    public abstract String[] getTagsForQuestion2();

    public abstract String[] getTagsForQuestion3();

    public abstract String[] getTagsForQuestion4();

    public abstract String[] getTagsForQuestion5();

    public abstract QA generateQuestion1();

    public abstract QA generateQuestion2();

    public abstract QA generateQuestion3();

    public abstract QA generateQuestion4();

    public abstract QA generateQuestion5();
}
