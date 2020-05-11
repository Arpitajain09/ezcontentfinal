package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ContentLiveBlogPage;
import ezcontent.qa.pages.LoginPage;

public class ContentLiveBlogTest extends TestBase {
	

		LoginPage loginpage;
		ContentLiveBlogPage contentliveblogPage;
		
		public ContentLiveBlogTest() throws IOException {
			super();
			// TODO Auto-generated constructor stub
		}


		@BeforeClass
		public void setup() throws IOException {
		browserLaunch();
		loginpage = new LoginPage();
		contentliveblogPage = new ContentLiveBlogPage();
			
		}
		
		@Test(priority=1)
		public void loginTest() {
		loginpage.validateLogin(prop.getProperty("Admin"), prop.getProperty("Adminpass"));
		}
		
 	    @Test(priority=2)
 	    public void navigatetoContentLiveBlogPage() {
 	    String content	= contentliveblogPage.contentHeading();
 	    Assert.assertEquals(content, prop.getProperty("labelContentExpected"));
 	    String addContent = contentliveblogPage.mousehoverOnContent();
 	    Assert.assertEquals(addContent, prop.getProperty("addContentHeading"));
 	    boolean liveBlog = contentliveblogPage.mousehoverOnAddContent();
 	    Assert.assertTrue(liveBlog);
 	    String createLiveBlog = contentliveblogPage.mousehoverOnLiveBlog();
 	    Assert.assertEquals(createLiveBlog, prop.getProperty("liveBlogHeading"));
 	    }
 	    
 	    @Test(priority=3)
 	    public void titleFieldData() {
 	    String title = contentliveblogPage.titleField();
 	    Assert.assertEquals(title, prop.getProperty("labelTitle"));
 	    }
 	    
 	    @Test(priority=4)
 	    public void shortTitleFieldData() {
 	    String shortTitle = contentliveblogPage.shortTitleField();
	    Assert.assertEquals(shortTitle, prop.getProperty("labelShortTitle"));
 	    }
 	 
 	    @Test(priority=5)
 	    public void eventStatusFieldData() {
 	    String eventStatus = contentliveblogPage.eventStatusField();
 	    Assert.assertEquals(eventStatus, prop.getProperty("eventStatus"));
 	    }
 	    
 	    @Test(priority=6)
 	    public void verifyLiveChecked() {
 	    contentliveblogPage.liveChecked();	
 	    }
        
 	    @Test(priority=7)
	    public void verifyPublishedChecked() {
	    contentliveblogPage.publishedChecked();	
	    }
 	    
 	    
 	    @Test(priority=8)
	    public void verifyRightSideLabels() {
	    boolean simpleXMLSiteLabel = contentliveblogPage.simpleXMLSiteField();
	    Assert.assertTrue(simpleXMLSiteLabel);
	    boolean urlAliasLabel = contentliveblogPage.urlAliasField();
	    Assert.assertTrue(urlAliasLabel);
	    boolean authoringInformationLabel = contentliveblogPage.authoringInformationField();
	    Assert.assertTrue(authoringInformationLabel);
	    boolean promotionsOptionsLabel = contentliveblogPage.promotionOptionsField();
	    Assert.assertTrue(promotionsOptionsLabel);
	    boolean revisionLabel = contentliveblogPage.revisionLogMessageField();
	    Assert.assertTrue(revisionLabel);
	    boolean lastSavedLabel = contentliveblogPage.lastSavedField();
	    Assert.assertTrue(lastSavedLabel);
	    boolean authorLabel = contentliveblogPage.authorField();
	    Assert.assertTrue(authorLabel);
	    }
 	    
 	    @Test(priority=9)
	    public void liveBlogCreated() {
	    boolean liveBlogcontent = contentliveblogPage.saveContentLiveBlog();	
	    Assert.assertTrue(liveBlogcontent);
	    }
 	    
        @AfterClass
	    public void closeBrowser() {
		browserQuit();
     	}

}