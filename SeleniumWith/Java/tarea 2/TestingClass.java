package ejercicio;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestingClass {

	public static WebDriver driver = null;
	private static String url = "http://puppies.herokuapp.com/";
	private static Util util = new Util();

	private static void adoptAPuppieWithTwoItems(){
		
		//.//label[.='AutoCustomCreditorBit400']/following-sibling::div//input[@type='checkbox']
		String[] arrProducts = {"collar","toy","carrier","vet"};
		
		Random randomGenerator = new Random();		
		
		int count = 0;
		
		do{
			
			String name = arrProducts[randomGenerator.nextInt(4)];			
			
			WebElement check = util.findOne(By.xpath("//input[@name='"+ name +"']"));
			
			if(!check.isSelected()){
				
				check.click();				
				count++;
				
			}
			
			
		}while(count <= 1);		
		
	}
	
	private static void adoptAPuppieWithAllItems(){
			
			List<WebElement> list_check = util.findAll(By.xpath("//input[@type='checkbox']"));			
	
			for (WebElement check : list_check) {
				
				  check.click();				
				
			}
			
	}
	
	private static void adoptAPuppieWitItemsByPrice(double expectedPrice){
		
			
		List<WebElement> listPrices = util.findAll(By.xpath(".//input[@type='checkbox']/.."));
		
		for (WebElement price : listPrices) {
			
			String originalPrice = price.getText();
			
			double realPrice = Double.parseDouble(originalPrice.substring(originalPrice.indexOf("$") + 1,originalPrice.lastIndexOf(")")));
			
			if( expectedPrice == realPrice){
				
				price.click();
				break;
			}
			
		}		
		
	}
	
	
	private static void selectFirst(){
				
		WebElement button = util.findOne(By.xpath("(//input[@type='submit'])[1]"));
		button.click();		

	}
	
	private static void adoptMe(){
		
		WebElement button = util.findOne(By.xpath("//input[@type='submit']"));
		button.click();		

	}
	
	private static void completeAdoption(){
		
		WebElement button = util.findOne(By.xpath("(.//input[@class='rounded_button'])[1]"));
		button.click();		

	}
	
	private static void fillForm(){
		
		WebElement txtName = util.findOne(By.xpath(".//label[.='Name']/following-sibling::input"));
		WebElement txtAddress = util.findOne(By.xpath(".//label[.='Address']/following-sibling::textarea"));
		WebElement txtEmail = util.findOne(By.xpath(".//label[.='Email']/following-sibling::input"));		
		Select cboPayType = new Select(util.findOne(By.xpath(".//label[.='Pay type']/following-sibling::select")));
		
		txtName.sendKeys("Carolina");
		txtAddress.sendKeys("Callao");
		txtEmail.sendKeys("aluckypets@gmail.com");		
		cboPayType.selectByValue("Check");
		
		WebElement btnPlaceOrder = util.findOne(By.xpath(".//input[@name='commit']"));
		
		btnPlaceOrder.click();		
		
	}
	

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    driver  = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	    driver.get(url);
	    
	    selectFirst();
	    adoptMe();
	    adoptAPuppieWithTwoItems();
	    completeAdoption();
	    fillForm();
	    
	    selectFirst();
	    adoptMe();
	    adoptAPuppieWithAllItems();
	    completeAdoption();
	    fillForm();
	    
	    selectFirst();
	    adoptMe();
	    double expectedPrice = 8.99;
	    adoptAPuppieWitItemsByPrice(expectedPrice);
	    completeAdoption();
	    fillForm();
	    
		driver.close();

	}

}
