package eg.edu.alexu.csd.oop.jdbc.cs51.parsers;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eg.edu.alexu.csd.oop.db.Database;

public class FunctionChooserParser implements ChooserParser{

	private static final String REGEX = "((CREATE +TABLE)|(DROP +TABLE)|(CREATE +DATABASE)|(DROP +DATABASE)|(UPDATE)|(DELETE +FROM)|(SELECT)|(INSERT +INTO)).*";

	@Override
	public int getOutput(String query) throws SQLException {
		Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(query);
		if (matcher.matches()) {
			String found = matcher.group(1);
			found = found.toLowerCase();
			found = found.replaceAll(" +", " ");
			switch (found) {
			case "create database":
				return 1;
			case "create table":
				return 1;
			case "drop database":
				return 1;
			case "drop table":
				return 1;
			case "select":
				return 3;
			case "insert into":
				return 2;
			case "update":
				return 2;
			case "delete from":
				return 2;
			default:
				return 0;
			}
		} else {
			return 0;
		}

}
}
