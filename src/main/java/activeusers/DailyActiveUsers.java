package activeusers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;

public class DailyActiveUsers implements AddItem, GetActiveUsers {

    private Hashtable<Date, HashSet<Long>> logins;
    private SimpleDateFormat formatter;

    public DailyActiveUsers(SimpleDateFormat formatter) {
        this.logins = new Hashtable<>();
        this.formatter = formatter;
    }

    public SimpleDateFormat getFormatter() { return this.formatter; }

    @Override
    public int getActiveUsers(Date time) {
        return this.logins.get(time).size();
    }

    @Override
    public void addItem(Long id, String dateString){
        dateString = (dateString.split(" "))[0];
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) { e.printStackTrace(); }

        this.logins.computeIfAbsent(date, k -> new HashSet<>());
        this.logins.get(date).add(id);
    }
}
