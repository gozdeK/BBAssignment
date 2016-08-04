import org.openqa.selenium.WebDriver;

/**
 * Created by gozdekaplan on 04/08/16.
 */
public class Page {
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }



}
