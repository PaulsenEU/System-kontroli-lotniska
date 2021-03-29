import com.company.objects.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteTest {

    @Test
    public void getID() {
        Route route = new Route();

        assertEquals("32",route.getID());

    }

    public void testHappy()throws Exception
    {
        Route route = new Route();
        assertFalse(route.isHappy());
    }
    }
