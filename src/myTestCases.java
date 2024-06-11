import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	
	WebDriver driver = new ChromeDriver();
	String myUrl = "https://www.saucedemo.com/inventory.html";
	String userName = "standard_user";
			
	String password ="secret_sauce";
	
	
	@BeforeTest
	public void mySetup () {
		
		driver.get(myUrl);
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void myfirstTest () {
		
		// List
		// String [] myStudents = {"ahmad","anas","omar","eman","layan","ethar"};
	//	System.out.println(myStudents[0].click());
		
		//List
		
		
		WebElement userNameInput = driver.findElement(By.id("user-name"));
		userNameInput.sendKeys(userName);
		
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		
	}

	@Test (priority =2, enabled=false)
	public void addAllItems() {
		
	List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"))  ;
	
	for (int i=0; i< myAddToCartButtons.size();i++ ) {
		myAddToCartButtons.get(i).click();
	}
	
	
	}
	
	@Test (priority =3,enabled = false)
	public void addOneItemAndSkipTheNext() {
		
	List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"))  ;
	
	for (int i=0; i< myAddToCartButtons.size();i++ ) {
		
	
		if (i==2) {
			continue;
			}
		myAddToCartButtons.get(i).click();
		}
	}
	
	@Test (priority =4)
	public void findAllElementsThatHasTheTextLabt() {
		
	List<WebElement> itemsNames = driver.findElements(By.className("inventory_item_name"))  ;
	List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"))  ;
	
	for (int i=0; i< itemsNames.size();i++ ) {
		String itemName = itemsNames.get(i).getText();
		if(itemName.contains("Labs"))
	
			myAddToCartButtons.get(i).click();
		}
	}
	
	}
	

