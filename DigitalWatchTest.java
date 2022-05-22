import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DigitalWatchTest {

        @Test
        public void TC1(){
            DigitalWatch n1 = new DigitalWatch();
            String inputs = "abadacaad";
            String output = "Current state: Normal_Display, the inner state: Time  Date: 1 - 1 - 2000  Time: 00:00";
            assertEquals( output , n1.DigitalWatch(inputs));
        }

        @Test
        public void TC2(){
            DigitalWatch n1 = new DigitalWatch();
            String inputs = "cbababababa";
            String output = "Current state: Normal_Display, the inner state: Time  Date: 2 - 2 - 2001  Time: 01:01";
            assertEquals( output , n1.DigitalWatch(inputs));
        }


        @Test
        public void TC3(){
            DigitalWatch n1 = new DigitalWatch();
            String inputs = "cbbabbbaaaa";
            String output = "Current state: Normal_Display, the inner state: Time  Date: 1 - 1 - 2000  Time: 03:02";
            assertEquals( output , n1.DigitalWatch(inputs));
        }

        @Test
        public void TC4(){
            DigitalWatch n1 = new DigitalWatch();
            String inputs = "caabbabbbbabbba";
            String output = "Current state: Normal_Display, the inner state: Time  Date: 3 - 5 - 2003  Time: 00:00";
            assertEquals( output , n1.DigitalWatch(inputs));
        }
    }

