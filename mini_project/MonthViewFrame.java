package mini_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MonthViewFrame {
   private GregorianCalendar cal1, cal2;
   private JFrame frame;
   private JPanel main;
   private JPanel up;
   private JPanel down;
   private JButton previous_button;
   private JComboBox<String> monthChoice;
   private JLabel year;
   private JButton next_button;
   private JPanel datep;
   private JPanel dayp;

   private int currentMonth;// �����
   private int currentYear;// ���翬��
   private int currentDay;// �������
   private String days[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
   private String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
         "October", "November", "December" };
   private int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

   private JButton[][] monthButtons = new JButton[6][7];
   private JLabel[] dayLabels = new JLabel[7];
   private JPanel panel;
   private JLabel guiname;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MonthViewFrame window = new MonthViewFrame();
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
   public MonthViewFrame() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      cal1 = new GregorianCalendar();
      currentYear = cal1.get(Calendar.YEAR);
      currentMonth = cal1.get(Calendar.MONTH);

      frame = new JFrame();
      frame.setBounds(100, 100, 750, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      panel = new JPanel();
      frame.getContentPane().add(panel, BorderLayout.NORTH);
      panel.setLayout(new BorderLayout(0, 0));
      
      guiname = new JLabel("Calendar");
      guiname.setBackground(Color.BLUE);
      guiname.setVerticalAlignment(SwingConstants.BOTTOM);
      panel.add(guiname);

      // main panel 
      main = new JPanel();
      frame.getContentPane().add(main, BorderLayout.CENTER);
      main.setLayout(new BorderLayout(0, 0));

      // ��ܹ� ���� �г�
      up = new JPanel();
      main.add(up, BorderLayout.NORTH);
      up.setLayout(new GridLayout(1, 4, 0, 0));

      previous_button = new JButton("<");
      previous_button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		int selectMonth = monthChoice.getSelectedIndex();// ������ ���� ���ؽ��� �˾Ƴ�
      		/*
      		 * if(selectMonth == 0) ���� �⵵�� �Ѿ���� 
      		 */
            monthChoice.setSelectedIndex(selectMonth-1);
            cal1.set(Calendar.MONTH, selectMonth - 1);// ������ ���� ���� �޷� ����
            currentMonth = cal1.get(Calendar.MONTH);
            display_cal();
      	}
      });
      up.add(previous_button);

      monthChoice = new JComboBox<String>();
      monthChoice.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            //Object o = ae.getSource();
            int selectMonth = monthChoice.getSelectedIndex();// ������ ���� ���ؽ��� �˾Ƴ�.
            monthChoice.setSelectedIndex(selectMonth);
            cal1.set(Calendar.MONTH, selectMonth);// ������ ���� ���� �޷� ����
            currentMonth = cal1.get(Calendar.MONTH);
            display_cal();
         }
      });

      for (int i = 0; i < months.length; i++) {
         monthChoice.addItem(months[i]);
      }

      monthChoice.setSelectedIndex(currentMonth);
      up.add(monthChoice);

      year = new JLabel("" + currentYear, JLabel.LEFT);
      up.add(year);

      next_button = new JButton(">");
      next_button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		int selectMonth = monthChoice.getSelectedIndex();// ������ ���� ���ؽ��� �˾Ƴ�
      		/*
      		 * if(selectMonth == 11) ���� �⵵�� �Ѿ���� 
      		 */
            monthChoice.setSelectedIndex(selectMonth+1); // ������ ���� Combobox�� ǥ��
            cal1.set(Calendar.MONTH, selectMonth + 1);   // ������ ���� ���� �޷� ����
            currentMonth = cal1.get(Calendar.MONTH);
            display_cal();      		
      	}
      });
      up.add(next_button);

      down = new JPanel();
      main.add(down, BorderLayout.CENTER);
      down.setLayout(new BorderLayout(0, 0));

      dayp = new JPanel();
      dayp.setLayout(new GridLayout(1, 7));
      for (int i = 0; i < days.length; i++) {
         dayLabels[i] = new JLabel(days[i]);
         // dayLabels[i].setFont(helvB16);
         dayp.add(dayLabels[i]);
      }
      down.add(dayp,BorderLayout.NORTH);

      datep = new JPanel();
      datep.setLayout(new GridLayout(6, 7));
      for (int i = 0; i < 6; i++) {
         for (int j = 0; j < 7; j++) {
            monthButtons[i][j] = new JButton("");
            datep.add(monthButtons[i][j]);
         }
      }
      down.add(datep,BorderLayout.CENTER);
      display_cal();
   }

   public void display_cal() {
      cal2 = new GregorianCalendar(currentYear, currentMonth, 1);
      currentDay = cal2.get(Calendar.DAY_OF_WEEK);// ���� ���� ù°������ �˾Ƴ���.

      int MaxDate = daysInMonth[currentMonth];// ���� ���� ������ ��¥�� �˾Ƴ���.
      int date_Now = 1;// ���� ��¥�� ��Ÿ����.
      boolean ok = true;// �� �� ���� ����.

      for (int i = 0; i < 6; i++) {
         for (int j = 0; j < 7; j++) {
            if (monthButtons[i][j] != null) {
               if (date_Now == 1 && j + 1 < currentDay) {// 1���� �Ͽ����� �ƴ϶�� ���ϱ��� ���ư.
                  monthButtons[i][j].setText("");
               } else if (date_Now > MaxDate)// ��¥�� ������ ��¥���� Ŀ����
                  monthButtons[i][j].setText("");
               else {
                  String today = "" + date_Now;
                  monthButtons[i][j].setText(today);
                  date_Now++;
               }
            }
         }
      }
   }
}