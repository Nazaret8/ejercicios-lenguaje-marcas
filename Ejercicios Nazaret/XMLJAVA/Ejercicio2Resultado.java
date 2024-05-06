import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

public class Ejercicio2Resultado {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // Cargar el archivo XML
        File fileXML = new File("Ejercicio1.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fileXML);

        // Obtener una lista de elementos 'libro'
        NodeList nodeList = doc.getElementsByTagName("libro");

        // Buscar el libro con id = 3 y mostrar su título
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element libroElement = (Element) node;

                // Me creo la variable id que coge el atributo id del libro
                String id = libroElement.getAttribute("id");

                // Muestra el libro cuyo id = 3
                if (id.equals("3")) {
                    String titulo = libroElement.getElementsByTagName("titulo").item(0).getTextContent();
                    System.out.println(titulo);
                }

                // Buscar el libro con id = 6 y mostrar todos sus atributos
                if (id.equals("6")) {
                    String digital = libroElement.getAttribute("digital");
                    String papel = libroElement.getAttribute("papel");
                    System.out.println("Todos los atributos del libro con id 6 son:");
                    System.out.println("Digital: " + digital);
                    System.out.println("Papel: " + papel);
                }
            }
        }
    }
}
