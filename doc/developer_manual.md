# Developer Manual for OHHAIKU
This document contains information for prospective developers of the OHHAIKU Android application.

## 1. Getting started

### 1.1 Prerequisites
To build the application, make sure that you have the following software installed:

1. Android SDK
2. Android API level 8
3. Apache Ant
4. Git

For development we recommend `Eclipse`.

To contribute, you need a [Github](http://github.com) account.

### 1.2 Getting the code

We strongly recommend prospective developers to fork the project on Github and get the code from the forked repository.

Those only wishing to browse the code can get it using a read-only url:

    git clone git://github.com/oh-haiku/oh-haiku.git
    
### 1.3 Building the application

To be able to build a signed apk-package for release you will need to contact the dev team to access the key store.

To build a debug apk:

1. `ant debug`

### 1.4 Getting started using Eclipse
1. Install the software as per 1.1
2. Get the code
3. Create an Eclipse workspace in the `code` directory
4. Create a new Android Project, choose `Create project from existing source`, select the OhHaiku directory
5. Create a new Android Test Project, choose `Create project from existing source`, select the OhHaikuTest directory, choose the OhHaiku project as test target.

## 2 Suggested topics
Any ideas for improving the application are welcome, but here are some suggested topics that need addressing:

1. Database
  - Check if any database connections need closing.
  - Use config files to build the database instead of class annotations. 
    This is recommended for performance reasons. See [ORMLite, section 4.2](http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite_4.html).
  - Amend the database helper to prepare for changes in the database model. Upgrades should not cause the tables to be dropped.
    See [ORMLite, section 4.5](http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite_4.html).

2. Syllable counters
  - Write an English language syllable counter.
  - Write a Swedish language syllable counter that handles compound words
  
## 3 Contributing
In general, follow these steps to contribute:

1. Create a fork of the application on Github.
2. Do work.
3. Create a pull request.

## 4 Reporting bugs
Report bugs by opening an issue in the [main project on Github](http://github.com/oh-haiku/oh-haiku).

Bug reports should contain:

1. Reference to any failing test cases connected to the bug
2. Steps to reproduce
3. Version of application used
4. Device informations