package ro.arnia.ridesharing.domain.model.Validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.Errors;
import ro.arnia.ridesharing.domain.model.Car;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CarValidatorTest {

    @InjectMocks
    private CarValidator classUnderTest;

    @Mock
    private Car car;

    @Mock
    private Errors err;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void brandIsNotNull() {
        classUnderTest.validate(car,err);
        System.out.print(err.getAllErrors());
        assertEquals(42, 43);
    }
}