package com.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ManualProgramaticApproach {
    public static void main(String[] args) throws IOException {
        String xmlFile = "C:\\Users\\MAHKOLA\\Documents\\workspace-sts-3.9.9.RELEASE\\XmlValidationApplication\\src\\com\\xml\\employee.xml";

        FileReader fr = new FileReader(xmlFile);
        BufferedReader br = new BufferedReader(fr);
        String xml = br.readLine();
        //xml = "<em><id>1<i>234</i></id><name>m</name><sal>0<asdf>adsf</asdf></sal></em>";
        System.out.println(xml);
        List<String> list = new ArrayList<>();
        String field = "";
        boolean isTextValue = false;

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
