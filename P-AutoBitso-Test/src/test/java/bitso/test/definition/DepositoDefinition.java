package bitso.test.definition;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.swing.JOptionPane;

import bitso.test.step.DepositoStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DepositoDefinition {

	String user="bistotestchallenge@gmail.com";
	String pass="Challenge1.";
	
	@Steps
	private DepositoStep depositoStep;
		
	@Given("^access to the web BitsoTest with Mexican mail$")
	public void access_to_the_web_BitsoTest_with_Mexican_mail() {
		depositoStep.ingresoBitsoTest(user, pass);
	}
	
	@Given("^select criptocurrency \"([^\"]*)\"$")
	public void select_criptocurrency(String criptoCode) {
		depositoStep.selectCurrency(criptoCode);
	}	
	
	@When("^select depositar$")
	public void select_depositar() {
		depositoStep.selectDepositar();
	}

	@Then("^should appear a message \"([^\"]*)\"$")
	public void validate_message(String mensaje) {
		String titleMessage = mensaje.substring(0, mensaje.indexOf("-"));
		String detailMessage = mensaje.substring(mensaje.indexOf("-")+1, mensaje.length());
		System.out.println(titleMessage +":"+detailMessage);
		List<String> result = depositoStep.getListMessageError();
		assertEquals(result.get(0), titleMessage);
		assertEquals(result.get(1), detailMessage);
	}

}
