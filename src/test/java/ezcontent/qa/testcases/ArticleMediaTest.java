package ezcontent.qa.testcases;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleMediaPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleMediaTest extends TestBase {
	TestUtil util = new TestUtil();
	LoginPage loginpage;
	ArticleMediaPage article;

	/*ArticleMediaTest() {
		super(); // to call the super class(BaseClass) constructor to get prop value
	}*/

	@BeforeClass
	public void setup() {
		TestBase.browserLaunch();
		driver.manage().deleteAllCookies();
		loginpage = new LoginPage();
		article = new ArticleMediaPage();
	}

	@Test(priority = 1)
	public void login() {
		loginpage.validateLogin(prop.getProperty("Admin"), prop.getProperty("Adminpass"));
		Wait.pageLoad(4);
	}
	@Test(priority = 2)
	public void dashboard() throws InterruptedException {
		article.dashBoardPage();
	}

	@Test(priority = 5)
	public void createArticleTest() throws InterruptedException {
		article.createArticle();

	}

	@Test(priority = 3)
	public void validatePageTitle() {
		String title = article.validateArticlePageTitle();
		Assert.assertEquals(title, prop.getProperty("articlePageTitle"));
	}

	@Test(priority = 4)
	public void validageLogo() {
		boolean flag = article.validateLogo();
		Assert.assertTrue(flag);
	}
	


	@AfterClass
	public void closeBrowser() {
		TestBase.browserQuit();
	}

}
