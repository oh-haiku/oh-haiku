#Requirements and Analysis Document for OH-Haiku

#1 Introduction

The germ of this application is a tweet. The Swedish comedian Jesper Rönndahl (@jesperronndahl)
tweeted that he often thinks in chunks of three unrelated thoughts. He indicated that he would 
like to have an app that could tell him whether these three sentences constitute a haiku poem.

# 2 Proposed application
## 2.1 Overview
The app shall be able to tell if a piece of text is a haiku. 
The app will help the user to write a haiku by indicating where more syllables are needed
or where they need to be removed.
The app shall give the user some kind of score, based upon how close the text is to a haiku.
The user shall be able to tweet his or her haikus.
The app shall let the user save his or her tweets.
## 2.2 Functional requirements

### F1 Basic requirements
#### F1.1 Enter a text
- Scenario: Enter a text to be checked
- Trigger: The user starts the app
- Precondition: None
- Basic path:
The user starts the app. When the app launches, the user sees a text area and a keyboard.
- Exceptional path: None

####F1.2 Haiku-algoritm

- Scenario: 
Haiku-algoritm

- Trigger: 
Användaren klickar ‘Verify Haiku’-knappen.

- Precondition:
Ingen.

- Basic path:
Användaren startar applikationen och matar eventuellt in en textsträng. Sedan klickar användaren på ‘Verify Haiku’-knappen.

- Exceptional path: 
Icke latinska alfabetet-tecken har fyllts i i textfältet. Användaren meddelas om felet och ingen Haiku-verifiering sker.
Inget har fyllts i i textfältet av användaren. Användaren meddelas om felet och ingen Haiku-verifiering sker.

- Post condition:
Ett meddelande om den inmatade textsträngens Haiku-värde och möjlighet att dela till twitter ges till användaren. Om den uppfyller kraven för en Haiku meddelas användaren. Användaren har fortfarande möjlighet att mata in ny textsträng och få den verifierad.

#### F1.3 Rättning av Haiku

- Scenario: 
Rättning av Haiku.

- Trigger: 
Användaren har matat in en textsträng som ej uppfyller Haiku-kraven.

- Precondition:
Användaren har matat in textsträng och klickat ‘Verify Haiku’-knappen. 

- Basic path:
Användaren matar in textsträng i textfältet och klickar ‘Verify Haiku’-knappen. Haiku-verifiering sker i applikationen.

- Exceptional path: 
Ingen.

- Post condition:
Användaren meddelas på något sätt (grafiskt, text) om vad den behöver göra för att få en giltig Haiku. Den nyss inmatade textsträngen finns kvar så användaren inte behöver skriva in den igen.

#### F1.4 Sparning av en inmatad Haiku

- Scenario: 
Sparning av en inmatad Haiku.

- Trigger: 
Applikationen har verifierat att en inmatad text är en Haiku.

- Precondition:
Användaren har matat in textsträng och klickat ‘Verify Haiku’-knappen. 

- Basic path:
Användaren matar in textsträng i textfältet och klickar ‘Verify Haiku’-knappen. Applikationen verifierar texten som Haiku.

- Exceptional path: 
För lite minnesutrymme finns för att spara Haikun. Användaren meddelas om detta och Haikun sparas inte.

- Post condition:
Användaren meddelas om att Haikun sparats och hur man läser den. Den inmatade Haikun finns nu sparad i telefonen och kan läsas vid senare tillfälle.
 
### F2 Twitter requirements
#### F2.1 Tweet the text

- Scenario: 
The user tweets the text.

- Trigger:
The user clicks "Tweet Haiku"

- Precondition: 
The user has written a text-string and has successfully writing a Verified Haiku. The user is logged in with Twitter. 

- Basic Path:
The text-string is submitted on Twitter when the user has written a verified Haiku and clicks "Tweet Haiku" . The tweet follows with a "Certified Haiku"-tag. 

- Exceptional path:
None.

- Post condition:
The user gets some sort of response if the text-string is successfully submitted (graphical, sound)

####F2.2 
- Scenario: 
Logging in with Twitter and store user-credentials

- Trigger:
The user clicks "Log in with Twitter". The user has an option to save the user-credentials by clicking "Remember me"/"Save user-credentials". 

- Precondition: 
The user has launched the application and has clicked on "Settings". 

- Basic Path:
The user launches the application, clicks on Settings and then choose "Log in with Twitter". This is optional which implies that the application can be used without a Twitter-account. The user is also able to click "Remember me"/"Save user-credentials".  

