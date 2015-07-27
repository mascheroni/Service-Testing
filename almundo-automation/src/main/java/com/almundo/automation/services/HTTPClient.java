package com.almundo.automation.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.almundo.automation.services.Parameters;
import com.almundo.automation.utils.EncryptKey;
import com.almundo.automation.utils.PropertyReader;

public class HTTPClient {

	private URL url;
	private URLConnection urlConnection;
	private String request;
	private boolean proxy = false;
	private Scanner scanner;
	private PropertyReader pr = new PropertyReader();
	
	public void get(){
		
	}

	public void addHeaderValue(String key, String value) {
		this.urlConnection.addRequestProperty(key, value);
	}

	public String getSearchRequest() {
		return this.request;
	}

	public void setSearchRequest(Map<String, String> data) {
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		sb.append(pr.getPropertiesValues("ITINERARI_SERVICE",
				"conf/conf.properties"));
		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) it
					.next();
			sb.append(pair.getKey());
			sb.append("=");
			sb.append(pair.getValue());
			sb.append("&");
		}

		this.request = sb.toString().substring(0, sb.length() - 1);
	}

	public void setRequest(List<Parameters> parameters) {
		SearchParameters param = new SearchParameters();
		parameters = param.concatenateParametersRoundtrip(parameters);
		StringBuffer sb = new StringBuffer();
		Iterator<Parameters> iterator = parameters.iterator();
		sb.append(pr.getPropertiesValues("ITENERARI_SERVICE",
				"conf/conf.properties"));
		while (iterator.hasNext()) {
			Parameters paramTemp = iterator.next();
			sb.append(this.concatenarParametro(paramTemp));
			sb.append("&");
		}

		this.request = sb.toString();
		System.out.println("Trying with: " + this.request);
	}

	public void openConection() {
		try {
			this.connect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void connect() throws MalformedURLException, IOException {
		this.url = new URL(this.request);
		if (this.proxy) {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
					pr.getPropertiesValues("HTTP", "conf/conf.properties"),
					Integer.parseInt(pr.getPropertiesValues("PORT",
							"conf/conf.properties"))));
			this.urlConnection = (HttpURLConnection) url.openConnection(proxy);
		} else {
			this.urlConnection = (HttpURLConnection) url.openConnection();
		}
	}

	public Response post() {

		this.openConection();
		this.addHeaderValue("X-ApiKey", EncryptKey.decryptText(pr
				.getPropertiesValues("API-Key", "conf/conf.properties")));
		this.addHeaderValue("X-UOW",
				pr.getPropertiesValues("glbUserName", "conf/conf.properties"));
		StringBuilder plainResponse = new StringBuilder();
		try {
			plainResponse.append(this.postAction());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return new Response(plainResponse.toString());

	}

	private String postAction() throws IOException {
		InputStream is = this.urlConnection.getInputStream();
		scanner = new Scanner(is);
		String inputLine = "";
		while (scanner.hasNext()) {
			inputLine = inputLine + scanner.nextLine() + "\n";
		}
		return inputLine;
	}

	private String concatenarParametro(Parameters parametro) {
		return parametro.parametro() + "=" + parametro.valor();

	}

}