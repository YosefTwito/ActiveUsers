package activeusers;

import java.util.Date;

public interface AddItem {
    /**
     * This function takes the login parameters and append it to the Data
     * @param id of the login record
     * @param dateString date of logging to be processed and added
     */
    public void addItem(Long id, String dateString);
}
