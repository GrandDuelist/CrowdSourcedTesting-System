package cn.com.crowdsourcedtesting.testing;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PublisherTesting {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/CrowdSourcedTesting-System";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPublisherTesting() throws Exception {
    driver.get(baseUrl + "/PublisherLoginView.jsp");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("ezhihan@gmail.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.cssSelector("button.btn-u.pull-right")).click();
    driver.findElement(By.linkText("问卷管理")).click();
    driver.findElement(By.xpath("//div[@id='sidebar-menu']/ul/li[4]/a/span[2]")).click();
    driver.findElement(By.xpath("//div[@id='sidebar-menu']/ul/li[4]/a/span[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'请单击')])[2]")).click();
    driver.findElement(By.cssSelector("span..glyphicons-circle_info")).click();
    driver.findElement(By.cssSelector("li.active > a > span.sidebar-title")).click();
    driver.findElement(By.linkText("请单击")).click();
    driver.findElement(By.id("RecruitmentTitle")).clear();
    driver.findElement(By.id("RecruitmentTitle")).sendKeys("网易招募");
    new Select(driver.findElement(By.id("isOnline"))).selectByVisibleText("线下");
    driver.findElement(By.id("RecruitmentPlace")).clear();
    driver.findElement(By.id("RecruitmentPlace")).sendKeys("上海");
    driver.findElement(By.id("RecruitmentCompany")).clear();
    driver.findElement(By.id("RecruitmentCompany")).sendKeys("网易");
    driver.findElement(By.id("RecruitmentBrief")).clear();
    driver.findElement(By.id("RecruitmentBrief")).sendKeys("招募测试人员");
    driver.findElement(By.id("RecruitmentContent")).clear();
    driver.findElement(By.id("RecruitmentContent")).sendKeys("待遇优厚");
    driver.findElement(By.id("addRecruitment")).click();
    driver.findElement(By.xpath("//div[@id='sizzle-1402146794178']/div/table/tbody/tr[2]/td[7]")).click();
    driver.findElement(By.xpath("//div[@id='sizzle-1402146794178']/div/table/tbody/tr[4]/td[5]")).click();
    driver.findElement(By.id("addRecruitment")).click();
    driver.findElement(By.cssSelector("span..glyphicons-circle_info")).click();
    driver.findElement(By.xpath("//div[@id='sidebar-menu']/ul/li[3]/a/span[2]")).click();
    driver.findElement(By.cssSelector("i.fa.fa-upload")).click();
    driver.findElement(By.name("questionnaireName")).clear();
    driver.findElement(By.name("questionnaireName")).sendKeys("软件需求调查");
    driver.findElement(By.name("questionName")).clear();
    driver.findElement(By.name("questionName")).sendKeys("你喜欢什么软件");
    driver.findElement(By.xpath("//form[@id='create-event-form']/div[2]/div[2]/label")).click();
    driver.findElement(By.id("createItem")).click();
    driver.findElement(By.name("questionName")).clear();
    driver.findElement(By.name("questionName")).sendKeys("为什么喜欢");
    driver.findElement(By.id("createItem")).click();
    driver.findElement(By.linkText("确认题目")).click();
    driver.findElement(By.linkText("确认题目")).click();
    driver.findElement(By.linkText("确认问卷")).click();
    driver.findElement(By.cssSelector("li.active > a > span.sidebar-title")).click();
    driver.findElement(By.linkText("请单击")).click();
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
