package mini_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Add_Edit_Delete_Dialog extends JDialog {

	private final JPanel main_Panel = new JPanel();
	private JTextField txtEvent;
	private JTextField txtFrom;
	private JTextField txtTo;
	private Doing doing;

	public Doing getDoing() {
		return doing;
	}

	/**
	 * Create the dialog.
	 */
	public Add_Edit_Delete_Dialog(Day_View_Frame parent, int Type) {

		super(parent, true);
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		setTitle(parent.getTitle());
		setBounds(100, 100, 400, 276);
		getContentPane().setLayout(new BorderLayout());
		main_Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(main_Panel, BorderLayout.CENTER);
		GridBagLayout gbl_main_Panel = new GridBagLayout();
		gbl_main_Panel.columnWidths = new int[]{69, 277, 0};
		gbl_main_Panel.rowHeights = new int[]{55, 55, 55, 0, 0};
		gbl_main_Panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_main_Panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		main_Panel.setLayout(gbl_main_Panel);
		
				{
					txtEvent = new JTextField("Event name");
					txtEvent.setForeground(Color.GRAY);
					txtEvent.addFocusListener(new FocusListener() {
						@Override
						public void focusGained(FocusEvent e) {
							if (txtEvent.getText().equals("Event name")) {
								txtEvent.setText("");
								txtEvent.setForeground(Color.BLACK);
							}
						}
		
						@Override
						public void focusLost(FocusEvent e) {
							if (txtEvent.getText().isEmpty()) {
								txtEvent.setForeground(Color.GRAY);
								txtEvent.setText("Event name");
							}
						}
		
					});
					{
						JLabel labelEvent = new JLabel("Event");
						labelEvent.setFont(new Font("굴림", Font.PLAIN, 18));
						GridBagConstraints gbc_labelEvent = new GridBagConstraints();
						gbc_labelEvent.fill = GridBagConstraints.BOTH;
						gbc_labelEvent.insets = new Insets(0, 0, 5, 5);
						gbc_labelEvent.gridx = 0;
						gbc_labelEvent.gridy = 0;
						main_Panel.add(labelEvent, gbc_labelEvent);
					}
					GridBagConstraints gbc_txtEvent = new GridBagConstraints();
					gbc_txtEvent.fill = GridBagConstraints.BOTH;
					gbc_txtEvent.insets = new Insets(0, 0, 5, 0);
					gbc_txtEvent.gridx = 1;
					gbc_txtEvent.gridy = 0;
					main_Panel.add(txtEvent, gbc_txtEvent);
					txtEvent.setColumns(10);
				}
		{
			txtFrom = new JTextField("XX:XX");
			txtFrom.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txtFrom.getText().equals("XX:XX")) {
						txtFrom.setText("");
						txtFrom.setForeground(Color.BLACK);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (txtFrom.getText().isEmpty()) {
						txtFrom.setForeground(Color.GRAY);
						txtFrom.setText("XX:XX");
					}
				}

			});
			{
				JLabel labelFrom = new JLabel("From");
				labelFrom.setFont(new Font("굴림", Font.PLAIN, 18));
				GridBagConstraints gbc_labelFrom = new GridBagConstraints();
				gbc_labelFrom.fill = GridBagConstraints.BOTH;
				gbc_labelFrom.insets = new Insets(0, 0, 5, 5);
				gbc_labelFrom.gridx = 0;
				gbc_labelFrom.gridy = 1;
				main_Panel.add(labelFrom, gbc_labelFrom);
			}
			GridBagConstraints gbc_txtFrom = new GridBagConstraints();
			gbc_txtFrom.fill = GridBagConstraints.BOTH;
			gbc_txtFrom.insets = new Insets(0, 0, 5, 0);
			gbc_txtFrom.gridx = 1;
			gbc_txtFrom.gridy = 1;
			main_Panel.add(txtFrom, gbc_txtFrom);
			txtFrom.setColumns(10);
		}
		{
			txtTo = new JTextField("XX:XX");
			txtTo.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txtTo.getText().equals("XX:XX")) {
						txtTo.setText("");
						txtTo.setForeground(Color.BLACK);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (txtTo.getText().isEmpty()) {
						txtTo.setForeground(Color.GRAY);
						txtTo.setText("XX:XX");
					}
				}

			});
			{
				JLabel labelTo = new JLabel("To");
				labelTo.setFont(new Font("굴림", Font.PLAIN, 18));
				GridBagConstraints gbc_labelTo = new GridBagConstraints();
				gbc_labelTo.fill = GridBagConstraints.BOTH;
				gbc_labelTo.insets = new Insets(0, 0, 5, 5);
				gbc_labelTo.gridx = 0;
				gbc_labelTo.gridy = 2;
				main_Panel.add(labelTo, gbc_labelTo);
			}
			txtTo.setColumns(10);
			GridBagConstraints gbc_txtTo = new GridBagConstraints();
			gbc_txtTo.insets = new Insets(0, 0, 5, 0);
			gbc_txtTo.fill = GridBagConstraints.BOTH;
			gbc_txtTo.gridx = 1;
			gbc_txtTo.gridy = 2;
			main_Panel.add(txtTo, gbc_txtTo);
		}

		{
			JPanel btPane = new JPanel();
			getContentPane().add(btPane, BorderLayout.SOUTH);
			btPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			{
				JButton btOk = new JButton("OK");
				btOk.setHorizontalAlignment(SwingConstants.LEADING);
				btOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// ADD踰꾪듉�쓣 �닃���쓣 �븣 援ы쁽�셿猷�
						if (Type == Day_View_Frame.ADD) {
							try {

								String splitData[];
								int fromHour, fromMin, doing_from;
								int toHour, toMin, doing_to;
								boolean check;
								// From txt�뿉 input�맂 媛믪씠 �삎�떇�쓣 留욎톬�뒗吏� 寃��궗

								check = txtFrom.getText().matches("\\d{2}:\\d{2}");

								if (!check) {
									JOptionPane.showMessageDialog(parent, "Error: From Number should be XX:XX",
											"Wrong format", JOptionPane.ERROR_MESSAGE, null);
									return;
								}
								// To txt�뿉 input�맂 媛믪씠 �삎�떇�쓣 留욎톬�뒗吏� 寃��궗

								check = txtTo.getText().matches("\\d{2}:\\d{2}");

								if (!check) {
									JOptionPane.showMessageDialog(parent, "Error: To Number should be XX:XX",
											"Wrong format", JOptionPane.ERROR_MESSAGE, null);

									return;

								}

								// :�쓣 湲곗��쑝濡� 履쇨컻�꽌 �떆媛꾧낵 遺꾩쓣 遺꾨━
								splitData = txtFrom.getText().split(":");

								fromHour = Integer.parseInt(splitData[0]);
								if (fromHour >= 24 || fromHour < 0) {
									JOptionPane.showMessageDialog(parent,
											"Error: From Time's hour should be under than 24 and be greater than or equal to 0",
											"Wrong hour", JOptionPane.ERROR_MESSAGE, null);

									return;
								}
								fromMin = Integer.parseInt(splitData[1]);
								if (fromMin >= 60 || fromMin < 0) {
									JOptionPane.showMessageDialog(parent,
											"Error: From Time's minute should be under than 60 and be greater than or equal to 0",
											"Wrong minute", JOptionPane.ERROR_MESSAGE, null);

									return;
								}
								doing_from = fromHour * 60 + fromMin;

								splitData = txtTo.getText().split(":");

								toHour = Integer.parseInt(splitData[0]);
								if (toHour >= 24 || toHour < 0) {
									JOptionPane.showMessageDialog(parent,
											"Error: To Time's hour should be under than 24 and be greater than or equal to 0",
											"Wrong hour", JOptionPane.ERROR_MESSAGE, null);

									return;
								}
								toMin = Integer.parseInt(splitData[1]);
								if (toMin >= 60 || toMin < 0) {
									JOptionPane.showMessageDialog(parent,
											"Error: To Time's minute should be under than 60 and be greater than or equal to 0",
											"Wrong minute", JOptionPane.ERROR_MESSAGE, null);

									return;
								}
								doing_to = toHour * 60 + toMin;

								if (0 > doing_from || doing_from >= doing_to) {
									JOptionPane.showMessageDialog(parent,
											"Error: The start Time must be before the end Time", "Wrong range",
											JOptionPane.ERROR_MESSAGE, null);

									return;
								}

								doing = new Doing(doing_from, doing_to, txtEvent.getText());

							} catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(parent, "Error: You should input Nubmer", "Wrong type",
										JOptionPane.ERROR_MESSAGE, null);
								return;
							}

							setVisible(false);
						}

						else if (Type == Day_View_Frame.EDIT) {
							try {

								String splitData[];
								int fromHour, fromMin, doing_from;
								int toHour, toMin, doing_to;
								boolean check;
								// From txt�뿉 input�맂 媛믪씠 �삎�떇�쓣 留욎톬�뒗吏� 寃��궗

								check = txtFrom.getText().matches("\\d{2}:\\d{2}");

								if (!check) {
									JOptionPane.showMessageDialog(parent, "Error: From Number should be XX:XX",
											"Wrong format", JOptionPane.ERROR_MESSAGE, null);
									return;
								}
								// To txt�뿉 input�맂 媛믪씠 �삎�떇�쓣 留욎톬�뒗吏� 寃��궗

								check = txtTo.getText().matches("\\d{2}:\\d{2}");

								if (!check) {
									JOptionPane.showMessageDialog(parent, "Error: To Number should be XX:XX",
											"Wrong format", JOptionPane.ERROR_MESSAGE, null);

									return;

								}

								// :�쓣 湲곗��쑝濡� 履쇨컻�꽌 �떆媛꾧낵 遺꾩쓣 遺꾨━
								splitData = txtFrom.getText().split(":");

								fromHour = Integer.parseInt(splitData[0]);
								if (fromHour >= 24 || fromHour < 0) {
									JOptionPane.showMessageDialog(parent,
											"Error: From Time's hour should be under than 24 and be greater than or equal to 0",
											"Wrong hour", JOptionPane.ERROR_MESSAGE, null);

									return;
								}
								fromMin = Integer.parseInt(splitData[1]);
								if (fromMin >= 60 || fromMin < 0) {
									JOptionPane.showMessageDialog(parent,
											"Error: From Time's minute should be under than 60 and be greater than or equal to 0",
											"Wrong minute", JOptionPane.ERROR_MESSAGE, null);

									return;
								}
								doing_from = fromHour * 60 + fromMin;

								splitData = txtTo.getText().split(":");

								toHour = Integer.parseInt(splitData[0]);
								if (toHour >= 24 || toHour < 0) {
									JOptionPane.showMessageDialog(parent,
											"Error: To Time's hour should be under than 24 and be greater than or equal to 0",
											"Wrong hour", JOptionPane.ERROR_MESSAGE, null);

									return;
								}
								toMin = Integer.parseInt(splitData[1]);
								if (toMin >= 60 || toMin < 0) {
									JOptionPane.showMessageDialog(parent,
											"Error: To Time's minute should be under than 60 and be greater than or equal to 0",
											"Wrong minute", JOptionPane.ERROR_MESSAGE, null);

									return;
								}
								doing_to = toHour * 60 + toMin;

								if (0 > doing_from || doing_from >= doing_to) {
									JOptionPane.showMessageDialog(parent,
											"Error: The start Time must be before the end Time", "Wrong range",
											JOptionPane.ERROR_MESSAGE, null);

									return;
								}

								doing = new Doing(doing_from, doing_to, txtEvent.getText());
							} catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(parent, "Error: You should input Nubmer", "Wrong type",
										JOptionPane.ERROR_MESSAGE, null);
								return;
							}

							setVisible(false);
						}

						// Delete踰꾪듉�쓣 �닃���쓣 �븣 �븘吏� 援ы쁽X

					}

				});
				btOk.setActionCommand("OK");
				btPane.add(btOk);
				getRootPane().setDefaultButton(btOk);
			}

			{
				JButton btCancel = new JButton("Cancel");
				btCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// store info
						doing = null;

						// close the Dialog
						setVisible(false);
					}
				});
				btCancel.setActionCommand("Cancel");
				btPane.add(btCancel);
			}
		}
		if (Type == Day_View_Frame.EDIT) {
			Doing tmpDoing = parent.getlistDoing().getElementAt(parent.getselectNo());
			txtFrom.setText(String.format("%02d:%02d", tmpDoing.getTimeFrom() / 60, tmpDoing.getTimeFrom() % 60));
			txtTo.setText(String.format("%02d:%02d", tmpDoing.getTimeTo() / 60, tmpDoing.getTimeTo() % 60));

			txtEvent.setText(tmpDoing.getToDo());
		}

	}

}