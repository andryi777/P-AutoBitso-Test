package bitso.test.page;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import bitso.test.util.PageObjectUtil;
import bitso.test.xpath.XPathHomePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppHomePage extends PageObject {

	private long wdwTimeOut = 300L;
		
	// xpath
	protected XPathHomePage xpathHomePage = XPathHomePage.getInstancia();

	// util
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(AppLoginPage.class.getName());

	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	public void selectCurrency(String currencyType) {
		switch(currencyType){
			case "BTC"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoBCH, 0); break;
			case "BAT"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoBAT, 0); break;
			case "BCH"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoBCH, 0); break;
			case "COMP"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoCOMP, 0); break;
			case "DAI"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoDAI, 0); break;
			case "ETH"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoETH, 0); break;
			case "LTC"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoLTC, 0); break;
			case "MANA"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoMANA, 0); break;
			case "TUSD"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoTUSD, 0); break;
			case "USDT"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoUSDT, 0); break;
			case "XRP"	: pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.opcCriptoXRP, 0); break;
		}
		looger.info("Se selecciono el tipo de cripto: " + currencyType);
		Serenity.takeScreenshot();
	}
	
	public void selectDepositar(){
		pageObjectUtil.seleniumScrolltoElementJScript(getDriver(), xpathHomePage.btnDepositar, 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.btnDepositar, 0);		
		looger.info("Se selecciona depositar");
		Serenity.takeScreenshot();
	}
	
	public List<String> getMessageError() {
		List<String> ListMessage = new ArrayList<String>();
		String messageDetail = pageObjectUtil.seleniumGetText(getDriver(), xpathHomePage.lblDetalleMensajeError, 0);
		String messageTitle = pageObjectUtil.seleniumGetText(getDriver(), xpathHomePage.lblTituloMensajeError, 0);
		
		System.out.println(messageDetail+"-"+messageTitle);
		
		ListMessage.add(messageTitle);
		ListMessage.add(messageDetail);
		
		Serenity.takeScreenshot();
		
		pageObjectUtil.seleniumTypeESCKey(getDriver(), xpathHomePage.lblDetalleMensajeError, 0);
		
		looger.info("Se mostró el mensaje de error");
		return ListMessage;
	}
	
	public void goPerfil() {
		pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.menuPerfil, 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.subMenuPerfil, 0);
		looger.info("Se selecciona el menú Perfil");
	}
}
