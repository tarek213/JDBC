package eg.edu.alexu.csd.oop.jdbc.cs51.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author elshamey
 */
public class FormatWithoutDate extends Formatter{

    @Override
    public String format(LogRecord record) {
         return record.getMessage()+"\n";
    }
    
}