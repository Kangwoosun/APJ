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
   public Add_Edit_Delete_Dialog(JFrame parent, int Type) {
      
      super(parent,true);
      getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
      setTitle(parent.getTitle());
      setBounds(100, 100, 450, 300);
      getContentPane().setLayout(new BorderLayout());
      main_Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(main_Panel, BorderLayout.CENTER);
      main_Panel.setLayout(new GridLayout(3, 2, 15, 15));
      {
         JLabel labelEvent = new JLabel("Event");
         main_Panel.add(labelEvent);
      }
      
      {
         txtEvent = new JTextField();
         main_Panel.add(txtEvent);
         txtEvent.setColumns(10);
      }
      {
         JLabel labelFrom = new JLabel("From");
         main_Panel.add(labelFrom);
      }
      {
         txtFrom = new JTextField();
         main_Panel.add(txtFrom);
         txtFrom.setColumns(10);
      }
      {
      	JLabel labelTo = new JLabel("To");
      	main_Panel.add(labelTo);
      }
      {
      	txtTo = new JTextField();
      	txtTo.setColumns(10);
      	main_Panel.add(txtTo);
      }
      {
         JPanel btPane = new JPanel();
         btPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(btPane, BorderLayout.SOUTH);
         {
            JButton btOk = new JButton("OK");
            btOk.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   //ADD버튼을 눌렀을 때 구현완료
            	   if(Type == Day_View_Frame.ADD) {
            	   try {
            		  
            		  String splitData[];
            		  int fromHour, fromMin, doing_from;
                 	  int toHour, toMin, doing_to;
                 	  boolean check;
                 	  //From txt에 input된 값이 형식을 맞췄는지 검사
                 	  check = txtFrom.getText().matches("[0-2]\\d{1}:[0-5]\\d{1}");
                 	  if(!check) {
                 		 JOptionPane.showMessageDialog(parent, "Error: From Number should be XX:XX", "Wrong number",
 								  JOptionPane.ERROR_MESSAGE, null);
 						 return;
                 	  }
                 	//To txt에 input된 값이 형식을 맞췄는지 검사
                 	  check = txtTo.getText().matches("[0-2]\\d{1}:[0-5]\\d{1}");
                 	  if(!check) {
                 		 JOptionPane.showMessageDialog(parent, "Error: To Number should be XX:XX", "Wrong number",
 								  JOptionPane.ERROR_MESSAGE, null);

 						 return;
 						 
                 	  }
                 	  //:을 기준으로 쪼개서 시간과 분을 분리
            		  splitData= txtFrom.getText().split(":");
                 	  
                 	  fromHour = Integer.parseInt(splitData[0]);
                 	  if (fromHour >= 24) {
                 		 JOptionPane.showMessageDialog(parent, "Error: From Time's hour should be under than 24", "Wrong number",
								  JOptionPane.ERROR_MESSAGE, null);

						 return;
                 	  }
                 	  fromMin = Integer.parseInt(splitData[1]);
                 	  doing_from = fromHour*60 + fromMin;
                 	  
                 	  splitData = txtTo.getText().split(":");
                 	  
                 	  toHour = Integer.parseInt(splitData[0]);
                 	 if (toHour >= 24) {
                 		 JOptionPane.showMessageDialog(parent, "Error:  Time's hour should be under than 24", "Wrong number",
								  JOptionPane.ERROR_MESSAGE, null);

						 return;
                 	  }
                 	  toMin = Integer.parseInt(splitData[1]);
            		  doing_to = toHour*60 + toMin;
            		   
  					 if(0> doing_from || doing_from >= doing_to ){
  						 JOptionPane.showMessageDialog(parent, "Error: The start Time must be before the end Time", "Wrong range",
  								  JOptionPane.ERROR_MESSAGE, null);

  						 return;
  						 }
  					 
  					 if(txtEvent.getText().contains(".")) {
  						JOptionPane.showMessageDialog(parent, "Error: You must not contain '.' in ToDo", "Wrong String",
								  JOptionPane.ERROR_MESSAGE, null);

						 return;
  					 }
  				    doing.setTimeFrom(doing_from);
                    doing.setTimeTo(doing_to);
                    doing.setToDo(txtEvent.getText());
  					 
            	   } catch (NumberFormatException ex) {
            		  JOptionPane.showMessageDialog(parent, "Error: You should input Nubmer", "Wrong type",
							  JOptionPane.ERROR_MESSAGE, null);
  						return;
            	   }
            	   
            	   setVisible(false);
            	   }
            	   
            	   
            	 
            	   //Edit버튼을 눌렀을 때 구현중
            	   else if (Type == Day_View_Frame.EDIT) {
            		   try {
            			   
                 		  String splitData[];
                 		  int fromHour, fromMin, doing_from;
                      	  int toHour, toMin, doing_to;
                      	  boolean check;
                      	  
                      	  //From txt에 input된 값이 형식을 맞췄는지 검사
                      	  check = txtFrom.getText().matches("\\d{2}:\\d{2}");
                      	  if(!check) {
                      		 JOptionPane.showMessageDialog(parent, "Error: From Number should be XX:XX", "Wrong number",
      								  JOptionPane.ERROR_MESSAGE, null);

      						 return;
                      	  }
                      	  
                      	//To txt에 input된 값이 형식을 맞췄는지 검사
                      	  check = txtTo.getText().matches("\\d{2}:\\d{2}");
                      	  if(!check) {
                      		 JOptionPane.showMessageDialog(parent, "Error: To Number should be XX:XX", "Wrong number",
      								  JOptionPane.ERROR_MESSAGE, null);

      						 return;
                      	  }
                      	  //:을 기준으로 쪼개서 시간과 분을 분리
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

       						 return;
       					 }
       					 
       					 
       				    doing.setTimeFrom(doing_from);
                         doing.setTimeTo(doing_to);
                         doing.setToDo(txtEvent.getText());
       					 
                 	   } catch (NumberFormatException ex) {
                 		  JOptionPane.showMessageDialog(parent, "Error: You should input Nubmer", "Wrong type",
     							  JOptionPane.ERROR_MESSAGE, null);
       						return;
                 	   }
                 	   
                 	   setVisible(false);
            	   }
            	   
            	   //Delete버튼을 눌렀을 때 아직 구현X
            	   else {
            		   try {
                 		  
                 		  
                 		  int fromHour, fromMin, doing_from;
                      	  int toHour, toMin, doing_to;
                      	  boolean check;
                      	  //From txt에 input된 값이 형식을 맞췄는지 검사
                      	  check = txtFrom.getText().matches("\\d{2}:\\d{2}");
                      	  if(!check) {
                      		 JOptionPane.showMessageDialog(parent, "Error: From Number should be XX:XX", "Wrong number",
      								  JOptionPane.ERROR_MESSAGE, null);

      						 return;
                      	  }
                      	//To txt에 input된 값이 형식을 맞췄는지 검사
                      	  check = txtTo.getText().matches("\\d{2}:\\d{2}");
                      	  if(!check) {
                      		 JOptionPane.showMessageDialog(parent, "Error: To Number should be XX:XX", "Wrong number",
      								  JOptionPane.ERROR_MESSAGE, null);

      						 return;
      						 
                      	  }
                      	  //:을 기준으로 쪼개서 시간과 분을 분리
                      	  String splitData[] = txtFrom.getText().split(":");
                      	  
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

       						 return;
       						 }
       					 
       					 
       				    doing.setTimeFrom(doing_from);
                         doing.setTimeTo(doing_to);
                         doing.setToDo(txtEvent.getText());
       					 
                 	   } catch (NumberFormatException ex) {
                 		  JOptionPane.showMessageDialog(parent, "Error: You should input Nubmer", "Wrong type",
     							  JOptionPane.ERROR_MESSAGE, null);
       						return;
                 	   }
                 	   
                 	   setVisible(false);
                   }
                   
                	   
            	   
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
                  
                  //close the Dialog
                  setVisible(false);
               }
            });
            btCancel.setActionCommand("Cancel");
            btPane.add(btCancel);
         }
      }
      
      doing = new Doing(0,0,"");
   }

}