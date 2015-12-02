# Pokemon Battle Simulator

The Pokemon battle simulator runs beginning from App.java, this contains our main method, though it does very little. It declares to prefer IPv4 communication for our online strategies, and starting our Main Menu.

##The main menu
The main menu is primarily a Java swing application, and one of our views. The main menu runs the initialize method, which starts music, establishes the Jframe used for the menu, and buttons that branch out to the other views. There is no model associated with the main menu.

##Credits
From the main menu, a button can be clicked to take you to the credits. Clicking this button does not stop music, but displays a new JFrame and closes the main menu. From this page, the only options are to close it or press return. When return is placed, music still plays continuously and the main menu opens back up.