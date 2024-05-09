package lesson3.webelemnt_methods;

import driver_init.DriverInit;
import org.openqa.selenium.*;
import utils.Urls;

public class WebElementExampleClass2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.accountPage);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        }catch (NoSuchElementException e){
            System.out.println("No cookies button");
        }
        WebElement createAccountButton = driver.findElement(By.cssSelector(".btn-primary"));

        //getText
        System.out.println("Text: " + createAccountButton.getText());
        //getTagName
        System.out.println("TagName: " + createAccountButton.getTagName());
        //getCssValue
        System.out.println("Css value of background: " + createAccountButton.getCssValue("background"));
        //getAttribute
        System.out.println("Attribute value: " + createAccountButton.getAttribute("type"));
        //getSize, getWidth, getHeight
        System.out.println("Size of element: " + createAccountButton.getSize());
        System.out.println("Width of element: " + createAccountButton.getSize().width);
        System.out.println("Height of element: " + createAccountButton.getSize().height);
        Dimension dimension = new Dimension(20, 23);

        System.out.println("==================");

        //getCoordinates and Location
        System.out.println("Coordinates of left top corner: " + createAccountButton.getLocation());
        System.out.println("X coordinate of left top corner: " + createAccountButton.getLocation().x);
        System.out.println("Y coordinate of left top corner: " + createAccountButton.getLocation().y);

        int centreX = createAccountButton.getLocation().x + createAccountButton.getSize().width/2;
        int centreY = createAccountButton.getLocation().y + createAccountButton.getSize().height/2;

        Point centreOfElement = new Point(centreX, centreY);
        System.out.println("Coordinates of centre: " + centreOfElement);

        driver.quit();

    }
}
