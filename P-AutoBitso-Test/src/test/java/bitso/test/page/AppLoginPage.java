package bitso.test.page;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import bitso.test.util.PageObjectUtil;
import bitso.test.xpath.XPathLoginPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppLoginPage extends PageObject {

	private long wdwTimeOut = 300L;
	
	protected XPathLoginPage xpathLoginPage = XPathLoginPage.getInstancia();

	// util
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(AppLoginPage.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void inicializar(String url) {
		getDriver().navigate().to(url);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		Serenity.takeScreenshot();
	}

	public void login(String user, String pass) {
		pageObjectUtil.seleniumClick(getDriver(), xpathLoginPage.lnkIniciaSesion, 0);
		
		pageObjectUtil.seleniumClick(getDriver(), xpathLoginPage.txtUser, 0);
		pageObjectUtil.seleniumWrite(getDriver(), xpathLoginPage.txtUser, 0, user);
		pageObjectUtil.seleniumWrite(getDriver(), xpathLoginPage.txtPass, 0, pass);
		
		Serenity.takeScreenshot();
		pageObjectUtil.seleniumScrolltoElementJScript(getDriver(), xpathLoginPage.btnIniciaSesion, 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathLoginPage.btnIniciaSesion, 0);
		
		looger.info("Login realizado");
		
	}
	
}
