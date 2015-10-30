package com.frankly.test;
import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frankly.keyword.Keywords;
import com.frankly.page.franklyHomePage;

public class franklyMeapp extends Keywords { 
//	public static Logger APP_LOGS = Logger.getLogger(franklyMeapp.class);
	franklyHomePage franklymetest=new franklyHomePage();
	/**
	 * @description- Launch the application in device
	 */
	@BeforeClass
	public void startappiumserver() throws  IOException, InterruptedException
	{
		franklymetest.appiumlaunch();
	}
	/**
	 * @description- Initialize OR and config property file
	 */
	@Test(enabled = true, priority = 1)
	public void Logging_In() throws InterruptedException, IOException, JSONException{	
		System.out.println("Initinilization of driver and property file");
		franklymetest.initilize();
	}
	/**
	 * @description- Login using Skip functionality and upload a video in MyAccount
	 */
	@Test(enabled = true, priority = 2)
	public void franklymetest() throws InterruptedException{
		franklymetest.SignInandNavigateHomeScreen("GetStarted_btn_ID","UserName_ID","userName","NextBtn_ID","Phone_Number_heading_ID","actual_text","SkipBtnID","RecordA_Vlog_Xpath");
		franklymetest.navigateToHomeScreen("RecordA_Vlog_Xpath");
		franklymetest.clickOnRecordingBtn("Recording_Btn_Xpath");
		franklymetest.uploadvideo("Recording_Btn_Xpath","Recording_Next_Btn_Xpath","Recording_cancle_Btn_ID","Recording_Filter_Nxt_Btn_ID","Add_Title_ID","video_heading","Upload_video_Btn_ID");
		franklymetest.verifyuploadedvideo("Account_Btn_ID","Uploaded_Video_section_ID","Video_Heading_ID","video_heading");
	}
	/**
	 * @description- Quit driver
	 */
	@AfterClass
	public void closingtheserver(){
		franklymetest.closeappium();
	}
	
}


