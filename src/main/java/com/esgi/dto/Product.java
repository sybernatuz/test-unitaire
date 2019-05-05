package com.esgi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Product {

    private String name;
    private User owner;

    public boolean isValid() {
        if (name == null || owner == null)
            return false;
        return owner.isValid();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(owner, product.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner);
    }
}
