package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ChooseProjectType;
import PageObject.LoginPage;
import PageObject.MenuPage;
import PageObject.MyWorkspace;
import PageObject.ShoppingOrderFormPage;
import PageObject.Templates;

public class ShoppingOrderForm extends BaseTest {
	private String firstName = "Eli";
	private String lastName = "Amar";
	private String email = "e-amar@gmail.com";
	private String styleName = "Time off";
	private String size = "m";
	private String shippingMethod = "Express shipping";
	private String[] address = { "hanorit", "99513513", "Beit shemesh", "Israel", "Israel" };
	private String finalTile = "Complete your order below";

	@Test(description = "Sign in with my name details")
	public void tc01_openLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		// compares between the account name and what is expected
		Assert.assertEquals(loginPage.GetMyLogin(), "Haim-a");
	}

	@Test(description = "click on START")
	public void tc02_startToProject() {
		MyWorkspace workspace = new MyWorkspace(driver);
		String Start = workspace.GetStart();
		workspace.StartProject();
		Assert.assertEquals(Start, "Start");
	}

	@Test(description = "Select the template type")
	public void tc03_openingPaymentFormPage() {
		ChooseProjectType choosePro = new ChooseProjectType(driver);
		String TypeTemplate = choosePro.PaymentFormTypeProject();
		choosePro.ChooseProject("Payment Form");
		Assert.assertEquals("Payment Form", TypeTemplate);
	}

	@Test(description = "my type project")
	public void tc04_chooseTypeProject() {
		Templates template = new Templates(driver);
		String Shopping = template.GetShoppingOrderForm();
		template.ChooseTemplate("Shopping Order Form");
		Assert.assertEquals(Shopping, "Shopping Order Form");
	}

	@Test(description = "Test Pay order form template")
	public void tc05_fillOrderFormTest() {
		ShoppingOrderFormPage shopping = new ShoppingOrderFormPage(driver);
		shopping.fillOrderForm(styleName, size, firstName, lastName, email, address, shippingMethod);
		Assert.assertTrue(shopping.getTitle().contains(finalTile));
	}

	@Test(description = "Back to Template")
	public void tc06_backToTemplate() {
		MenuPage menu = new MenuPage(driver);
		String Exit = menu.exitTheProject();
		Assert.assertTrue(Exit != "/img/frontend/icon-modal-close.svg");
	}
}
