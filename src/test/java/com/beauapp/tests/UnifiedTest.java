package com.beauapp.tests;


import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


import org.junit.Test;

public class UnifiedTest {

	@Test
	public void registerTest() throws IOException{
		String email="test@test.com";
		String pwd="test";
		String username="Ming Sun";
		
//		HttpClient httpclient = HttpClients.createDefault();
//		HttpPost httppost = new HttpPost("http://localhost:8080/com.beauapp/reg");
		//PostMethod post = new PostMethod("http://localhost:8080/com.beauapp/reg");
//		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//		NameValuePair[] data = {
//			    new NameValuePair("email", email),
//			    new NameValuePair("password", pwd),
//			    new NameValuePair("username",username)
//			};
		
//		post.setRequestBody(data);
		
//		InputStream in = post.getResponseBodyAsStream();
//		
//		InputStreamReader inr=new InputStreamReader(in);
//		
//		BufferedReader  inb=new BufferedReader (inr);
//		String line;
//        while((line = inb.readLine()) != null) {
//            System.out.println(line);
//        }  
		
		Map<String, String> params = new HashMap<String, String>();
		String requestURL  = "http://localhost:8080/com.beauapp/reg";
        params.put("email", email);
        params.put("password", pwd);
        params.put("username", username);
        try {
            HttpUtility.sendPostRequest(requestURL, params);
            String[] response = HttpUtility.readMultipleLinesRespone();
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HttpUtility.disconnect();
	}
}
