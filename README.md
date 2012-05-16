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
8. In both projects, select any jar-files in the lib directory, right click and choose `Build Path > Add to Build Path`


To use Emma to check for Test Coverage:

1. Make sure you have added the Android tools to your build path
2. Navigate to the `code` directory
3. Make your main project an Android CLI project: `android update project --target 8 --path ./OhHaiku`
4. Check that tool hasn't done anything crazy (it messed up my `project-properties` file by changing the target to something stupid).
5. Make your test project an Android CLI test-project: `android update test-project -m ../OhHaiku -p OhHaikuTest` (yup, the path to the main project really is relative to the test project...)
6. Check for craziness.
7. Start your emulator.
8. Make an apk that is prepared for coverage testing:
   - Go to the main project folder and enter: `ant emma debug install`
   - Go to the test project folder and enter: `ant emma debug install test`
9. And Voilà!