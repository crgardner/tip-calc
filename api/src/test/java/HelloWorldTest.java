import static org.assertj.core.api.Assertions.assertThat;

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

}
