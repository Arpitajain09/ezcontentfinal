package ezcontent.qa.util;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


import ezcontent.qa.base.TestBase;

public class TestUtil extends TestBase {


//	public static long PageLoadTimeout = 20;
//	public static long ImplicitWait = 10;
static String currentDirec= System.getProperty("user.dir");
 
	
	

	
	public static Select select;
	public static Actions action;

	//Navigate to any url
	public static void navigateToURL(String url)
	{
		driver.navigate().to(url);

	}	
	
	// Switch by Index
	public static void switchFrameByIndex(int index)
	{
		driver.switchTo().frame(index);
	}

    //Switch by frame name
	public static void switchFrameByName(String name)
	{
		driver.switchTo().frame(name);
	}

	// Switch by frame ID

public static void switchFrameById(String frameId)
{
	driver.switchTo().frame(frameId);
}


public static void switchFrameByWebElement(WebElement frameElement)
{
	driver.switchTo().frame(frameElement);
}

    
	// Switch back to the main window from iframe
	public static void switchBackToWindow() {

		driver.switchTo().defaultContent();
	}

	// switch to simple alert
	public static void switchToSimpleAlert() {
	Alert simpleAlert = driver.switchTo().alert();
	 String alertText = simpleAlert.getText();
	 System.out.println("Alert text is " + alertText);
	 simpleAlert.accept();
	 }
	 
	 // Clear any field
     public static void clearField(WebElement element)
     {
         try {
             element.clear();
         } catch (Exception e) {
             System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));

         }
        }
         
     public static void scrollToEndOfPage() {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
 		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
     }
     
     
   
     public static String timeStamp() {
    	 return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());


     }


     public static String timeStampByDate() {
    	 return new SimpleDateFormat("yyyy-MM-dd").format(new Date());


     }
     
     //To capture screenshot
     public static String captureScreenshot() {
    	 
    	 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 String fileWithPath = currentDirec+File.separator+"test-output"+File.separator+timeStamp()+".png"; 
    	 File DestFile=new File(fileWithPath); 
    	 try {
			FileUtils.copyFile(srcFile,DestFile );
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		 return fileWithPath;
    	 
     }
     
     public static void jsExecuterClick(WebElement element) {
    	 JavascriptExecutor jse = (JavascriptExecutor)driver;
 		jse.executeScript("arguments[0].click();", element); 
    	 
     }

     public static void scrollToPixel() {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
 		js.executeScript("window.scrollTo(0, 500)");
     }

     
     // Click any element
     public static void onClick(WebElement element)
 	 {
 		element.click();
 	 }
 	
     //select value from drop-down by index
 	 public static void selectByIndex(WebElement element , int index)
 	 {
 		 new Select(element).selectByIndex(index);	
 	 }
 	
 	//select value from drop-down by value
 	 public static void selectByValue(WebElement element , String value)
 	 {
 		new Select(element).selectByValue(value);
 	}
 	
 	//select value from drop-down by visible text
 	 public static void selectByText(WebElement element,String Text) 
 	{
 		new Select(element).selectByVisibleText(Text);
 	}
 	
 	//Mouse Hover
 	 public static void mouseHover(WebElement element)
	 {
		new Actions(driver).moveToElement(element).perform();
		
	 }
	
 	//mouseClick
	public static void mouseClick(WebElement element)
    {
		
		new Actions(driver).click(element).perform();
	}
	
	// scroll down
	public static void scroll(int startdimension, int enddimension) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + String.valueOf(startdimension) + "," + String.valueOf(enddimension) + ")");

	}

}
