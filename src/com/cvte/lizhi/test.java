

package com.cvte.lizhi;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class test extends UiAutomatorTestCase {   


	public static int INDEX =4;

	public static UiDevice  uidevice ;
	public static int width = 0;
	public static int height = 0;

	public void testDemo() throws UiObjectNotFoundException {   

		// Simulate a short press on the HOME button.
		// getUiDevice().pressHome();
		uidevice = getUiDevice();
		width = uidevice.getDisplayWidth();
		height = uidevice.getDisplayHeight();
		System.out.println(width+""+height);

		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("应用"));
		allAppsButton.clickAndWaitForNewWindow();

		// 然后在 Apps tab界面，模拟用户滑动到时钟应用的操作。
		// 由于Apps界面是可以滚动的，所有用
		// UiScrollable 对象.
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));

		appViews.setAsHorizontalList();

		UiObject settingsApp = appViews.getChildByText(
				new UiSelector().className(android.widget.TextView.class.getName()), "立知");
		settingsApp.clickAndWaitForNewWindow();
		//sleep(300);
		IsExistUpdate();
		Article article = new Article();
//		System.out.println("-----------文章全部列表UI验证-----------");
//		article.ArticleUICheck();
//
//		System.out.println("-----------文章点赞及取消点赞功能验证-----------");
//
//		article.ArticlePraise(INDEX);
//
//
//		System.out.println("-----------文章收藏以及取消收藏功能验证-----------");
//
//		article.collectArticle(INDEX);
//
//		System.out.println("-----------文章搜索功能验证-----------");
//		article.searchArticle();
//		System.out.println("-----------文章评论点赞功能验证-----------");
//		article.ArticleCommentPraise(INDEX);
//		System.out.println("-----------评论文章的评论功能验证-----------");
//		article.ArticleCommentOtherComment(INDEX);
		
//		Forum forum = new Forum();
//		forum.ForumPost();
		My my = new My();
		my.ModifyNickName();
	}

	/***
	 * 检测是否有更新的按钮
	 */
	public void IsExistUpdate(){
		try {
			UiObject update  = new UiObject(new UiSelector().text("以后再说"));
			if(update.exists()){
				update.click();
			}

		} catch (Exception e) {
			//e.printStackTrace();
		}

	}


	/**
	 * 我的页面立知账号登录
	 */
	public void LoginOn(){

		try {

			UiObject my = new UiObject(new UiSelector().text(Constant.my)); 

			my.click();

			UiObject mailLogin = new UiObject(new UiSelector().text(Constant.mailLogin));

			mailLogin.clickAndWaitForNewWindow();

			UiObject mailEdit = new UiObject(new UiSelector().text("邮箱"));

			mailEdit.setText("411249087@qq.com");

			UiObject passwordEdit  = new UiObject(new UiSelector().className("android.widget.EditText").focused(false));

			passwordEdit.setText("123456");


			UiObject login = new UiObject(new UiSelector().text("登录"));

			login.clickAndWaitForNewWindow();




		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();

		}

	}








}



