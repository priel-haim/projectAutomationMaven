package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageObject.MenuPage;

public class MyMenu extends MenuPage {

	@FindBy(css = ".fas.fa-caret-down.ml-2")
	private WebElement yourAccountField;
	@FindBy(css = "div>.darken")
	private WebElement forgetBtn;
	@FindBy(css = "[autocomplete='username']")
	private WebElement forgetPasswordField;
	@FindBy(css = ".btn.btn-primary")
	private WebElement messageEmailBtn;
	@FindBy(css = ".nav-item.dropdown")
	private WebElement OpenMenulist;
	@FindBy(css = ".dropdown-menu.w-auto.whitespace-no-wrap.absolute.bg-white.shadow-md>li>a")
	private List<WebElement> Menulist;

	public MyMenu(WebDriver driver) {
		super(driver);
	}

	public void UserMenu(String name) {
		click(yourAccountField);
		sleep(2000);
		List<WebElement> list = Menulist;
		for (WebElement menuList : list) {
			if (getText(menuList).equalsIgnoreCase(name)) {
				click(menuList);
				break;
			}
		}
		sleep(1000);
	}

	public void ForgetPassword(String Email) {
		click(forgetBtn);
		sleep(1000);
		fillText(forgetPasswordField, Email); // forget your password
		sleep(2000);
		click(messageEmailBtn); // message to Email
	}

}