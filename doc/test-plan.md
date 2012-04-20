#Testplan

##Testcases


### T2 Twitter testcases
#### T2.1 Tweet the text

- Description: 
When the user presses "Tweet" the text is submitted to Twitter

- Precondition: 
T1.1, T1.3, T2.2 The text-string is written or loaded from saved Haikus and the Haiku is certified correctly. The test checking that the user is logged in with Twitter must be passed.  

- Test steps:
Press "Share", then the options "Tweet", "Send by sms" and "e-mail" should appear. When the user presses "Tweet", the text should be submitted to Twitter if the user is logged in with the Twitter-credentials. 

- Result state:
The text is submitted and the user is informed

- Related requirement
F2.1


#### T2.2 Logging in with Twitter and store user-credentials

- Description: 
The user inserts Twitter-credentials and presses "Log in with Twitter" and has an option to store the credentials. 

- Precondition: 
Start application and press "Settings" should have been tested.  

- Test steps:
The user can insert Twitter-credentials and store them. If the typed Twitter-credentials is wrong in some way (either the username doesn't exist or the password is wrong), the user is informed by some sort of error-message (graphical, sound). If the user presses "remember me" the credentials is stored. 

- Result state:
The user is logged in with Twitter

- Related requirement
F2.2

#### T2.3 Analysis of other users on Twitter, optional

- Description: 
 

- Precondition: 


- Test steps:


- Result state:


- Related requirement
