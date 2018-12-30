package eg.edu.alexu.csd.oop.jdbc.cs51.parsers;

import java.sql.SQLException;
public interface ChooserParser {
	public int getOutput (String query) throws SQLException;
}
