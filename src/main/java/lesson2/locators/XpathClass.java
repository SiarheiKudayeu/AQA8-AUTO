package lesson2.locators;

import driver_init.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class XpathClass {
    public static void main(String[] args) throws InterruptedException {
        // полный xpath /html/body/div[1]/main/div/section/div/div[3]/a
        // относительный xpath //div[@class='columned block block-4-12']

        //By.xpath with text
        WebDriver driver = DriverInit.setUpDriver();
        /*driver.get("https://www.guinnessworldrecords.com/search?term=%2A#");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Tallest man");
        driver.findElement(By.xpath("//*[text()='Search']")).click();

        //By.xpath contains
        Thread.sleep(4000);
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //contains with text
        driver.findElement(By.xpath("//a[contains(text(), 'LICATION PROC')]")).click();
        //contains with attribute value
        List<WebElement> webElementList = driver.findElements(By.xpath("//a[contains(@href, 's/showcase')]"));
        System.out.println(webElementList.size());
        webElementList.get(10).click();
        Thread.sleep(4000);
        //contains not
        //div[contains(@class, 'block block-4-12')][not(contains(@class, 'columned'))]
        //*[@id='Username'][@autofocus='autofocus']*/

        //относительный путь внутри относительного пути
        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        Thread.sleep(2000);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        }catch (NoSuchElementException e){
            System.out.println("No cookies button");
        }
        driver.findElement(By.xpath("(//div[@class='container'])[1]//*[@id='Username']")).sendKeys("AQA8");


        //xpath передвижение по DOM дереву
    /*
        /.. - вверх по тегу
        /имя_тега - вниз к указанному тегу
        переход на родительский тег - /parent::div
        переход на дочерний тег - /child::a
        переход на параллельный тег - /following - sibling:: *[1]
        предок - / ancestor::span
        потомок        / descendant::h3
        */

        driver.findElement(By.xpath("//label[@for='Password']/../following-sibling::div/input")).sendKeys("PASS");

        //xpath - операторы >, <, >=, <=, !=
        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-val-length-max!=100]")).sendKeys("email");
        driver.findElement(By.xpath("//input[@data-val-length-max<200]")).sendKeys("passsssss");

    }
}
