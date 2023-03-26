package api.BaseConfig;

import api.BaseConfig.fakeUser.api.UserService;

public class ServicesAll {

    private UserService userService;


    public UserService getUserService() {
        if(userService == null) {
            userService = new UserService();
        }
        return userService;
    }
}
