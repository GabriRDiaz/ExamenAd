package eval.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import eval.pojo.Libros;


public class AddJdbc {
	private static PreparedStatement query;
	public static void addLibros(ArrayList<Libros> libros) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eval1?serverTimezone=Europe/Madrid", "root", "abc123.");

		String sql = "CREATE TABLE libros("
				+ "isbn varchar(15) NOT NULL,"
				+ "titulo varchar(150) NOT NULL,"
				+ "editorial varchar(150) NOT NULL,"
				+ "codautor int(5) NOT NULL);";
		query = conn.prepareStatement(sql);
		
		query.execute(sql);
		sql= "INSERT INTO libros(isbn,titulo,editorial,codautor)"
				+ "VALUES(?,?,?,?)";
		
		query = conn.prepareStatement(sql);

		libros.forEach(l->{
			try {
				query.setString(1, l.getIsbn());
				query.setString(2, l.getTitulo());
				query.setString(3, l.getEditorial());
				query.setInt(4, l.getCodautor());
				query.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}
}
