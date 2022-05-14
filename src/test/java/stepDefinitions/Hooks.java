package stepDefinitions;
import driver.MyDriver;
import io.cucumber.java.After;

public class Hooks extends MyDriver{

    //Closes the browser after each test.
    @After
    public void tearDown(){
        driver.quit();
    }

}
