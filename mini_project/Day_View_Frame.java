package mini_project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
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
import javax.swing.DefaultListModel;

import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;

public class Day_View_Frame extends JFrame{
	public static final int ADD = 1;
	public static final int EDIT = 2;
	public static final int DELETE = 3;
	
	private JTable table;
	private JScrollPane clockTable;
	private JPanel option_Panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel time_doing_Panel;
	private JSplitPane main_Pane;
	private JSplitPane dialog_Pane;
	private JTextField txtTime;
	private JTextField txtToDo;
	private JFrame Frame = this;
	private JList<String> list;
	private JList<String> list_1;
	private DefaultListModel<String> listModel;
	private DefaultListModel<String> listModel_1;
	private DefaultListModel<Doing> listDoing;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;



	public Day_View_Frame(String str) {

	
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
	
		main_Pane = new JSplitPane();
		getContentPane().add(main_Pane);

		this.setSize(870, 560);
		this.setTitle(str);
				table = new JTable();
				table.setFont(new Font("HY¬∞√ü¬∏√≠√Å¬∂", Font.PLAIN, 18));

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
				
				
				clockTable = new JScrollPane(table);
				main_Pane.setLeftComponent(clockTable);
				
				dialog_Pane = new JSplitPane();
				
				main_Pane.setRightComponent(dialog_Pane);
				main_Pane.setDividerLocation((int)this.getSize().getWidth()/5*2);
				main_Pane.setDividerSize(15);
				
				dialog_Pane.setOrientation(JSplitPane.VERTICAL_SPLIT);
				
				option_Panel = new JPanel();
				option_Panel.setBorder(new EmptyBorder(8, 10, 8, 10));
				dialog_Pane.setLeftComponent(option_Panel);
				option_Panel.setLayout(new GridLayout(0, 3, 0, 0));
				
				btnNewButton = new JButton("Add"); // ±∏«ˆ¡ﬂ (Add«œ¿⁄∏∂¿⁄ Sortøœ∑·, FileIO ±∏«ˆ«ÿæﬂµ )
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Add_Edit_Delete_Dialog dlg = new Add_Edit_Delete_Dialog(Frame, Day_View_Frame.ADD);
						dlg.setVisible(true);
						
						Doing tmpDoing = dlg.getDoing();
			            if(tmpDoing != null) {
			            	
			            	String divide[] = new String[2];
			            	
			                listDoing.addElement(tmpDoing);
			                //Add«œ¿⁄∏∂¿⁄ Sort«ÿ¡÷¥¬ ∫Œ∫–
			                ArrayList<Doing> doingList = Collections.list(listDoing.elements());
			                Collections.sort(doingList);
			                
			                listDoing.clear();
			                listModel.clear();
			            	listModel_1.clear();
			            	
			                // add Doing list to model
			                ListIterator<Doing> iter = doingList.listIterator();
			                while(iter.hasNext()) {
			                   tmpDoing = iter.next();
			                   listDoing.addElement(tmpDoing);

			                   divide = tmpDoing.toString().split("\\.");
			                   listModel.addElement(divide[0]);
			                   listModel_1.addElement(divide[1]);
			                   
			                }
			            }
			            
			            //listModel¿ª GUIø° √‚∑¬
			            list.setModel(listModel);
			            list_1.setModel(listModel_1);
					}
				});
				option_Panel.add(btnNewButton);
				
				btnNewButton_1 = new JButton("Edit"); // ±∏«ˆ¡ﬂ
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Add_Edit_Delete_Dialog dlg = new Add_Edit_Delete_Dialog(Frame, Day_View_Frame.EDIT);
						dlg.setVisible(true);
						
						Doing tmpDoing = dlg.getDoing();
			            if(tmpDoing != null) {
			            	
			            	String divide[] = new String[2];
			            	
			                listDoing.addElement(tmpDoing);
			                //Add«œ¿⁄∏∂¿⁄ Sort«ÿ¡÷¥¬ ∫Œ∫–
			                ArrayList<Doing> doingList = Collections.list(listDoing.elements());
			                Collections.sort(doingList);
			                
			                listDoing.clear();
			                listModel.clear();
			            	listModel_1.clear();
			            	
			                // add Doing list to model
			                ListIterator<Doing> iter = doingList.listIterator();
			                while(iter.hasNext()) {
			                   tmpDoing = iter.next();
			                   listDoing.addElement(tmpDoing);

			                   divide = tmpDoing.toString().split("\\.");
			                   listModel.addElement(divide[0]);
			                   listModel_1.addElement(divide[1]);
			                   
			                }
			            }
			            
			            //listModel¿ª GUIø° √‚∑¬
			            list.setModel(listModel);
			            list_1.setModel(listModel_1);
					}
				});
				option_Panel.add(btnNewButton_1);
				
				btnNewButton_2 = new JButton("Delete");//æ∆¡˜ ±∏«ˆ X
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Add_Edit_Delete_Dialog dlg = new Add_Edit_Delete_Dialog(Frame, Day_View_Frame.DELETE);
						dlg.setVisible(true);
					}
				});
				option_Panel.add(btnNewButton_2);
				
				time_doing_Panel = new JPanel();
				time_doing_Panel.setBackground(Color.LIGHT_GRAY);
				time_doing_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				dialog_Pane.setRightComponent(time_doing_Panel);

				dialog_Pane.setDividerLocation(65);
				dialog_Pane.setDividerSize(30);
				
				GridBagLayout gbl_time_doing_Panel = new GridBagLayout();
				gbl_time_doing_Panel.columnWidths = new int[]{151, 0, 0, 0, 0};
				gbl_time_doing_Panel.rowHeights = new int[]{0, 26, 0, 0};
				gbl_time_doing_Panel.columnWeights = new double[]{1.0, 1.0, 2.0, 1.0, Double.MIN_VALUE};
				gbl_time_doing_Panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
				time_doing_Panel.setLayout(gbl_time_doing_Panel);
				
				txtTime = new JTextField();
				txtTime.setFont(new Font("HY¬∞√ü¬∞√≠¬µ√±", Font.PLAIN, 18));
				txtTime.setText("Time");
				GridBagConstraints gbc_txtTime = new GridBagConstraints();
				gbc_txtTime.gridheight = 2;
				gbc_txtTime.insets = new Insets(0, 0, 5, 5);
				gbc_txtTime.fill = GridBagConstraints.BOTH;
				gbc_txtTime.gridx = 0;
				gbc_txtTime.gridy = 0;
				time_doing_Panel.add(txtTime, gbc_txtTime);
				txtTime.setColumns(10);
				
				txtToDo = new JTextField();
				txtToDo.setFont(new Font("HY¬∞√ü¬∞√≠¬µ√±", Font.PLAIN, 18));
				txtToDo.setText("To Do");
				txtToDo.setColumns(10);
				GridBagConstraints gbc_txtToDo = new GridBagConstraints();
				gbc_txtToDo.gridwidth = 3;
				gbc_txtToDo.gridheight = 2;
				gbc_txtToDo.insets = new Insets(0, 0, 5, 0);
				gbc_txtToDo.fill = GridBagConstraints.BOTH;
				gbc_txtToDo.gridx = 1;
				gbc_txtToDo.gridy = 0;
				time_doing_Panel.add(txtToDo, gbc_txtToDo);
				
	
				listDoing = new DefaultListModel<Doing>();
				
				listModel = new DefaultListModel<String>();
				list = new JList<String>(listModel);
				list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				
				listModel_1 = new DefaultListModel<String>();
				list_1 = new JList<String>(listModel_1);
				list_1.setLayoutOrientation(JList.HORIZONTAL_WRAP);

			      
			    scrollPane = new JScrollPane(list);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 2;
				time_doing_Panel.add(scrollPane, gbc_scrollPane);
				
				
				scrollPane_1 = new JScrollPane(list_1);
				GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
				gbc_scrollPane_1.gridwidth = 3;
				gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_1.gridx = 1;
				gbc_scrollPane_1.gridy = 2;
				time_doing_Panel.add(scrollPane_1, gbc_scrollPane_1);
				
				
				this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   
				
	}
	
	
}




















