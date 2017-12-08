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
	static Text ReciveTxt;
	static Display display;
	private static Thread mThread = null;
	public static void main(String[] args) {
		// 显示应用 GUI

		display = new Display(); // 创建 Display 实例
		final Shell shell = new Shell(); // 创建Shell 实例
		shell.setText("Window"); // 设置窗口显示标签
		shell.setBounds(20, 20, 0, 0); // 设置shell的显示范围

		// 创建标签
		Label IPLab = new Label(shell, SWT.NONE);
		IPLab.setText("IP:");
		IPLab.setBounds(80, 50, 30, 30);
		Text IPTxt = new Text(shell, SWT.NONE);
		IPTxt.setBounds(120, 50, 150, 30);
		Label PortLab = new Label(shell, SWT.NONE);
		PortLab.setText("Port:");
		PortLab.setBounds(340, 50, 30, 30);
		Text PortTxt = new Text(shell, SWT.NONE);
		PortTxt.setBounds(370, 50, 150, 30);
		Label LengLab = new Label(shell, SWT.NONE);
		LengLab.setText("距离:");
		LengLab.setBounds(580, 50, 30, 30);
		Text LengTxt = new Text(shell, SWT.NONE);
		LengTxt.setBounds(620, 50, 150, 30);
		Label DanweiLab = new Label(shell, SWT.NONE);
		DanweiLab.setText("m");
		DanweiLab.setBounds(780, 50, 200, 30);
		Label JieshouLab = new Label(shell, SWT.NONE);
		JieshouLab.setText("接收到:");
		JieshouLab.setBounds(60, 120, 60, 30);
		final Text JieshouTxt = new Text(shell, SWT.NONE);
		JieshouTxt.setBounds(120, 120, 650, 30);

		final Button ReadBut = new Button(shell, SWT.NONE);
		ReadBut.setText("Start");
		ReadBut.setBounds(120, 180, 100, 50);

		Button ClearBut = new Button(shell, SWT.NONE);
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
				if(ReadBut.getText()=="Start") {
					mThread = new Thread(mRunnable);
					mThread.start();
					ReadBut.setText("Stop");
				}else {
					mThread.stop();
					ReadBut.setText("Start");
				}
				
			}
		});
		ClearBut.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {		
				ReciveTxt.setText("");
			}
		});

		// shell.layout();
		// 开始事件处理循环，直到用户关闭窗口
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private static Runnable mRunnable = new Runnable() {

	public void run() {
            // 此处为另外一个单独线程，非UI线程                  
            while(true) {
                // 非UI线程访问UI
                display.syncExec(new Runnable() {
                    public void run() {
                        // 这段代码实际上会被放在UI线程中执行
                    	ReciveTxt.setText("a" + "\n" + ReciveTxt.getText());
                    }
                });
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
	};
		
}
