package eg.edu.alexu.csd.oop.jdbc.cs51.sql;

import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import eg.edu.alexu.csd.oop.jdbc.cs51.log.Logger;

public class SqlResultSetMetaData implements ResultSetMetaData {
    private List<String> columnNames;
    private List<String> columnTypes;
    private String tableName;

    public SqlResultSetMetaData(List<String> columnNames, List<String> columnTypes, String tableName) {
        this.columnNames = columnNames;
        this.columnTypes = columnTypes;
        this.tableName = tableName;
    }
    
	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCatalogName(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getColumnClassName(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int getColumnCount() throws SQLException {
		try {
			Logger.getInstance().info("return column count");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
		}
		return columnNames.size();
	}

	@Override
	public int getColumnDisplaySize(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getColumnLabel(int column) throws SQLException {
		try {
			Logger.getInstance().info("column label at index "+column+" = "+columnNames.get(column - 1));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
		}
		return columnNames.get(column - 1);
	}

	@Override
	public String getColumnName(int column) throws SQLException {
		try {
			Logger.getInstance().info("column label at index "+column+" = "+columnNames.get(column - 1));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
		}
	    return columnNames.get(column - 1);
	}

	@Override
	public int getColumnType(int column) throws SQLException {
	    String type = columnTypes.get(column - 1);
	    if(type.equalsIgnoreCase("varchar")) {
	    	try {
				Logger.getInstance().info("column type at index "+column+" = VARCHAR");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
	        return java.sql.Types.VARCHAR;
	    } else {
	    	try {
				Logger.getInstance().info("column type at index "+column+" = INTEGER");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
	        return java.sql.Types.INTEGER;
	    }
	}

	@Override
	public String getColumnTypeName(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int getPrecision(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int getScale(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getSchemaName(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getTableName(int column) throws SQLException {
		try {
			Logger.getInstance().info("return table name");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
		}
		return tableName;
	}

	@Override
	public boolean isAutoIncrement(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isCaseSensitive(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isCurrency(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDefinitelyWritable(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int isNullable(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReadOnly(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSearchable(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSigned(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isWritable(int column) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
