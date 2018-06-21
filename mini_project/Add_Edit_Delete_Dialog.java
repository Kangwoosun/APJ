package mini_project;

import java.awt.BorderLayout;
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
   public Add_Edit_Delete_Dialog(Day_View_Frame parent, int Type) {
      
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
            	   //ADD踰꾪듉�쓣 �닃���쓣 �븣 援ы쁽�셿猷�
            	   if(Type == Day_View_Frame.ADD) {
            	   try {
            		  
            		  String splitData[];
            		  int fromHour, fromMin, doing_from;
                 	  int toHour, toMin, doing_to;
                 	  boolean check;
                 	  //From txt�뿉 input�맂 媛믪씠 �삎�떇�쓣 留욎톬�뒗吏� 寃��궗
                 	  check = txtFrom.getText().matches("\\d{2}:\\d{2}");
                 	  if(!check) {
                 		 JOptionPane.showMessageDialog(parent, 
                 				 "Error: From Number should be XX:XX", "Wrong format",
 								  JOptionPane.ERROR_MESSAGE, null);
 						 return;
                 	  }
                 	//To txt�뿉 input�맂 媛믪씠 �삎�떇�쓣 留욎톬�뒗吏� 寃��궗
                 	  check = txtTo.getText().matches("\\d{2}:\\d{2}");
                 	  if(!check) {
                 		 JOptionPane.showMessageDialog(parent, 
                 				 "Error: To Number should be XX:XX", "Wrong format",
 								  JOptionPane.ERROR_MESSAGE, null);

 						 return;
 						 
                 	  }
                 	  
                 	  //:�쓣 湲곗��쑝濡� 履쇨컻�꽌 �떆媛꾧낵 遺꾩쓣 遺꾨━
            		  splitData= txtFrom.getText().split(":");
                 	  
                 	  fromHour = Integer.parseInt(splitData[0]);
                 	  if (fromHour >= 24 || fromHour<0) {
                 		 JOptionPane.showMessageDialog(parent, 
                 				 "Error: From Time's hour should be under than 24 and be greater than or equal to 0", "Wrong hour",
								  JOptionPane.ERROR_MESSAGE, null);

						 return;
                 	  }
                 	  fromMin = Integer.parseInt(splitData[1]);
                 	  if(fromMin >= 60 || fromMin<0) {
                 		 JOptionPane.showMessageDialog(parent, 
                 				 "Error: From Time's minute should be under than 60 and be greater than or equal to 0", "Wrong minute",
								  JOptionPane.ERROR_MESSAGE, null);

						 return;
                 	  }
                 	  doing_from = fromHour*60 + fromMin;
                 	  
                 	  splitData = txtTo.getText().split(":");
                 	  
                 	  toHour = Integer.parseInt(splitData[0]);
                 	 if (toHour >= 24 || toHour<0) {
                 		 JOptionPane.showMessageDialog(parent, 
                 				 "Error: To Time's hour should be under than 24 and be greater than or equal to 0", "Wrong hour",
								  JOptionPane.ERROR_MESSAGE, null);

						 return;
                 	  }
                 	  toMin = Integer.parseInt(splitData[1]);
                 	 if(toMin >= 60|| toMin<0) {
                 		 JOptionPane.showMessageDialog(parent, 
                 				 "Error: To Time's minute should be under than 60 and be greater than or equal to 0", "Wrong minute",
								  JOptionPane.ERROR_MESSAGE, null);

						 return;
                 	  }
            		  doing_to = toHour*60 + toMin;
            		   
  					 if(0> doing_from || doing_from >= doing_to ){
  						 JOptionPane.showMessageDialog(parent, "Error: The start Time must be before the end Time", "Wrong range",
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
            	   
            	   
            	 
            	   //Edit踰꾪듉�쓣 �닃���쓣 �븣 援ы쁽以�
            	   else if (Type == Day_View_Frame.EDIT) {
            		   try {
            			  
            			  
            			  String splitData[];
                 		  int fromHour, fromMin, doing_from;
                      	  int toHour, toMin, doing_to;
                      	  boolean check;
                      	  //From txt�뿉 input�맂 媛믪씠 �삎�떇�쓣 留욎톬�뒗吏� 寃��궗
                      	  check = txtFrom.getText().matches("[0-2]\\d{1}:[0-5]\\d{1}");
                      	  if(!check) {
                      		 JOptionPane.showMessageDialog(parent, "Error: From Number should be XX:XX", "Wrong number",
      								  JOptionPane.ERROR_MESSAGE, null);
      						 return;
                      	  }
                      	//To txt�뿉 input�맂 媛믪씠 �삎�떇�쓣 留욎톬�뒗吏� 寃��궗
                      	  check = txtTo.getText().matches("[0-2]\\d{1}:[0-5]\\d{1}");
                      	  if(!check) {
                      		 JOptionPane.showMessageDialog(parent, "Error: To Number should be XX:XX", "Wrong number",
      								  JOptionPane.ERROR_MESSAGE, null);

      						 return;
      						 
                      	  }
                      	  //:�쓣 湲곗��쑝濡� 履쇨컻�꽌 �떆媛꾧낵 遺꾩쓣 遺꾨━
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
       					 
       					 
       					 
       					doing = new Doing(doing_from, doing_to, txtEvent.getText());
                 	   } catch (NumberFormatException ex) {
                 		  JOptionPane.showMessageDialog(parent, "Error: You should input Nubmer", "Wrong type",
     							  JOptionPane.ERROR_MESSAGE, null);
       						return;
                 	   }
                 	   
                 	   setVisible(false);
            	   }
            	   
            	   //Delete踰꾪듉�쓣 �닃���쓣 �븣 �븘吏� 援ы쁽X
            	   
                   
                	   
            	   
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
      if(Type == Day_View_Frame.EDIT) {
	      Doing tmpDoing = parent.getlistDoing().getElementAt(parent.getselectNo());
		  txtFrom.setText(String.format("%02d:%02d",tmpDoing.getTimeFrom()/60, tmpDoing.getTimeFrom()%60));
		  txtTo.setText(String.format("%02d:%02d", tmpDoing.getTimeTo()/60, tmpDoing.getTimeTo()%60));
		  
		  txtEvent.setText(tmpDoing.getToDo());
      }

   }


}