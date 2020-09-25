package runner;		

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;

/**
 * @author Swathi
 * Test Runner class contains the location of the feature file
 * and path of the step definition class
 */
@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"stepDefinitions"})						
public class TestRunner 				
{
	//Test runner class executes the test as a cucumber test
}	
