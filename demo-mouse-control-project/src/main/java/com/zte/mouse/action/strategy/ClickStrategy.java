package com.zte.mouse.action.strategy;

import java.awt.Robot;
import java.awt.event.InputEvent;

import com.zte.mouse.robot.RobotFactory;

public class ClickStrategy implements MouseAction
{
    private Point clickPosition;
    private int waitTime;
    protected Robot robot;

    public ClickStrategy(Robot robot)
    {
        this.robot = robot;
    }

    public ClickStrategy()
    {
        robot = RobotFactory.getInstance();
    }

    public int getWaitTime()
    {
        return waitTime;
    }

    public void setWaitTime(int waitTime)
    {
        this.waitTime = waitTime;
    }

    public Point getClickPosition()
    {
        return clickPosition;
    }

    public void setClickPosition(Point clickPosition)
    {
        this.clickPosition = clickPosition;
    }

    public void setClickPosition(int x, int y)
    {
        Point point = new Point(x, y);
        this.clickPosition = point;
    }

    @Override
    public void action()
    {
        robot.delay(this.waitTime);
        if (this.clickPosition != null)
        {
            robot.mouseMove(this.clickPosition.getX(), this.clickPosition.getY());
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}
