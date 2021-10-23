package com.framework.core.component;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class RepositoryLoader
{
    public static String FetchElementValue(String type, String pageName, String env, String element) throws Exception
    {
       File xmlFile=new File(System.getProperty("user.dir") + "//src//main//resources//" + "OR.xml");
       // File xmlFile=new File(System.getProperty("user.dir") + "//src//main//resources//" + "OrangeCRM.xml");
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder docbuilder= dbFactory.newDocumentBuilder();
        Document document= docbuilder.parse(xmlFile); //Build a document


        XPathFactory xpathFactory= XPathFactory.newInstance(); //Creating a object of XPathFactory
        XPath xpath =xpathFactory.newXPath();
        XPathExpression xpathExpression=null;
        if(type.equalsIgnoreCase("id"))
        {
            xpathExpression =xpath.compile("//" + env+ "//" + pageName+ "//" + element+ "/id/text()");
        }

        if(type.equalsIgnoreCase("xpath"))
        {
            xpathExpression =xpath.compile("//" + env+ "//" + pageName+ "//" + element+ "/xpath/text()");
        }

        return (String) xpathExpression.evaluate(document, XPathConstants.STRING);

    }

    public static void main(String[] args) throws Exception
    {
        RepositoryLoader rObj=new RepositoryLoader();
        System.out.println(rObj.FetchElementValue("xpath", "LoginPage", "sit", "tdx_password"));
    }

}

