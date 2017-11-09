package com.simbirsoft.autotests.simbirsoftcom.abstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;
/**
 * Created by Julia Klimova
 */
public class MainPage {
    private WebDriver driver;

    public MainPage (WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Get main page title")
    public String getMainPageTitle() {
        driver.get("https://simbirsoft.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("http://simbirsoft.com title is " + driver.getTitle());
        return driver.getCurrentUrl();
    }


}