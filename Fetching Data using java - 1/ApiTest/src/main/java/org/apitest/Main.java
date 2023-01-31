package org.apitest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try{
            // call the method
            callApi();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    // create the method to call the api
    public static void callApi() throws Exception {
        // create the object for the uri builder
        URIBuilder builder = new URIBuilder("https://api.chucknorris.io/jokes/random");
        builder.setParameter("category", "history");

        // create a httpGet object
        HttpGet getData = new HttpGet(builder.build());

        // create a closeable http client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // create a closeable http response
        CloseableHttpResponse httpResponse = httpClient.execute(getData);

        // Check the response
        if(httpResponse.getStatusLine().getStatusCode() == 200){
            // get the entity
            HttpEntity httpEntity = httpResponse.getEntity();

            // convert it to string
            String responseStr = EntityUtils.toString(httpEntity);

            // convert it to json
            JSONObject obj = new JSONObject(responseStr);
            System.out.println("Jokes");
            System.out.println(obj.getString("value"));
        }else{
            throw new Exception("Somthing went wrong");
        }
    }

}