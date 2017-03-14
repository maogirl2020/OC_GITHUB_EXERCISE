package com.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by shache on 29/02/2016.
 */
public class GetDataFromFile {


    public GetDataFromFile(){};

    //Get Data From XML File
    public String GetDataFromFile(String DataPath, int Iteration, String tagValue)
    {
        try {

            File stocks = new File(DataPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());
            NodeList nodes1 = (NodeList) doc.getElementsByTagName("TestData");
            System.out.println("==========================");


            Node node = (Node) nodes1.item(Iteration);

            Element element = (Element) node;
            NodeList nodes2 = element.getElementsByTagName(tagValue).item(0).getChildNodes();
            Node NodeValue = (Node) nodes2.item(0);
            String Parameter = NodeValue.getNodeValue();
            return Parameter;


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
