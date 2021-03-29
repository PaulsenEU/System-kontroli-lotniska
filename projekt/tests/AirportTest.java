import org.junit.Test;
import com.company.objects.*;
import com.company.Service.*;

import static org.junit.Assert.*;

public class AirportTest {

    @Test
    public void getName() throws Exception{
        Airport airport = new Airport("Chopin","","","",0,0);
        assertEquals("Chopin",airport.getName());

    }

public void testHappy()throws Exception
{
    Airport airport = new Airport("Chopin","","","",0,0);
    assertFalse(airport.isHappy());
}

}