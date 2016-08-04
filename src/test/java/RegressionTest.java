import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by gozdekaplan on 03/08/16.
 */
public class RegressionTest {

    @Test
    public void shouldCreateAndViewNewRecord() {
        String computerName = RandomStringUtils.randomAlphabetic(10);
        String date1 = "2016-10-10";
        String date2 = "2016-10-10";
        String selection = "RCA";

        WebDriver driver = new FirefoxDriver();
        HomePage homepage = new HomePage(driver);
        homepage.openPage();

        DetailPage detailPage = homepage.clickComputer();
        detailPage.createComputer(computerName,date1,date2,selection);
        homepage.filter(computerName);

        assertTrue(homepage.getResultList().contains(computerName));
        homepage.closeApp();
    }

    @Test
    public void shouldFailCreatingRecordsWithEmptyName() {
        String computerName = null;
        String date1 = "2016-10-10";
        String date2 = "2016-10-10";
        String selection = "RCA";

        WebDriver driver = new FirefoxDriver();

        HomePage homepage = new HomePage(driver);
        homepage.openPage();

        DetailPage detailPage = homepage.clickComputer();
        String currentUrl =  detailPage.createComputer(computerName,date1,date2,selection);

        assertTrue(currentUrl.equals("http://computer-database.herokuapp.com/computers"));
        homepage.closeApp();

    }

    @Test
    public void shouldGetAndUpdateExistingRecord() {
        String newComputerName = RandomStringUtils.randomAlphabetic(10);
        String date1 = "2016-10-10";
        String date2 = "2016-10-10";
        String selection = "RCA";

        WebDriver driver = new FirefoxDriver();

        HomePage homepage = new HomePage(driver);
        homepage.openPage();
        String computerName = homepage.getResultList();

        homepage.filter(computerName);
        DetailPage detailPage = homepage.goToDetails(computerName);

        detailPage.updateComputer(newComputerName,date1,date2,selection);
        homepage.filter(newComputerName);

        assertTrue(homepage.getResultList().contains(newComputerName));
        homepage.closeApp();
    }

    @Test
    public void shouldDeleteARecordSuccessfully(){
        String computerName = RandomStringUtils.randomAlphabetic(10);
        String date1 = "2016-10-10";
        String date2 = "2016-10-10";
        String selection = "RCA";

        WebDriver driver = new FirefoxDriver();

        HomePage homepage = new HomePage(driver);
        homepage.openPage();

        DetailPage detailPage = homepage.clickComputer();
        detailPage.createComputer(computerName,date1,date2,selection);

        homepage.filter(computerName);
        homepage.goToDetails(computerName);

        detailPage.deleteRecord();
        homepage.filter(computerName);

        assertTrue(homepage.getResultText().contains("Nothing to display"));
        homepage.closeApp();
    }


}
