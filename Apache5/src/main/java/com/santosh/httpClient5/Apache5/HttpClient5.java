package com.santosh.httpClient5.Apache5;

import java.io.IOException;

	import org.apache.hc.client5.http.classic.methods.HttpGet;
	import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
	import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
	import org.apache.hc.client5.http.impl.classic.HttpClients;
	import org.apache.hc.core5.http.HttpEntity;
	import org.apache.hc.core5.http.ParseException;
	import org.apache.hc.core5.http.io.entity.EntityUtils;


	public class HttpClient5 {
		public static void main(String[] args) {

			while (true) {

				try {
					String result = get("http://httpbin.org/get");
					System.out.println(result);
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public static String get(String url) {
			String resultContent = null;
			HttpGet httpGet = new HttpGet(url);
			try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
				try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
					// Get status code
					System.out.println(response.getVersion()); // HTTP/1.1
					System.out.println(response.getCode()); // 200
					System.out.println(response.getReasonPhrase()); // OK
					HttpEntity entity = response.getEntity();
					// Get response information
					resultContent = EntityUtils.toString(entity);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return resultContent;
		}
	}


