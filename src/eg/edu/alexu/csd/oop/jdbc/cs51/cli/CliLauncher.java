package eg.edu.alexu.csd.oop.jdbc.cs51.cli;

import java.sql.Driver;
import java.util.Scanner;

import eg.edu.alexu.csd.oop.jdbc.cs51.sql.SqlDriver;

public class CliLauncher {

    public static void main(String[] args) {
        Driver d = new SqlDriver();
        commandParser cp = new commandParser(d);
        while(true) {
            Scanner reader = new Scanner(System.in); 
           cp.excute(reader.nextLine());
        }

    }

}
