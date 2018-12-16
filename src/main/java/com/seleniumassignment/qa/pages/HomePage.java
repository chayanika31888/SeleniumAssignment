package com.seleniumassignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.seleniumassignment.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	//@FindBy(xpath="//*[starts-with(text(),'Hello ')]")
	@FindBy(xpath="//div[@class='fl']/h1")
	WebElement userNameLabel;
	
	@FindBy(id="_ctl0__ctl0_Content_MenuHyperLink1")
	WebElement viewAccountSummary;
	
	@FindBy(id="_ctl0__ctl0_Content_MenuHyperLink2")
	WebElement viewRecentTransactions;
	
	@FindBy(id="_ctl0__ctl0_Content_MenuHyperLink3")
	WebElement transferFunds;
	
	@FindBy(id="_ctl0__ctl0_Content_MenuHyperLink4")
	WebElement searchNewArticles;
	
	@FindBy(id="_ctl0__ctl0_Content_MenuHyperLink5")
	WebElement customizeSiteLanguage;
	
	@FindBy(id="_ctl0__ctl0_Content_AccountLink")
	WebElement myAccountTab;
	
	@FindBy(id="_ctl0__ctl0_Content_LinkHeader2")
	WebElement personalTab;
	
	@FindBy(id="_ctl0__ctl0_Content_LinkHeader3")
	WebElement smallBusinessTab;

	@FindBy(id="Header4")
	WebElement insideAltoroMutualTab;
	
	@FindBy(id="listAccounts")
	WebElement accountDropdown;
	
	@FindBy(id="btnGetAccount")
	WebElement goBtn;
	
	@FindBy(xpath="//a[@href='apply.aspx']")
	WebElement hereLink;
	
	@FindBy(id="_ctl0__ctl0_LoginLink")
	WebElement signOffLink;
	
	@FindBy(id="_ctl0__ctl0_HyperLink3")
	WebElement contactUsLink;
	
	@FindBy(id="_ctl0__ctl0_HyperLink4")
	WebElement feedbackLink;
	
	@FindBy(xpath="//label[text()='Search']")
	WebElement searchLabel;
	
	@FindBy(id="txtSearch")
	WebElement searchTextBox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement searchSubmit;
	
	//Constructor to initialise elements
	
	public HomePage(){
	PageFactory.initElements(driver, this);	
	}
	
	//Actions
	
	public String homePageTitle(){
		String pageTitle = driver.getTitle();
		return pageTitle;		
	}
	
	public String userLabel(){
		String userLabel = userNameLabel.getText();
		return userLabel;
	}
	
	public boolean userNameLabelAvailable(){
		return userNameLabel.isDisplayed();
	}
	
	public PersonalPage clickPersonalTab(){
		
		personalTab.click();
		return new PersonalPage();
		
	}
	
	public SmallBusinessPage clicksmallBusinessTab(){
		
		smallBusinessTab.click();
		return new SmallBusinessPage();
	}
	
	public InsideAltoroMutualPage clickInsideAltoromutualTab(){
		
		insideAltoroMutualTab.click();
		return new InsideAltoroMutualPage();
	}
	
	public void clickMyAccountTab(){
		myAccountTab.click();
	}
	
	public AccountInformationPage selectCheckingAccount(){
		
		Select accounts = new Select(accountDropdown);
		
		 accounts.selectByValue("1001160140");
		 goBtn.click();	
		 return new AccountInformationPage();
	}
	
	public AccountInformationPage selectSavingAccount(){
		
		Select accounts = new Select(accountDropdown);
		accounts.selectByValue("1001160141");
		goBtn.click();
		return new AccountInformationPage();
	}
	
	public FeedbackPage clickFeedbackLink(){
		feedbackLink.click();
		 return new FeedbackPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}