package com.tsa.keyboardutil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class KeyBoardUtil {
	//按Enter键的封装方法
	public static void pressEnterKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//将制定字符串设为剪贴板的内容，然后执行粘贴操作
	//将页面焦点切换到输入框后，调用此函数可以将制定字符串粘贴到输入框中
	public static void setAndctrlVClipboardData(String str) throws AWTException, InterruptedException {
		StringSelection stringSelection=new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(1000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}

}
