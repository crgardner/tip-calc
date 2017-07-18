import static org.assertj.core.api.Assertions.assertThat;

import java.math.*;

import org.joda.money.*;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {

    private HelloWorld helloWorld;
    private String greeting;

    @Before
    public void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    public void saysHello() {
        greeting = helloWorld.say();
        
        assertThat(greeting).isEqualTo("hello, world");
    }
    
    @Test
    public void money() {
        Money money = Money.of(CurrencyUnit.USD, BigDecimal.valueOf(11.25));
        System.out.println(money.multipliedBy(0.15, RoundingMode.UP));
        
    }

}
