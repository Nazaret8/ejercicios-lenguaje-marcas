import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio1Resultado {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        File fileXML = new File("C:/Users/Usuario/Desktop/LMSGI/Tercer Trimestre/XMLJAVA/Ejercicio1.xml");

        DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(fileXML);

        Element nodoRaiz = document.getDocumentElement();
        NodeList listadoLibro = nodoRaiz.getElementsByTagName("libro");

        // Iterar sobre cada elemento 'libro'
        for (int i = 0; i < listadoLibro.getLength(); i++) {
            Node nodoLibro = listadoLibro.item(i);

            if (nodoLibro.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoLibro = (Element) nodoLibro;

                // Verificar si el atributo 'digital' es 'true'
                if (elementoLibro.getAttribute("digital").equals("true")) {
                    // Obtener el nodo 'titulo'
                    Node nodoTitulo = elementoLibro.getElementsByTagName("titulo").item(0);

                    if (nodoTitulo != null) {
                        // Obtener el contenido del nodo 'titulo'
                        String tituloLibro = nodoTitulo.getTextContent();
                        System.out.println(tituloLibro);
                    }
                }
            }
        }

    }
}
