package tutorial;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import tutorial.code.JavaCodeRunner;
import tutorial.question.QA;
import tutorial.question.QuestionManager;
import tutorial.question.Theme;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Austin Moon on 11.28.16.
 * </p>
 */
public class Global {
    private static volatile Global instance;
    private JavaCodeRunner javaCodeRunner;
    private QuestionManager questionManager;
    private User user;

    public static Global getInstance() {
        Global localInstance = instance;
        if (localInstance == null) {
            synchronized (Global.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Global();
                }
            }
        }
        return localInstance;
    }

    private Global() {
        javaCodeRunner = new JavaCodeRunner();
        questionManager = new QuestionManager();
        user = new User();
    }

    public List getQAForTags(String string) {
    	System.out.println("Global: getQAforTags method");
        return questionManager.generateQuestion(string.split("\\s+"));
    }

    public boolean runCode(String program, QA qa) {
        try {
            String res = javaCodeRunner.runCode(program);
            System.out.println("Res = " + res);
            boolean val = res.equals(qa.getAnswer());
            if (val) {
                user.getAns().add(program);
                user.getQa().add(qa);
                saveUser();
            }
            return val;
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String getUserName() {
        return user.getLogin();
    }

    public User getUser() {
        return user;
    }

    public boolean register(String login, String password) {
        File root = checkUsersFolder();
        File[] fileList = getFolderFiles(root);
        for (File file : fileList) {
            if (file.getName().equals(login)) {
                return false;
            }
        }
        user = new User(login, password);
        saveUser();
        return true;
    }

    public boolean login(String login, String password) {
        File root = checkUsersFolder();
        File[] fileList = getFolderFiles(root);
        for (File file : fileList) {
            if (file.getName().equals(login)) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    User local = mapper.readValue(file, User.class);
                    if (local.getLogin().equals(login) && local.getPassword().equals(password)) {
                        user = local;
                        return true;
                    }
                } catch (IOException e) {
                    System.err.println("Can't read file");
                    e.printStackTrace();
                }
                break;
            }
        }
        return false;
    }

    public void saveUser() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File("users/" + user.getLogin()), user);
        } catch (IOException e) {
            System.err.println("Can't save user");
            e.printStackTrace();
        }
    }

    public static File checkUsersFolder() {
        File file = new File("users");
        if (!file.isDirectory() || !file.exists()) {
            System.out.println("Can't find users folder. Creating new");
            if (!file.mkdir()) {
                System.err.println("Can't create users folder");
            }
        }
        return file;
    }

    private static File[] getFolderFiles(File root) {
        File[] listFiles = root.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            System.out.println("Folder doesn't contains any files");
        }
        return listFiles;
    }
}
