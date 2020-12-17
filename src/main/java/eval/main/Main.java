package eval.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import eval.csv.CsvWriter;
import eval.database.AddHibernate;
import eval.database.AddJdbc;
import eval.xml.XmlReader;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, SQLException {
		XmlReader info = new XmlReader();
		info.readXml();
		AddHibernate.addAutores(info.getAutores());
		AddJdbc.addLibros(info.getLibros());
		CsvWriter.writeCsv(info.getAutores(), info.getLibros());
	}

}
