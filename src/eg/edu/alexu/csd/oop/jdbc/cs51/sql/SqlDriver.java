package eg.edu.alexu.csd.oop.jdbc.cs51.sql;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class SqlDriver implements Driver {
	private eg.edu.alexu.csd.oop.jdbc.cs51.log.Logger log;
	

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		try {
			log.getInstance().info("Accepted URL: " + url);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
		}
		return true;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		if (url == null) {
			try {
				log.getInstance().warnning("URL equals null");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
			throw new UnsupportedOperationException();
		}
		File file = (File) info.get("path");
		try {
			log.getInstance().info("Connected");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
		}
		return new SqlConnection(file.getAbsolutePath());

	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		DriverPropertyInfo[] driverPropertyInfo = {(DriverPropertyInfo) info.get("path")};
		return driverPropertyInfo;
	}

	/***************************** unused methods ******************************/

	@Override
	public int getMajorVersion() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getMinorVersion() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean jdbcCompliant() {
		throw new UnsupportedOperationException();
	}

}
