package com.tsa.util;

import java.awt.AWTException;

import com.tsa.keyboardutil.KeyBoardUtil;

public class LocateDefinitePath {
	public static void execute() throws AWTException, InterruptedException {
		KeyBoardUtil.setAndctrlVClipboardData("c:\\");
		KeyBoardUtil.pressEnterKey();
		Thread.sleep(2000);
		KeyBoardUtil.setAndctrlVClipboardData("users");
		KeyBoardUtil.pressEnterKey();
		Thread.sleep(2000);
		KeyBoardUtil.setAndctrlVClipboardData("unitrust");
		KeyBoardUtil.pressEnterKey();
		Thread.sleep(2000);
		KeyBoardUtil.setAndctrlVClipboardData("Desktop");
		KeyBoardUtil.pressEnterKey();
		Thread.sleep(2000);
		KeyBoardUtil.setAndctrlVClipboardData("selenium");
		KeyBoardUtil.pressEnterKey();
		Thread.sleep(2000);
	}

}
