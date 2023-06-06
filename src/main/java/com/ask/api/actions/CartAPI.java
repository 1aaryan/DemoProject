package com.ask.api.actions;

import com.ask.objects.User;
import com.ask.utils.ConfigLoader;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CartAPI {
    private Cookies cookies;

    public CartAPI(){}
    public CartAPI(Cookies cookies){
        this.cookies=cookies;
    }

    public Cookies getCookies(){
        return cookies;
    }


    public Response addToCart(int productId, int quantity){
        Map<String, Object> formParams= new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);
        Header header= new Header("Content-Type", "application/x-www-form-urlencoded");
        Headers headers=new Headers(header);

        if(cookies==null){
            cookies= new Cookies();
        }


        Response response=given().
                baseUri(ConfigLoader.getInstance().getUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
         when().
                post("/?wc-ajax=add_to_cart").
         then().
                log().
                all().
                extract().
                response();

        if(response.getStatusCode()!=200){
            throw new RuntimeException("Failed to add the product to the cart" +productId+", Http Status code "+ response.getStatusCode());
        }
        this.cookies=response.getDetailedCookies();
        return response;
    }
}
