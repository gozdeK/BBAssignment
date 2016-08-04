import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by gozdekaplan on 03/08/16.
 */
public class HomePage extends Page{
    public static final String URL = "http://computer-database.herokuapp.com/computers";

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void openPage() {
        getDriver().navigate().to(URL);
    }

    public DetailPage clickComputer(){
        getDriver().findElement(By.id("add")).click();
        DetailPage detailPage = new DetailPage(getDriver());

        return detailPage;

    }

    public void filter(String name) {
        getDriver().findElement(By.id("searchbox")).sendKeys(name);
        getDriver().findElement(By.id("searchsubmit")).click();
    }

    public String getResultList(){
        return getDriver().findElement(By.xpath(".//*[@id='main']/table/tbody/tr[1]/td[1]/a")).getText();
    }

    public DetailPage goToDetails(String name) {
        getDriver().findElement(By.xpath(".//*[@id='main']/table//a[text()='"+ name + "']")).click();

        DetailPage detailPage = new DetailPage(getDriver());
        return  detailPage;
    }


    public String getResultText() {
        return getDriver().findElement(By.xpath("//div[@class='well']")).getText();
    }

    public void closeApp(){
        getDriver().close();
    }
}
