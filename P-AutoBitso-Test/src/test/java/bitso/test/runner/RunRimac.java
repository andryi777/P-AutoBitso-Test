package bitso.test.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

import org.junit.runner.RunWith;
	
	@RunWith(RunPersonalizar.class)

//	@CucumberOptions(features = { "src/test/resources/features/" }, tags = { "@MakeDeposit" }, glue = { "bitso" })
//	@CucumberOptions(features = { "src/test/resources/features/" }, tags = { "@AddBeneficiary" }, glue = { "bitso" })
	@CucumberOptions(features = { "src/test/resources/features/" }, tags = { "@tag" }, glue = { "bitso" })
	
public class RunRimac {

}

		