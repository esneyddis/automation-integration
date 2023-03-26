package Utils.dataGeneration;

import api.BaseConfig.fakeUser.dto.User;
import api.BaseConfig.fakeUser.dto.UserAddress;
import api.BaseConfig.fakeUser.dto.UserGeolocation;
import api.BaseConfig.fakeUser.dto.UserName;


public class UserCreationData {


    public static User userGeneration() {
        UserName userName = new UserName();
        userName.setName("nany");
        userName.setLastName("Guerrero");

        UserGeolocation userGeolocation = new UserGeolocation();
        userGeolocation.setLat("102");
        userGeolocation.setLog("234");

        UserAddress userAddress = new UserAddress();
        userAddress.setUserGeolocation(userGeolocation);
        userAddress.setCity("austin");
        userAddress.setStreet("11001 street");
        userAddress.setZipcode("78478");
        userAddress.setNumber(123);

        User userCreation = new User();
        userCreation.setEmail("nanita2023@gmail.com");
        userCreation.setPassword("Welcome1");
        userCreation.setPhone("512098567");
        userCreation.setUserNameAbre("nanita");
        userCreation.setUserAddress(userAddress);
        userCreation.setUserName(userName);

        return userCreation;
    }
}
