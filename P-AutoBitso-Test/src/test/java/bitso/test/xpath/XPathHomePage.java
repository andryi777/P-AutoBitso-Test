package bitso.test.xpath;

public class XPathHomePage {
	
	// singleton
	private static XPathHomePage obj = null;

	private XPathHomePage() {
	}

	public static XPathHomePage getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XPathHomePage();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public final String opcCriptoBTC="//label[@for='btc']";
	public final String opcCriptoBAT="//label[@for='bat']";
	public final String opcCriptoBCH="//label[@for='bch']";
	public final String opcCriptoCOMP="//label[@for='comp']";
	public final String opcCriptoDAI="//label[@for='dai']";
	public final String opcCriptoETH="//label[@for='eth']";
	public final String opcCriptoLTC="//label[@for='ltc']";
	public final String opcCriptoMANA="//label[@for='mana']";
	public final String opcCriptoTUSD="//label[@for='tusd']";
	public final String opcCriptoUSDT="//label[@for='usdt']";
	public final String opcCriptoXRP="//label[@for='xrp']";
	public final String btnDepositar="//*[@class='moon-arrow_deposit']";
	public final String lblTituloMensajeError="//*[@class='modal-content']/.//h3";
	public final String lblDetalleMensajeError="//*[@class='modal-content']/.//small"; 
	
	public final String menuPerfil ="//*[@class='styles__WrapperLabel-sc-1wdqgcn-1 jfUuiF' and contains(text(), 'Perfil')]";
	public final String subMenuPerfil ="//a[contains(@href,'r/user/overview')]";

}
