package glucode;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.WebSiteUtility;

public class LoginStepDef1 {
	public RemoteWebDriver driver;
	public Scenario s;
    public BaseClass bc;
    public WebSiteUtility wu;
	
    public LoginStepDef1(BaseClass bc) {
		this.bc=bc;
		
	}
    
	@Given("open browser")
	public void openBrowser()  {
		wu=new WebSiteUtility();
	    bc.driver=wu.launchBrowser("firefox");
		bc.driver.manage().window().maximize();
		bc.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));	
	}	
	@When("launch {string} site")
	public void openSite(String url) throws Exception {
		wu=new WebSiteUtility();
		wu.launchSite(bc.driver, url);
	}
	
	
	@Then("get title of page is equal to {string}")
	public void titleValidate(String tt) throws IOException, Exception {
		String title=bc.driver.getTitle();
		if(title.contains(tt)) {
			System.out.println("fb login page opened");
			
		}else {
			
			System.out.println("fb login page not opened");
		}
		Thread.sleep(4000);
	}
	
}
