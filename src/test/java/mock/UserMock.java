package mock;

import com.esgi.Builder;
import com.esgi.dto.User;

public class UserMock {

    public static User createDefaultUser() {
        return Builder.of(User::new)
                .with(User::setAge, 18)
                .with(User::setEmail, "user@gmail.com")
                .with(User::setLastName, "Jean")
                .with(User::setFirstName, "Jacques")
                .build();
    }

    static User createMinorUser() {
        return Builder.of(User::new)
                .with(User::setAge, 14)
                .with(User::setEmail, "toto@gmail.com")
                .with(User::setLastName, "toto")
                .with(User::setFirstName, "titi")
                .build();
    }
}
