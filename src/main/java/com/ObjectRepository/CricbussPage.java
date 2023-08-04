package com.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CricbussPage {

	@FindBy(xpath = "https://www.cricbuzz.com/")
	private WebElement login;
	@FindBy(xpath = "//a[@title='West Indies v Nepal - 9th Match, Group A']")
	private WebElement match;
	@FindBy(xpath = "//a[text()='Scorecard']")
	private WebElement s_card;
	public WebElement getLogin() {
		return login;
	}
	public void setLogin(WebElement login) {
		this.login = login;
	}
	public WebElement getMatch() {
		return match;
	}
	public void setMatch(WebElement match) {
		this.match = match;
	}
	public WebElement getS_card() {
		return s_card;
	}
	public void setS_card(WebElement s_card) {
		this.s_card = s_card;
	}
	public void business_lib() {
		
		s_card.click();
	}
	
//	@FindBy(xpath = "//div[@class='cb-col cb-col-100 cb-scrd-sub-hdr cb-bg-gray']/following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms ']/descendant::a[@class='cb-text-link']")
//	private WebElement bowl;
//	@FindBy(xpath = "//a[contains(text(),'\"+p_name+\"') and @class='cb-text-link']/parent::div[@class='cb-col cb-col-38']/following-sibling::div[@class='cb-col cb-col-8 text-right text-bold']")
//	private WebElement wick;
}
