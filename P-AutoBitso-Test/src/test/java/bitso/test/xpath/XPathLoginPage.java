package bitso.test.xpath;

public class XPathLoginPage {
	// singleton
	private static XPathLoginPage obj = null;

	private XPathLoginPage() {
	}

	public static XPathLoginPage getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XPathLoginPage();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public final String lnkIniciaSesion = "//a[contains(@href,'/login')]";
	public final String txtUser =  "//*[@name='client_id']";
	public final String txtPass =  "//*[@name='password']";
	public final String btnIniciaSesion = "//button[@type='submit']";
	
}
