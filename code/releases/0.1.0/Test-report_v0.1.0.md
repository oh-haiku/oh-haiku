#Test-report for OH-HAIKU Release Ver 0.1.0

This is the test-report for Release Ver 0.1.0 of the OH-HAIKU application. The contents of the written tests can be viewed in the [RAD-document](https://github.com/oh-haiku/oh-haiku/blob/master/doc/RAD.md). For further information about the tests, take a look at the [Test-plan](https://github.com/oh-haiku/oh-haiku/blob/master/doc/test-plan.md) for the project. 
##1 Written tests

These tests has been done according to the [Test-plan](https://github.com/oh-haiku/oh-haiku/blob/master/doc/test-plan.md) for the project. 

<table>
  <tr>
        <td><b>Test-ID</b></td>
		<td><b>Test-result</b></td>
		<td><b>Comments</b></td>
    </tr>

    <tr>
        <td>T1.1.1</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T1.1.2</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T1.2</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T1.3</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T1.4</td>
		<td>Fail</td>
    </tr>
<tr>
        <td>T1.5</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T1.6</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T2.1</td>
		<td>Fail</td>
		<td>Not implemented</td>
    </tr>
<tr>
        <td>T2.2</td>
		<td>Fail</td>
		<td>Not implemented</td>
    </tr>
<tr>
        <td>T2.3</td>
		<td>Fail</td>
		<td>Not implemented</td>
    </tr>
<tr>
        <td>T3.1</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T3.2</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T3.2</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T3.2</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T4.1</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T4.2</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T4.3</td>
		<td>Passed</td>
    </tr>
<tr>
        <td>T4.4</td>
		<td>Fail</td>
		<td>Updated button clickable</td>
    </tr>
<tr>
        <td>T4.5</td>
		<td>Fail</td>
		<td>Not implemented</td>
    </tr>
</table>

##2 Unit-tests
Here follows the test output of the `ant test` action:

    -test-project-check:

    test:
         [echo] Running tests ...
         [exec] 
         [exec] com.ohhaiku.test.activitytests.HaikuCompositionActivityTests:.
         [exec] com.ohhaiku.test.modeltests.HaikuTests:.........
         [exec] com.ohhaiku.test.modeltests.PoemTests:.............
         [exec] Test results for InstrumentationTestRunner=.......................
         [exec] Time: 0.668
         [exec] 
         [exec] OK (23 tests)
         [exec] 
         [exec] 

    BUILD SUCCESSFUL
    Total time: 5 seconds

##3 Coverage report
The coverage report can be accessed [here](./coverage/coverage.html)