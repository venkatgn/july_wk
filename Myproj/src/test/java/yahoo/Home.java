package yahoo;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Home 
{
	WebDriver driver;
	
	public Home(WebDriver driver)
	{
		this.driver=driver;
	}
	public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.yahoomail.com");
	}
	public void validate_links()
	{
		open();
		String lnks[]={"About Mail","Features","Get App","Help"};
		WebElement w=driver.findElement(By.xpath("//*[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px)']"));
		List<WebElement> lst=w.findElements(By.tagName("a"));
		for(int i=0;i<lst.size();i++)
		{
			if(lst.get(i).getText().trim().matches(lnks[i]))
			{
				Reporter.log("<font color='green'><b>link is matching</b></font>"+lnks[i]);
			}
			else
			{
				Reporter.log("<font color='red'><b>link is NOT matching</b></font>"+lnks[i]);
			}
		}
		
	}
	public void login()
	{
		open();
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.name("passwd")).sendKeys("mq123456");
		driver.findElement(By.name("signin")).click();	
	}
	public void createacc() throws Exception
	{
		open();
		driver.findElement(By.xpath("//*[@id='login-signup']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("firstname")).sendKeys("abcd");
		
		
		
		driver.findElement(By.xpath("//*[@class='country-code-arrow']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-code='91']")).click();
		driver.findElement(By.id("mobile")).sendKeys("8989898989");
		
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("March");
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("20");
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1984");
		
		driver.findElement(By.id("male")).click();	
	}

}
