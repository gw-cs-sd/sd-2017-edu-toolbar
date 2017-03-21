package tutorial.question;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QA {
    @JsonProperty
    private String question;
    @JsonProperty
    private String answer;
    @JsonProperty
    private String code;
    @JsonProperty
    private String date;
    @JsonProperty
    private String topic;

    public QA(){
        
    }
    
    public QA(String question, String answer, String code,String date) {
        this.question = question;
        this.answer = answer;
        this.code = code;
        this.date=date;
        this.topic=topic;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    
}