- Exceptional path:
The typed Twitter-credentials is wrong in some way. Either the username doesn't exist or the password is wrong. The user is informed by some sort of error-message (graphical, sound).  

- Post condition:
The user is informed graphically if the application is connected to Twitter. 

####F2.3 Analysis of other users on Twitter

- Scenario: 
Analyse other users on Twitter

- Trigger:
The user clicks "Analyse friends"

- Precondition: 
The user has logged in with Twitter. 

- Basic Path:
The user has logged in with Twitter, clicked on "Analyse friends" and typed a text-string with the friend's username on Twitter 

- Exceptional path:
The friend's username doesn't exist. The user is reported by some error-message. 

- Post condition:
Information about the Haiku-tweets-proportion of the friend appears.  

### 2.2.1 Algoritm som räknar stavelser
1.	Kunna identifiera och räkna stavelser i en text

#### 2.2.2 Haiku-algoritm
1.	Kunna avgöra om texten uppfyller kraven för en haiku
2.	Kunna beräkna någon form av poäng för hur haikun, kanske på basis av hur nära den är en “korrekt” haiku
3.	Kunna berätta vilken rad som innehåller för många eller för få stavelser
4.	Kunna räkna stavelser i realtid
5.	Kunna fungera för språken engelska och svenska 

#### 2.2.3 Twitter <--- Jesper G
	
7.	Kunna tweeta texten med haikupoängen
8.	Kunna skriva ut Certified Haiku på Twitter i fallet att texten är en fullständig Haiku
9.	Kunna logga in med sina Twitter-credentials
10.	Kunna komma ihåg Twitter-användaruppgifter
11.	Kunna analysera användare på Twitter. Hur många procent av tweetsen är Haikus? Hur Haiku är en användare?

### F3 Saving and retrieving haikus

#### F3.1 Save a haiku
- Scenario: Save a haiku
- Trigger: The user clicks the save button in the text input view
- Precondition: The user has entered text into any of the text input fields
- Basic path: The user starts the app, enters some text and pushes the save button
- Exceptional path: N/A
- Post condition: The haiku has been saved to the haiku storage. The GUI informs the user of this.

#### F3.2 Browse saved haikus
- Scenario: Browse saved haikus
- Trigger: The user clicks the My saved haikus button in the main menu
- Precondition: N/A
- Basic path: The user starts the app, goes to the menu, selects My saved haikus
- Exceptional path: N/A
- Post condition: The user sees all his or her saved haikus as a list. Each haiku is represented by its first row. Haikus are sorted by date (updated). Symbols next to the haikus reflect if they have been shared in any way. There are separate symbols for twitter, sms and email. The background color of each haiku reflects whether it is a valid haiku.

#### F3.3 Retreive a saved haiku
- Scenario: Retrieve a saved haiku
- Trigger: The user selects a haiku in the My saved haikus view
- Precondition: F3.2
- Basic path: F3.2, then the user selects a haiku
- Post condition: The user is taken to the text input view. The selected haiku has been entered into the text input fields.

#### F3.4 Update a haiku
As F3.1, except the Save button is labelled Update and clicking it updates the existing haiku

### F4 SMS-related requirements

#### F4.1 Browse the user's SMSes
- Scenario: Browse the user's SMSes
- Trigger: The user clicks the SMSes-button in the main menu
- Precondition: The user has authorized the app to read his or her SMSes
- Basic path: The user starts the app, goes to the main menu and clicks the SMS-button
- Exceptional path: N/A
- Post condition: The user sees a list of his or her SMSes

#### F4.2 Analyze an SMS
- Scenario: Analyze an SMS
- Trigger: The user selects an SMS in the Browse SMSes view
- Precondition: F4.1
- Basic path: F4.1, then selects an SMS and pushes the analyze-button
- Exceptional path: N/A
- Post condition: The user sees the selected SMS, indication whether the SMS is a haiku and the number of syllables on each row.

#### F4.3 Prepare to share a haiku via SMS
- Scenario: Prepare to send a haiku as an SMS
- Trigger: The user clicks the share button and then the Via SMS button in the text input view or when viewing a saved haiku
- Precondition: The users has authorized the app to send SMSes. The user has a saved haiku or has entered text in the text input view
- Basic Path: The user views a saved haiku or is in the text input view. The user then pushes the share button and the Via SMS button.
- Exceptional path: N/A
- Post condition: The user is presented with a preview of the SMS that is to be sent

