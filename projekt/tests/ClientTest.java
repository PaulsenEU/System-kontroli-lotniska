import com.company.objects.Airport;
import org.junit.Test;
import com.company.objects.Client;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void getName() {
        Client client = new Client();
        assertEquals("Kamil",client.getName());

    }

    public void testHappy()throws Exception
    {
        Client client = new Client();
        assertFalse(client.isHappy());
    }

}
