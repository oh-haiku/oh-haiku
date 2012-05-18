# Test plan

## Testcases

### 1 Introduction

#### 1.1 Purpose of application
The germ of this application is a tweet. The Swedish comedian Jesper Rönndahl (@jesperronndahl)
tweeted that he often thinks in chunks of three unrelated thoughts. He indicated that he would 
like to have an app that could tell him whether these three sentences constitute a haiku poem.


#### 1.2 General characteristics of application

This application is a simple and easy-to-use poem-checker. It can be used to verify that a piece of text is written according to Haiku-rules and tweet the text. The application is also an easy way to store the users poems.
 
### 2 Test environment
First, read [Developer manual](https://github.com/oh-haiku/oh-haiku/blob/master/doc/developer_manual.md) to get the code or .apk and install. 

To do code coverage you need to install [ant](http://ant.apache.org/) and an easy way to do that is using [brew](http://mxcl.github.com/homebrew/). After installing ant you could easily write Apache ant-commands in Terminal. Check more precise commands [here](http://developer.android.com/guide/developing/projects/projects-cmdline.html). You HAVE TO run the emulator before code coverage. 

To update the project to the new development environment, go to [Managing projects from the command line](http://developer.android.com/guide/developing/projects/projects-cmdline.html) and [Testing from other IDEs](http://developer.android.com/guide/developing/testing/testing_otheride.html). The android tool will generate any files and folders that are either missing or need to be updated, as needed for the Android project. In Terminal, type:
	android update project --name Ohhaiku --target 2 --path <path_to_Ohhaiku_project>
	android update test-project -m ../Ohhaiku -p <Path_to_Ohhaikutest_project>



To get the coverage, navigate to /Ohhaikutest and write:
	ant emma debug install test 

	open coverage/coverage.html



####2.1 Hardware enviroment
We have used the following plattform for testing:

 - Model:	MacBook Pro
 - Modellidentifierare:	MacBookPro5,5
 - CPU:	Intel Core 2 Duo, 2,53 GHz
 - Number of CPU:s:	1
 - Kernels:	2
 - L2-cache:	3 MB
 - Memory:	4 GB
 - Busspeed:	1,07 GHz
 - Boot ROM-version:	MBP55.00AC.B03
 - SMC-version (system):	1.47f2

We have been running our written tests (more information about the tests in the  [RAD-document](https://github.com/oh-haiku/oh-haiku/blob/master/doc/RAD.md))
on a Android HTC Wildfire (2.7in QVGA) and in the emulator. 
 

####2.2 Software environment

####2.2.3 Softwares

Coding:

 - Eclipse SDK Version 3.6 (Helios) or later. 

Mockups:

 - Balsamiq Mockups Version 2.1.16

Code coverage:

 - [EclEmma](http://www.eclemma.org/)

Nightly builds:

 - [Travis CI](http://travis-ci.org/)

Unit tests:

 - JUnit 3 with Android extensions


GUI-tests:

 - [robotium](http://code.google.com/p/robotium/)






####2.2.3 Software settings

### 3 System information

#### 3.1 System version

### 4 Known bugs and limitations

### 5 Test specification
For documentation on the tests, view [RAD-document with tests](https://github.com/oh-haiku/oh-haiku/blob/master/doc/RAD.md)



### 6 Automatic test

#### 6.1 Code coverage

We've have been using [ant](http://ant.apache.org/) to calculate the code coverage.



#### 6.2 Nightly builds

A service named [Travis CI](http://travis-ci.org/) will be used.
Each time something is pushed to Github a [service hook](https://github.com/blog/964-all-of-the-hooks) 
will push the code from GH to Travis CI. TCI will run all test for us, but in a neutral enviroment.

#### 6.3 Unit test

JUnit 3 with Android extensions will be used for unit testing.

We can't test the GUI using *JUnit*, instead something like [robotium](http://code.google.com/p/robotium/) might be used.

### 7 Test report

We'll be using two branches for oh-haiku, one unstable called *master* and one stable(ish) called *stable*.
Both of these will be testet each time something is pushed to Github, but we aren't expecting everyting in *master* to pass.

The *stable* branch should reflect the deployed version (maybe on Google Play). Each release is tagged using *git tags*. Each tag is in it self named according to the [semver](http://semver.org/) version conversion.


