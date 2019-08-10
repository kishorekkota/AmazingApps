package hello;


import com.amazon.restapi.MyFirstRestController;
import com.amazon.restapi.RestapiApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestapiApplication.class)
public abstract class BaseClass {


    @Autowired  MyFirstRestController myFirstRestController;



    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(myFirstRestController);
    }
}


