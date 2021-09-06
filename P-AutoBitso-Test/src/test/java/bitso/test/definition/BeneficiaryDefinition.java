package bitso.test.definition;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import bitso.test.step.BeneficiaryStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BeneficiaryDefinition {

	@Steps
	private BeneficiaryStep beneficiaryStep;
	
	@Given("^select menu Perfil-Perfil$")
	public void select_menu_Perfil_Perfil() {
		beneficiaryStep.selectPerfil();
	}

	@When("^select beneficiarios$")
	public void select_beneficiarios() {
		beneficiaryStep.selectBeneficiary();
	}

	@When("^register one beneficiario with name \"([^\"]*)\", lastname1 \"([^\"]*)\", lastname2 \"([^\"]*)\", datebirth \"([^\"]*)\", relationship \"([^\"]*)\", relationshippercentage \"([^\"]*)\"$")
	public void register_one_beneficiario_with_name_lastname_lastname_datebirth_relationship_relationshippercentage(String name, String lastname1, String lastname2, String datebirth, String relationship, String relationshipPercentage) {
		beneficiaryStep.registerBeneficiary(name, lastname1, lastname2, datebirth, relationship, relationshipPercentage);
	}

	@Then("^should appear a confirmation window$")
	public void should_appear_a_confirmation_window() {
		assertTrue(beneficiaryStep.getConfirmation());
	}
	
}
