package tutorial.question.theme;

import javafx.util.Pair;
import tutorial.Utils;
import tutorial.question.QA;

import java.util.ArrayList;
import java.util.List;

public abstract class QuestionFather {
    public QA getRandomQuestonForTag(String tag) {
        tag = tag.toLowerCase();
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

    public Pair<QA, Integer> getRandomQuestonForTagsArray(String[] tagsArray) {
        int question1Match = 0;
        for (String tags : getTagsForQuestion1()) {
            for (String tag : tagsArray) {
                if (tags.toLowerCase().contains(tag)) {
                    question1Match++;
                }
            }
        }

        Pair<QA, Integer> pair = new Pair<>(generateQuestion1(), question1Match);

        int question2Match = 0;
        for (String tags : getTagsForQuestion2()) {
            for (String tag : tagsArray) {
                if (tags.toLowerCase().contains(tag)) {
                    question2Match++;
                }
            }
        }

        if (question2Match > pair.getValue()) {
            pair = new Pair<>(generateQuestion2(), question2Match);
        }

        int question3Match = 0;
        for (String tags : getTagsForQuestion3()) {
            for (String tag : tagsArray) {
                if (tags.toLowerCase().contains(tag)) {
                    question3Match++;
                }
            }
        }

        if (question3Match > pair.getValue()) {
            pair = new Pair<>(generateQuestion3(), question3Match);
        }

        int question4Match = 0;
        for (String tags : getTagsForQuestion4()) {
            for (String tag : tagsArray) {
                if (tags.toLowerCase().contains(tag)) {
                    question4Match++;
                }
            }
        }

        if (question4Match > pair.getValue()) {
            pair = new Pair<>(generateQuestion4(), question4Match);
        }

        int question5Match = 0;
        for (String tags : getTagsForQuestion5()) {
            for (String tag : tagsArray) {
                if (tags.toLowerCase().contains(tag)) {
                    question5Match++;
                }
            }
        }

        if (question5Match > pair.getValue()) {
            pair = new Pair<>(generateQuestion5(), question5Match);
        }


        if (pair.getValue() == 0) {
            return null;
        } else {
            return pair;
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
