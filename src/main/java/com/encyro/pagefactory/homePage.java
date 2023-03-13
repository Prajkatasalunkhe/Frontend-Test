package com.encyro.pagefactory;

import com.aventstack.extentreports.Status;
import com.encyro.util.CustUtil;
import com.encyro.util.TestBed;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.encyro.util.BasePage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static com.encyro.util.TestBed.TestBedBrowser;

public class homePage extends BasePage {

    ObjectRepository objRepo = new ObjectRepository(driver, mywait);
    WebElement wEle = null;

    public homePage(WebDriver driver, WebDriverWait mywait) {
        super(driver, mywait);
    }

//    protected String getHomeUsername()  {
//        mywait.until(ExpectedConditions.visibilityOf(objRepo.capUserName));
////		System.out.println(capUserName.getText());
//        return objRepo.capUserName.getText();
//    }

    public void clickAcntDrpDnButton() throws InterruptedException {
        Thread.sleep(3000);
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnAcntDrpDn));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnAcntDrpDn));
        objRepo.btnAcntDrpDn.click();
//        new Actions(driver).moveToElement(objRepo.btnAcntDrpDn,1,1).click().build().perform();
        TestBed.test.log(Status.PASS, "Clicked On AcntDrpDnBtn");
    }

    public void clickAddAcntBtn() {
        try {
            mywait.until(ExpectedConditions.visibilityOf(objRepo.btnAddAcnt));
            objRepo.btnAddAcnt.click();
        } catch (Exception e1) {
            try {
                mywait.until(ExpectedConditions.visibilityOf(objRepo.btnAddAnotherAcnt));
                objRepo.btnAddAnotherAcnt.click();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            TestBed.test.log(Status.PASS, "Clicked On Add Acnt Btn");
        }
    }

    public void switchAcnt(String semailId) {
        String s1 = "//div[@id=\"nv-acnts\"]//span[contains(text(),'" + semailId + "')]";
        WebElement ele = driver.findElement(By.xpath(s1));
        ele.click();

        String switchedUser = objRepo.btnAcntDrpDn.getText();
        Assert.assertTrue(switchedUser.equalsIgnoreCase(semailId), "User Switch Not Successfully");
        TestBed.test.log(Status.PASS, "Switched to Account" + switchedUser);
    }

    public void clickLogout(String sName) throws InterruptedException {
        String str1 = "(//span[text()='"+sName+"'])[1]";
        if (!TestBedBrowser.equalsIgnoreCase("safari")) {
            this.clickAcntDrpDnButton();
        }
        driver.findElement(By.xpath(str1)).isDisplayed();
        Actions act = new Actions(driver);
        String logoutMenu ="//button/div/span[text()=\'Log out\']";
        String logoutCurrent ="//button/div/span[text()='Log out from current account']";
        String logoutAll ="//button/div/span[text()='Log out all']";
        act.moveToElement( driver.findElement(By.xpath(str1))).moveToElement( driver.findElement(By.xpath(str1))).moveToElement( driver.findElement(By.xpath(logoutMenu))).click(driver.findElement(By.xpath(logoutCurrent)));

        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnLogout));
        objRepo.btnLogout.click();
        //   mywait.until(ExpectedConditions.visibilityOf(objRepo.btnAddAnotherAcnt));
        Reporter.log("clicked on logout Successful");
        TestBed.test.log(Status.PASS, "clicked on logout Successful");

    }

    public void clickLogout() throws InterruptedException {

        if (!TestBedBrowser.equalsIgnoreCase("safari")) {
            this.clickAcntDrpDnButton();
        }

        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnLogout));
        objRepo.btnLogout.click();
        //   mywait.until(ExpectedConditions.visibilityOf(objRepo.btnAddAnotherAcnt));
        Reporter.log("clicked on logout Successful");
        TestBed.test.log(Status.PASS, "clicked on logout Successful");

    }

    public void clickRemove()  {
        List<WebElement> RemoveLinks = driver.findElements(objRepo.lnkRemove);
        if (RemoveLinks.size() > 0) {
            mywait.until(ExpectedConditions.visibilityOf(driver.findElement(objRepo.lnkRemove)));
            driver.findElement(objRepo.lnkRemove).click();

            Reporter.log("clicked on Remove Successfully");
            TestBed.test.log(Status.PASS, "clicked on Remove Successfully");
        }
    }

    public void clickCompose() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnCompose));
        objRepo.btnCompose.click();
        mywait.until(ExpectedConditions.visibilityOf(objRepo.txtTo));

        TestBed.test.log(Status.PASS, "Clicked on Compose Successfully");
    }

    public void clickComposeEsign() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnComposeEsignBtn));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnComposeEsignBtn));
        objRepo.btnComposeEsignBtn.click();
        TestBed.test.log(Status.PASS, "Clicked on Compose Esign Successfully");
    }

    public void selectFileToBrowse(String File) {
        try {
            Thread.sleep(6000);

//        mywait.until(ExpectedConditions.visibilityOf(objRepo.selectEsignFile));
            objRepo.selectEsignFile.sendKeys(File);
            TestBed.test.log(Status.PASS, "selected file "+File+"Successfully");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickonAddNewSign() {
        try {
            mywait.until(ExpectedConditions.visibilityOf(objRepo.btnAddSign));
            mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnAddSign));
            objRepo.btnAddSign.click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillAdSignerForm(String Email, String Name, String Role) {
        try {
            mywait.until(ExpectedConditions.visibilityOfElementLocated(objRepo.txtEmail));
            driver.findElement(objRepo.txtEmail).sendKeys(Email);
            Thread.sleep(1000);
            mywait.until(ExpectedConditions.visibilityOfElementLocated(objRepo.txtName));
            driver.findElement(objRepo.txtName).sendKeys(Name);

            Thread.sleep(1000);
            mywait.until(ExpectedConditions.presenceOfElementLocated(objRepo.txtRole));
            driver.findElement(objRepo.txtRole).sendKeys(Role);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnSave() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnSave));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnSave));
        objRepo.btnSave.click();
        TestBed.test.log(Status.PASS, "Clicked on Save Successfully");
    }

    public void clickOnNext() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnNext));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnNext));
        objRepo.btnNext.click();
        TestBed.test.log(Status.PASS, "Clicked on Next Successfully");
    }

    public void clickOnEsignSend() {
        CustUtil.pageScrollDown(driver);
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnEsignSend));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnEsignSend));
        objRepo.btnEsignSend.click();
        TestBed.test.log(Status.PASS, "Clicked on Next Successfully");
    }

    public void clickOnCanvas(int xcord, int ycord) {
        try {
            String canvas = "//div[@id='esgn-pdfview']/div[3]/div[2]/canvas";
            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(canvas)));
            //   driver.findElement(By.xpath(canvas)).click();
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath(canvas)), xcord, ycord);
            actions.moveByOffset(xcord, ycord).click().build().perform();
            Thread.sleep(1000);
            TestBed.test.log(Status.PASS, "Clicked on Canvas Coord"+xcord+ycord+" Successfully");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
    public void AddSignature() {
        try {
            String signature = "//*/text()[normalize-space(.)='Signature']/parent::*";
            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(signature)));
            driver.findElement(By.xpath(signature)).click();
            Thread.sleep(1000);
            TestBed.test.log(Status.PASS, "Clicked on Signature Successfully");
