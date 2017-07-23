# SplashScreenDemo

I developed multiple applications and one time one tester given me bug regarding to splash.
The bug was wheneven application start and before splash screen time out interval user press home button and after application redirec to dashboard after time inerval
so i managed this case in my thos demo example

1. Start post delay handler 
2. One runnerable function call method of  navigation to dashboard screen
3.  boolean isFinish = false; 
this boolean updated to true when runnable call and start new activity
4. now when user close app before this time interval this variable was false and on pause mathos remove handler call back runnable

