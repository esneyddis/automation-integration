package api.BaseConfig.fakeUser.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String email;

    private String userNameAbre;

    private String password;

    private UserName userName;

    private UserAddress userAddress;

    private String phone;

}
