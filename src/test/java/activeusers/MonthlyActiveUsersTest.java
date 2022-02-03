package activeusers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MonthlyActiveUsersTest {

    static FileReader reader;
    static String filePath;
    static Date day = new Date();

    static MonthlyActiveUsers dau;

    @BeforeAll
    static void beforeAll(){

        filePath = "src/test/resources/input.txt";
        dau = new MonthlyActiveUsers(new SimpleDateFormat("MM/yyyy"));
        reader = new FileReader();
        reader.addItemsFromFile(filePath, dau);
    }

    @Test
    void getActiveUsersFirstMonth() {
        dayAssignment("01/2020");

        int firstDay = dau.getActiveUsers(day);
        assertEquals(4, firstDay);
    }

    @Test
    void getActiveUsersSecondMonth() {
        dayAssignment("02/2020");

        int firstDay = dau.getActiveUsers(day);
        assertEquals(3, firstDay);
    }

    @Test
    void getActiveUsersThirdMonth() {
        dayAssignment("03/2020");

        int firstDay = dau.getActiveUsers(day);
        assertEquals(1, firstDay);
    }

    void dayAssignment(String dayAsString){
        try {
            day = dau.getFormatter().parse(dayAsString);
        } catch (ParseException e) { e.printStackTrace(); }
    }
}