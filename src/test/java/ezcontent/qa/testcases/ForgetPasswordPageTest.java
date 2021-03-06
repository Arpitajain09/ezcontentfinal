package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ForgetPasswordPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.Wait;

public class ForgetPasswordPageTest extends TestBase {

	ForgetPasswordPage forgetPswdPage;
	LoginPage loginpage;

	public ForgetPasswordPageTest() {
		super(); // to call the super class(BaseClass) constructor to get prop value
	}

	@BeforeClass
	public void setup() {

		TestBase.browserLaunch(); // to launch browser and get url


		loginpage = new LoginPage();
		loginpage.forgetPassword();       // click on forget password link

		forgetPswdPage = new ForgetPasswordPage(); 
	}

	@Test(priority = 1)
	public void forgetPaswdTitleTest() {
		String title = forgetPswdPage.validateForgetPaswdTitle();
		Assert.assertEquals(title, "Reset your password | EZContent");
		System.out.println("Forget Page title is :" + title);
	}

	@Test(priority = 2)
	public void logoImageTest() {
		boolean flag = forgetPswdPage.validateForgetPaswdLogo();
		Assert.assertTrue(flag);
		System.out.println("Forget page logo is displayed");
	}

	@Test(priority = 3)
	public void forgetPaswdSubmitTest() throws InterruptedException {
		forgetPswdPage.submitForgetPaswd(prop.getProperty("Admin"));
		Wait.Pause(5000);
	}

	@Test(priority = 4)
	public void statusMessageTest() {
		String statusMessage = forgetPswdPage.validateStatusMessage();
		Assert.assertEquals(statusMessage, "Further instructions have been sent to your email address.");
		System.out.println("Status message after reset password is :" + statusMessage);
	}

	@AfterClass
	public void closeBrowser() {
		browserQuit();
	}
}
