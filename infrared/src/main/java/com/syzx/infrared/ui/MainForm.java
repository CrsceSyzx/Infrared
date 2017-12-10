/**
 * Project Name:Infrared
 * File Name:MainForm.java
 * Package Name:com.syzx.infrared.ui
 * Date:2017年12月7日下午4:22:03
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.syzx.infrared.service.GetInfraredDataThread;
import com.syzx.infrared.service.ThreadEventArgs;
import com.syzx.infrared.service.ThreadUpdateEventHandler;

/**
 * ClassName: MainForm <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月7日 下午4:22:03 <br/>
 *
 * @author Zxy
 * @version
 * @since JDK 1.8
 */
public class MainForm {

    private Label lblIP;
    private Label PortLab;
    private Label LengLab;
    private Label DanweiLab;
    private Label JieshouLab;
    private Text IPTxt;
    private Text PortTxt;
    private Text LengTxt;
    private Text JieshouTxt;
    private Text ReciveTxt;
    private Button ReadBut;
    private Button ClearBut;
    private Display display;
    private GetInfraredDataThread mainThread = null;
    Shell shell;

    /**
     *创建一个MainForm的实例.
     *
     */
    public MainForm() {
        // 显示应用 GUI
        display = new Display(); // 创建 Display 实例
        shell = new Shell(); // 创建Shell 实例
        shell.setText("红外数据接收器"); // 设置窗口显示标签
        shell.setBounds(20, 20, 0, 0); // 设置shell的显示范围

        // 创建标签
        lblIP = new Label(shell, SWT.NONE);
        lblIP.setText("IP:");
        lblIP.setBounds(80, 50, 30, 30);
        IPTxt = new Text(shell, SWT.NONE);
        IPTxt.setBounds(120, 50, 150, 30);
        PortLab = new Label(shell, SWT.NONE);
        PortLab.setText("Port:");
        PortLab.setBounds(340, 50, 30, 30);
        PortTxt = new Text(shell, SWT.NONE);
        PortTxt.setBounds(370, 50, 150, 30);
        LengLab = new Label(shell, SWT.NONE);
        LengLab.setText("距离:");
        LengLab.setBounds(580, 50, 30, 30);
        LengTxt = new Text(shell, SWT.NONE);
        LengTxt.setBounds(620, 50, 150, 30);
        DanweiLab = new Label(shell, SWT.NONE);
        DanweiLab.setText("m");
        DanweiLab.setBounds(780, 50, 200, 30);
        JieshouLab = new Label(shell, SWT.NONE);
        JieshouLab.setText("接收到:");
        JieshouLab.setBounds(60, 120, 60, 30);
        JieshouTxt = new Text(shell, SWT.NONE);
        JieshouTxt.setBounds(120, 120, 650, 30);

        ReadBut = new Button(shell, SWT.NONE);
        ReadBut.setText("Start");
        ReadBut.setBounds(120, 180, 100, 50);

        ClearBut = new Button(shell, SWT.NONE);
        ClearBut.setText("Clear");
        ClearBut.setBounds(620, 180, 100, 50);

        ReciveTxt = new Text(shell, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
        ReciveTxt.setBounds(120, 280, 650, 300);
        Label Lab = new Label(shell, SWT.NONE);
        Lab.setBounds(580, 660, 30, 30);
        shell.pack();
        shell.open();

        ReadBut.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                if (ReadBut.getText() == "Start") {
                    //					mThread = new Thread(mRunnable);
                    //					mThread.start();
                    mainThread = new GetInfraredDataThread(IPTxt.getText());
                    mainThread.setThreadUpdateEventHandler(new ThreadUpdateEventHandler() {
                        public void dataUpdate(Object sender, ThreadEventArgs e) {
                            display.syncExec(new TextAppender(ReciveTxt, e.getThreadData()));
                        }
                    });
                    mainThread.start();

                    ReadBut.setText("Stop");
                } else {
                    mainThread.stopThread();
                    ReadBut.setText("Start");
                }

            }
        });
        ClearBut.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                ReciveTxt.setText("");
            }
        });

    }

    public void show() {
        // shell.layout();
        // 开始事件处理循环，直到用户关闭窗口
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    protected class TextAppender implements Runnable {

        private Text textbox;
        private Object value;

        /**
         *创建一个TextSetter的实例.
         *
         * @param textbox
         * @param value
         */

        public TextAppender(Text textbox, Object value) {
            this.textbox = textbox;
            this.value = value;
        }

        /**
         * TODO 简单描述该方法的实现功能（可选）.
         * @see java.lang.Runnable#run()
         */
        public void run() {
            textbox.append(value.toString());
            textbox.append("\n");
        }
    }

    //    private static Runnable mRunnable = new Runnable() {
    //
    //        public void run() {
    //            // 此处为另外一个单独线程，非UI线程                  
    //            while (true) {
    //                // 非UI线程访问UI
    //                display.syncExec(new Runnable() {
    //                    public void run() {
    //                        // 这段代码实际上会被放在UI线程中执行
    //                        ReciveTxt.setText("a" + "\n" + ReciveTxt.getText());
    //                    }
    //                });
    //                try {
    //                    Thread.sleep(100);
    //                } catch (InterruptedException e1) {
    //                    e1.printStackTrace();
    //                }
    //            }
    //        }
    //    };

}
