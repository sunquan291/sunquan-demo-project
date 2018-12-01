package com.zte.mouse.app;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MouseCtlApp {
    protected Shell shell;
    public MousePosSetComposite com;

    public static void main(String[] args) {
        try {
            MouseCtlApp window = new MouseCtlApp();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {
                System.exit(0);
            }
        });
        shell.setSize(450, 400);
        shell.setText("控制台");
        shell.setLayout(new FillLayout());
        com = new MousePosSetComposite(shell, SWT.NONE);
        // HotKey key = new HotKey(com);

    }
}
