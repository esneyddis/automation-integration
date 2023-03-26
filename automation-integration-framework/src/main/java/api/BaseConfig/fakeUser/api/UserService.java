package api.BaseConfig.fakeUser.api;

import api.BaseConfig.BaseService;
import api.BaseConfig.fakeUser.dto.User;
import io.restassured.response.Response;

public class UserService extends BaseService {

    public UserService() {
        super("https://fakestoreapi.com");
    }

    public Response addUser(User userCreation){
        return getRestService()
                .setRequestUrl("/users")
                .postRequest(userCreation)
                .getResponse();
    }
}
