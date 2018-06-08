package mini_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Add_Edit_Delete_Dialog extends JDialog {

   private final JPanel contentPanel = new JPanel();
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
   public Add_Edit_Delete_Dialog(JFrame parent) {
      
      super(parent,true);
      setTitle(parent.getTitle());
      setBounds(100, 100, 450, 300);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(new GridLayout(3, 2, 15, 15));
      {
         JLabel lblNewLabel = new JLabel("Event");
         contentPanel.add(lblNewLabel);
      }
      
      {
         txtEvent = new JTextField();
         contentPanel.add(txtEvent);
         txtEvent.setColumns(10);
      }
      {
         JLabel lblNewLabel_1 = new JLabel("From");
         contentPanel.add(lblNewLabel_1);
      }
      {
         txtFrom = new JTextField();
         contentPanel.add(txtFrom);
         txtFrom.setColumns(10);
      }
      {
      	JLabel lblTo = new JLabel("To");
      	contentPanel.add(lblTo);
      }
      {
      	txtTo = new JTextField();
      	txtTo.setColumns(10);
      	contentPanel.add(txtTo);
      }
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   try {
            		   
            		  String splitData[];
            		  int fromHour, fromMin, doing_from;
                 	  int toHour, toMin, doing_to;
                 	  boolean check;
                 	  
                 	  check = txtFrom.getText().matches("\\d{2}:\\d{2}");
                 	  if(!check) {
                 		 JOptionPane.showMessageDialog(parent, "Error: From Number should be XX:XX", "Wrong number",
 								  JOptionPane.ERROR_MESSAGE, null);
                 		setVisible(false);
 						 return;
                 	  }
                 	  
                 	  check = txtTo.getText().matches("\\d{2}:\\d{2}");
                 	  if(!check) {
                 		 JOptionPane.showMessageDialog(parent, "Error: To Number should be XX:XX", "Wrong number",
 								  JOptionPane.ERROR_MESSAGE, null);
                 		setVisible(false);
 						 return;
                 	  }
                 	  
            		  splitData= txtFrom.getText().split(":");
                 	  
                 	  fromHour = Integer.parseInt(splitData[0]);
                 	  fromMin = Integer.parseInt(splitData[1]);
                 	  doing_from = fromHour*60 + fromMin;
                 	  
                 	  splitData = txtTo.getText().split(":");
                 	  
                 	  toHour = Integer.parseInt(splitData[0]);
                 	  toMin = Integer.parseInt(splitData[1]);
            		  doing_to = toHour*60 + toMin;
            		   
  					 if(0> doing_from || doing_from >= doing_to ){
  						 JOptionPane.showMessageDialog(parent, "Error: The start Time must be before the end Time", "Wrong range",
  								  JOptionPane.ERROR_MESSAGE, null);
  						setVisible(false);
  						 return;
  						 }
  					 
  				    doing.setTimeFrom(doing_from);
                    doing.setTimeTo(doing_to);
                    doing.setToDo(txtEvent.getText());
  					 
  				} catch (NumberFormatException ex) {
  					JOptionPane.showMessageDialog(parent, "Error: You should input Nubmer", "Wrong type",
							  JOptionPane.ERROR_MESSAGE, null);
  					setVisible(false);
  					return;
  				}
            	   
            	   setVisible(false);
               }
            });
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
         }
         
         {
            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  // store info
                  doing = null;
                  
                  //close the Dialog
                  setVisible(false);
               }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
         }
      }
      
      doing = new Doing(0,0,"");
   }

}