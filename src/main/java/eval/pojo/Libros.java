package eval.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Libros {
	@Id
	private String isbn;
	@Column
	private String titulo;
	@Column
	private String editorial;
	@Column
	private int codautor;
	
	public Libros(String isbn, String titulo, String editorial, int codautor) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.codautor = codautor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getCodautor() {
		return codautor;
	}

	public void setCodautor(int codautor) {
		this.codautor = codautor;
	}
	
	
}
