package com.esgi.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;

@Getter
@Setter
public class User {

    private String email;
    private String lastName;
    private String firstName;
    private Integer age;

    public boolean isValid() {
        boolean isEmailValid = EmailValidator.getInstance().isValid(email);
        if (!isEmailValid)
            return false;
        if (lastName == null || firstName == null)
            return false;
        return age != null && age >= 13;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, lastName, firstName, age);
    }
}
