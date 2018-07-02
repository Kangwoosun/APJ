<Information>
=============
- Version of the Java: Oxygen.2 Release (4.7.2)

- We make 4 java files("Month_View_Frame.java", "Day_View_Frame.java", "Add_Edit_Delete_Dialog.java", "Doing.java") to design and activate the GUI program. 


## <Team Student name>
- 12171615 Park min woo

- 12171575 Kang woo sun


## <Result>
- Park min woo : A+

- Kang woo sun : A0 // :( Why am I not an a+ 


## <Month_View_Frame.java>
- have class Month_View_Frame that implements ActionListener. And in the class Month_View_Frame, there are many      fields and methods used to calculate the current date and display each day for each year and month. And also in the    class, there are fields and methods that are components for Main Frame and create, organize, update the GUI.

- initialize() 
  this method is invoked by constructor when object is created. First, calculate the current Year and current Month         using class GregorianCalendar and create the main frame. next, create the main panel and up panel. the          previous_button, monthChoice Combobox, year Button, next_button will fill the up panel.   
  then, in main panel, also exist down panel. In down panel, there are two panels - dayp, datep. dayp panel contains
  dayLabels that shows each day(Mon, Tue, ...). 
  date Panel contains monthButtons that has actionListener. when the monthButtons that assigned each number's of      the day(ex-1~31) in each month are clicked, Day_View_Frame frame is appeared on the screen and it enables to           show the to-do list for each day. also, Add, Edit, Delete the list can be done. 
 

## <Day_View_Frame.java>
- have class Day_View_Frame that implements JDialog and in class Day_View_Frame, there are many fields and methods   to organize the day view frame GUI, load the information to to-do list and show the graphical view of the to-do list     to time table.

- the main frame is Frame and it is JDialog. in Frame, there is JSpiltPane named main_Pane. in main_Pane, there is          JScrollPane named clockTable and JSpiltPane named dialog_Pane. dialog_Pane display the each job's name, start 
  time and end time. and Also enables to Add, Edit, Delete the to-do list. in clockTable, the graphical view of the 
  to-do list will be showed.

- Specially, in class Day_View_Frame, there is class DrawGraphs that extends JPanel, for drawing graph time table and      rectangle graph in clocktable. To describe the paintComponent method, we uses drawRect(), fillRect(), drawString
  () and others. we assign different color for each job graph, and if length of job is more than 5 characters, divide the      text into segment. Also, if the length of the job is too big to print in rectangle graph, we print like ex) home... . 

- we set the rule when writing to-do list, the object that have earlier time_from is more above than the object that         have later time_from.


## <Add_Edit_Delete_Dialog>
- have class Add_Edit_Delete_Dialog that implements JDialog and in class Add_Edit_Delete_Dialog, there are many fields    and methods to organize the Add, Edit, Delete view frame GUI

- In constructor, the constant is passed over to judge purpose of the frame along Add, Edit, Delete when open the         Add_Edit_Delete_Dialog.

- when we accept the information from the user in Add or Edit or Delete Dialog, we check the many validity test. 
  For example, Check txtFrom's format (user's input) using regular expression, Check txtFrom's hour is under than 24,      and greater than or equal to 0, Check txtFrom's minute is under than 60, and greater than or equal to 0. Check start    time is before end time, and so on. 


## <Doing.java>
- we make doing class in doing.java to define the object that contain start time, end time, job name of the each job.
  there are generic get & set functions for each fields. we redifine the soString methods to match text's length with       GUI components.


