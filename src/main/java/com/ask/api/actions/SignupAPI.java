package com.ask.api.actions;

import com.ask.objects.User;
import com.ask.utils.ConfigLoader;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class SignupAPI {



        private Cookies cookies;

        public Cookies getCookies(){
            return cookies;
        }

        private String fetchNonceValueUsingJsoup(){
            Response response=getAccount();
            Document doc= Jsoup.parse(response.body().prettyPrint());
            Element element= doc.selectFirst("#woocommerce-register-nonce");
            return element.attr("value");
        }

        public Response getAccount(){
            cookies= new Cookies();

            Response response=given().
                    baseUri(ConfigLoader.getInstance().getUrl()).
                    cookies(cookies).
                    log().all().
            when().
                    get("/account").
            then().
                    log().
                    all().
                    extract().
                    response();

            if(response.getStatusCode()!=200){
                throw new RuntimeException("Failed to fetch the account, Http Status code "+ response.getStatusCode());
            }
            return response;
        }

    public Response register(User user){
            Map<String, String> formParams= new HashMap<>();
            formParams.put("username", user.getId());
            formParams.put("email", user.getEmail());
            formParams.put("password", user.getPassword());
            formParams.put("woocommerce-register-nonce", fetchNonceValueUsingJsoup());
            formParams.put("register", "Register");
            formParams.put("_wp_http_referer", "/account/");
        cookies= new Cookies();
        Header header= new Header("Content-Type", "application/x-www-form-urlencoded");
        Headers headers=new Headers(header);
        Response response=given().
                baseUri(ConfigLoader.getInstance().getUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
                when().
                    post("/account").
                    then().
                    log().
                    all().
                    extract().
                    response();

        if(response.getStatusCode()!=302){
            throw new RuntimeException("Failed to fetch the account, Http Status code "+ response.getStatusCode());
        }
        this.cookies=response.getDetailedCookies();
        return response;
    }
    }

