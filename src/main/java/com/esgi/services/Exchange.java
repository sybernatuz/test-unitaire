package com.esgi.services;

import com.esgi.dto.Product;
import com.esgi.dto.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Exchange {

    private User receiver;
    private Product product;
    private LocalDate startDate;
    private LocalDate endDate;
    private EmailSender emailSender;
    private DBConnection dbConnection;

    public boolean save() {
        if (receiver == null || product == null)
            return false;
        if (!receiver.isValid() || !product.isValid())
            return false;
        if (!startDate.isAfter(LocalDate.now()))
            return false;
        if (!endDate.isAfter(startDate))
            return false;
        if (receiver.getAge() < 18) {
            boolean isMailSent = emailSender.sendEmail(receiver, "Mail content");
            if (!isMailSent)
                return false;
        }
        return dbConnection.save(this);
    }
}
