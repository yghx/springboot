package com.kfit.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class TestHC {
	public String post() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse httpResponse = null;
		HttpPost httpPost = new HttpPost("http://localhost:8080/WEY.WebApp/auth/right/right/receivePost.html");
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(20000).setSocketTimeout(22000).build();
		httpPost.setConfig(requestConfig);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("user.loginId", "Lin"));
		params.add(new BasicNameValuePair("user.employeeName", "令狐冲"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Charset.forName("UTF-8"));
		httpPost.setEntity(entity);
		httpResponse = httpClient.execute(httpPost);
		HttpEntity responseEntity = httpResponse.getEntity();
		if (responseEntity != null) {
			String content = EntityUtils.toString(responseEntity, "UTF-8");
			System.out.println(content);
		}

		if (httpResponse != null) {
			httpResponse.close();
		}
		if (httpClient != null) {
			httpClient.close();
		}
		return null;
	}
}
