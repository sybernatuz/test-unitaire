import com.esgi.services.Exchange;
import com.esgi.services.DBConnection;
import com.esgi.services.EmailSender;
import mock.ExchangeMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ExchangeTest {

    @Mock
    private DBConnection dbConnection;
    @Mock
    private EmailSender emailSender;
    private Exchange exchange;

    @Before
    public void init() {
        exchange = ExchangeMock.createExchange(emailSender, dbConnection);
    }

    @Test
    public void testSave() {
        when(dbConnection.save(any())).thenReturn(true);
        when(emailSender.sendEmail(any(), any())).thenReturn(true);
        assertTrue(exchange.save());
    }

    @Test
    public void testSaveWithSendMailFailure() {
        when(dbConnection.save(any())).thenReturn(true);
        when(emailSender.sendEmail(any(), any())).thenReturn(false);
        assertFalse(exchange.save());
    }

    @Test
    public void testSaveWithDbInsertFailure() {
        when(dbConnection.save(any())).thenReturn(false);
        when(emailSender.sendEmail(any(), any())).thenReturn(true);
        assertFalse(exchange.save());
    }

    @Test
    public void testSaveWithoutReceiver() {
        when(dbConnection.save(any())).thenReturn(true);
        when(emailSender.sendEmail(any(), any())).thenReturn(true);
        exchange.setReceiver(null);
        assertFalse(exchange.save());
    }

    @Test
    public void testSaveWithoutProduct() {
        when(dbConnection.save(any())).thenReturn(true);
        when(emailSender.sendEmail(any(), any())).thenReturn(true);
        exchange.setProduct(null);
        assertFalse(exchange.save());
    }

    @Test
    public void testSaveWithPastStartDate() {
        exchange.setStartDate(LocalDate.of(2000, 1, 1));
        assertFalse(exchange.save());
    }

    @Test
    public void testSaveWithEndDateBeforeStartDate() {
        exchange.setEndDate(LocalDate.of(2000, 1, 1));
        assertFalse(exchange.save());
    }




}
