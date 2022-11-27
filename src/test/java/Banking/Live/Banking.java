package Banking.Live;

import org.testng.annotations.Test;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;


public class Banking {

    /**
     *
     * The syntax of Rest Assured.io is the most beautiful part As it is very BDD
     * like and understandable.
     *
     *
     * Given(). param("x", "y"). header("z", "w"). when(). Method(). Then().
     * statusCode(XXX). body("x, "y", equalTo("z"));
     *
     *
     *
     */

    @Test
    public void getUser() {

        // given().when().get("https://6382ca1f6e6c83b7a986a0b0.mockapi.io/api/v1/Banking/1").then().assertThat().statusCode(200);

        Response response = given().contentType("application/json").when().get("https://6382ca1f6e6c83b7a986a0b0.mockapi.io/api/v1/Banking/2");
        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(200);
        //System.out.println(response.jsonPath().getString("last_name"));

    }

    @Test
    public void postUser() {

        Map<String, String> user = new HashMap<String, String>();

        user.put("first_name", "Julio");
        user.put("last_name", "Zapata");
        user.put("email", "Zapata@gmail.com");
        user.put("country", "Londres");
        user.put("telephone", "3208566963");


        Response response = given().contentType("application/json").body(user).when().post("https://6382ca1f6e6c83b7a986a0b0.mockapi.io/api/v1/Banking");

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(200);
    }

    @Test
    public void updateUser() {

        Map<String, String> user = new HashMap<String, String>();

        user.put("first_name", "Andres");
        user.put("last_name", "Leal");
        user.put("email", "Leal@gmail.com");
        user.put("country", "Argentina");
        user.put("telephone", "3115334672");
        user.put("id", "8");


        Response response = given().contentType("application/json").body(user).when().put("https://6382ca1f6e6c83b7a986a0b0.mockapi.io/api/v1/Banking/2");

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(200);
    }

    @Test
    public void deleteUser() {



        Response response = given().contentType("application/json").when().delete("https://6382ca1f6e6c83b7a986a0b0.mockapi.io/api/v1/Banking/1");

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(200);
    }

}
