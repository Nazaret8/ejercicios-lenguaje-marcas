import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.newDocument();

        // Crear el elemento raíz del catálogo
        Element catalogo = doc.createElement("catalogo");
        Element fechaPublicacion = doc.createElement("fechaPublicacion");
        Element tiendas = doc.createElement("tiendas");

        Element tienda = doc.createElement("tienda");
        Element provincia = doc.createElement("provincia");
        Element ciudad = doc.createElement("ciudad");

        Element tienda2 = doc.createElement("tienda");
        Element provincia2 = doc.createElement("provincia");
        Element ciudad2 = doc.createElement("ciudad");


        Element productos = doc.createElement("productos");

        Element producto = doc.createElement("producto");
        producto.setAttribute("cantidad", "10");
        Element nombre = doc.createElement("nombre");
        Element descripcion = doc.createElement("descripcion");
        Element precio = doc.createElement("precio");
        precio.setAttribute("divisa", "EUR");

        Element producto2 = doc.createElement("producto");
        producto.setAttribute("cantidad", "10");
        Element nombre2 = doc.createElement("nombre");
        Element descripcion2 = doc.createElement("descripcion");
        Element precio2 = doc.createElement("precio");
        precio.setAttribute("divisa", "EUR");


        //AppendChild y TextContent
        doc.appendChild(catalogo);

        catalogo.appendChild(fechaPublicacion);
        fechaPublicacion.setTextContent("09/02/2024");
        catalogo.appendChild(tiendas);
        catalogo.appendChild(productos);

        tiendas.appendChild(tienda);
        tiendas.appendChild(tienda2);

        tienda.appendChild(provincia);
        provincia.setTextContent("Sevilla");
        tienda.appendChild(ciudad);
        ciudad.setTextContent("El Cuervo de Sevilla");

        tienda2.appendChild(provincia2);
        provincia2.setTextContent("Cadiz");
        tienda2.appendChild(ciudad2);
        ciudad2.setTextContent("Jerez");

        productos.appendChild(producto);
        productos.appendChild(producto2);
        
        producto.appendChild(nombre);
        nombre.setTextContent("Silla");
        producto.appendChild(descripcion);
        descripcion.setTextContent("Para sentarse");
        producto.appendChild(precio);
        precio.setTextContent("24");

        producto2.appendChild(nombre2);
        nombre2.setTextContent("Mesa");
        producto2.appendChild(descripcion2);
        descripcion2.setTextContent("Para apoyar cosas");
        producto2.appendChild(precio2);
        precio2.setTextContent("50");

        guardarDocumento(doc, "Ejercicio3.xml");

    }

    private static void guardarDocumento(Document document, String nombreFichero) throws IOException, TransformerException
    {
        DOMSource domSource = new DOMSource(document);
        FileWriter fileWriter = new FileWriter(new File(nombreFichero));
        StreamResult streamResult = new StreamResult(fileWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);
        fileWriter.close();
    }
}
