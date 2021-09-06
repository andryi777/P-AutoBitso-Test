package bitso.test.page;

import java.util.List;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import bitso.test.util.PageObjectUtil;
import bitso.test.xpath.XPathBeneficiaryPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppBeneficiaryPage extends PageObject  {

	private long wdwTimeOut = 300L;
		
	// xpath
	protected XPathBeneficiaryPage xPathBeneficiaryPage = XPathBeneficiaryPage.getInstancia();

	// util
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(AppBeneficiaryPage.class.getName());

	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	public void selectBeneficiary() {
		pageObjectUtil.seleniumScrolltoElementJScript(getDriver(), xPathBeneficiaryPage.opcBeneficiarios, 0);
		pageObjectUtil.seleniumClick(getDriver(), xPathBeneficiaryPage.opcBeneficiarios, 0);	
		looger.info("Se selecciona la opción Beneficiario");
	}

	public void registerBeneficiary(String name, String lastname1, String lastname2, String datebirth, String relationship, String relationshipPercentage){
		pageObjectUtil.seleniumClick(getDriver(), xPathBeneficiaryPage.btnAgregar, 0);

		String dia = datebirth.substring(0, 2);
		String mes = datebirth.substring(3, 5);
		String anio= datebirth.substring(6, 10);
		
		pageObjectUtil.seleniumScrolltoElementJScript(getDriver(), xPathBeneficiaryPage.txtNombre, 0);
		pageObjectUtil.seleniumClick(getDriver(), xPathBeneficiaryPage.txtNombre, 0);
		pageObjectUtil.seleniumWrite(getDriver(), xPathBeneficiaryPage.txtNombre, 0, name);
		pageObjectUtil.seleniumWrite(getDriver(), xPathBeneficiaryPage.txtPrimerApellido, 0, lastname1);
		pageObjectUtil.seleniumWrite(getDriver(), xPathBeneficiaryPage.txtSegundoApellido, 0, lastname2);	
		Serenity.takeScreenshot();
		pageObjectUtil.seleniumScrolltoElementJScript(getDriver(), xPathBeneficiaryPage.txtDiaNacimiento, 0);
		pageObjectUtil.seleniumWrite(getDriver(), xPathBeneficiaryPage.txtDiaNacimiento, 0, dia);
		getDriver().findElement(By.xpath(xPathBeneficiaryPage.txtDiaNacimiento)).sendKeys(Keys.DOWN,Keys.ENTER);
		pageObjectUtil.seleniumWrite(getDriver(), xPathBeneficiaryPage.txtMesNacimiento, 0, mes);
		getDriver().findElement(By.xpath(xPathBeneficiaryPage.txtMesNacimiento)).sendKeys(Keys.DOWN,Keys.ENTER);
		pageObjectUtil.seleniumWrite(getDriver(), xPathBeneficiaryPage.txtAnioNacimiento, 0, anio);	
		getDriver().findElement(By.xpath(xPathBeneficiaryPage.txtAnioNacimiento)).sendKeys(Keys.DOWN,Keys.ENTER);
		pageObjectUtil.seleniumClick(getDriver(), xPathBeneficiaryPage.cboParentesco, 0);	
		pageObjectUtil.seleniumClick(getDriver(), xPathBeneficiaryPage.seleccionarCombo(relationship), 0);
		pageObjectUtil.seleniumWrite(getDriver(), xPathBeneficiaryPage.txtPorcentajeParentesco, 0, relationshipPercentage);
		Serenity.takeScreenshot();
		pageObjectUtil.seleniumScrolltoElementJScript(getDriver(), xPathBeneficiaryPage.btnAgregar, 0);
		pageObjectUtil.seleniumClick(getDriver(), xPathBeneficiaryPage.btnAgregar, 0);
		Serenity.takeScreenshot();
		pageObjectUtil.seleniumClick(getDriver(), xPathBeneficiaryPage.txtNIP, 0);
		pageObjectUtil.seleniumWrite(getDriver(), xPathBeneficiaryPage.txtNIP, 0,"115148");
		pageObjectUtil.seleniumClick(getDriver(), xPathBeneficiaryPage.btnConfirmar, 0);
		looger.info("Se registra un beneficiario");
		Serenity.takeScreenshot();
		
	}
	
	public boolean getWindowConfirmation() {
//		pageObjectUtil.seleniumGetWebElement(getDriver(), "", 0).isDisplayed();
		return false;
	}
}
