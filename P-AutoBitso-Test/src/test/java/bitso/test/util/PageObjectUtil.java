/**
 * @author choucair
 * @version 2.0
 */
package bitso.test.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PageObjectUtil {

	// singleton
	private static PageObjectUtil obj = null;
	private long wdwTimeOut = 5L;

	private PageObjectUtil() {
	}

	public static PageObjectUtil getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new PageObjectUtil();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public void seleniumClick(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(1.5);
			}
		}
	}

	public String seleniumGetText(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		String texto ="";
		int count=1;
		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			do {
				texto = we.getText();
				sleep(1.5);
				count++;
			}while(!we.isDisplayed() || count==10);			
		}
		return texto;
	}

	public void seleniumWrite(WebDriver webDriver, final String path, int pos, String valor) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(0.25);
				we.clear();
				we.sendKeys(valor);

				sleep(1);
			}
		}
	}
	
	
	public void seleniumTypeESCKey(WebDriver webDriver, final String path, int pos) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					robot.keyRelease(KeyEvent.VK_ESCAPE);

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
	}
	
	public void seleniumSelectCombo(WebDriver webDriver, final String path, int pos, String valor) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();			
				Select select=new Select(we);
				select.selectByVisibleText(valor);
				sleep(1);
			}
		}
	}
	
	public WebElement seleniumGetWebElement(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			return we;
		}else
			return null;
	}

	
	public void seleniumScrolltoElementJScript(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		
		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			JavascriptExecutor jse1 = (JavascriptExecutor) webDriver;
			jse1.executeScript("arguments[0].scrollIntoView(false); arguments[0].scrollIntoView({block: 'center'});", we);
			sleep(1);
		}
	}
	
	
	public void sleep(double seg) {
		long miliseg = (new Double(seg * 1000)).longValue();

		try {
			// System.out.println("sleep:\t\t" + seg + " seg... <--> " + miliseg +
			// "miliseg...");
			Thread.sleep(miliseg);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}


	/**
	 * 
	 * @param webDriver
	 * @param xpath
	 */
	public void verificarCarga(WebDriver webDriver, String xpath) {
		WebDriverWait wdw = new WebDriverWait(webDriver, 120);
		wdw.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}


	/**
	 * 
	 * @param webDriver
	 * @param path
	 * @param time
	 */
	public void loading(WebDriver webDriver, final String path, double time) {
		System.out.print("loading:");
		sleep(2.5);
		long t1 = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(webDriver, 900);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
		sleep(time);
		long t2 = System.currentTimeMillis();
		System.out.println("\t" + ((t2 - t1) / 1000d) + " seg...");
	}

}
