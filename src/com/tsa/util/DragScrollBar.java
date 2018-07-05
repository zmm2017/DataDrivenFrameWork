package com.tsa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class DragScrollBar {
	public static void execute() throws AWTException {
		Robot rb=new Robot();
		for(int i=1;i<=5;i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
	}

}
