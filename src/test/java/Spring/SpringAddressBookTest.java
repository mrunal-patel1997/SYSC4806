package Spring;

import Spring.AddressBookController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringAddressBookTest {


    @Autowired
    private AddressBookController testController;

    @Test
    public void contexLoads() /*throws Exception*/ {
        assertThat (testController).isNotNull();

    }
}
