package tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import tests.BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class CustomITestListener implements ITestListener {
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseClass) result.getInstance()).getDriver();

        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String failureImageFileName = result.getMethod().getMethodName() + new SimpleDateFormat("__MM-dd-yyyy__HH-ss").format(new GregorianCalendar().getTime()) + ".png";

        // It will store all the screenshots in test-output/screenshots folder
        String destDir = System.getProperty("user.dir") + "/test-output/screenshots";
        deleteFilesFromDir(destDir);
        new File(destDir).mkdirs();
        String destFile = destDir + "/" + failureImageFileName;
        try {
            FileUtils.copyFile(imageFile, new File(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("<img src=\"file:///" + destFile + "\" alt=\"\"/><br />");

    }

    private void deleteFilesFromDir(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.exists()) ;
            {
                f.delete();
            }
            {
                System.out.println("ER: Can't delete files from path:" + path + " due to open or error.");
            }
        }
    }


    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
