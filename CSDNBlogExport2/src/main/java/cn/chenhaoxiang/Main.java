package cn.chenhaoxiang;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

public class Main extends JFrame {
	public static String userName = "";
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JTextField textField_1;

	public static int blogs =0;
	/**
	 * 程序入口
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setTitle("版本2.1 -chx");
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnNewButton = new JButton("导出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton.setEnabled(false);
				Main.blogs=0;
				long begin = System.currentTimeMillis();
				textArea.setText("");
				String userName = textField.getText();
				if (userName==null||userName.trim().equals("")) {// 用户名为空
					textArea.append("用户名不能为空\n");
					btnNewButton.setEnabled(true);
					return;
				}
				textArea.append("开始获取全部文章数量...\n");
				Set<String> blogIdSet =  CSDNBlogExport.startGetBlogID(userName,textArea);
				if(blogIdSet==null){
					textArea.append("请检查用户名或网络是否已经连接!\n");
					btnNewButton.setEnabled(true);
					return;
				}
				if(blogIdSet.size()==0){
					textArea.append("您的博客数量为0!\n");
					btnNewButton.setEnabled(true);
					return;
				}
				int threadNum = 50;
				String threadNumStr = textField_1.getText().trim();
				if(threadNumStr==null||threadNumStr.equals("")){
					textField_1.setText("50");
				}
				try {
					threadNum = Integer.parseInt(threadNumStr);
				} catch (NumberFormatException e1) {
					threadNum = 50;
					textField_1.setText("50");
				}

				SaveBlogDataEntity.startGetBlogandSave(begin,btnNewButton,textArea,blogIdSet,threadNum);

				textArea.append("本次线程获取-------共"+Main.blogs+"篇\n");
			}
		});

		JLabel lblCsdn = new JLabel("CSDN博客导出工具-CSDNBlogExport");
		lblCsdn.setFont(new Font("宋体", Font.BOLD, 20));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 14));
		textField.setColumns(10);

		JLabel label = new JLabel("用户名:");
		label.setFont(new Font("宋体", Font.PLAIN, 12));

		JLabel lblcsdn = new JLabel("此处用户名为您CSDN博客链接后面的用户名");
		lblcsdn.setFont(new Font("宋体", Font.PLAIN, 12));

		JScrollPane scrollPane = new JScrollPane();

		textField_1 = new JTextField();
		textField_1.setText("50");
		textField_1.setFont(new Font("宋体", Font.BOLD, 14));
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("线程:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));

		JLabel label_2 = new JLabel("建议50-100");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(scrollPane))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(38)
												.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(label, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addComponent(lblcsdn, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
																				.addGap(33)
																				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
																				.addGap(46))))))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(60)
												.addComponent(lblCsdn)))
								.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblCsdn)
								.addGap(30)
								.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lblcsdn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addContainerGap())
		);

		textArea = new JTextArea();
		textArea.setForeground(Color.BLUE);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("宋体", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
}
