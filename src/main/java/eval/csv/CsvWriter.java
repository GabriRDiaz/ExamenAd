package eval.csv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import eval.pojo.Autores;
import eval.pojo.Libros;

public class CsvWriter {
	public static void writeCsv(ArrayList<Autores> autores, ArrayList<Libros> libros) throws IOException {
		Path csv = Paths.get("D:\\Pruebas\\grd.csv");
		
		BufferedWriter bw = Files.newBufferedWriter(csv);
			autores.forEach(a->{
				try {
					bw.write(a.getCodigo()+","+a.getNombre()+","+a.getPais()+"\n");
				} catch (IOException e) {e.printStackTrace();}
			});
			
			libros.forEach(l->{
				try {
					bw.write(l.getIsbn()+","+l.getTitulo()+","+l.getEditorial()+","+l.getCodautor()+"\n");
				} catch (IOException e) {e.printStackTrace();}
			});
			bw.flush();
			bw.close();
	}
}
