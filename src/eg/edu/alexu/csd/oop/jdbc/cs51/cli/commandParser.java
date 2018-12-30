package eg.edu.alexu.csd.oop.jdbc.cs51.cli;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eg.edu.alexu.csd.oop.jdbc.cs51.log.Logger;
import eg.edu.alexu.csd.oop.jdbc.cs51.parsers.FunctionChooserParser;
import eg.edu.alexu.csd.oop.jdbc.cs51.sql.SqlConnection;
import eg.edu.alexu.csd.oop.jdbc.cs51.sql.SqlDriver;

public class commandParser {
    private static final String CLI_NAME = "jdbc";
    private static final String CONNECT_COMMAND = CLI_NAME + " +connect +(.+)";
    private static final String EXECUTE_COMMAND = CLI_NAME + " +execute +(.+)";
    private static final String CLOSE_COMMAND = CLI_NAME + " +close *";
    private static final String ADD_BATCH_COMMAND = CLI_NAME + " +add batch +(.+)";
    private static final String CLEAR_BATCH_COMMAND = CLI_NAME + " +clear batch *";
    private static final String EXECUTE_BATCH_COMMAND = CLI_NAME + " +execute batch";
    private static final String SET_QUERY_TIME_OUT = CLI_NAME + " +set query timeout +(\\d+)";
    private static final String QUERY_TIMEOUT = CLI_NAME + " +query timeout *";
    private static final String HELP = CLI_NAME + " +help *";
    private Driver sqlDriver;
    private Connection connection;
    private Statement statement;
    
    public commandParser(Driver sqlDriver) {
        this.sqlDriver = sqlDriver;
    }
    
    public void excute(String command) {
        command = command.toLowerCase();
        Pattern p1 = Pattern.compile(CONNECT_COMMAND);
        Pattern p2 = Pattern.compile(CLOSE_COMMAND);
        Pattern p3 = Pattern.compile(EXECUTE_COMMAND);
        Pattern p4 = Pattern.compile(ADD_BATCH_COMMAND);
        Pattern p5 = Pattern.compile(CLEAR_BATCH_COMMAND);
        Pattern p6 = Pattern.compile(EXECUTE_BATCH_COMMAND);
        Pattern p7 = Pattern.compile(SET_QUERY_TIME_OUT);
        Pattern p8 = Pattern.compile(QUERY_TIMEOUT);
        Pattern p9 = Pattern.compile(HELP);

        Matcher m1 = p1.matcher(command);
        Matcher m2 = p2.matcher(command);
        Matcher m3 = p3.matcher(command);
        Matcher m4 = p4.matcher(command);
        Matcher m5 = p5.matcher(command);
        Matcher m6 = p6.matcher(command);
        Matcher m7 = p7.matcher(command);
        Matcher m8 = p8.matcher(command);
        Matcher m9 = p9.matcher(command);
        if(m1.matches()) {
            String path = m1.group(1);
            Properties info = new Properties();
            File dbDir = new File(path);
            info.put("path", dbDir.getAbsoluteFile());
            try {
                connection = sqlDriver.connect("jdbc:xmldb://localhost", info);
                statement = connection.createStatement();
                //System.out.println("connected!");
            } catch (SQLException e) {
            	try {
        			Logger.getInstance().warnning("Invalid path");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
            }
        } else if (m2.matches()) {
            if(connection != null) {
                try {
                    connection.close();
                    connection = null;
                    //System.out.println("closed!");
                } catch (SQLException e) {
                }
            } else {
            	try {
        			Logger.getInstance().warnning("no conncetion found to close");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
            }
            if(statement != null) {
                try {
                    statement.close();
                    statement = null;
                } catch (SQLException e) {
                }
            }
        } else if (m6.matches()) {
        	if(connection == null) {
        		try {
        			Logger.getInstance().warnning("no conncetion found");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
        		return;
        	}
        	try {
				int[] b = statement.executeBatch();
				System.out.println("Results: ");
				for(int i : b) {
					System.out.println("query result : " + i);
				}
			} catch (SQLException e) {
				try {
        			Logger.getInstance().warnning("wrong query");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
			}
        } else if (m3.matches()) {
            String query = m3.group(1);
            if(connection != null && statement != null) {
                FunctionChooserParser f = new FunctionChooserParser();
                int q = 0;
                try {
                     q = f.getOutput(query);
                } catch (SQLException e) {
                }
                
                switch(q) {
                case 1:
                    executeStructure(query);
                    break;
                case 2:
                    executeUpdate(query);
                    break;
                case 3:
                    executeSelect(query);
                    break;
                default:
                	try {
            			Logger.getInstance().warnning("wrong query");
            		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
            			// TODO Auto-generated catch block
            		}
                    break;
                }
            } else {
            	try {
        			Logger.getInstance().warnning("no connection found");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
            }
        } else if (m4.matches()) {
        	if(connection == null) {
        		try {
        			Logger.getInstance().warnning("no conncetion found");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
        		return;
        	}
        	try {
				statement.addBatch(m4.group(1));
			} catch (SQLException e) {
			}
        } else if (m5.matches()) {
        	if(connection == null) {
        		try {
        			Logger.getInstance().warnning("no conncetion found");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
        		return;
        	}
        	try {
				statement.clearBatch();
			} catch (SQLException e) {
			}
        } else if (m7.matches()) {
        	if(connection == null) {
        		try {
        			Logger.getInstance().warnning("no conncetion found");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
        		return;
        	}
        	int t = Integer.parseInt(m7.group(1));
        	try {
				statement.setQueryTimeout(t);
			} catch (SQLException e) {
			}
        } else if (m8.matches()) {
        	if(connection == null) {
        		try {
        			Logger.getInstance().warnning("no conncetion found");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
        			// TODO Auto-generated catch block
        		}
        		return;
        	}
        	try {
				System.out.println("Query Timeout: " + statement.getQueryTimeout());
			} catch (SQLException e) {
			}
        } else if (m9.matches()) {
        	System.out.println("Commands: ");
        	System.out.println("connect <path to database>");
        	System.out.println("execute <query>");
        	System.out.println("add batch <query>");
        	System.out.println("clear batch");
        	System.out.println("execute batch");
        	System.out.println("set query timeout <time in seconds>");
        	System.out.println("close");
        	System.out.println("query timeout");
        } else {
        	try {
    			Logger.getInstance().warnning("couldn't find command : " + command);
    		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
    			// TODO Auto-generated catch block
    		}
        }
    }
    
    private void executeStructure(String query) {
        try {
            statement.execute(query);
           // System.out.println("Done!");
        } catch (SQLException e) {
        	try {
    			Logger.getInstance().warnning("wrong query");
    		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
    			// TODO Auto-generated catch block
    		}
        }
    }
    private void executeUpdate(String query) {
        try {
            System.out.println("Updated : " + statement.executeUpdate(query));
        } catch (SQLException e) {
        	try {
    			Logger.getInstance().warnning("wrong query");
    		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
    			// TODO Auto-generated catch block
    		}
        }
    }
    private void executeSelect(String query) {
        try {
            ResultSet rs = statement.executeQuery(query);
            System.out.println("results: ");
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()) {
                System.out.print("Row: ");
                for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getObject(i) + "  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
        	try {
    			Logger.getInstance().warnning("wrong query");
    		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
    			// TODO Auto-generated catch block
    		}
        }
    }
}