//            String canvas = "//div[@id='esgn-pdfview']/div[3]/div[2]/canvas";
//            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(canvas)));
//            driver.findElement(By.xpath(canvas)).click();
            clickOnCanvas(0,0);
//            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddInitials() {
        try {
            String intial ="//div[@id='prp-cntrl']/div[3]/div[5]/button[2]";// "//*/text()[normalize-space(.)='Initials']/parent::*";
            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(intial)));
            driver.findElement(By.xpath(intial)).click();
            Thread.sleep(1000);
            TestBed.test.log(Status.PASS, "Clicked on initials Successfully");
            clickOnCanvas(0,50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public void AddSignDate() {
        try {
            String signDate = "//*/text()[normalize-space(.)='Sign. Date']/parent::*";
            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(signDate)));

            driver.findElement(By.xpath(signDate)).click();
            Thread.sleep(1000);
            TestBed.test.log(Status.PASS, "Clicked on SignDate Successfully");

            clickOnCanvas(0,80);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddDate() {
        try {
            String Date = "//*/text()[normalize-space(.)='Date']/parent::*";
            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(Date)));

            driver.findElement(By.xpath(Date)).click();
            Thread.sleep(1000);
            TestBed.test.log(Status.PASS, "Clicked on Date Successfully");
            clickOnCanvas(0,100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddText() {
        try {
            String Text = "//*/text()[normalize-space(.)='Text']/parent::*";
            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(Text)));

            driver.findElement(By.xpath(Text)).click();
            Thread.sleep(1000);
            TestBed.test.log(Status.PASS, "Clicked on Text Successfully");
            clickOnCanvas(100,50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddCheckbox() {
        try {
            String checkbox = "//*/text()[normalize-space(.)='Checkbox']/parent::*";
            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkbox)));

            driver.findElement(By.xpath(checkbox)).click();
            Thread.sleep(1000);
            TestBed.test.log(Status.PASS, "Clicked on checkbox Successfully");
            clickOnCanvas(130,0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddCInsertText() {
        try {
            String itext = "//*/text()[normalize-space(.)='Insert Text']/parent::*";
            mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(itext)));
            driver.findElement(By.xpath(itext)).click();
            Thread.sleep(1000);
            TestBed.test.log(Status.PASS, "Clicked on insert text Successfully");
            clickOnCanvas(120,80);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterSecuredMessge(String desc)  {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.txtSecuredMessge));
        objRepo.txtSecuredMessge.sendKeys(desc);
        System.out.println("Entered secured message -" +desc);
        Reporter.log("Entered secured message -" +desc);
        TestBed.test.log(Status.PASS, "Entered secured message -" +desc);

    }

    public void enterEmailSubject(String subject)  {

        mywait.until(ExpectedConditions.visibilityOf(objRepo.txtEmailSubject));
        objRepo.txtEmailSubject.sendKeys(subject);
        System.out.println("Entered Email Subject message -" +subject);
        Reporter.log("Entered Email Subject message -" +subject);
        TestBed.test.log(Status.PASS, "Entered Email Subject  message -" +subject);

    }

    public void clickOnAddEmailIntro(){
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnClickOnAddEmailIntro));
        objRepo.btnClickOnAddEmailIntro.click();

        Reporter.log("Clicked on Add Email Intro succesfull");
        TestBed.test.log(Status.PASS, "Clicked on Add Email Intro succesfully");
    }

    public void selectFolder(String emailId) {
        String sLoc = "//div[@class=\"ltgraybg folderflap tileview\"]/span[text()='" + emailId + "']";
//		String sLoc = "//div[@class=\"ltgraybg folderflap tileview\"]/span[text()='encyro21user2@yopmail.com']";
        wEle = driver.findElement(By.xpath(sLoc));
        mywait.until(ExpectedConditions.elementToBeClickable(wEle));
        wEle.click();
        TestBed.test.log(Status.PASS, "Selected Folder: " + emailId);
    }


    public void selectMessageToForward(String emailId) {
        wEle = driver.findElement(By.xpath("//div//span[@data-user-email=\"" + emailId + "\"]/parent::span/parent::div/preceding::div[@class=\"inboxview\"]//button[@class=\"forward btn btn-sm btnmsghd float-right d-none d-sm-inline-block\"]/i"));
        mywait.until(ExpectedConditions.elementToBeClickable(wEle));
        wEle.click();
        TestBed.test.log(Status.PASS, "Clicked on Forward Button");
    }

    public void enterEmailInToField(String emailId) {
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.txtTo));
        objRepo.txtTo.click();
        objRepo.txtTo.clear();
        objRepo.txtTo.sendKeys(emailId);
        TestBed.test.log(Status.PASS, "Entered Email in To Field: " + emailId);
    }

    public void selectFileUsingBrowse(String sFile) {
        //***IMPT***** DONT REMOVE THIS COMMENT IT CAN BE USED AS BACK UP IF FILE SELECTION FAILS
//        try {
//            objRepo.btnBrowse.click();
//            System.out.println("********** " + driver.switchTo().activeElement().getText());
//            driver.switchTo().activeElement().sendKeys(sFile);
//            Thread.sleep(1000);
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_ESCAPE);
//            robot.keyRelease(KeyEvent.VK_ESCAPE);
//        } catch (AWTException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        objRepo.browseFile.sendKeys(sFile);
        try {
            cu.waitForElementToDisapper(driver,objRepo.uploadSpinner);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TestBed.test.log(Status.PASS, "Selected File successfully: " + sFile);
    }

    public void clickSendBtn() {
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnSend));
        objRepo.btnSend.click();
        TestBed.test.log(Status.PASS, "Clicked on Send Button");
    }

    public void verifyToastrMsgSent() {
        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(objRepo.tostrMsgSent));
        mywait.until(ExpectedConditions.invisibilityOfElementLocated(objRepo.tostrMsgSent));
        TestBed.test.log(Status.PASS, "Verified toastr -Secure Message Sent successfully");
    }

    public void verifyEsignRsstSent() {
        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(objRepo.EsignRqstSnt));
        mywait.until(ExpectedConditions.invisibilityOfElementLocated(objRepo.EsignRqstSnt));
        TestBed.test.log(Status.PASS, "Verified toastr 'E-Sign Request Sent' successfully");
    }

}
