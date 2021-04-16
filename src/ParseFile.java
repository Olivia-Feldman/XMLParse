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
            File inputFile = new File("/Users/oliviafeldman/XMLParse/src/SampleDrugDatabase.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("drug");
            System.out.println("----------------------------");
            drugDictionary = new HashMap<>();


            for (int temp = 0; temp < nList.getLength(); temp++) {
                drugList = new ArrayList<>();
                XMLDrug drug = new XMLDrug();

                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());


                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode; //eElement is always a drug

                    System.out.println("drugbank-id"
                            + eElement.getElementsByTagName("drugbank-id").item(0).getTextContent());
                    //initializing the drug id value
                    drug.setId(eElement.getElementsByTagName("drugbank-id").item(0).getTextContent());


                    System.out.println("drug name:"
                            + eElement.getElementsByTagName("name").item(0).getTextContent());

                    //initializing the drug name value
                    drug.setName(eElement.getElementsByTagName("name").item(0).getTextContent());


                    System.out.println("drug description:"
                            + eElement.getElementsByTagName("description").item(0).getTextContent());
                    drug.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());



                    System.out.println("indication"
                            + eElement.getElementsByTagName("indication").item(0).getTextContent());
                    //initialize the drug indication
                    drug.setIndication(eElement.getElementsByTagName("indication").item(0).getTextContent());

                      NodeList newNode = eElement.getElementsByTagName("drug-interaction");
                      for(int j = 0; j < newNode.getLength();j++){
                          Node nNode1 = newNode.item(j);
                          XMLDrug.DrugInt tempIntDrug = new XMLDrug.DrugInt();
                          if(nNode1.getNodeType() ==Node.ELEMENT_NODE){
                              Element eElement1 = (Element) nNode1; //eElement1 is always a drug-interaction

                              tempIntDrug.setID(eElement.getElementsByTagName("drugbank-id").item(0).getTextContent());
                              System.out.println(eElement1.getElementsByTagName("drugbank-id").item(0).getTextContent());
                              tempIntDrug.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                              System.out.println(eElement1.getElementsByTagName("name").item(0).getTextContent());
                              System.out.println(eElement1.getElementsByTagName("description").item(0).getTextContent());
                              tempIntDrug.setInteraction(eElement.getElementsByTagName("description").item(0).getTextContent());
                              drugList.add(tempIntDrug);
                          }



                      }






                }

                drug.setDrugInteractionList(drugList);
                drugDictionary.put(drug.getId(),drug);
                System.out.println(drugDictionary.size());
                System.out.println(drugDictionary.containsKey("DB00009"));
                System.out.println(drugList.size());


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void createList(XMLDrug.DrugInt temp){
        drugList.add(temp);

    }

}