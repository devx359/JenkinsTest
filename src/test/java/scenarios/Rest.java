package scenarios;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Rest {
	
	@Test
	void get()
	{
		RestAssured.baseURI="https://reqres.in/api";
		Response  res ;
		res = given().
				param("page",2).log().headers().
				when().get("/users").
				then().extract().response();
		System.out.println(res.getStatusCode());

		System.out.println(res.getStatusLine());
		System.out.println(res.getTime());
		System.out.println(res.body().path("data[0].email").toString());
		List<Header> ll = res.getHeaders().asList();
		for(Header h : ll) {
			//System.out.println(h.getName()+":"+h.getValue());
		}
	}

	@Test
	void get2()
	{
		RestAssured.baseURI="https://reqres.in/api";

	}

	@Test(enabled = false)
	void post()
	{
		RestAssured.baseURI="https://reqres.in/api";
		Response res;
		JSONObject jsonreq = new JSONObject();
		jsonreq.put("email","eve.holt@reqres.in");
		jsonreq.put("password","cityslicka");

		res = given().
				body(jsonreq).
				when().contentType(ContentType.JSON).
				post("/login").
				then().contentType(ContentType.JSON).extract().response();
		System.out.println(res.body().prettyPrint());
		System.out.println(res.header("ContentType"));

	}
	
	

}
