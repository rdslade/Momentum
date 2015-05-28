This project was created to demonstrate the concept of momentum and how it can be analyzed by creating a virtual
experiment. Unfortunatley, the features I had planned to create were too complicated and far fetch, so it more just
bounces balls around the screen and takes guides to get this motion. You can customize the angle so that it bounces
differently too. The main conept that I focused on was class design through object oriented programming. This is the
class heiracrchy of having a viewer class that contains the panel/component to run the program and lastly that this panel
contains Ball objects all that own an arrow object. Also, it covers many of the topics that we discussed 
The most important algorithms are the paintComponent method in the Component class and also the runSimulation method
of the Ball class. In the paintComponent method, instance variable of the Component class (objects on the screen)
are checked to see if they are null in order to assign the correct objects in the correct order. Fianlly, once an angle
is set from the user, the program runs the runSimulation method which is run everytime the paintComponent is checked,
(alot of times) and this moves the ball in the direction of the angle given and then checks to see if the ball has hit
the barrier. Once is does, it switches the speed of the ball in the direction that it hit.
In order to run, run the main method of the viewer class. There are still some troubleshooting errors due to time
constraints, but the basis of the program works well.
Please contact me if you have any questions.
Note: Ignore the additional classes (MouseDragTest, ClosingFrameDialog, AffineTrasformTest). These were not written by
me and were solely in order to learn the application of other, unfamiliar Java classes.