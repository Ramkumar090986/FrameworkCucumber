package org.login;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass {
	
	public LoginPojo() {
	PageFactory.initElements(driver, this);
	}
	
@FindBy(id="email")
private WebElement txtUsername;

@FindBy(id="pass")
private WebElement txtPassword;

@FindBy(name="login")
private WebElement btnLogin;

public WebElement getTxtUsername() {
	return txtUsername;
}

public void setTxtUsername(WebElement txtUsername) {
	this.txtUsername = txtUsername;
}

public WebElement getTxtPassword() {
	return txtPassword;
}

public void setTxtPassword(WebElement txtPassword) {
	this.txtPassword = txtPassword;
}

public WebElement getBtnLogin() {
	return btnLogin;
}

public void setBtnLogin(WebElement btnLogin) {
	this.btnLogin = btnLogin;
}

}
