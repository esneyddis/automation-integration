package api.BaseConfig;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;

public class RestService {

    private String restUrl;

    private String requestUrl;

    private Response response;

    private ContentType contentType;

    private Map<String, String> headers = new HashMap<>();

    RestService() {
        setContentType(ContentType.JSON);
    }

    RestService(String baseUrl) {
        this();
        this.restUrl = baseUrl;
    }

    public RestService getRequest(Map<String, ?> queryParams) {
        return restRequest(Method.GET, queryParams, null);
    }

    public RestService postRequest(Map<String, ?> queryParams, Object body) {
        return restRequest(Method.POST, queryParams, body);
    }

    public RestService postRequest(Object body) {
        return restRequest(Method.POST, null, body);
    }

    public RestService deleteRequest(Map<String, ?> queryParams) {
        return restRequest(Method.DELETE, queryParams, null);
    }

    public RestService putRequest(Map<String, ?> queryParams, Object body) {
        return restRequest(Method.PUT, queryParams, body);
    }

    private RestService restRequest(Method methodType, Map<String, ?> queryParams, Object body) {
        System.out.println("Calling " +  ": " + requestUrl);
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(restUrl)
                .contentType(contentType)
                .headers(headers)
                .queryParams(queryParams != null ? queryParams : new HashMap<>());
        if (body != null) {
            requestSpecification.body(body);
        }
        response = requestSpecification.request(methodType, requestUrl);
        return this;
    }

    public RestService setContentType(ContentType content) {
        this.contentType = content;
        return this;
    }

    public RestService setHeaders(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public RestService resetHeaders() {
        this.headers = new HashMap<>();
        return this;
    }

    public RestService setAuthorization(String value)
    {
        this.headers.put("Authorization", value);
        return this;
    }
    public RestService setRequestUrl(String url, Object... parameters) {
        requestUrl = restUrl == null ? String.format(url, parameters) : restUrl + String.format(url, parameters);
        return this;
    }

    public Response getResponse(){
        return response;
    }

    public int getResponseCode(){
        return response.getStatusCode();
    }

}
