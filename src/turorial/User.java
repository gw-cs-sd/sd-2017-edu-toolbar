package turorial;

import com.fasterxml.jackson.annotation.JsonProperty;
import turorial.question.QA;
import turorial.question.Theme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    @JsonProperty
    private String login = "login";
    @JsonProperty
    private String password = "password";
    @JsonProperty
    private List<QA> qa = new ArrayList<>();
    @JsonProperty
    private List<String> ans = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<QA> getQa() {
        return qa;
    }

    public void setQa(List<QA> qa) {
        this.qa = qa;
    }

    public List<String> getAns() {
        return ans;
    }

    public void setAns(List<String> ans) {
        this.ans = ans;
    }
}
