package com.tsa.keyboardutil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class KeyBoardUtil {
	//��Enter���ķ�װ����
	public static void pressEnterKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//���ƶ��ַ�����Ϊ����������ݣ�Ȼ��ִ��ճ������
	//��ҳ�潹���л��������󣬵��ô˺������Խ��ƶ��ַ���ճ�����������
	public static void setAndctrlVClipboardData(String str) throws AWTException, InterruptedException {
		StringSelection stringSelection=new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(1000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
	}

}
