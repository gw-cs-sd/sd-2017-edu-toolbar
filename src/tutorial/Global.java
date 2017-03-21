package tutorial;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;

import jdk.nashorn.internal.scripts.JO;
import tutorial.code.JavaCodeRunner;
import tutorial.question.QA;
import tutorial.question.QuestionManager;
import tutorial.question.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * Created by Austin Moon on 11.28.16.
 * </p>
 */
public class Global {
    private static volatile Global instance;
    private JavaCodeRunner javaCodeRunner;
    private QuestionManager questionManager;
    private User user;
    private static Properties prop = new Properties();
    

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
        try {
            prop.load(Global.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List getQAForTags(String string) {
    	System.out.println("Global: getQAforTags method");
       try
       {
    	   return questionManager.generateQuestion(string.split(","));
       }
       catch (Exception e) {
		return null;
	}
       }
    

    public boolean runCode(String program, QA qa) {
        try {
            String res = javaCodeRunner.runCode(program);
            System.out.println("Res = " + res);
            boolean val = res.equals("true");
            if (val) {
                user.getAns().add(program);
                user.getQa().add(qa);
                saveUser();
            }
            return val;
        } catch (NullPointerException ex) {
            System.out.println("runcode() error");
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
        System.out.println("check user folder");
        File[] fileList = getFolderFiles(root);
        System.out.println("user Files");
        if(fileList!=null)
        {
        for (File file : fileList) {
            if (file.getName().equals(login)) {
                return false;
            }
        }
        }
        user = new User();
        user.setLogin(login);
        user.setPassword(password);
        saveUser();
        System.out.println("user save");
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
                } catch (Exception e) {
                    System.err.println("Can't read file");
                    e.printStackTrace();
                }
                break;
            }
        }
        return false;
    }
    
    public User getCurrentUserObj(String username){
        User curr=null;
            File file=new File(prop.getProperty("store")+"\\"+ username);
            ObjectMapper mapper = new ObjectMapper();
                try {
                     curr = mapper.readValue(file, User.class);
                   
                } catch (Exception e) {
                    System.err.println("Can't read file");
                    e.printStackTrace();
                }
        return curr;
    }
    
    public void saveUser() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"login\":\""+user.getLogin()+"\",\"password\":\""+user.getPassword()+"\"}";
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
        	User myuser = mapper.readValue(jsonString, User.class);
        	System.out.println(myuser);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
        	jsonString = mapper.writeValueAsString(myuser);
        	//JOptionPane.showConfirmDialog(null, jsonString);
        	System.out.println(jsonString);
                File userFile=new File(prop.getProperty("store")+"\\" + user.getLogin());
                if(userFile!=null && userFile.exists()){
                    userFile.delete();
                }
            writer.writeValue(new File(prop.getProperty("store")+"\\" + user.getLogin()), user);
        } catch (IOException e) {
            System.err.println("Can't save user");
            e.printStackTrace();
        }
    }

    public static File checkUsersFolder() {
        File file = new File(prop.getProperty("store"));
        if (!file.isDirectory() || !file.exists()) {
            System.out.println("Can't find users folder. Creating new");
            //File userfile = new File("F:\\Own Software House data\\Java\\codingfolio\\TestQuiz2\\users\\"+);
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

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
