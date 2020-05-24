package com.company.saver;

import com.company.model.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class Saver {
    public void save(List<Student> students, String filePath) {
        try {
            // Получение фабрики, чтобы после получить билдер документов.
            DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory.newInstance();
            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
            DocumentBuilder dBuilder = dBuilderFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("Students");
            doc.appendChild(rootElement);

            for (Student student : students) {
                Element studentElement = doc.createElement("Student");
                rootElement.appendChild(studentElement);

                Element studName = doc.createElement("Name");
                studName.appendChild(doc.createTextNode(student.getName()));
                studentElement.appendChild(studName);

                Element group = doc.createElement("Group");
                group.appendChild(doc.createTextNode(student.getGroup()));
                studentElement.appendChild(group);

                Element first = doc.createElement("firstSemestr");
                first.appendChild(doc.createTextNode(String.valueOf(student.getFirstSemestr())));
                studentElement.appendChild(first);

                Element second = doc.createElement("SecondSemestr");
                second.appendChild(doc.createTextNode(String.valueOf(student.getSecondSemestr())));
                studentElement.appendChild(second);

                Element three = doc.createElement("threethSemestr");
                three.appendChild(doc.createTextNode(String.valueOf(student.getThirdSemestr())));
                studentElement.appendChild(three);

                Element fouth = doc.createElement("fourthSemestr");
                fouth.appendChild(doc.createTextNode(String.valueOf(student.getFourthSemestr())));
                studentElement.appendChild(fouth);

                Element five = doc.createElement("fivethSemestr");
                five.appendChild(doc.createTextNode(String.valueOf(student.getFiveSemestr())));
                studentElement.appendChild(five);

                Element six = doc.createElement("sixthSemestr");
                six.appendChild(doc.createTextNode(String.valueOf(student.getSixthSemestr())));
                studentElement.appendChild(six);

                Element seven = doc.createElement("seventhSemestr");
                seven.appendChild(doc.createTextNode(String.valueOf(student.getFiveSemestr())));
                studentElement.appendChild(seven);

                Element eigth = doc.createElement("eighthSemestr");
                eigth.appendChild(doc.createTextNode(String.valueOf(student.getEighthSemestr())));
                studentElement.appendChild(eigth);

                Element nine = doc.createElement("ninthSemestr");
                nine.appendChild(doc.createTextNode(String.valueOf(student.getNinthSemestr())));
                studentElement.appendChild(nine);

                Element ten = doc.createElement("tenthSemestr");
                ten.appendChild(doc.createTextNode(String.valueOf(student.getTenthSemestr())));
                studentElement.appendChild(ten);


            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
