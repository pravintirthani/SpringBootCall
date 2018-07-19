package mvp;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin
@Controller
@RequestMapping(path="/httpCall")
public class HttpClientCall { 
	 
	    @GetMapping(path="/")
		public @ResponseBody String call () throws ClientProtocolException, IOException {
			
	    	DefaultHttpClient httpClient = new DefaultHttpClient();
	        
//	        User user = new User();
//	        user.setId(100);
//	        user.setFirstName("Lokesh");
//	        user.setLastName("Gupta");
	         
//	        StringWriter writer = new StringWriter();
//	        JAXBContext jaxbContext = JAXBContext.newInstance();
//	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//	        jaxbMarshaller.marshal(user, writer);
	         
	        try
	        {
	            //Define a postRequest request
//	            HttpPost postRequest = new HttpPost("https://jsonplaceholder.typicode.com/posts");
	            HttpPost postRequest = new HttpPost("https://reqres.in/api/users");
	             
	            //Set the API media type in http content-type header
	            postRequest.addHeader("content-type", "application/json");
	             
	            //Set the request post body
	            
//	            JSONObject object=new JSONObject();
//	            object.put("id", "1");
	            StringEntity userEntity = new StringEntity("{\"name\": \"morpheus\",\"job\": \"leader\"}");
	            postRequest.setEntity(userEntity);
	              
	            //Send the request; It will immediately return the response in HttpResponse object if any
	            HttpResponse response = httpClient.execute(postRequest);
	             
	            //verify the valid error code first
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != 201)
	            {
	                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
	            }
	          //Now pull back the response object
	            HttpEntity httpEntity = response.getEntity();
	            String apiOutput = EntityUtils.toString(httpEntity);
	            System.out.println(apiOutput);
	        }
	        finally
	        {
	            //Important: Close the connect
	            httpClient.getConnectionManager().shutdown();
	        }
	    	
	    	
	    	
	    	
	    	
			return "Called";
		}

		
}

class demo{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
