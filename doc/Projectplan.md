#Projectplan for the OH-HAIKU-project

<em>Software Engineering Project - DAT255</em>

<p>Linus Oleander</p>

<p>Jesper Josefsson</p>

<p>Victor Karlsson</p>

<p>Jesper Gunnerling</p>
<p>Eric Bengtsson</p>




##Introduction and purpose 
This projectplan is for the project OH-HAIKU, which purpose is to develop and release an andriod-application. The application helps users compose Haiku poems and lets the user save poems and share them via Twitter, SMS or e-mail.


##Demand
Twitter-users has requested an application that helps users composing Haiku poems. The supervisor of the project has developed an application which implements an easy algorithm to check if a textstring is written in Haiku-form and this application has been downloaded enough times to indicate that a demand exists. 

##Haiku

Haiku is a type of poem which originates from Japan. According to the Swedish Haiku Association the exact definition is ambiguous. The most naive definition of a western Haiku implies 3 rows of text, with the syllables distributed according to 5-7-5. The Japan way of writing a Haiku is however more advanced and sophisticated. The Japan Haiku is written in one single vertical row and the only thing that is counted is the sound of the tokens which means that syllables are ignored. The Japanese sound of tokens is in general shorter than the western syllables. In this project we will initially use the Western Haiku-form. More criterias, according to the Swedish Haiku Association:

 - It contains a word that refers to a time of year 
 - It is divided in two parts in order to surprise 
 - It is not sentimental
 - It merges nature observations with the conditions of life
 - It should be short-spoken and avoid repetition
 - It should not contain personal pronominals
 - It should avoid too strong adjectives


 <p><em> These criterias are optional and will be implemeted if we have possibilities</em></p>


##Requirements
See [Requirements and Analysis Document for OH-Haiku](https://github.com/oh-haiku/oh-haiku/blob/master/doc/requirements-analysis.md)



##Project organization, responsibilities and method

We have planned to use Scrum which is a method for system development. According to this method, the work should be divided into functional phases where the deliverance between the phases should be distinct. Thus, certain roles will occur along with meetings and documents. The roles are in general a product owner, a scrum master and a team. Product owner will set requirements and the srum master will act as a bridge-builder in the team. The team is the development group. 

The product owner will be responsible for the product backlog which is a collection of prioritized requirements. The scrum master, which will be appointed later, will be responsible for the sprint backlog which implies the demand of the product owner. Every sprint will last for 1-3 weeks. The team is divided in different areas of responsibility. To be responsible for a certain area means responsibility for briefing and updating in that area each week. 
 
The work is supported by daily scrum, sprint review, sprint retrospective and sprint planning. Daily scrum is status updates by e-mail. The Sprint review purpose is to analyze an upcoming sprint and will be discussed during the weekly meetings. See Milestones and sprinters for a short explanation of the contents of each sprinter. The Retrospective part is in feedback-purpose and will be used to learn about what went right and what went wrong in earlier sprinters. 
 

###Responsibilities

The team will be divided in the following areas of responsibility:

####Role and	resonsible team-member
 - Project management, <em>Jesper G, Eric</em>
 - Documents and Reporting, <em>Jesper G, Eric</em>
 - Requirements, <em>All</em>
 - Testing, <em>Linus</em>
 - GUI, <em>Jesper J</em>
 - Algorithm, <em>Victor</em>



###Other techniques of development

The ambition is to use BDD. Tests is written first, then coding with the purpose to go through the testcases. 


##License

The codebase will be public which indicates that the choice of license is essential. The goal is to choose a license easy to grasp which gives the developers, in this case this team, credit for the work. 

In this moment we plan to write most of the code by ourselves which means we don't have to take licenses for external libraries into account. These conditions might be changed. 

We have choosen to do research on three licenses; GPL V3, MIT and Apache. 

The requirements for the license:

 - Easy to understand, we are not lawyers
 - The license should give us credit for the work. The codebase should provide a LICENSE-file with the names of the developers

The GPL V3 licens is too extreme. It may cause problems if the license force the user to publish added code(for third party). As a result of this, the user may choose another codebase. 

The MIT- and Apache-licenses are relatively liberal and don't force the user to adaptation. 

We finally chose MIT because of the length of the licens-document( ~160 words v.s 4 pages). The compact text and the simplicity is of great advantage for us as OSS-developers. We don't necessarily have the juridical qualification to understand every single detail. 

According to the license-research the Apache-licens covers more about rights and it guarantees both the developer and the third party in a juridical dispute. However, we are 5 students and we are fully concerned that MIT will cover our needs:

<em>- Permission is hereby granted, free of charge [...] to use, copy, modify, merge, publish, distribute, sublicense.</em>



##Milestones and Sprinters

Sprinter S0
  
 - Project purpose
 - Project method
 - Projectplan completed
 - Motivate the choice of license 
 - Stating requirements, intiated

Sprinter S1

 - GIT-repo
 - First iteration of Haiku-algoritm


Sprinter S2

 - A naive Haiku-algoritm that returns a boolean (true/false)

S3

 - Activities in every sprinter completed, sprint-planning
 - Testcases completed
 - First passable Haiku-algoritm completed

S4

 - Mock-up of the application, using Balsamiq
 - Mapping the contents of the MVC
	- classes, constructors, methods..

S5

 - ...

S6

 - Twitter-interaction
 - Testcases for almost the whole system (cov:+50%)
 - No more features, bug-fixing

S7

 - Source code package, package ready to install (apk)
 - User manual, developer manual
 - Description of 3PP

S8

 - Release, Project OH-HAIKU completed 





