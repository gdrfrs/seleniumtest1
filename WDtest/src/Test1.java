import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class Test1 {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws Exception {
		Double PriceSJ=myFunction("SFO","JFK");
		System.out.println("Price from SFO to JFK is "+PriceSJ);
		
		Double PriceJP=myFunction("JFK","PHL");
		System.out.println("Price from JFK to PHL is "+PriceJP);
		
		if (PriceSJ==PriceJP){
			System.out.println("The same price");
		}
		else if (PriceSJ>PriceJP){
			System.out.println("Cheaper to go from JFK to PHL ");
		}
		else {
			
			System.out.println("Cheaper to go from SFO to JFK ");
			
		}
			

	}
	public static Double myFunction(String fromDest, String toDest)throws Exception {
		
		
		// Open Firefox
				WebDriver wd = new FirefoxDriver();
				//Goto 
				wd.get("http://www.orbitz.com");
				// click 
				wd.findElement(By.id("tab-flight-tab")).click();
				// wait
				Thread.sleep(5000);
				// enter text
				//wd.findElement(By.id("package-origin")).clear();
				wd.findElement(By.id("flight-origin-label")).sendKeys(new String[]{fromDest});
				//wd.findElement(By.id("package-origin")).clear();
				wd.findElement(By.id("flight-destination")).sendKeys(new String[]{toDest});
				wd.findElement(By.id("flight-departing")).clear();
				wd.findElement(By.id("flight-departing")).sendKeys(new String[]{"04/15/2016"});
				wd.findElement(By.id("flight-returning")).clear();
				wd.findElement(By.id("flight-returning")).sendKeys(new String[]{"04/18/2016"});
				
				wd.findElement(By.id("search-button")).click();
				
				Thread.sleep(20000);
				
				String price = wd.findElement(By.xpath(".//*[@id='flight-module-wl_']/div/div[3]/span[2]")).getText();
				double dprice=Double.parseDouble(price.replace("$", ""));
				//System.out.println("The lowest price: "+ price);
				
				wd.close();	
				return dprice;
	}

}
