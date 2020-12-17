package eval.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eval.pojo.Autores;
import eval.pojo.Libros;

public class XmlReader{
	private static ArrayList<Autores> autores;
	private static ArrayList<Libros> libros;
	
public XmlReader() {}


public static void readXml() throws ParserConfigurationException, SAXException, IOException{
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
	FileInputStream fis = new FileInputStream("D:\\Pruebas\\biblioteca.xml");
	Document doc = db.parse(fis);
	
	NodeList cod = doc.getElementsByTagName("Codigo");
	NodeList nombre = doc.getElementsByTagName("Nombre");
	NodeList pais = doc.getElementsByTagName("Pais");
	NodeList isbn = doc.getElementsByTagName("ISBN");
	NodeList titulo = doc.getElementsByTagName("Titulo");
	NodeList editorial = doc.getElementsByTagName("Editorial");
	NodeList codautor = doc.getElementsByTagName("CodAutor");
	
	autores = new ArrayList<Autores>();
	libros = new ArrayList<Libros>();
	for(int i=0; i<cod.getLength(); i++) {
	  autores.add(new Autores(Integer.parseInt(cod.item(i).getTextContent()),nombre.item(i).getTextContent(),pais.item(i).getTextContent()));
	  }

	  for(int i=0; i<codautor.getLength(); i++) {
	    libros.add(new Libros(isbn.item(i).getTextContent(),titulo.item(i).getTextContent(),editorial.item(i).getTextContent(),Integer.parseInt(codautor.item(i).getTextContent())));
	  }
}

public static ArrayList<Autores> getAutores() {
	return autores;
}

public static ArrayList<Libros> getLibros() {
	return libros;
}

}
