package com.danailbd;

import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TicTacToeGui {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TicTacToeGui window = new TicTacToeGui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
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
		shell.setSize(340, 360);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());
		
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		FormData fd_toolBar = new FormData();
		fd_toolBar.left = new FormAttachment(0);
		toolBar.setLayoutData(fd_toolBar);
		
		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.setText("New");
		
		ToolItem tltmNewItem_6 = new ToolItem(toolBar, SWT.SEPARATOR);
		
		ToolItem tltmNewItem_2 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_2.setText("Load");
		
		ToolItem tltmNewItem_1 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_1.setText("Save");
		
		ToolItem tltmNewItem_5 = new ToolItem(toolBar, SWT.SEPARATOR);
		
		ToolItem tltmNewItem_3 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_3.setText("Undo");
		
		ToolItem tltmNewItem_4 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_4.setText("Redo");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(null);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(toolBar, 6);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.bottom = new FormAttachment(100, -10);
		fd_composite.right = new FormAttachment(0, 338);
		composite.setLayoutData(fd_composite);
		
		
		
		Label label_11 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_11.setBounds(33, 89, 258, 8);
		
		Label label_10 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_10.setBounds(33, 178, 258, 8);
		
		Label label = new Label(composite, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(107, 24, 1, 236);
		
		Label label_9 = new Label(composite, SWT.SEPARATOR);
		label_9.setBounds(201, 24, 7, 236);
		
		
		
		Label[] board = new Label[9];
		
		final Label label_0 = new Label(composite, SWT.NONE);
		label_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				label_0.setImage(SWTResourceManager.getImage("/home/danailbd/Danailbd/Java/Projects/JavaCore/TicTacToe/images/O_image.png"));
			}
		});
		label_0.setBounds(32, 24, 69, 62);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBounds(122, 24, 69, 62);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBounds(214, 24, 69, 62);
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setBounds(33, 103, 69, 69);
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setBounds(32, 192, 69, 62);
		
		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setBounds(214, 192, 69, 62);
		
		Label label_6 = new Label(composite, SWT.NONE);
		label_6.setBounds(214, 103, 77, 69);
		
		Label label_7 = new Label(composite, SWT.NONE);
		label_7.setBounds(114, 103, 81, 69);
		
		Label label_8 = new Label(composite, SWT.NONE);
		label_8.setBounds(126, 192, 69, 62);

	}
}
