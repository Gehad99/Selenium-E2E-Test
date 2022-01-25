package SurveyTask.SurveyTask;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPOM extends ElementHelper{
	
	

	public DashboardPOM(WebDriver driver) {
		super(driver);
		
	}
	
	int [] ValuesBefore = new int [3];
	int [] ValuesAfter = new int [3];
	
	
	
	// total N of the first question
	private By FirstTotalN = By.xpath("(//*[@class='highcharts-credits' and @text-anchor='end'])[3]");
	
	// total N of the Second question
	private By SecondTotalN = By.xpath("(//*[@class='highcharts-credits' and @text-anchor='end'])[2]");

	// total N of the Third question
	private By ThirdTotalN = By.xpath("(//*[@class='highcharts-credits' and @text-anchor='end'])[1]");

	
	public void getTotalNBefore(){
		
		ValuesBefore [0] = Integer.parseInt(getText(FirstTotalN).replaceAll("\\D+",""));
		ValuesBefore [1] = Integer.parseInt(getText(SecondTotalN).replaceAll("\\D+",""));
		ValuesBefore [2] = Integer.parseInt(getText(ThirdTotalN).replaceAll("\\D+",""));
		
	}
	
	public void getTotalNAfter(){
		
		ValuesAfter [0] = Integer.parseInt(getText(FirstTotalN).replaceAll("\\D+","")); 
		ValuesAfter [1] = Integer.parseInt(getText(SecondTotalN).replaceAll("\\D+","")); 
		ValuesAfter [2] =Integer.parseInt(getText(ThirdTotalN).replaceAll("\\D+","")); 
	}
	
	public void navigateToDashboard() {
		
		driver.navigate().to("https://app.quantilope.com/share/WJvveDz5BDzwSDYBX?type=dashboard");
	}
	
	public void assertValuesBeforeAfter() {
		
		for(int i =0 ;i< ValuesBefore.length; i++) {
			
			assertEquals(Integer.toString(ValuesBefore[i] +1),Integer.toString(ValuesAfter[i]));
		}
		
	}
	
}
