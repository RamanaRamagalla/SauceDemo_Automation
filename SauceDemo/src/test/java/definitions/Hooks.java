package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

   

    @Before
    public void setUp() {
    	 DriverFactory.initDriver(); // initialize driver before scenario
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(); // quit driver after scenario
    }
}
