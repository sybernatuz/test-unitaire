package mock;

import com.esgi.Builder;
import com.esgi.dto.Product;

public class ProductMock {

    public static Product createProduct() {
        return Builder.of(Product::new)
                .with(Product::setName, "Book")
                .with(Product::setOwner, UserMock.createDefaultUser())
                .build();
    }
}
