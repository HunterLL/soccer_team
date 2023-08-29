### 1. About/Overview:
(Give a general overview of the problem and how your program solves the problem.)
The problem:  
The British Columbia Soccer Club has asked me to develop a software solution to build soccer teams for children under ten years old (U10). U10 soccer teams have seven players on the field. The best players are usually selected as the starting lineup and the remaining players are on the bench, ready to substitute the players on the field.

How my program solves the problem:  
After running my program, a GUI will show up. On the left side of the window, the section is called cadidate information, a coach can add players one by one by entering details of each player such as first name, last name, preferred position, skill level, birthday and then clicking the button 'Add' on the top right corner. If the player isn't under ten years old, error messages will pop up. A team is made up of at least 10 players so if the coach click 'Create' button(below 'Add' button) before adding at least 10 players, an error message will pop up. When a team is successfully created, 'View team' and 'View lineup' buttons will be available below 'Create' for a coach to use. When either of them is clicked on, a popup window will show up, showing the whole team details including jsersey number info or the starting lineup(seven players) details inculding position info.

### 2. List of features:
(List all features that are present in your program.)
- For the candidate info section part of the view, user should enter first name and last name by typing them out separate into the text fields. But for preferred position and skill level, user can only enter these details by selecting the choices given in the comboboxes. For the birthday part, users can input the birthday by clicking on the small calendar icon and then selecting birthday on the calendar small window. For birthday, I used a datechooser. 
- At the bottom left corner, there is a label showing how many players are added after each click on 'Add' button.
- On the right side of the window, there are five buttons vertically placed.
Clicking 'Add' without entering a candidate's details including first name and last name will cause error messages thrown and the candidate can't be added successfully.
'Create' has the same effect. When the number of players is under ten and the button is clicked, an error message can show up. When the number requirement is met and 'Create' is clicked on, 'View team' and 'View lineup' buttons will be available for a user to click on. And 'Add' and 'Create' buttons will be unvailable and can't be clicked on anymore. 
- Clicking the two view buttons can both make a window pop up, showing the whole team details including jersey number info or the starting lineup(seven players) details inculding position info. 'Close' button can close these popup windows.
- 'Exit' button can help close the main program window.
- In addition, I added a UI theme: nimbus and set the frame color blue and background color white.

### 3. How To Run:
(Instructions to run the program should include the following:)
(How to run the jar file? What arguments are needed (if any) to run the jar file, what do they mean)

No arguments are needed to run the jar file.
Open the project folder in the res/ folder.
Select the jar file.
Click on the jar file.
Select run 'Team.jar' on the popup menu.
Then the GUI window will show up.

### 4. How to Use the Program
（Instructions on how to use functionality in your program. if interactive, how to interact with your program? Pay particular attention to the parts that are not part of the example runs that you provided.）
- The main operation the program can do is 'Add'. This can help a user to add a player to the candidate list in the model. But before pressing that button, first user needs to fill in all the details of a player, on the left side of the window. The first one is first name which is a text field. So is the second one last name. User only should type their first name and surname in these text field. Preferred position and skill level are comboboxes, and user only needs to select the options available. For birthday part, after clicking the little calendar icon, a calendar window pops up and user can choose the target birthday. At this point, all the information is entered but needs to be stored. So one last thing to add a player successfully is to press the 'Add' button.
- The second operation is 'Create'. The bottom left part shows how many players are added to the candidate list. If the number is equal or greater than ten, clicking on the 'Create' button can successfully create a soccer team. When the number is over 20. The extra players will be deleted according to their skill level. Only the most skillful ones will be selected to create the team.
- The third operation is 'View team'. When 'Create' is pressed, this button will be available for user to click on. By clicking on the view button, a list of all the team members will appear in a popup window. They are arranged alphabetically and user can also learn about their unique jersey number. By clicking on the 'close' button, the popup window can be closed.
- The fourth operation is 'View lineup'. When 'Create' is pressed, this button will be available for user to click on. By clicking on the view button, a list of all the starting lineup players will appear in a popup window. They are arranged in the order of positions.
- The fifth operation is 'Exit'. By clicking on this button, the program can be terminated immediately.
Following the instructions above can help a coach successfully create a team, assign each of them a unique jersey number, select a lineup team.

### 5. Design/Model Changes
(It is important to document what changes that you have made from earlier designs. Why were those changes required? You can write these changes in terms of version if you wish.)
- This time, I added another function called getCandidateSize() in the Team interface and overrode it in TeamModel class to count how many candidates are added in the candidate list. The reason why it is added is that I want that users can learn how many players are added in the view. It is convenient for users to know when they can create a team.
- I added equals(Object): boolean, boolean hashCode(): int in the Player class. The reason is that I find that when I try to add an identical Player with the same first name, last name, preferred position,  skill level, birthday, it can be successful and by adding the equal method and hashcode method, I can make the program recognize that they are identical and the second player shoudn't be added to the program.

### 6. Assumptions. 
(List what assumptions you made during program development and implementation.) Be sure that these do not conflict with the requirements of the project.
- I assume that two players can be considered as the same when all their fields are the same. If they are all the same, the second player can't be added.
- I assume that after a team is built successfully, players can't be added again.
- I assume that names including first name and last name contain only characters. If integers or other signs are entered, adding the player will fail.

### 7. Limitations.
Limitations of your program if any. This should include any requirements that were not implemented or were not working correctly (including something that might work some of the time).
- When a player is added, the full details of a player can't be shown on the window for users to check. Maybe I should include an area of displaying the added players. Besides, users can't modify the player's details again. If users have a typo in the names or select the wrong birthday, they can't change them. In addition, users can't delete a player.
- Team window and lineup window are two separate windows and users can't open them at the same time so if users want to see who isn't selected in the lineup team, it will be quite painful.
- It's better to show the team and lineup info as tables. Each field of a player is just separated by a comma now which can be improved by putting them separately into each column.
- I don't know how to make future days on the calendar unable for users to click on. They can still select them.

### 8. Citations
Be sure to include any citations that are required for your project. Citations should include references (paper, website, etc.) for any site that you used to research a solution. Proper APA format should be used. For websites this includes the name of the website, title of the article, the url, and the date of retrieval. If you have nothing to cite, you should indicate this.

1. Java Swing Tutorial - javatpoint. (n.d.). www.javatpoint.com. Retrieved April 16, 2023, from https://www.javatpoint.com/java-swing
2. JPanel: setBorder(Border border) : JPanel « javax.swing « Java by API. (n.d.). 2015 Demo Source and Support Ltd. Retrieved April 16, 2023, from http://www.java2s.com/Code/JavaAPI/javax.swing/JPanelsetBorderBorderborder.htm
3. How to change JFrame background color in Java. (n.d.). Retrieved April 16, 2023, from https://www.tutorialspoint.com/how-to-change-jframe-background-color-in-java
4. Nimbus Look and Feel (The JavaTM Tutorials > Creating a GUI With Swing > Modifying the Look and Feel). (n.d.). Retrieved April 16, 2023, from https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html
5. Java GridBagLayout - javatpoint. (n.d.). www.javatpoint.com. Retrieved April 16, 2023, from https://www.javatpoint.com/java-gridbaglayout
6. Learning Java. (n.d.). O’Reilly Online Learning. Retrieved April 16, 2023, from https://learning.oreilly.com/library/view/learning-java/1565927184/ch17s06.html
7. Swing Examples - Show a Modal Dialog. (n.d.). Retrieved April 16, 2023, from https://www.tutorialspoint.com/swingexamples/show_modal_dialog.htm


