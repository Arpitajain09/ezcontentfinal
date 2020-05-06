package ezcontent.qa.testcases;

import ezcontent.qa.pages.ArticleMapPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ArticleMapTest extends ArticleMapPage {


    @Test(priority = 1)
    public void loginTest() {
        logger=extent.createTest("LoginTest");
        //System.out.println("in test one ");
        loginpage.validateLogin(prop.getProperty("Admin"), prop.getProperty("Adminpass"));

    }
//test class <- POM <- parent class

    @Test(priority = 2)
    public void verifyContent() {
        logger=extent.createTest("verifyContent");
        String contentTitle = articlemapPage.contentHeading();
        Assert.assertEquals(contentTitle, prop.getProperty("contentHeading"));

    }


    @Test(priority = 3)
    public void Content() {
        logger=extent.createTest("Content");
        String content = articlemapPage.mousehoverOnContent();
        Assert.assertEquals(content, prop.getProperty("addContentHeading"));

    }

    @Test(priority = 4)

    public void addContent() {
        logger=extent.createTest("addContent");
        boolean addContent = articlemapPage.mousehoverOnAddContent();
        Assert.assertTrue(addContent);
    }

    @Test(priority = 5)
    public void article() {
        logger=extent.createTest("article");
        String article = articlemapPage.mousehoverOnArticle();
        Assert.assertEquals(article, prop.getProperty("articleHeading"));


    }

    @Test(priority = 6)
    public void verifySections() {
        logger=extent.createTest("verifySections");
        List<String> mylist = articlemapPage.verifySubSections();
        System.out.println(mylist);
    }


    @Test(priority = 7)

    public void titleField() {
        logger=extent.createTest("titleField");
        boolean title = articlemapPage.enterTitleFieldData();
        Assert.assertTrue(title);
    }


    @Test(priority = 8)
    public void subTitleField() {
        logger=extent.createTest("subTitleField");
        boolean subTitle = articlemapPage.subTitleFieldLabel();
        Assert.assertTrue(subTitle);

    }


    @Test(priority = 9)
    public void subHeadField() {
        logger=extent.createTest("subHeadField");
        boolean subhead = articlemapPage.enterSubheadFieldData();
        Assert.assertTrue(subhead);
    }


    @Test(priority = 10)
    public void authorField() throws InterruptedException {
        logger=extent.createTest("authorField");
        boolean author = articlemapPage.enterAuthorFieldData();
        Assert.assertTrue(author);
    }

    @Test(priority = 11)
    public void summaryField() {
        logger=extent.createTest("summaryField");
        String SummaryLabel = articlemapPage.enterSummaryFieldData();
        Assert.assertEquals(SummaryLabel, prop.getProperty("labelSummary"));
    }

    @Test(priority = 12)
    public void thumbnailFieldLabel() {
        logger=extent.createTest("thumbnailFieldLabel");
        String thumbnail = articlemapPage.thumbnailLabel();
        Assert.assertEquals(thumbnail, prop.getProperty("labelThumbnail"));
    }


    @Test(priority = 13)
    public void selectImages() throws InterruptedException {
        logger=extent.createTest("selectImages");
        articlemapPage.selectImages();
    }


    @Test(priority = 14)
    public void addParagraphField() throws InterruptedException {
        logger=extent.createTest("addParagraphField");
        articlemapPage.addParagraph();
    }

    @Test(priority = 15)
    public void googleMapField() {
        logger=extent.createTest("googleMapField");
        String googleMap = articlemapPage.entergoogleMapFieldData();
        Assert.assertEquals(googleMap, prop.getProperty("labelGoogleMap"));
    }

    @Test(priority = 16, dependsOnMethods = {"addParagraphField", "googleMapField"})
    public void tagsField() {
        logger=extent.createTest("tagsField");
        boolean tagsLabel = articlemapPage.enterTagsFieldData();
        Assert.assertTrue(tagsLabel);
    }

    @Test(priority = 18)
    public void focusKeywordField() {
        logger=extent.createTest("focusKeywordField");
        String focusKeyword = articlemapPage.enterFocusKeyword();
        Assert.assertEquals(focusKeyword, prop.getProperty("labelFocusKeyword"));

    }

  /*  @Test(priority = 19)
    public void saveArticleContent() {
        boolean articleCreated = articlemapPage.saveArticleContent();
        Assert.assertTrue(articleCreated);
    }*/


}




 