package mini_project;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Paint;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;


public class Month_View_Frame implements ActionListener {
	private GregorianCalendar cal1, cal2;
	JFrame frame;
	private JPanel main;
	private JPanel up;
	private JPanel down;
	private JButton previous_button;
	private JComboBox<String> monthChoice;
	private JButton year;
	private JButton next_button;
	private JPanel datep;
	private JPanel dayp;

  
	private int currentMonth;
	private int currentYear;
	private int currentDay;
	private String days[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	private String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	// private int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	// };

	private int currentMonth;// 현재월
	private int currentYear;// 현재연도
	private int currentDay;// 현재요일
	private String days[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	private String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	//private int daysInMonth[] = new int[12];
    //private int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };


	private JButton[][] monthButtons = new JButton[6][7];
	private JLabel[] dayLabels = new JLabel[7];
	private int[][] monthArr = new int[6][7];

	/**
	 * Launch the application.
	 */


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Month_View_Frame window = new Month_View_Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public Month_View_Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		// calculate the current Year and current Month using class GregorianCalendar

		cal1 = (GregorianCalendar) Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal1.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		currentYear = cal1.get(Calendar.YEAR);
		currentMonth = cal1.get(Calendar.MONTH);


		// main frame- frame

		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calendars");


		/*
		 * change the look & feel try{ UIManager.setLookAndFeel
		 * ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		 * SwingUtilities.updateComponentTreeUI(frame) ; }catch(Exception e){
		 * //bottomInfo.setText("ERROR : LookAndFeel setting failed"); }
		 */

		// main panel
		
		main = new JPanel();
		frame.getContentPane().add(main, BorderLayout.CENTER);
		main.setLayout(new BorderLayout(0, 0));

		up = new JPanel();
		up.setBackground(Color.white);
		main.add(up, BorderLayout.NORTH);
		up.setPreferredSize(new Dimension(750, 50));

		previous_button = new JButton("<");

		previous_button.setLocation(116, 0);
		previous_button.setSize(70, 50);
		previous_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectMonth = monthChoice.getSelectedIndex();

				if (selectMonth == 0) {
					cal1.set(Calendar.YEAR, currentYear - 1);
					currentYear = cal1.get(Calendar.YEAR);
					year.setText("" + currentYear);
					monthChoice.setSelectedIndex(11);
					cal1.set(Calendar.MONTH, 11);
					currentMonth = cal1.get(Calendar.MONTH);
				} else {
					monthChoice.setSelectedIndex(selectMonth - 1);

					cal1.set(Calendar.MONTH, selectMonth - 1);

					cal1.set(Calendar.MONTH, selectMonth - 1);// 선택한 월을 현재 달로 설정

					currentMonth = cal1.get(Calendar.MONTH);
					display_cal();
				}
			}
		});
		up.setLayout(null);
		up.add(previous_button);

		monthChoice = new JComboBox<String>();

		monthChoice.setBounds(200, 0, 161, 50);
		monthChoice.setFont(new Font("굴림", Font.PLAIN, 15));

		for (int i = 0; i < months.length; i++) {
			monthChoice.addItem(months[i]);
		}

		monthChoice.setSelectedIndex(currentMonth);
		monthChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// Object o = ae.getSource();

				int selectMonth = monthChoice.getSelectedIndex();
				monthChoice.setSelectedIndex(selectMonth);
				cal1.set(Calendar.MONTH, selectMonth);

			
				currentMonth = cal1.get(Calendar.MONTH);
				display_cal();
			}
		});

		up.add(monthChoice);


		year = new JButton("" + currentYear);
		year.setBounds(373, 0, 138, 48);
		year.setFont(new Font("굴림", Font.BOLD, 17));
		up.add(year);
		year.setHorizontalAlignment(SwingConstants.CENTER);


		next_button = new JButton(">");
		//next_button.setBorder(new EtchedBorder());
		//next_button.setBackground(Color.white);
		next_button.setBounds(525, 0, 70, 50);
		next_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectMonth = monthChoice.getSelectedIndex();

				if (selectMonth == 11) {
					cal1.set(Calendar.YEAR, currentYear + 1);
					currentYear = cal1.get(Calendar.YEAR);
					year.setText("" + currentYear);
					monthChoice.setSelectedIndex(0);
					cal1.set(Calendar.MONTH, 0);
					currentMonth = cal1.get(Calendar.MONTH);
				} else {

					monthChoice.setSelectedIndex(selectMonth + 1);
					cal1.set(Calendar.MONTH, selectMonth + 1);

					currentMonth = cal1.get(Calendar.MONTH);
					display_cal();
				}
			}
		});
		up.add(next_button);

		down = new JPanel();
		down.setBackground(Color.white);
		main.add(down, BorderLayout.CENTER);
		down.setLayout(new BorderLayout(0, 0));

		dayp = new JPanel();
		dayp.setPreferredSize(new Dimension(750, 30));
		dayp.setBackground(Color.white);
		dayp.setLayout(new GridLayout(1, 7));
		for (int i = 0; i < days.length; i++) {
			dayLabels[i] = new JLabel(days[i] + "   ");
			dayLabels[i].setHorizontalAlignment(JLabel.RIGHT);
			// dayLabels[i].setFont(helvB16);
			dayp.add(dayLabels[i]);
		}
		down.add(dayp, BorderLayout.NORTH);

		datep = new JPanel();
		datep.setLayout(new GridLayout(6, 7));

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				// count_i = i;
				// count_j = j;
				monthButtons[i][j] = new JButton("");
				monthButtons[i][j].addActionListener(this);
				datep.add(monthButtons[i][j]);
			}
		}
		down.add(datep, BorderLayout.CENTER);
		display_cal();
	}

	public void actionPerformed(ActionEvent ae) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (ae.getSource() == monthButtons[i][j]) {
					Day_View_Frame dayframe = new Day_View_Frame(months[currentMonth] + " - " + monthArr[i][j]);
				}
			}
		}
	}

	public void display_cal() {
		cal2 = new GregorianCalendar(currentYear, currentMonth, 1);

		currentDay = cal2.get(GregorianCalendar.DAY_OF_WEEK);
		int MaxDate = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		int date_Now = 1;
		boolean ok = true;


		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (monthButtons[i][j] != null) {

					monthButtons[i][j].setBorder(new EtchedBorder()); //
					monthButtons[i][j].setHorizontalAlignment(SwingConstants.RIGHT);
					//monthButtons[i][j].setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
					monthButtons[i][j].setFont(new Font("고딕", Font.ITALIC, 15));
					if (date_Now == 1 && j + 1 < currentDay) {
						monthButtons[i][j].setText("");
					} else if (date_Now > MaxDate) {
						monthButtons[i][j].setText("");
					} else {

						String today = "" + date_Now;
						monthArr[i][j] = date_Now;
						monthButtons[i][j].setText(today);
						date_Now++;

					}
				}
				if (j == 0) {
					monthButtons[i][j].setBackground(Color.PINK);
					// monthButtons[i][j].setBackground(Color.red);
				}
			}
		}
	}
}
