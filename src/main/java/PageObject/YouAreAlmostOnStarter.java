package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouAreAlmostOnStarter extends MenuPage {

	// Your Payment Details
	@FindBy(css = "#card-holder-name")
	private WebElement NameField;
	// Frame
	@FindBy(css = "div iframe")
	private WebElement Frame;
	@FindBy(css = "[name='cardnumber']")
	private WebElement NumCardField;
	@FindBy(css = "[name='exp-date']")
	private WebElement DateCardField;
	@FindBy(css = "[name='cvc']")
	private WebElement SecurityNumbersField;
	@FindBy(css = "label>#coupon")
	private WebElement CouponField;

	// Your Billing Details
	@FindBy(css = "#first_name")
	private WebElement firstNameField;
	@FindBy(css = "#last_name")
	private WebElement lastNameField;
	@FindBy(css = "#company")
	private WebElement companyField;
	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = "#phone")
	private WebElement phoneField;
	@FindBy(css = "#street")
	private WebElement streetField;
	@FindBy(css = "#street_no")
	private WebElement streetNoField;
	@FindBy(css = "#zip")
	private WebElement ZIPCodeField;
	@FindBy(css = "#city")
	private WebElement cityField;
	@FindBy(css = "label #country")
	private WebElement countryList;

	// I agree to the involve.me
	@FindBy(css = "span>label")
	private WebElement IagreeBtn;
	@FindBy(css = "div #payment-submit")
	private WebElement PaymentBtn;

	// where is the your payment details?
	@FindBy(css = "#payment-form>.justify-content-left>.align-self-center .text-2xl")
	private WebElement YourPaymentDetails;

	// where is the your billing details?
	@FindBy(css = ".col-md-6>.text-2xl")
	private WebElement YourBillingDetails;

	// Your order summary
	@FindBy(css = ".order-summary>h5")
	private WebElement YourOrderSummary;

	// finish the upgrade
	@FindBy(css = ".order-summary h5")
	private WebElement orderSummary;

	public YouAreAlmostOnStarter(WebDriver driver) {
		super(driver);
	}

	public void yourPaymentDetails(String[] paymentDetails) {
		fillText(NameField, paymentDetails[0]);
		// move to frame
		driver.switchTo().frame(Frame);
		fillText(NumCardField, paymentDetails[1]);
		fillText(DateCardField, paymentDetails[2]);
		fillText(SecurityNumbersField, paymentDetails[3]);
		// move Back the window
		driver.switchTo().defaultContent();
		fillText(CouponField, paymentDetails[4]);
	}

	public void yourBillingDetails(String[] BillingDetails) {
		fillText(firstNameField, BillingDetails[0]);
		fillText(lastNameField, BillingDetails[1]);
		fillText(companyField, BillingDetails[2]);
		fillText(emailField, BillingDetails[3]);
		fillText(phoneField, BillingDetails[4]);
		fillText(streetField, BillingDetails[5]);
		fillText(streetNoField, BillingDetails[6]);
		fillText(ZIPCodeField, BillingDetails[7]);
		fillText(cityField, BillingDetails[8]);
		selectByValue(countryList, BillingDetails[9]);
	}

	public void yourOrderSummary() {
		click(IagreeBtn);
		click(PaymentBtn);
	}

	public void almostOnBusiness(String[] paymentDetails, String[] BillingDetails, String yourOrderSummary) {
		yourPaymentDetails(paymentDetails);
		yourBillingDetails(BillingDetails);
		yourOrderSummary();
	}

	public String yourOrderSummaryy() {
		return getText(orderSummary);
	}
}
