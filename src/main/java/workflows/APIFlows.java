package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;

public class APIFlows extends CommonOps
{
    @Step("Business Flow: Get User Details")
    public static String getUserDetails (String jPath)
    {
        Response response = APIActions.get("https://reqres.in/api/unknown");
        return APIActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New User")
    public static void postUser (String name, String job)
    {

        params.put("name", name);
        params.put("job", job);
        APIActions.post(params, "https://reqres.in/api/users");
    }

    @Step("Business Flow: Update Existing User")
    public static void put (String name, String job, String id)
    {
        params.put("name", name);
        params.put("job", job);
        APIActions.put(params, "https://reqres.in/api/users/" + id);
    }

    @Step("Business Flow: Delete Existing User")
    public static void delete (String id)
    {
        APIActions.delete(id);
    }
}
