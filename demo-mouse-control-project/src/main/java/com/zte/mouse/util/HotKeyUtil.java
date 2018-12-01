package com.zte.mouse.util;

import java.io.File;

import javax.swing.JOptionPane;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.zte.mouse.action.strategy.Point;
import com.zte.mouse.app.Launcher;

public class HotKeyUtil implements HotkeyListener
{
    static final int start = 88;
    static final int stop = 89;
    static final int pause = 90;
    static final int showCurPos = 91;

    private Launcher launcher;

    public HotKeyUtil(Launcher launcher)
    {
        this.launcher = launcher;
    }

    public HotKeyUtil()
    {
        JIntellitype.setLibraryLocation(new File("conf/JIntellitype.dll"));
    }

    public Launcher getLauncher()
    {
        return launcher;
    }

    public void setLauncher(Launcher launcher)
    {
        this.launcher = launcher;
    }

    @Override
    public void onHotKey(int key)
    {
        switch (key)
        {
            case start:
                launcher.start();
                break;
            case pause:
                launcher.stop();
                break;
            case stop:
                launcher.stop();
                destroy();
            case showCurPos:
                Point p = PositionUtil.getCurPosition();
                JOptionPane.showMessageDialog(null, "X=" + p.getX() + ",Y=" + p.getY(), "显示当前位置：", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    void destroy()
    {

        JIntellitype.getInstance().unregisterHotKey(start);
        JIntellitype.getInstance().unregisterHotKey(stop);
        JIntellitype.getInstance().unregisterHotKey(pause);
        JIntellitype.getInstance().unregisterHotKey(showCurPos);
        System.exit(0);
    }

    public void initHotkey()
    {
        JIntellitype.getInstance().registerHotKey(start, JIntellitype.MOD_SHIFT, 'S');
        JIntellitype.getInstance().registerHotKey(stop, JIntellitype.MOD_SHIFT, 'X');
        JIntellitype.getInstance().registerHotKey(pause, JIntellitype.MOD_SHIFT, 'P');
        JIntellitype.getInstance().registerHotKey(showCurPos, JIntellitype.MOD_SHIFT, 'L');
        JIntellitype.getInstance().addHotKeyListener(this);
    }

}
