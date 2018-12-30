package eg.edu.alexu.csd.oop.jdbc.cs51.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author elshamey
 */
public class FormateWithDate extends Formatter{

    @Override
    public String format(LogRecord record) {
         return 
               new Date(record.getMillis())+"::"
                +record.getMessage()+"\n";
    }
    
}
