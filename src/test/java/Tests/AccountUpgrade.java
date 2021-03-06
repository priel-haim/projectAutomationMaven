package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ChooseASubscriptionThatSuitsYou;
import PageObject.LoginPage;
import PageObject.MyWorkspace;
import PageObject.YouAreAlmostOnStarter;

public class AccountUpgrade extends BaseTest {
	private String[] paymentDetails = { "Haim Navon", "4580-0303-3333-8353", "1226", "333", "ert54v6" };
	private String[] BillingDetails = { "Haim", "Navon", "PHA", "p-azoulay@gmail.com", "052-2345672", "Rakefet", "15",
			"99000", "bait shemesh", "IL" };
	private String payment = "Your order summary";

	@Test(description = "Sign in with my name details")
	public void tc01_OpenLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		String expected = "Haim-a";
		String actual = loginPage.GetMyLogin();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "click on the button to upgrade")
	public void tc02_ChooseUpgrate() {
		MyWorkspace myWorkspace = new MyWorkspace(driver);
		String Upgrade = myWorkspace.GetUpgrade();
		myWorkspace.ClickUpgrade();
		Assert.assertEquals("Upgrade ⭐", Upgrade);
	}

	@Test(description = "choose in upgrade")
	public void tc03_chooseTypeUpgrade() {
		ChooseASubscriptionThatSuitsYou chooseSuitable = new ChooseASubscriptionThatSuitsYou(driver);
		String Type = chooseSuitable.GetChooseTypeUpgade();
		chooseSuitable.TypeUpgrade("Get Business monthly");
		Assert.assertEquals(Type, "Get Business monthly");

	}

	@Test(description = "The details of the means of payment, and personal details should be stated")
	public void tc04_FillInDetails() {
		YouAreAlmostOnStarter starter = new YouAreAlmostOnStarter(driver);
		starter.yourPaymentDetails(paymentDetails);
		starter.yourBillingDetails(BillingDetails);
		starter.yourOrderSummary();
		Assert.assertTrue(starter.yourOrderSummaryy().contentEquals(payment));
	}

}
