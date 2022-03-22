package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;

@Listeners(utilities.Listeners.class)
public class reqresAPI extends CommonOps
{
   @Test(description = "Test 01: Get User Data")
   @Description("This Test Verifies User Details")
    public void test01_verifyUser()
   {
       Verifications.verifyText(APIFlows.getUserDetails(("data[0].name")), "cerulean");
   }

   @Test(description = "Test 02: Create New User and Verify")
   @Description("This Test Add User and Verifies It")
    public void test02_AddUserAndVerify()
   {
     APIFlows.postUser("omer", "QA");
     Verifications.verifyStatusCode(201);
   }

    @Test(description = "Test 03: Update User and Verify")
    @Description("This Test Add User and Verifies It")
    public void test03_UpdateUserAndVerify()
    {
        APIFlows.put("New", "Test", "2");
        Verifications.verifyStatusCode(200);
    }

    @Test(description = "Test 04: Delete User and Verify")
    @Description("This Test Delete User and Verifies It")
    public void test04_DeleteUserAndVerify()
    {
        APIFlows.delete("3");
        Verifications.verifyStatusCode(204);
    }
}
