import com.company.objects.Airport;
import org.junit.Test;
import com.company.objects.Airplane;

import static org.junit.Assert.*;

public class AirplaneTest {

    @Test
    public void getRange() {

        Airplane airplane = new Airplane();
        double r = airplane.getRange();
        //assertEquals(340,r);

    }
    public void testHappy()throws Exception
    {
        Airplane airplane = new Airplane();
        assertFalse(airplane.isHappy());
    }
}