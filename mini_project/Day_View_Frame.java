package mini_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

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
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.OverlayLayout;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Day_View_Frame extends JDialog {

	// constants to pass over when open the Add_Edit_Delete_Dialog
	// so that judge purpose of the frame along Add, Edit, Delete
	public static final int ADD = 1;
	public static final int EDIT = 2;
	public static final int DELETE = 3;

	// fields that are components for Day_View_Frame and create, organize, update
	// the GUI.
	private JTable table;
	private JScrollPane clockTable;
	private JPanel option_Panel;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JPanel time_doing_Panel;
	private JSplitPane main_Pane;
	private JSplitPane dialog_Pane;
	private JTextField txtTime;
	private JTextField txtToDo;
	private JScrollPane scrollPane;
	private JDialog Dialog = this;

	// fields to sort, print, manage Doing Object
	private JList<Doing> list;
	private DefaultListModel<Doing> listDoing;
	private ArrayList<Doing> doingList;

	private int selectNo;

	// fields to manage File I/O
	private boolean checkFile = false;
	private InputStream input_S;
	private BufferedInputStream bInput_S;
	private ObjectInputStream objInput_S;

	// methods

	/*
	 * Constructor - take arguments for JFrame and 2 Dimension string array to set
	 * the title of the frame and open the file which is match with each
	 * date(ex-20180601)
	 */

	public Day_View_Frame(JFrame frame, String[] str) {
		super(frame, str[1] + " - " + str[2], true);
		getContentPane().setLayout(null);

		// main_Pane - main Pane that consisted of clockTable and dialog_Pane
		main_Pane = new JSplitPane();
		main_Pane.setBounds(0, 0, 852, 513);

		getContentPane().add(main_Pane);

		this.setSize(870, 560);

		// clockTable - JScrollPane that display Graphical image of to-do list
		clockTable = new JScrollPane(new DrawGraph());
		clockTable.getViewport().setPreferredSize(new Dimension(300, 600));
		clockTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		main_Pane.setLeftComponent(clockTable); 

		// dialog_Pane - option_Panel, time_doing_Panel will be attached
		// display the each job's name, start time and end time.
		// Also enables to Add, Edit, Delete the to-do list
		dialog_Pane = new JSplitPane();
		main_Pane.setRightComponent(dialog_Pane);
		main_Pane.setDividerLocation((int) this.getSize().getWidth() / 5 * 2);
		main_Pane.setDividerSize(15);
		dialog_Pane.setOrientation(JSplitPane.VERTICAL_SPLIT);

		// time_doing_Panel - txtTime, txtTodo and scrollPane will be attached
		time_doing_Panel = new JPanel();
		time_doing_Panel.setBackground(Color.LIGHT_GRAY);
		time_doing_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		dialog_Pane.setRightComponent(time_doing_Panel);

		dialog_Pane.setDividerLocation(65);
		dialog_Pane.setDividerSize(30);

		// set GridBagLayout to time_doing_Panel
		GridBagLayout gbl_time_doing_Panel = new GridBagLayout();
		gbl_time_doing_Panel.columnWidths = new int[] { 151, 0, 0, 0, 0 };
		gbl_time_doing_Panel.rowHeights = new int[] { 0, 26, 0, 0 };
		gbl_time_doing_Panel.columnWeights = new double[] { 1.0, 1.0, 2.0, 1.0, Double.MIN_VALUE };
		gbl_time_doing_Panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		time_doing_Panel.setLayout(gbl_time_doing_Panel);

		// txtTime designing
		txtTime = new JTextField();
		txtTime.setFont(new Font("HY????碌帽", Font.PLAIN, 18));
		txtTime.setText("Time");
		txtTime.setColumns(10);
		GridBagConstraints gbc_txtTime = new GridBagConstraints();
		gbc_txtTime.gridheight = 2;
		gbc_txtTime.insets = new Insets(0, 0, 5, 5);
		gbc_txtTime.fill = GridBagConstraints.BOTH;
		gbc_txtTime.gridx = 0;
		gbc_txtTime.gridy = 0;
		time_doing_Panel.add(txtTime, gbc_txtTime);

		// txtTodo designing
		txtToDo = new JTextField();
		txtToDo.setFont(new Font("HY????碌帽", Font.PLAIN, 18));
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

		// option_Panel - btnAdd, btnEdit, btnDelete will be attached
		option_Panel = new JPanel();
		option_Panel.setBorder(new EmptyBorder(8, 10, 8, 10));
		dialog_Pane.setLeftComponent(option_Panel);
		option_Panel.setLayout(new GridLayout(0, 3, 0, 0));

		// btnAdd
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Edit_Delete_Dialog dlg = new Add_Edit_Delete_Dialog((Day_View_Frame) Dialog, Day_View_Frame.ADD);
				dlg.setVisible(true);
				Doing tmpDoing = dlg.getDoing();

				if (tmpDoing != null) {
					listDoing.addElement(tmpDoing);

					// Before add tmpDoing to listsDoing sort the objects for time order
					doingList = Collections.list(listDoing.elements());
					Collections.sort(doingList);
					listDoing.clear();

					// add doinglist's object to listDoing 
					ListIterator<Doing> iter = doingList.listIterator();
					while (iter.hasNext()) {
						tmpDoing = iter.next();
						listDoing.addElement(tmpDoing);
					}
					clockTable.repaint(); // repaint to update the graphical image
					;
				}

			}
		});
		option_Panel.add(btnAdd);

		// btnEdit
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// check if selected
				if (list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(Dialog, "Error: You should select to edit ", "Nothing Select",
							JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				setselectNo(list.getSelectedIndex());
				Add_Edit_Delete_Dialog dlg = new Add_Edit_Delete_Dialog((Day_View_Frame) Dialog, Day_View_Frame.EDIT);
				dlg.setVisible(true);

				Doing tmpDoing = dlg.getDoing();
				if (tmpDoing != null) {

					listDoing.setElementAt(tmpDoing, getselectNo());

					doingList = Collections.list(listDoing.elements());
					Collections.sort(doingList);

					listDoing.clear();

					// add doinglist's object to listDoing 
					ListIterator<Doing> iter = doingList.listIterator();
					while (iter.hasNext()) {
						tmpDoing = iter.next();
						listDoing.addElement(tmpDoing);
					}
					clockTable.repaint();
				}

			}
		});
		option_Panel.add(btnEdit);

		// btnDelete
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(Dialog, "Error: You should select to edit ", "Nothing Select",
							JOptionPane.ERROR_MESSAGE, null);
					return;
				}

				listDoing.removeElementAt(list.getSelectedIndex()); // delete the selected index
				doingList = Collections.list(listDoing.elements());
				clockTable.repaint();

			}
		});
		option_Panel.add(btnDelete);

		// list & listDoing
		listDoing = new DefaultListModel<Doing>();
		list = new JList<Doing>(listDoing);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

		// scrollPane designing - add list to scrollPane
		scrollPane = new JScrollPane(list);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		time_doing_Panel.add(scrollPane, gbc_scrollPane);

		// File I/O
		File f = new File(String.format("%d%02d%02d.dat", Integer.parseInt(str[0]), this.checkMonth(str[1]),
				Integer.parseInt(str[2])));

		if (f.exists()) {
			try {
				input_S = new FileInputStream(String.format("%d%02d%02d.dat", Integer.parseInt(str[0]),
						this.checkMonth(str[1]), Integer.parseInt(str[2])));
				bInput_S = new BufferedInputStream(input_S);
				objInput_S = new ObjectInputStream(bInput_S);

				setlistDoing((DefaultListModel<Doing>) objInput_S.readObject());
				doingList = Collections.list(listDoing.elements());
				checkFile = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					objInput_S.close();
					list.setModel(listDoing);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Get & Set functions to selectNo and listDoing
	public int getselectNo() {
		return selectNo;
	}

	public void setselectNo(int selectNo) {
		this.selectNo = selectNo;
	}

	public DefaultListModel<Doing> getlistDoing() {
		Doing tmpDoing;
		DefaultListModel<Doing> NewlistDoing = new DefaultListModel<Doing>();
		ArrayList<Doing> doingList = Collections.list(listDoing.elements());

		ListIterator<Doing> iter = doingList.listIterator();
		while (iter.hasNext()) {
			tmpDoing = iter.next();
			NewlistDoing.addElement(tmpDoing);
		}
		return NewlistDoing;
	}

	public void setlistDoing(DefaultListModel<Doing> listDoing) {
		Doing tmpDoing;
		ArrayList<Doing> doingList = Collections.list(listDoing.elements());
		listDoing.clear();
		ListIterator<Doing> iter = doingList.listIterator();
		while (iter.hasNext()) {
			tmpDoing = iter.next();
			this.listDoing.addElement(tmpDoing);
		}
	}

	// check the month
	public int checkMonth(String Month) {
		String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int i;
		for (i = 0; i < 12; i++) {
			if (Month == months[i])
				break;
		}
		return i + 1;
	}

	// methods to checkfile
	public boolean getcheckFile() {
		return checkFile;
	}

	// class to Draw Graphical image
	class DrawGraph extends JPanel {
		private static final int WIDTH = 10000;
		private static final int HEIGHT = 960;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("Gulim", Font.PLAIN, 20));
			for (int i = 0; i < 24; i++) {
				g.drawRect(0, 40 * i, 10000, 40); // x, y, width, height
				g.setColor(new Color(255, 255, 255));
				g.fillRect(0, 40 * i + 1, 10000, 37);
				g.setColor(new Color(0, 0, 0));
				if (i < 10)
					g.drawString("0" + i + ":00", 0, 40 * i + 30); // draw time sections
				else {
					g.drawString(i + ":00", 0, 40 * i + 30);
				}
			}

			int timeStart[][] = new int[100][100]; // to compare with time_from
			int timeEnd[][] = new int[100][100]; // to compare with time_to

			int p = 0;
			if (doingList != null) {
				for (Doing i : doingList) {
					int x_start = 0;
					while (true) {
						if (timeStart[x_start][0] != 0) {
							boolean isBreak = true;
							int end = 0;
							for (end = 0; timeStart[x_start][end] != 0; end++)
								;
							end--;

							for (int t = 0; t <= end; t++) {
								if (timeStart[x_start][t] <= i.getTimeFrom() && timeEnd[x_start][t] > i.getTimeFrom()) {
									isBreak = false;
									x_start++;
								}
								if (timeStart[x_start][t] <= i.getTimeTo() && timeEnd[x_start][t] > i.getTimeTo()) {
									isBreak = false;
									x_start++;
								}
								if (timeStart[x_start][t] > i.getTimeFrom() && timeEnd[x_start][t] < i.getTimeTo()) {
									isBreak = false;
									x_start++;
								}
							}
							if (isBreak) {
								timeStart[x_start][end + 1] = i.getTimeFrom();
								timeEnd[x_start][end + 1] = i.getTimeTo();
								break;
							}
						} else {
							timeStart[x_start][0] = i.getTimeFrom();
							timeEnd[x_start][0] = i.getTimeTo();
							break;
						}
					}

					// for assign different color for each job graph
					if (p % 6 == 0) {
						g.setColor(new Color(255, 102, 102));
					} else if (p % 6 == 1) {
						g.setColor(new Color(255, 255, 102));
					} else if (p % 6 == 2) {
						g.setColor(new Color(000, 255, 153));
					} else if (p % 6 == 3) {
						g.setColor(new Color(153, 204, 255));
					} else if (p % 6 == 4) {
						g.setColor(new Color(204, 153, 204));
					} else if (p % 6 == 5) {
						g.setColor(new Color(204, 153, 153));
					}

					g.fillRect(60 + x_start * 50, (i.getTimeFrom()) * 2 / 3, 50,
							(i.getTimeTo() - i.getTimeFrom()) * 2 / 3);
					g.setColor(new Color(0, 0, 0));
					g.setFont(new Font("Gulim", Font.PLAIN, 15));

					// draw text for to-do above the each rectangle
					// if length of job is more than 5 characters, divide the text into segment
					if (i.getToDo().length() <= 5) {
						g.drawString(i.getToDo(), 60 + x_start * 50 + 5,
								(i.getTimeFrom()) * 2 / 3 + (i.getTimeTo() - i.getTimeFrom()) / 3);
					} else {
						// if the length of the job is too big to print in rectangle graph
						if ((i.getTimeTo() - i.getTimeFrom()) / 12 < i.getToDo().length()) {
							int j = 0;
							g.drawString(i.getToDo().substring(0, 3) + "...", 60 + x_start * 50 + 5,
									(i.getTimeFrom()) * 2 / 3 + (i.getTimeTo() - i.getTimeFrom()) / 3 + 15 * j / 5);
						}

						else {
							int j = 0;
							for (j = 0; j < i.getToDo().length() - 4; j += 5) {
								g.drawString(i.getToDo().substring(j, j + 5), 60 + x_start * 50 + 5,
										(i.getTimeFrom()) * 2 / 3 + (i.getTimeTo() - i.getTimeFrom()) / 3 + 15 * j / 5);
							}
							g.drawString(i.getToDo().substring(j), 60 + x_start * 50 + 5,
									(i.getTimeFrom()) * 2 / 3 + (i.getTimeTo() - i.getTimeFrom()) / 3 + 15 * j / 5);
						}
					}
					p++;
				}
			}
		}

		public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		}
	}
}
