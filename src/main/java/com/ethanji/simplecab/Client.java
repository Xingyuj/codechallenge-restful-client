package com.ethanji.simplecab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Client implements SimpleCabService {
	@Option(name = "-url", usage = "base url for server")
	private String baseUrl = "127.0.0.1:8080";
	@Option(name = "-i", usage = "ignore cache or not when querying")
	private boolean ignoreCache;
	@Option(name = "-med", usage = "medallions need to be queried")
	private String medallions;
	@Option(name = "-date", usage = "pickup date")
	private String pickupDate;
	@Option(name = "-clear", usage = "clear cache")
	private boolean clearCache;

	public static void main(String[] args) throws Exception {
		Client client = new Client();
		CmdLineParser parser = new CmdLineParser(client);
		parser.parseArgument(args);
		if (client.clearCache) {
			client.deleteCache();
		} else {
			System.out.println("request server: " + client.baseUrl);
			System.out.println("ignoreCache: " + client.ignoreCache);
			System.out.println("medallions: " + client.medallions);
			System.out.println("pickupDate: " + client.pickupDate);
			System.out.println(client.getMedallionsSummary(client.pickupDate,
					client.ignoreCache, client.medallions));
		}
	}

	// HTTP GET request
	private String sendGet(String url) {
		StringBuffer response = new StringBuffer();
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.toString();
	}

	@Override
	public void deleteCache() {
		sendGet("http://" + baseUrl + "/clearcache");
	}

	@Override
	public String getMedallionsSummary(String pickupDate, String medallions) {
		return this.getMedallionsSummary(pickupDate, false, medallions);
	}

	@Override
	public String getMedallionsSummary(String pickupDate, boolean ignoreCache,
			String medallions) {
		String url = "http://" + baseUrl + "/cabs?medallions=" + medallions
				+ "&pickup_date=" + pickupDate+"&cached="+!ignoreCache;
		return sendGet(url);
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
