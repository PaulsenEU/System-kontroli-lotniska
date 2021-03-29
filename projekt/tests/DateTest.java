import com.company.objects.Airport;
import org.junit.Test;
import com.company.objects.Date;
import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void getDeparture_day() {
        Date date = new Date();
        assertEquals(3,date.getDeparture_day());
    }

    public void testHappy()throws Exception
    {
        Date date = new Date();
        assertFalse(date.isHappy());
    }
}