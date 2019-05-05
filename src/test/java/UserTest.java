import com.esgi.dto.User;
import mock.UserMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    private User user;

    @Before
    public void init() {
        user = UserMock.createDefaultUser();
    }

    @Test
    public void testIsValid() {
        assertTrue(user.isValid());
    }

    @Test
    public void testIsValidWithoutEmail() {
        user.setEmail(null);
        assertFalse(user.isValid());
    }

    @Test
    public void testIsValidWithWrongEmail() {
        user.setEmail("@.com");
        assertFalse(user.isValid());
    }

    @Test
    public void testIsValidWithUnderAge() {
        user.setAge(12);
        assertFalse(user.isValid());
    }

    @Test
    public void testIsValidWithNoNomAndPrenom() {
        user.setFirstName(null);
        user.setLastName(null);
        assertFalse(user.isValid());
    }

}
