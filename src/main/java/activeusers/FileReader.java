package activeusers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements DataReader{

    /**
     * This function reads data from source, process it, and send it to the activeUserGetter
     * @param fileName - path to file
     * @param activeUsersGetter - getActiveUsers object
     */
    @Override
    public void addItemsFromFile(String fileName, AddItem activeUsersGetter) {
        File file = new File(fileName);
        Scanner scan = null;
        try {
            String[] line;
            scan = new Scanner(file);
            while(scan.hasNextLine()) {
                line = scan.nextLine().split(",");
                activeUsersGetter.addItem(Long.parseLong(line[0]), line[1]);
            }
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }

//    try{
//        FileInputStream fin=new FileInputStream("D:\\testout.txt");
//        int i=fin.read();
//        System.out.print((char)i);
//
//        fin.close();
//    }catch(Exception e){ System.out.println(e);}
}
