package cn.com.crowdsourcedtesting.testing;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesterTesting {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/CrowdSourcedTesting-System/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCrowdSourcedTesting() throws Exception {
    driver.get(baseUrl + "recruitment.do?method=selectRecentRecruitment");
    driver.findElement(By.linkText("登录")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("1306922411@qq.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("111111");
    driver.findElement(By.cssSelector("button.btn-u.pull-right")).click();
    driver.findElement(By.linkText("关于对于青少年上网成瘾的调查问卷")).click();
    driver.findElement(By.linkText("主页")).click();
    driver.findElement(By.linkText("甲骨文数据库攻防测试")).click();
    driver.findElement(By.linkText("礼品中心")).click();
    driver.findElement(By.cssSelector("em.overflow-hidden > img")).click();
    driver.findElement(By.cssSelector("li > form > button.btn-u")).click();
    driver.findElement(By.linkText("主页")).click();
    driver.findElement(By.linkText("问卷调查")).click();
    driver.findElement(By.id("55")).click();
    driver.findElement(By.linkText("招募帖")).click();
    driver.findElement(By.linkText("VISIT THE PROJECT")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
