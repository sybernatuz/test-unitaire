import com.esgi.dto.Product;
import mock.ProductMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductTest {

    private Product product;

    @Before
    public void init() {
        product = ProductMock.createProduct();
    }

    @Test
    public void testIsValid() {
        assertTrue(product.isValid());
    }

    @Test
    public void testIsValidWithoutName() {
        product.setName(null);
        assertFalse(product.isValid());
    }

    @Test
    public void testIsValidWithoutOwner() {
        product.setOwner(null);
        assertFalse(product.isValid());
    }
}
