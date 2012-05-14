#Releases and related requirements

##Release 1.0
In general the first release should have taken all requirements into consideration except the Twitter-requirements and the optional requirements. 

###Functional requirements, Release 1.0 

#### F1 Basic requirements 
 - F1.1, F1.2 and F1.3

#### F3 Saving and retrieving Haikus
 - F3.1, F3.2, F3.3, F3.4 and F3.5

###Non-functional requirements, Release 1.0


####2.3.1 Usability

- A smooth and nice GUI
- Take Asian influences in consideration when developing the GUI
- Nice icon
- Lock the GUI as little as possible
- Easy to use for everyone, even people who aren't familiar with Haiku
- A text that fails Haiku verification should not be tweetable using the application. (Twitter scenario 2.1)

####2.3.2 Reliability

- The Verify Haiku function should never fail! (Verify Haiku scenario 1.2)
- Saved Haikus should not be deletable by mistake 
- The Haiku should not disappear if access to Twitter or Internet is missing

####2.3.3 Performance

- Response time should not be noticeable (all scenarios)
- Verifying if a text is a Haiku should not take more than 10(?) ms (Verify Haiku scenario 1.2)
- Saving a Haiku should not take more than 10 ms (Save a Haiku scenario 3.1)
- Deleting a saved Haiku should not take more than 10 ms (Deleting a Haiku F3.5)
- Robust
- Resource light, according to Android's demands

####2.3.4 Scalability, Extensibility

- The interface should be designed in a way making it possible to implement other rule based poetry later
- The design should easily be changable so that the rule algorithm can be used in other applications

####2.3.5 Packaging and Installation
- Shall be packaged as a Android application and be released on Google Play
- Shall have a selling description on Google Play

####2.3.6 Accessibility
- Verifying if a text is a Haiku should not require Internet access (Verify Haiku scenario 1.2)
- Saving a Haiku/text should not require Internet access (Save Haiku scenario 3.1)
- Updating to more recent versions of the application should not be required to use the application. (all scenarios)
- Using the application shall not require a twitter account (all scenarios)

####2.3.8 Legal
- Shall use a suitable license. The MIT license will be used if no conflicts occur, for example from using external libraries. The project may become licensed under a GPL license if necessary


##Release 1.1
This release comes with the Twitter functional requirements + some additional non-functional requirements. 

###Functional requirements, Release 1.1



#### F2 Twitter requirements
 - 2.1, 2.2


###Non-functional requirements, Release 1.1

####2.3.1 Usability

- Give appropiate sound feedback
- Asynchronous requests when suitable 
- The application shall notify the user at start up if a more recent version of the application exists

####2.3.4 Scalability, Extensibility

- Logic calculating syllables shall be separated from the Haiku logic


####2.3.7 Maintainability
- A clear channel to receive feedback and bug reports
- The application will be updated regularly if demanded


  