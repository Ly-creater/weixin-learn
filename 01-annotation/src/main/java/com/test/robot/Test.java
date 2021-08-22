package com.test.robot;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.robot
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws AWTException {
                     System.out.println("ok");
                    Robot robot = new Robot();

                     //将鼠标移到控制台区域
                     robot.mouseMove(150,150);

                     //单击右键
        while (true) {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(100);
        }
    }
}
