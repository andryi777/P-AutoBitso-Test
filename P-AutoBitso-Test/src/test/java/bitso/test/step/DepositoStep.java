package bitso.test.step;

import java.util.List;

import bitso.test.page.AppHomePage;
import bitso.test.page.AppLoginPage;

public class DepositoStep {

	private AppLoginPage appAppLoginPage;
	private AppHomePage appAppHomePage;
	
	public void ingresoBitsoTest(String user, String pass) {
		appAppLoginPage.inicializar("https://devmalta.bitso.com/");		
		appAppLoginPage.login(user, pass);
	}
	
	public void selectCurrency(String currencyType) {
		appAppHomePage.selectCurrency(currencyType);
	}
	
	public void selectDepositar() {
		appAppHomePage.selectDepositar();
	}
		
	public List<String> getListMessageError() {
		List<String> ListMessageError = appAppHomePage.getMessageError();
		return ListMessageError;
	}
	
}
