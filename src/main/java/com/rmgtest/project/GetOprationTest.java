/**
 * 
 */
package com.rmgtest.project;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author akhil
 * @since 17/02/2021
 * 
 */
public class GetOprationTest {
	
	/**
	 * PreCondation:we must  have a project in order to get project /delet /pu
	 * Post opration
	 */
	@Test
	public void createTest() {

	/**In order to use hashMam we are not 
	 * going to user genrics coz data type could varry**/
		
		
		
		JSONObject jasonBody = new JSONObject();
		
		
		jasonBody.put("createdBy", "Sabana");
		jasonBody.put("createdOn", "jan");
		jasonBody.put("status", "completed");
 		jasonBody.put("teamSize", 20);
		
		RequestSpecification restGiven = RestAssured.given();
		restGiven.contentType(ContentType.JSON);
		restGiven.body(jasonBody.toJSONString());
	    
		Response postResponce = restGiven.post("http://localhost:8084/addProject");
	   
	    Assert.assertEquals(postResponce.getStatusCode(), 201);
		
	}
	
	@Test (priority=1)
	public void getTest(){
		
		/**Call the get() from RestAssured Class**/
		Response responce = RestAssured.get("http://localhost:8084/projects");
		
		/**prettyPrint( use to print contaont on conol in string but structurd way)**/
		responce.prettyPrint();
		
		
	}
	
	@Test (priority=2)
	public void putTest() {
		
	}
	/**
	 * http://localhost:8084/deleteProject
	 * **/
	
	@Test(priority=3)
	public void deletTest() {
	//i want to give same id from first	
		Response responce = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_002");
		responce.getStatusCode();
		Assert.assertEquals(responce.getStatusCode(), 204);
	}

}
