/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class regex {

    public static ArrayList<String> regex(String type, String s) {
        ArrayList<String> list = new ArrayList<String>();
        String str = "";
        s = s.replace(";", ";\n");

        s = s.replace("=", ";");

        Pattern pattern;
        switch (type) {
            case "int":
                pattern = Pattern.compile("(int )[[a-zA-Z0-9]*[,]*]*");
                break;
            case "String":
                pattern = Pattern.compile("(String )[[a-zA-Z0-9]*[,]*]*");
                break;
            default:
                pattern = Pattern.compile("(Array )[[a-zA-Z0-9]*[,]*]*");
                break;
        }
       //  Pattern pattern = Pattern.compile("(int )[[a-zA-Z0-9]*[,]*]*");
        Matcher matcher = pattern.matcher(s);
        StringBuffer sb = new StringBuffer();
        int t = s.split("\n").length;
        int y = 0;
        while (matcher.find()) {
            sb.delete(0, sb.length());

            String temp = matcher.group(0);

            switch (type) {
                case "int":
                    pattern = Pattern.compile("(int )");
                    break;
                case "String":
                    pattern = Pattern.compile("(String )");
                    break;
                default:
                    pattern = Pattern.compile("(Array )");
                    break;

            }

            Matcher m = pattern.matcher(temp);
            y++;
            int i = 0;
            while (m.find()) {
                //  if (i == 0) {
                {
                    m.appendReplacement(sb, str + ",");
                    i++;
                }
            }
            m.appendTail(sb);
            String temp2[] = sb.toString().split(",");
            for (String temp21 : temp2) {
                System.out.println(temp21);
                list.add(temp21);
 
            }
        }
        return list;
    }

   

   
}
