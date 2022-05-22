import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;

public class ATM_Test {

    @Test
    public void userInput() {
        ATM test = new ATM();
        String simulatedinput = 15000 + "";
        ByteArrayInputStream in = new ByteArrayInputStream("MENU".getBytes());
        System.setIn(in);
        assertFalse(test.userInput("BALANCE"));
        assertFalse(test.userInput("DEFAULT"));
        in = new ByteArrayInputStream("YES".getBytes());
        System.setIn(in);
        assertTrue(test.userInput("EXIT"));
        in = new ByteArrayInputStream("NO".getBytes());
        System.setIn(in);
        assertFalse(test.userInput("EXIT"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("DEPOSIT"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("DEPOSIT"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("DEPOSIT"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("DEPOSIT"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("DEPOSIT"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("WITHDRAWAL"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("WITHDRAWAL"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("WITHDRAWAL"));
        in = new ByteArrayInputStream(simulatedinput.getBytes());
        System.setIn(in);
        assertFalse(test.userInput("WITHDRAWAL"));
    }

    @Test
    public void getbalance() {
        ATM test = new ATM();
        assertEquals(1000, test.getbalance(), 0);
    }

    @Test
    public void Frequency_Test(){
        ATM test = new ATM();
        assertTrue(test.can_deposit(3));
        assertFalse(test.can_deposit(11));
        assertTrue(test.can_withdraw(2));
        assertFalse(test.can_withdraw(6));
    }

    @Test
    public void Withdrawal(){
        ATM test = new ATM();
        assertEquals("ERORR",1000, test.withdrawal(10000), 0);
        assertEquals("ERORR",1000, test.withdrawal(-50), 0);
        assertEquals(500, test.withdrawal(500), 0);

    }

    @Test
    public void deposit() {
        ATM test = new ATM();
        assertEquals(10500, test.deposit(10000), 0);
        assertEquals("ERROR: Maximum deposit amount at most 10000 L.E.",10500, test.deposit(40000), 0);
        assertEquals(18000, test.deposit(7500), 0);
        assertEquals("ERROR: Enter a valid amount.",18000, test.deposit(-50), 0);
    }


    @Test
    public void quit() {
        ATM test = new ATM();
        assertFalse(test.quit("NO"));
        assertTrue(test.quit("YES"));
        assertTrue(test.quit("yes"));
    }

}