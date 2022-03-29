package tasks.parsing.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlRunner {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Root root = new Root();

        Document doc = getDocument();

        var rootNode = doc.getFirstChild();
        var rootChild = rootNode.getChildNodes();

        String mainName = null;

        Node peopleNode = null;

        for (int i = 0; i < rootChild.getLength(); i++) {

            if(rootChild.item(i).getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Child's-> " + rootChild.item(i).getNodeName());
                switch (rootChild.item(i).getNodeName()){
                    case "name": {
                        mainName = rootChild.item(i).getTextContent();
                        System.out.println(mainName + " <- main name");
                    }
                    case "people":{
                        peopleNode = rootChild.item(i);
                    }
                }
            }
        }

        root.setName(mainName);
        if(peopleNode == null){
            return;
        }
        List<People> peopleList = new ArrayList<>();
        var peopleChild = peopleNode.getChildNodes();
        for (int i = 0; i < peopleChild.getLength(); i++) {
            if(peopleChild.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            if (!peopleChild.item(i).getNodeName().equals("element")){
                continue;
            }
            var elementChild = peopleChild.item(i).getChildNodes();
            for (int j = 0; j < elementChild.getLength(); j++) {
                if (peopleChild.item(i).getNodeType() != Node.ELEMENT_NODE){
                    continue;
                }

            }


        }


    }

    private static Document getDocument() throws SAXException, IOException, ParserConfigurationException {
        File file = new File("E:\\javaprojec\\pattern\\src\\main\\resources\\text.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = dbf.newDocumentBuilder().parse(file);
        return doc;
    }
}

class Root {
    private String name;

    private List<People> people;

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }
}

class People {
    private int age;
    private String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}