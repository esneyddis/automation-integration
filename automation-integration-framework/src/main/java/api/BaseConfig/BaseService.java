package api.BaseConfig;

import lombok.Getter;


public abstract class BaseService {

    private String restUrl;
    @Getter
    private RestService restService;

    public BaseService () {
        restService = new RestService();
    }

    public BaseService(String restUrl) {
        restService = new RestService(restUrl);
        this.restUrl = restUrl;
    }
}
