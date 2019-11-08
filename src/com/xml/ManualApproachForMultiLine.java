package com.xml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ManualApproachForMultiLine {
    public static void main(String arg[]) throws Exception{
        String xmlFile = "C:\\Users\\MAHKOLA\\Documents\\workspace-sts-3.9.9.RELEASE\\XmlValidationApplication\\src\\com\\xml\\employee.xml";

        FileReader fr = new FileReader(xmlFile);
        BufferedReader br = new BufferedReader(fr);


        //xml = "<em><id>1<i>234</i></id><name>m</name><sal>0<asdf>adsf</asdf></sal></em>";

        List<String> list = new ArrayList<>();
        String field = "";
        boolean isTextValue = false;
        String xml = null;
        System.out.println(xml);
        while((xml = br.readLine())!=null) {
            xml = xml.trim();
            System.out.println(xml);
            for (int j = 1; j < xml.length(); j++) {
                if (xml.charAt(j) != '>' && xml.charAt(j) != '<' && !isTextValue) {
                    field = field + xml.charAt(j);
                } else if (xml.charAt(j) == '>' && (j + 1) < xml.length() && xml.charAt(j + 1) == '<') {
                    list.add(field);
                    field = "";
                    ++j;
                } else if (xml.charAt(j) == '>' && (j + 1) < xml.length() && xml.charAt(j + 1) != '<') {
                    list.add(field);
                    isTextValue = true;
                    ++j;
                } else if (xml.charAt(j) == '>' && !isTextValue) {
                    list.add(field);
                    field = "";
                } else if (xml.charAt(j) == '<' && isTextValue) {
                    field = "";
                    isTextValue = false;
                }
            }
        }

        System.out.println(list);
        Stack<String> tempStack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            if (tempStack.size() == 0) {
                tempStack.push(list.get(i));
            } else if (list.get(i).contains("/") && ("/" + tempStack.peek()).toString().equals(list.get(i).toString())) {
                tempStack.pop();
            } else {
                tempStack.push(list.get(i));
            }
        }
        if (tempStack.size() == 0) {
            System.out.println("Given XML is well formed");
        } else {
            System.out.println("Given XML is not well formed");
        }
    }
}
