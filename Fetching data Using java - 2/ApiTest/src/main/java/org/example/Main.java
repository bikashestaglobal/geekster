package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try{
            callApi();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // cerate the method
    public static void callApi() throws Exception{
        String uri = "https://api.weatherbit.io/v2.0/forecast/daily";

        // create Uribuilder
        URIBuilder builder = new URIBuilder(uri);
        builder.setParameter("city", "Delhi");
        builder.setParameter("key", "9087c1ff65654414b6852317350c7150");

        // create httpGet object
        HttpGet getData = new HttpGet(builder.build());

        // create httpClient object
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // create closeable httpResponse object
        CloseableHttpResponse httpResponse = httpClient.execute(getData);

        if(httpResponse.getStatusLine().getStatusCode() == 200){
            // get httpEntity
            HttpEntity httpEntity = httpResponse.getEntity();
            String responseStr = EntityUtils.toString(httpEntity);

            // convert into object
            JSONObject obj = new JSONObject(responseStr);
            System.out.println("high_temp\tlow_temp\tozone\t\tsnow\ttemp");

            JSONArray data = obj.getJSONArray("data");

            // loop through the data
            for(int i=0; i<data.length(); i++){
                System.out.printf("%f\t%f\t%f\t%d\t%f\n", data.getJSONObject(i).getFloat("high_temp"),
                        data.getJSONObject(i).getFloat("low_temp"),
                        data.getJSONObject(i).getFloat("ozone"),
                        data.getJSONObject(i).getInt("snow"),
                        data.getJSONObject(i).getFloat("temp"));
            }
        }else{
            throw new Exception("Something went wrong");
        }
    }
}