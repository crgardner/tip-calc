package com.crg.api.hello;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.crg.api.hello.HelloWorld;

import spark.*;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldTest {

    private HelloWorld helloWorld;
    
    @Mock
    private Request request;
    
    @Mock
    private Response response;

    @Before
    public void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    public void saysHello() {
        String greeting = helloWorld.say(request, response);
        
        verify(response).status(200);
        assertThat(greeting).isEqualTo("hello, world");
    }

}
