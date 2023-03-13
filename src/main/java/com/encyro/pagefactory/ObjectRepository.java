package com.encyro.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.encyro.util.BasePage;


public class
ObjectRepository extends BasePage {

	public ObjectRepository(WebDriver driver, WebDriverWait mywait) {
		super(driver, mywait);
	}

	//--------LOGIN SCREEN----

	@FindBy(xpath = "//li/a[@href=\"/my\"]/span[text()='Login']")
	WebElement loginMenuBtn;

//	@FindBy(id = "lgusrname")
	@FindBy(xpath ="//input[@name=\"email\"]")
	WebElement txtUsername;

//	@FindBy(id = "lgpasswd")
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement txtPassword;

	@FindBy(id = "ntvpasswd")
	WebElement txtNavPassword;
	@FindBy(xpath = "//button[@type=\"submit\" and contains(text(),'Login')]")
	WebElement btnLogin;

//	Prajakta Code

	@FindBy(xpath = "//span[@class='flex items-center gap-1 font-manrope text-base font-medium justify-start']")
	WebElement forgetPwdButton;

	@FindBy(xpath = "//input[@placeholder='Enter your email']")
		WebElement forgetEmailEnter;


	@FindBy(xpath = "//button[@type='submit']")
			WebElement forgetEmaillogin;



	By txtName = By.xpath( "//div//input[@class=\"form-control sgnr-nm-ip\"]");
	By txtEmail = By.xpath( "//div[@id='signer-addedt']/div/div/div[2]/form/div/input");

	By txtRole = By.xpath( "//div[@id='signer-addedt']/div/div/div[2]/form/div[3]/input");

	@FindBy(xpath = "//div//button[@id=\"sgnr-adedt-save\" and text()='Save']")
	WebElement btnSave;

	@FindBy(id = "esgn-prep2cnfg")
	WebElement btnNext;


	@FindBy(id = "esgn-file-input")
	WebElement selectEsignFile;

	@FindBy(xpath = "//div[@id='prp-cntrl']/div[3]/div[3]/button")
	WebElement btnAddSign;

	@FindBy(xpath = "//div//button/span[text()='Compose E-Sign']")
	WebElement btnComposeEsignBtn;

	@FindBy(xpath = "//div[@id='prp-cntrl']/div[3]/div[3]/butto")
	WebElement btnAddNewSign;

	@FindBy(xpath = "(//div[@id='esgn-config']//button[text()='Send'])[1]")
	WebElement btnEsignSend;

	@FindBy(xpath = "//button[@type=\"submit\" and contains(text(),'Continue')]")
	WebElement btnContinue;

//	@FindBy(xpath = "(//nav//span[@as=\"span\" and text()='encyrodev04@yopmail.com'])[1]")
//	WebElement capUserName;


	By spinner = By.xpath("//div[@class=\"initspinner\"]");

	@FindBy(xpath = "//a/span[@id=\"nv-actv-acntnm\"]")
	WebElement btnAcntDrpDn;
	
	@FindBy(xpath ="//div[@style!=\"display:none;\" and text()='Logout']")
	WebElement btnLogout;

	@FindBy(xpath ="//div/button/span[text()='Compose' and @class=\"d-none d-sm-inline\"]")
	WebElement btnCompose;



	@FindBy(xpath ="//div[@id='new-cmps']/div/div[4]/textarea")
	WebElement txtSecuredMessge;

	@FindBy(xpath = "//div[@id=\"new-cmps\"]//textarea[@placeholder=\"Subject (not secure)\"]")
	WebElement txtEmailSubject;

	@FindBy(xpath = "//div[@id=\"new-cmps\"]//button[text()='Add Email Intro']")
	WebElement btnClickOnAddEmailIntro;

	@FindBy(xpath ="//button[@class=\"dropdown-item nv-add-acnt\"]")
	WebElement btnAddAcnt;

	@FindBy(xpath ="//button[text()='Add another account']")
	WebElement btnAddAnotherAcnt;

	@FindBy(xpath ="//div[@id=\"new-cmps\"]//b[text()='To']/parent::div/parent::div//following-sibling::input")
	WebElement txtTo;

	@FindBy(xpath ="//div[@id=\"new-cmps\"]//button[text()='Send']")
	WebElement btnSend;

    @FindBy(xpath = "(//div[@class=\"btn btn-secondary btn-file btn200\"]//input[@class=\"multifileinput\"])[1]")
    WebElement browseFile;
    By uploadSpinner = By.xpath("//div[@class=\"ltgraybg file-upld\"]//div[@class=\"attachedfilediv fl-upld-pend\"]");

	@FindBy(xpath = "//div[@id=\"new-cmps\"]//div[@class=\"btn btn-secondary btn-file btn200\" and contains(text(),'Browse ')]")
	WebElement btnBrowse;


	By lnkRemove = By.xpath("//div[@id=\"lgn-optns\"]//small[text()='Remove']");


	By tostrMsgSent = By.xpath("//div[@id=\"msg-sent-alrt\"]//strong[text()='Secure Message Sent']");

	By EsignRqstSnt = By.xpath("//div//strong[text()='E-Sign Request Sent']");

}
