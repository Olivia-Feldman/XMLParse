import org.w3c.dom.*;
import javax.xml.parsers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class ParseFile {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    public HashMap<String, XMLDrug> getDrugDictionary() {
        return drugDictionary;
    }

    public void setDrugDictionary(HashMap<String, XMLDrug> drugDictionary) {
        this.drugDictionary = drugDictionary;
    }

    public ArrayList<XMLDrug.DrugInt> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<XMLDrug.DrugInt> drugList) {
        this.drugList = drugList;
    }
    //datastructure
    private HashMap<String, XMLDrug> drugDictionary;
    private ArrayList<XMLDrug.DrugInt> drugList;



    public ParseFile() throws ParserConfigurationException {
        try {
            File inputFile = new File("/Users/oliviafeldman/Desktop/XMLParse/src/SampleDrugDatabase copy.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("drug");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                XMLDrug drug = new XMLDrug();
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    NodeList nodeList = doc.getElementsByTagName("drug");
                    System.out.println("drugbank-id"
                            + eElement.getElementsByTagName("drugbank-id").item(0).getTextContent());
                    System.out.println("drug name:"
                            + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("drug description:"
                            + eElement.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("indication"
                            + eElement.getElementsByTagName("indication").item(0).getTextContent());

                    System.out.println("drug-interactions"
                            + eElement.getElementsByTagName("drug-interactions").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}