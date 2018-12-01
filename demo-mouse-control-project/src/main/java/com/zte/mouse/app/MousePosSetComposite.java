package com.zte.mouse.app;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zte.mouse.action.strategy.ClickStrategy;
import com.zte.mouse.action.strategy.DoubleClickStrategy;
import com.zte.mouse.action.strategy.MouseAction;
import com.zte.mouse.action.strategy.MoveStrategy;
import com.zte.mouse.data.PositionData;
import com.zte.mouse.task.MouseTimerTask;
import com.zte.mouse.util.HotKeyUtil;
import com.zte.mouse.util.PropsUtil;

public class MousePosSetComposite extends Composite
{

    private HotKeyUtil hotKeyUtil;

    private final Text txt_time;

    private final int time = 0;
    private final Button button;
    public PositionData data;
    private final Label lblMs;
    private final Text txtBat;
    private final Label label_1;
    private final Button btnNewButton;

    private final Map<String, Class<? extends MouseAction>> actionMap = new HashMap<String, Class<? extends MouseAction>>();

    public int getTime()
    {
        return time;
    }

    private void initActionMap()
    {
        actionMap.put("Move", MoveStrategy.class);
        actionMap.put("Click", ClickStrategy.class);
        actionMap.put("DoubleClick", DoubleClickStrategy.class);
    }

    public MousePosSetComposite(Composite parent, int style)
    {
        super(parent, style);
        initActionMap();
        setLayout(new GridLayout(5, false));

        Label label = new Label(this, SWT.NONE);
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        label.setText("迭代周期：");

        txt_time = new Text(this, SWT.BORDER);
        txt_time.setText(PropsUtil.readValue("time"));
        txt_time.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

        lblMs = new Label(this, SWT.NONE);
        lblMs.setText("ms");
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);

        label_1 = new Label(this, SWT.NONE);
        label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        label_1.setText("执行脚本：");

        txtBat = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
        GridData gd_txtBat = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2);
        gd_txtBat.heightHint = 120;
        txtBat.setLayoutData(gd_txtBat);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);

        button = new Button(this, SWT.NONE);
        button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
        button.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                // 写配置
                writeData2ConfigFile();
                arrangeLauncher();
                // PropsUtil.writeDataToFile(data);
            }
        });
        button.setText("\u4FDD\u5B58\u8BBE\u7F6E");

        btnNewButton = new Button(this, SWT.NONE);
        btnNewButton.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                arrangeLauncher();
            }
        });
        btnNewButton.setText("注册脚本");
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);
        initHotKey();
        // 初始化脚本
        initBat();
    }

    private void initHotKey()
    {
        hotKeyUtil = new HotKeyUtil();
        hotKeyUtil.initHotkey();
    }

    private MouseTimerTask initTimerTask()
    {
        MouseTimerTask timerTask = new MouseTimerTask();
        String bat = txtBat.getText();
        try
        {
            JSONArray jsonArray = new JSONArray(bat);
            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                MouseAction mouseAction = actionMap.get(jsonObject.get("action")).newInstance();
                if (mouseAction instanceof MoveStrategy)
                {
                    MoveStrategy moveStrategy = (MoveStrategy) mouseAction;
                    moveStrategy.setEndPosition(Integer.parseInt(jsonObject.get("x").toString()), Integer.parseInt(jsonObject.get("y").toString()));
                    moveStrategy.setWaitTime(Integer.parseInt(jsonObject.get("delay").toString()));
                    timerTask.addStrategy(moveStrategy);
                }
                else if (mouseAction instanceof ClickStrategy)
                {
                    ClickStrategy clickStrategy = (ClickStrategy) mouseAction;
                    if (jsonObject.get("x") != null && jsonObject.get("y") != null)
                        clickStrategy.setClickPosition(Integer.parseInt(jsonObject.get("x").toString()), Integer.parseInt(jsonObject.get("y").toString()));
                    if (jsonObject.get("delay") != null)
                        clickStrategy.setWaitTime(Integer.parseInt(jsonObject.get("delay").toString()));
                    timerTask.addStrategy(clickStrategy);
                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return timerTask;
    }

    private void arrangeLauncher()
    {
        int time = Integer.parseInt(txt_time.getText());
        Launcher launcher = new Launcher();
        MouseTimerTask timerTask = initTimerTask();
        // MoveStrategy mousesStrategy = new MoveStrategy();
        // mousesStrategy.setEndPosition(100, 200);
        // timerTask.addStrategy(mousesStrategy);
        launcher.setCycleTime(time);
        launcher.addTimerTask(timerTask);
        hotKeyUtil.setLauncher(launcher);
    }

    @Override
    protected void checkSubclass()
    {
    }

    public void writeData2ConfigFile()
    {
        String time = txt_time.getText();
        String bat = txtBat.getText();
        PropsUtil.writeDataToFile(time, bat);
    }

    private void initBat()
    {
        if (PropsUtil.readValue("time") != null)
            txt_time.setText(PropsUtil.readValue("time"));
        if (PropsUtil.readValue("bat") != null)
            txtBat.setText(PropsUtil.readValue("bat"));
    }
}
