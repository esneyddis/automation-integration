package testUser;

import Utils.dataGeneration.UserCreationData;
import api.BaseConfig.fakeUser.dto.User;
import common.AbstractTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UserE2ETest extends AbstractTest {


    @Test
    public void createUserValidation(ITestContext context){
        User userCreation= UserCreationData.userGeneration();
        Response response = api().getUserService().addUser(userCreation);
        context.setAttribute("userId", response.jsonPath().get("id").toString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
