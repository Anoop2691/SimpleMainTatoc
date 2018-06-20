package automationFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class Box {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\anoopkumar\\Downloads\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
           System.out.println("Chrome is opened");
           driver.get("http://10.0.1.86/tatoc/");
           System.out.println("tatoc is selected");
           driver.findElement(By.linkText("Basic Course")).click();
           driver.findElement(By.className("greenbox")).click();    
           String Box1Color="",Box2Color="";
          Box1Color=driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
          do {
        	  Box2Color=driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");;
        	  driver.switchTo().parentFrame();
        	  if(Box1Color.equals(Box2Color)) {
        		  driver.findElement(By.linkText("Proceed")).click();
        	  }
        	  else {
        		  driver.findElement(By.linkText("Repaint Box 2")).click();
        	  }
          }while(!Box1Color.equals(Box2Color));
          new Actions(driver).dragAndDrop(driver.findElement(By.id("dragbox")),driver.findElement(By.id("dropbox"))).perform();
          driver.findElement(By.linkText("Proceed")).click();
          driver.findElement(By.linkText("Launch Popup Window")).click();
          String winHandleBefore = driver.getWindowHandle();
          for(String winHandle : driver.getWindowHandles()){
        	  driver.switchTo().window(winHandle);
          }
          WebElement we=driver.findElement(By.id("name"));
          we.sendKeys("Anoop Kumar");
          driver.findElement(By.id("submit")).click();
          driver.switchTo().window(winHandleBefore);
          driver.findElement(By.linkText("Proceed")).click();
          driver.findElement(By.linkText("Generate Token")).click();
          String c=driver.findElement(By.id("token")).getText();
          String[] str=c.split(" ");
          Cookie ck=new Cookie("Token", str[str.length-1]);
          driver.manage().addCookie(ck);
         driver.findElement(By.linkText("Proceed")).click();
        // driver.close();
	}
}
