# Steamworks2017-preseason18-19
code for the robot from 2017 season

camera is working but multiple cameras causes high lag

There is a slight problem with checking the distance in DriveToDistance (the robot travels way too far during 1 tick)- try PID controller - subsystem for driving with Ultrasonic is uploaded, I will reupload the rest of the code later and testing is coming next week (something after 10/21)

gyro is not tested properly

teleOp is finished and works

safeDrive_Command is finished and works

gearGrab_Command is finished - might need some improvements with the switches - but works (open and close in teleOp, open when the switch is pressed

climber is finished and works - all values of the right Y-axis are running only in one direction (we don't want to cook the motor)

ControlledRotate is used for teleOp driving (it is easier to handle when it is defined together with the gyro)

Proper comments in the code coming later
