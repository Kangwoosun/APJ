package homework8;

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

public class SwingWorkerApp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JButton btnStop;
	JButton btnStart;
	JTextArea txtArea;
	JProgressBar progressBar;
	JLabel lblStatus;
	private JScrollPane scrollPane;
	private JFrame F = this;
	WorkerClass worker;
	private JTextField textField_1;
	private JLabel lblTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingWorkerApp frame = new SwingWorkerApp();
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
	public SwingWorkerApp() {
		setTitle("Find Prime Number");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);

		JPanel pnInput = new JPanel();
		contentPane.add(pnInput, BorderLayout.NORTH);
		pnInput.setLayout(new GridLayout(0, 6, 0, 0));

		JLabel lblNewLabel = new JLabel("Find prime from");
		lblNewLabel.setFont(new Font("πŸ≈¡", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnInput.add(lblNewLabel);

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				// reset all views
				progressBar.setValue(0); // reset JProgressBar
				txtArea.setText(""); // clear JTextArea
				lblStatus.setText(""); // clear JLabel

				// get user input
				int startnum;
				int endnum;
				try {
					 startnum = Integer.parseInt(textField.getText());
					 endnum = Integer.parseInt(textField_1.getText());
					
					 if(1>=startnum || startnum>=endnum ){
						 JOptionPane.showMessageDialog(F, "You have to re input the range numbers", "Wrong number",
								  JOptionPane.ERROR_MESSAGE, null);
						 return;
						 }
				} catch (NumberFormatException ex) {
					lblStatus.setText("Enter an integer.");
					return;
				} // end try

				// create and start a thread
				// workThread = new Thread(new CalculatorClass(number));
				// workThread.start();

				worker = new WorkerClass(startnum, endnum);
				worker.addPropertyChangeListener(new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent e) {
						// if the changed property is progress, update the progress bar
						if (e.getPropertyName().equals("progress")) {
							int newValue = (Integer) e.getNewValue();
							progressBar.setValue(newValue);
						}
					}
				});
				worker.execute();	
			}
		});
		
				textField = new JTextField();
				pnInput.add(textField);
				textField.setColumns(10);
		
		lblTo = new JLabel("to");
		lblTo.setFont(new Font("πŸ≈¡", Font.PLAIN, 18));
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		pnInput.add(lblTo);
		
		textField_1 = new JTextField();
		pnInput.add(textField_1);
		textField_1.setColumns(10);
		pnInput.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worker.stopWork();
			}
		});
		btnStop.setEnabled(false);
		pnInput.add(btnStop);

		JPanel pnList = new JPanel();
		contentPane.add(pnList, BorderLayout.CENTER);
		SpringLayout sl_pnList = new SpringLayout();
		pnList.setLayout(sl_pnList);

		txtArea = new JTextArea();
		txtArea.setEditable(false);

		scrollPane = new JScrollPane(txtArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sl_pnList.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, pnList);
		sl_pnList.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, pnList);
		sl_pnList.putConstraint(SpringLayout.SOUTH, scrollPane, -5, SpringLayout.SOUTH, pnList);
		sl_pnList.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, pnList);

		pnList.add(scrollPane);

		JPanel pnStatus = new JPanel();
		contentPane.add(pnStatus, BorderLayout.SOUTH);
		pnStatus.setLayout(new GridLayout(0, 2, 10, 0));

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		pnStatus.add(progressBar);

		lblStatus = new JLabel();
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		pnStatus.add(lblStatus);
	}
	
	public boolean isPrime(int n) {
		for(int i =2; i<n; i++)
			if(n%i ==0)
				return false;
			return true;
	}
	

	public class WorkerClass extends SwingWorker<Integer, String> {
		int startnum;
		int endnum;
		boolean stopped;

		public WorkerClass(int startnumber, int endnumber) {
			startnum = startnumber;
			endnum = endnumber;
			stopped = false;
		}

		@Override
		protected Integer doInBackground() throws Exception {
			// disable Start button and enable Cancel button
			btnStart.setEnabled(false);
			btnStop.setEnabled(true);
			lblStatus.setText("Running...");
			
			int cnt = 0;
			int size = endnum - startnum;
			try {
				for (int i = startnum; i <= endnum; i++) {
					
					if (stopped) {
						break;
					}
					if(isPrime(i)) {
						publish(String.valueOf(i));
					}
					// do some complex work here
					Thread.sleep(0);

					// update the result
					cnt++;

					// update the view
					setProgress( (i-startnum) *100 / size);
				}
			} catch (InterruptedException e) {
				// update the status
				lblStatus.setText("Error performing computation.");
			}
			return cnt;
		}

		// displays published values
		protected void process(List<String> publishedVals) {
			for (int i = 0; i < publishedVals.size(); i++) {
				txtArea.append(publishedVals.get(i) + "\n");
				txtArea.setCaretPosition(txtArea.getDocument().getLength());
			}
			
			// update the status
			lblStatus.setText(getProgress() + "% done.");
		} // end method process

		// code to execute when doInBackground completes
		protected void done() {
			// disable Start button and enable Cancel button
			btnStart.setEnabled(true);
			btnStop.setEnabled(false);
			int retNum = 0;
			try {
				retNum = get();
				lblStatus.setText("Finish " + retNum + " jobs.");
			}catch (InterruptedException ex) {
				lblStatus.setText("Interrupted while waiting for results.");
			}catch (ExecutionException ex) {
				lblStatus.setText("Error performing computation1.");
			} // end try catch
		}

		public void stopWork() {
			stopped = true;
		}

	}
}