#### F4.4 Share a haiku via SMS
- Scenario: Send a haiku as an SMS
- Trigger: F4.3
- Precondition: F4.3
- Basic path: The user has reviewed the SMS to be sent, then pushes the Send button
- Exceptional Path: The user chooses to reject the SMS by pushin the cancel button
- Post condition: The user is returned to the parent view. If the user pushed the send button, an SMS is sent. Otherwise, nothing happens.

### F5 Email related requirements
#### F5.1 Share a haiku via email
- Scenario: Prepare to send a haiku as an email
- Trigger: The user clicks the share button and then the Mail button in the text input view or when viewing a saved haiku
- Precondition: The user has a saved haiku or has entered text in the text input view
- Basic Path: The user views a saved haiku or is in the text input view. The user then pushes the share button and the Mail button.
- Exceptional path: N/A
- Post condition: The user is sent to the mail application of the phone, with the haiku inserted in the message body

#### 2.2.4 Övrigt <-- Fixa

12.	Kunna använda applikationen utan Twitter-konto
13.	Kunna kontrollera om en användares sms är en Haiku
14.	Kunna dela via sms och mail
15.	Kunna spara en Haiku
16.	Kunna ta bort en sparad Haiku
	
### 2.3 Non-functional requirements
Rubriken avser applikationens kvalitativa mått

####2.3.1 Usability

- Ett smidigt och trevligt GUI
- Ta asiatiska influenser i beaktning vid utformning av grafiskt gränssnitt
- Ge trevlig ljud-feedback
- Snygg ikon
- Låsa GUI:t så lite som möjligt 
- Asynkrona requests där det är lämpligt
- Enkel att använda för personer som inte är helt insatta i Haiku

####2.3.2 Reliability

- Enkel funktion, skall därav aldrig behöva faila
- Sparade Haikus ska inte kunna gå att ta bort av misstag 
- Haikun ska inte försvinna om åtkomst till Twitter eller Internet saknas 

####2.3.3 Performance

- Snabb respons
- Robust
- Resurssnål, i enlighet med Androids krav
- Skall kunna kontrollera om texten är en Haiku utan tillgång Internet
- Skall kunna spara en Haiku utan tillgång till Internet

####2.3.4 Scalability, Extensibility

- Logik som beräknar stavelser ska separeras från Haikulogiken
- Ett interface ska utarbetas som gör det möjligt att koppla på andra sätt att poängsätta strängar på basis av stavelseuppsättningen i dem. På detta sätt skulle man kunna lägga till andra regelbestämda diktformer senare.
- Design skall enkelt kunna ändras för att regelalgoritmen skall kunna användas i andra applikationer

####2.3.5 Packaging and Installation

- Skall paketeras som en android-applikation och släppas på google-play
- Skall ha en säljande beskrivning på google-play

####2.3.6 Accessibility

- Enkel att använda för personer som inte är helt insatta i Haiku

####2.3.7 Maintainability

- En tydlig kanal för att ta emot feedback vid eventuella buggar
- Vid stor efterfrågan uppgraderas applikationen kontinuerligt
- En trigger med meddelande om att applikationen inte är den senaste versionen skall presenteras vid start

####2.3.8 Legal
- Skall använda en lämplig licens. MIT-licensen används om inga konflikter uppstår till exempel på grund av externa bibliotek. Projektet kan komma att läggas under en GPL-licens om så krävs.

###2.4 Application models 
####2.4.1 Scenarios  
####2.4.2 Use case model Use cases priority 
####2.4.3 Static model 
####2.4.4 Dynamic model
####2.4.5 User interface
####2.5 Test cases
####2.6 Possible future directions
####2.7 References

 





#3 Architecture
Arkitekturen kommer att följa MVC-mönstret (Model - View - Controller) vilket innebär att data och presentation separeras. 
Data enkapsuleras i en modell. Vyn presenterar data från modellen. Kontrollern förmedlar händelser i vyn till modellen och förändringar i modelldata till vyn.
På så vis kan till exempel databasmotorn eller hela lagringslösningen bytas ut utan att det påverkar vyn. I gengäld kan även presentationen av data förändras utan att modellen behöver skrivas om. 

#4 Design
Färdiga stavelseräknande algoritmer ska undersökas. Ett möjligt alternativ är att använda sig av en algoritm som används i LaTeX. Den finns beskriven i en doktorsavhandling. Färdiga implementationer finns släppta under GPL-licens. Val av den implementationen skulle alltså föranleda ett byte av licens.
Även vad gäller Twitter-integrationen skall färdiga bibliotek undersökas. Twitter4J är ett möjligt alternativ. Biblioteket skötet auktorisering och autentisering mot Twitter via OAuth. Licensen är Apache, vilken torde vara kompatibel med MIT.