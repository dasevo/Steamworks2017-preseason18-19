# Steamworks2017-preseason18-19

safeDrive_Command is finished and works

teleOp is finished and works

gearGrab_Command is finished - consider adding possibility to close in autonomous period

Proper comments are added -> it might be easier to find out, how it works

climber is finished and works - all values of the right Y-axis are running only in one direction (we don't want to cook the motor)

------------------------------------------------------------------------------------------------------------------------------

camera is working but multiple cameras cause high lag

the PID controller for driving to distance is implemented - testing this week (10/22 - 10/29) + adding encoders in case of low accuracy

gyro is not tested properly

ControlledRotate is used for teleOp driving (it is easier to handle when it is defined together with the gyro)

UltrasonicPIDController is used in DriveToDistance_Subsystem

