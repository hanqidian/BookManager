package hqd.book.manager.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("图书管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本数据维护");
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("图书类别管理");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bookTypeManager.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("图书类别添加");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInternalFrame bookTypeAddInternalFrame = new BookTypeAddInternalFrame();
				bookTypeAddInternalFrame.setVisible(true);
				table.add(bookTypeAddInternalFrame);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("图书类别维护");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerInternalFrame bookTypeManagerInternalFrame = new BookTypeManagerInternalFrame();
				bookTypeManagerInternalFrame.setVisible(true);
				table.add(bookTypeManagerInternalFrame);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit.png")));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("图书管理");
		mnNewMenu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bookManager.png")));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem menuItem = new JMenuItem("图书添加");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInternalFrame bookAddInternalFrame = new BookAddInternalFrame();
				bookAddInternalFrame.setVisible(true);
				table.add(bookAddInternalFrame);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		mnNewMenu_3.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("图书维护");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManagerInternalFrame bookManagerInternalFrame = new BookManagerInternalFrame();
				bookManagerInternalFrame.setVisible(true);
				table.add(bookManagerInternalFrame);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit.png")));
		mnNewMenu_3.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("安全退出");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统?");
				if(result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit.png")));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("关于我们");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/about.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("关于系统");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Java1234InternalFrame java1234InternalFrame = new Java1234InternalFrame();
				java1234InternalFrame.setVisible(true);	//可见
				table.add(java1234InternalFrame);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/about.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置JFrame最大化 
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
}
