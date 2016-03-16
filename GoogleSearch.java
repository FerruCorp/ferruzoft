package tarea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {

	private static WebDriver driver = null;
	private static String url = "http://www.google.com.pe";
	private static Util util = new Util();

	private static void doSearch(String searchQuery, String[] arrPages) throws InterruptedException{
		
		driver.get(url);
		
		WebElement txtSearch = driver.findElement(By.name("q"));
		
		txtSearch.sendKeys(searchQuery);
		
		util.sleep(2500);
		
		WebElement btnSearch = driver.findElement(By.xpath(".//button[@name='btnG']"));
		
		btnSearch.click();
		
		util.sleep(1500);
		
		util.printMessage("################# Search: " + searchQuery + " ###########################");
				
		for (int i = 0; i < arrPages.length; i++) {
			
			show_results_count(arrPages[i]);
			
		}
		
		util.printMessage("##############################################################################");
		
		
	}
	
	private static void show_results_count(String page) throws InterruptedException{
		
		util.printMessage("--------------------------- " + page.toUpperCase() + " TAB ---------------------------------------");
		driver.findElement(By.xpath(".//a[text()='"+ page +"']")).click();	
		util.sleep(3000);
		WebElement results = driver.findElement(By.id("resultStats"));
		util.printMessage("Results: " + util.getNumber(results.getText()));
		util.printMessage("------------------------------------------------------------------------------");
				
	}
	

		
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	    driver  = new FirefoxDriver();
		
	    String[] arrSearches = {"puppies","rats"};
	    String[] arrPages = {"Vídeos","Noticias"};
	    
	    for (int i = 0; i < arrSearches.length; i++) {
			
	    	doSearch(arrSearches[i],arrPages);
	    	
		}
		
		driver.close();

	}

}
