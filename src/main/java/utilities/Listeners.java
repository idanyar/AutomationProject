package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;

public class Listeners extends CommonOps implements ITestListener
{
    public void onStart(ITestContext execution) {
        System.out.println("------- Starting Execution --------");
    }

    public void onFinish(ITestContext execution)
    {
        System.out.println("------- Ending Execution --------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        //Todo implement this...
    }

    public void onTestSkipped(ITestResult test)
    {
        System.out.println("------- Skipping test:" + test.getName() + "--------");
    }

    public void onTestStart(ITestResult test)
    {
        System.out.println("------- Starting test:" + test.getName() + "--------");
    }

    public void onTestSuccess(ITestResult test)
    {
        // Stop Recording
        System.out.println("------- test:" + test.getName() + "Passed -----");
        if(!Platform.equalsIgnoreCase("api")){
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Delete Recorded File
        File file = new File ("C:\\Automation\\AutomationProject\\test-recordings\\" + test.getName() + ".avi");
        if (file.delete()) {
            System.out.println("File Deleted Successfully");
        } else {
            System.out.println("Failed to Delete File");
        }
    }
    }

    public void onTestFailure(ITestResult test)
    {
        System.out.println("------- test:" + test.getName() + "Failed -----");
        if(!Platform.equalsIgnoreCase("api")){
        // Stop Recording
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveScreenshot();
    }
    }

    @Attachment(value = "Page Screen Shot", type = "image/png")
    public byte[] saveScreenshot()
    {
        if (!Platform.equalsIgnoreCase("api")) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        else
           return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}




