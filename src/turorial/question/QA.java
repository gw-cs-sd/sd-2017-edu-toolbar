package turorial.question;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QA {
    @JsonProperty
    private String question;
    @JsonProperty
    private String answer;
    @JsonProperty
    private String code;

    public QA(String question, String answer, String code) {
        this.question = question;
        this.answer = answer;
        this.code = code;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
