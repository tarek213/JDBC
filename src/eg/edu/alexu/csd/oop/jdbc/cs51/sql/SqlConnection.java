package eg.edu.alexu.csd.oop.jdbc.cs51.sql;

import java.io.IOException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import eg.edu.alexu.csd.oop.db.Database;
import eg.edu.alexu.csd.oop.db.cs51.DBMS;

import eg.edu.alexu.csd.oop.db.cs51.DBMS;

import eg.edu.alexu.csd.oop.db.cs51.database.CurrentDatabase;



import eg.edu.alexu.csd.oop.jdbc.cs51.log.Logger;




public class SqlConnection implements Connection {
    private Database dbms;

    public SqlConnection(String path) {
        dbms = new DBMS();
        dbms.createDatabase(path, false);
    }
    
	@Override
	public void close() throws SQLException {
	    if(CurrentDatabase.getInstance().getPath() != null) {
	        CurrentDatabase.getInstance().shutdown();
	    }
		try {
			Logger.getInstance().info("Connection closed");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
		}
		dbms = null;
	}

	@Override
	public Statement createStatement() throws SQLException {
		try {
			Logger.getInstance().info("Statement created from connection");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
		}
		
		return new SqlStatement(this, dbms);
	}
	/************************ unused **************************/
	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();

	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void clearWarnings() throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void commit() throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void rollback() throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		throw new UnsupportedOperationException();

	}

}
