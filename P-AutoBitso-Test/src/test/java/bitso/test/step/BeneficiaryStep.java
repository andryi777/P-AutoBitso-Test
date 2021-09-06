package bitso.test.step;

import bitso.test.page.AppBeneficiaryPage;
import bitso.test.page.AppHomePage;

public class BeneficiaryStep {

	private AppHomePage appAppHomePage;
	private AppBeneficiaryPage appBeneficiaryPage; 
	
	public void selectPerfil() {
		appAppHomePage.goPerfil();
	}
	
	public void selectBeneficiary() {
		appBeneficiaryPage.selectBeneficiary();
	}
	
	public void registerBeneficiary(String name, String lastname1, String lastname2, String datebirth, String relationship, String relationshipPercentage) {
		appBeneficiaryPage.registerBeneficiary(name, lastname1, lastname2, datebirth, relationship, relationshipPercentage);
	}
	
	public boolean getConfirmation() {
		return appBeneficiaryPage.getWindowConfirmation();
	}
	
}
