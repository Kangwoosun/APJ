package mini_project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;

public class Day_View_Frame extends JFrame{
	private JTable table;
	private JScrollPane jspWn;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_1;
	private JTextPane txtpnAbcdefg_1;
	private JTextPane txtpnAbcdefg;
	private JSplitPane splitPane_1;
	private JSplitPane splitPane;
	private JTextField txtTime;
	private JTextField txtToDo;
	private JFrame Frame = this;
	public Day_View_Frame() {
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		
		splitPane_1 = new JSplitPane();
		getContentPane().add(splitPane_1);

		this.setSize(870, 560);
				
				table = new JTable();
				table.setFont(new Font("HY°ß¸íÁ¶", Font.PLAIN, 18));

				table.setModel(new DefaultTableModel(
					new Object[][] {
						{"00:00"}, {"01:00"}, {"02:00"}, {"03:00"},
						{"04:00"},
						{"05:00"},
						{"06:00"},
						{"07:00"},
						{"08:00"},
						{"09:00"},
						{"10:00"},
						{"11:00"},
						{"12:00"},
						{"13:00"},
						{"14:00"},
						{"15:00"},
						{"16:00"},
						{"17:00"},
						{"18:00"},
						{"19:00"},
						{"20:00"},
						{"21:00"},
						{"22:00"},
						{"23:00"},
					},
					new String[] {
						"Clock"
					}
				));
				table.setRowHeight(50);
				
				
				jspWn = new JScrollPane(table);
				splitPane_1.setLeftComponent(jspWn);
				
				splitPane = new JSplitPane();
				
				splitPane_1.setRightComponent(splitPane);
				splitPane_1.setDividerLocation((int)this.getSize().getWidth()/5*2);
				splitPane_1.setDividerSize(15);
				
				splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
				
				panel = new JPanel();
				panel.setBorder(new EmptyBorder(8, 10, 8, 10));
				splitPane.setLeftComponent(panel);
				panel.setLayout(new GridLayout(0, 3, 0, 0));
				
				btnNewButton = new JButton("Add");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Add_Edit_Delete_Dialog dlg = new Add_Edit_Delete_Dialog(Frame);
					}
				});
				panel.add(btnNewButton);
				
				btnNewButton_1 = new JButton("Edit");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				panel.add(btnNewButton_1);
				
				btnNewButton_2 = new JButton("Delete");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				panel.add(btnNewButton_2);
				
				panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				splitPane.setRightComponent(panel_1);
//				
//				
//				splitPane.setSize((int)splitPane_1.getRightComponent().getSize().getWidth(),
//						(int)splitPane_1.getRightComponent().getSize().getHeight());
//				
//				
//				splitPane.setDividerLocation((int)splitPane.getSize().getHeight()/5);
				splitPane.setDividerLocation(65);
				splitPane.setDividerSize(30);
				
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{151, 0, 0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 26, 0, 0};
				gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 2.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				
				txtTime = new JTextField();
				txtTime.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 18));
				txtTime.setText("Time");
				GridBagConstraints gbc_txtTime = new GridBagConstraints();
				gbc_txtTime.gridheight = 2;
				gbc_txtTime.insets = new Insets(0, 0, 5, 5);
				gbc_txtTime.fill = GridBagConstraints.BOTH;
				gbc_txtTime.gridx = 0;
				gbc_txtTime.gridy = 0;
				panel_1.add(txtTime, gbc_txtTime);
				txtTime.setColumns(10);
				
				txtToDo = new JTextField();
				txtToDo.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 18));
				txtToDo.setText("To Do");
				txtToDo.setColumns(10);
				GridBagConstraints gbc_txtToDo = new GridBagConstraints();
				gbc_txtToDo.gridwidth = 3;
				gbc_txtToDo.gridheight = 2;
				gbc_txtToDo.insets = new Insets(0, 0, 5, 0);
				gbc_txtToDo.fill = GridBagConstraints.BOTH;
				gbc_txtToDo.gridx = 1;
				gbc_txtToDo.gridy = 0;
				panel_1.add(txtToDo, gbc_txtToDo);
				
				txtpnAbcdefg = new JTextPane();
				txtpnAbcdefg.setFont(new Font("µ¸¿ò", Font.PLAIN, 18));
				txtpnAbcdefg.setForeground(Color.RED);
				GridBagConstraints gbc_txtpnAbcdefg = new GridBagConstraints();
				gbc_txtpnAbcdefg.insets = new Insets(0, 0, 0, 5);
				gbc_txtpnAbcdefg.fill = GridBagConstraints.BOTH;
				gbc_txtpnAbcdefg.gridx = 0;
				gbc_txtpnAbcdefg.gridy = 2;
				panel_1.add(txtpnAbcdefg, gbc_txtpnAbcdefg);
				
				txtpnAbcdefg_1 = new JTextPane();
				txtpnAbcdefg_1.setFont(new Font("µ¸¿ò", Font.PLAIN, 18));
				txtpnAbcdefg_1.setForeground(Color.RED);
				GridBagConstraints gbc_txtpnAbcdefg_1 = new GridBagConstraints();
				gbc_txtpnAbcdefg_1.gridwidth = 3;
				gbc_txtpnAbcdefg_1.fill = GridBagConstraints.BOTH;
				gbc_txtpnAbcdefg_1.gridx = 1;
				gbc_txtpnAbcdefg_1.gridy = 2;
				panel_1.add(txtpnAbcdefg_1, gbc_txtpnAbcdefg_1);
				this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}




















