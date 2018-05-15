package com.datarepublic.simplecab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Client implements SimpleCabService {
	@Option(name="-url",usage="base url for server")
	private String baseUrl = "127.0.0.1:8080";
	@Option(name="-i",usage="ignore cache or not when querying")
    private boolean ignoreCache;
	@Option(name="-med",usage="medallions need to be queried")
    private String medallions;
	@Option(name="-date",usage="pickup date")
	private String pickupDate;
	
	public static void main(String[] args) throws Exception {
		Client client = new Client();
		CmdLineParser parser = new CmdLineParser(client);
		parser.parseArgument(args);
		System.out.println("request server: "+client.baseUrl);
		System.out.println("ignoreCache: "+client.ignoreCache);
		System.out.println("medallions: "+client.medallions);
		System.out.println("pickupDate: "+client.pickupDate);
		client.sendGet();
	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://"+baseUrl+"/cabs?medallions="+medallions+"&pickup_date="+pickupDate;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	@Override
	public void deleteCache() {
		// TODO Auto-generated method stub
	}

	@Override
	public String getMedallionsSummary(Date pickupDate, String... medallions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMedallionsSummary(Date pickupDate, boolean ignoreCache,
			String... medallions) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
