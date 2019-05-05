package mock;

import com.esgi.Builder;
import com.esgi.services.Exchange;
import com.esgi.services.DBConnection;
import com.esgi.services.EmailSender;

import java.time.LocalDate;

public class ExchangeMock {

    public static Exchange createExchange(EmailSender emailSender, DBConnection dbConnection) {
        return Builder.of(Exchange::new)
                .with(Exchange::setStartDate, LocalDate.of(2022, 1, 21))
                .with(Exchange::setEndDate, LocalDate.of(2022, 2, 24))
                .with(Exchange::setProduct, ProductMock.createProduct())
                .with(Exchange::setDbConnection, dbConnection)
                .with(Exchange::setEmailSender, emailSender)
                .with(Exchange::setReceiver, UserMock.createMinorUser())
                .build();
    }
}
