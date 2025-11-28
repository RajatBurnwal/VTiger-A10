package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkFacebook {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for(WebElement link:allLinks)
		{
			String url = link.getAttribute("href");
			if(!url.isEmpty() && !url.equals(null))
			{
				URL u = new URL(url);
				HttpURLConnection h = (HttpURLConnection)u.openConnection();
				h.connect();
				if(h.getResponseCode()>=400)
				{
					System.out.println("This link is broken: "+link.getText());
				}
			}
		}
	}

}
