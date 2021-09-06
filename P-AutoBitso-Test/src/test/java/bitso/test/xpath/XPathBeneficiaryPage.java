package bitso.test.xpath;

import org.openqa.selenium.By;

public class XPathBeneficiaryPage {
	// singleton
	private static XPathBeneficiaryPage obj = null;

	private XPathBeneficiaryPage() {
	}

	public static XPathBeneficiaryPage getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XPathBeneficiaryPage();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public final String opcBeneficiarios = "//a[contains(@href,'/r/user/beneficiaries')]";
	public final String txtNombre =  "//*[@name='first_name']";
	public final String txtPrimerApellido =  "//*[@name='last_name']";
	public final String txtSegundoApellido =  "//*[@name='second_last_name']";
	public final String txtDiaNacimiento =  "//*[@id='day']";
	public final String txtMesNacimiento =  "//*[@id='month']";
	public final String txtAnioNacimiento =  "//*[@id='year']";
	public final String cboParentesco =  "//label[@for='relationship']";
	public final String txtPorcentajeParentesco =  "//*[@id='percentage']";
	public final String btnAgregar =  "//button[text()='Agregar']";
	public final String txtNIP = "//*[@id='pin']";
	public final String btnConfirmar ="//button[text()='Confirmar']";
	
	public String seleccionarCombo(String varOpcion) {
		String opcion = "//*[text()='"+varOpcion+"']";
		return opcion;
	}
}
