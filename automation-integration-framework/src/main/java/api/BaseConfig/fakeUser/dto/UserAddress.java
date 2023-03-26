package api.BaseConfig.fakeUser.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddress {

    private String city;

    private String street;

    private int number;

    private String zipcode;

    private UserGeolocation userGeolocation;
}
