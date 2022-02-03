package activeusers;

public interface DataReader {
    /**
     * This function reads the logging data from a file and append it to activeUsersGetter
     * @param fileName path for data file
     * @param activeUsersGetter used for appending the data
     */
    public void addItemsFromFile(String fileName, AddItem activeUsersGetter);
}
