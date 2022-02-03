package activeusers;

import java.util.Date;

public interface GetActiveUsers {
    /**
     * This function takes a date and return the active users for the date
     * @param time - Date object for the periodic time
     * @return the number of active users
     */
    public int getActiveUsers(Date time);
}
