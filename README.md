# Oh-Haiku - the awesome Haiku detecting app for Android

# For developers:
To get started with developing Oh-Haiku

1. Install Eclipse
2. Install the Android Development Toolkit
3. Get the correct Android API: API 8
4. Clone the project from Github
5. Create an Eclipse workspace in the `code` directory
6. Create a new Android Project, choose `Create project from existing source`, select the OhHaiku directory
7. Create a new Android Test Project, choose `Create project from existing source`, select the OhHaikuTest directory, choose the OhHaiku project as test target.


To use Emma to check for Test Coverage:

1. Make sure you have `ant` installed.
2. Start your emulator.
3. Make an apk that is prepared for coverage testing:
   - Go to the main project folder and enter: `ant emma debug install`
   - Go to the test project folder and enter: `ant emma debug install test`
4. And Voilà!