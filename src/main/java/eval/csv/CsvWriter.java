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
	private static BufferedWriter bw;
	public static void writeCsv(ArrayList<Autores> autores, ArrayList<Libros> libros) {
		Path csv = Paths.get("D:\\Pruebas\\grd.csv");
		try {
			bw = Files.newBufferedWriter(csv);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.print("----------------------");
			System.out.print("Error al escribir libros en el Csv");
			System.out.print("----------------------");
		}
			autores.forEach(a->{
				try {
					bw.write(a.getCodigo()+","+a.getNombre()+","+a.getPais()+"\n");
				} catch (IOException e) {System.out.print("ERROR LOG");
				System.out.print("----------------------");
				System.out.print("Error al escribir libros en el Csv");
				System.out.print("----------------------");}
			});
			
			libros.forEach(l->{
				try {
					bw.write(l.getIsbn()+","+l.getTitulo()+","+l.getEditorial()+","+l.getCodautor()+"\n");
				} catch (IOException e) {e.printStackTrace();
				System.out.print("ERROR LOG");
				System.out.print("----------------------");
				System.out.print("Error al escribir autores en el Csv");
				System.out.print("----------------------");}
			});
			bw.flush();
			bw.close();
	}
}
