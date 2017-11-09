package com.simbirsoft.autotests.simbirsoftcom;
import com.simbirsoft.autotests.DriverInit;
import com.simbirsoft.autotests.simbirsoftcom.abstractPages.MainPage;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.utils.AllureResultsUtils;

/**
 * Created by Julia Klimova
 */

public class MainPageTest extends DriverInit {
    MainPage mainPage = new MainPage(driver);

    @Title("Проверка доступности главной страницы по aдресу")
    @Test
    public void case00() throws Exception {
        String url = mainPage.getMainPageTitle();
        if (!url.contains("somesite.com")) {
            byte[] screenShotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            AllureResultsUtils.writeAttachment(saveScreenshot(screenShotBytes), "Test result");
        }
        Assert.assertTrue("Case 00 is failed. http://somesite.com is responding" ,
                url.contains("somesite.com"));
        System.out.println("Case 00 is passed. http://somesite.com is responding");
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
