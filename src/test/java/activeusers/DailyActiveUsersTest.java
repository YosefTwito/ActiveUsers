package activeusers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DailyActiveUsersTest {

    static FileReader reader;
    static String filePath;
    static Date day = new Date();

    static DailyActiveUsers dau;

    @BeforeAll
    static void beforeAll(){

        filePath = "src/test/resources/input.txt";
        dau = new DailyActiveUsers(new SimpleDateFormat("dd/MM/yyyy"));
        reader = new FileReader();
        reader.addItemsFromFile(filePath, dau);
    }

    @Test
    void getActiveUsersFirstDay() {
        dayAssignment("01/01/2020");

        int firstDay = dau.getActiveUsers(day);
        assertEquals(3, firstDay);
    }

    @Test
    void getActiveUsersSecondDay() {
        dayAssignment("02/01/2020");

        int firstDay = dau.getActiveUsers(day);
        assertEquals(2, firstDay);
    }

    @Test
    void getActiveUsersThirdDay() {
        dayAssignment("03/01/2020");

        int firstDay = dau.getActiveUsers(day);
        assertEquals(2, firstDay);
    }

    void dayAssignment(String dayAsString){
        try {
            day = dau.getFormatter().parse(dayAsString);
        } catch (ParseException e) { e.printStackTrace(); }
    }
}