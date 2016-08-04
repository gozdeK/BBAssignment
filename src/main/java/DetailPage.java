import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by gozdekaplan on 04/08/16.
 */
public class DetailPage extends Page{

    public DetailPage(WebDriver driver) {
        super(driver);
    }

    public String createComputer(String computerName, String date1, String date2, String company) {
        getDriver().findElement(By.id("name")).sendKeys(computerName);
        getDriver().findElement(By.id("introduced")).sendKeys(date1);
        getDriver().findElement(By.id("discontinued")).sendKeys(date2);
        getDriver().findElement(By.xpath(".//*[@id='company']/option[text()='" + company + "']")).click();

        getDriver().findElement(By.xpath(".//*[@id='main']/form/div/input")).click();

        return getDriver().getCurrentUrl();
    }

    public void updateComputer(String computerName, String date1, String date2, String company) {
        getDriver().findElement(By.id("name")).clear();
        getDriver().findElement(By.id("name")).sendKeys(computerName);
        getDriver().findElement(By.id("introduced")).clear();
        getDriver().findElement(By.id("introduced")).sendKeys(date1);
        getDriver().findElement(By.id("discontinued")).clear();
        getDriver().findElement(By.id("discontinued")).sendKeys(date2);
        getDriver().findElement(By.xpath(".//*[@id='company']/option[text()='" + company + "']")).click();

        getDriver().findElement(By.xpath(".//*[@id='main']/form/div/input")).click();
    }

    public void deleteRecord(){
        getDriver().findElement(By.xpath(".//*[contains(@class,'danger')]")).click();
    }
}
