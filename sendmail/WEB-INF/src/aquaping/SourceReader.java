package aquaping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SourceReader {

    private HttpURLConnection connection;
    private BufferedReader rd;
    private StringBuilder sb;
    private String line;
    private String uID;
    private URL serverAddress;

    private String completeURL;

    public SourceReader(String url, String uID) {
	completeURL = url + uID;
	try {
	    this.serverAddress = new URL(url + uID);
	} catch (Exception e) { }
	this.uID = uID;
	this.connection = null;
	this.rd = null;
	this.sb = null;
	this.line  = null;
    }

    public String readJson() {      
	String json = null;
       	try {
	    connection = (HttpURLConnection)serverAddress.openConnection();
	    connection.setRequestMethod("GET");
	    connection.setDoOutput(true);
	    connection.setReadTimeout(10000);

	    connection.connect();

	    rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    sb = new StringBuilder();
	    
	    while((line = rd.readLine()) != null) {
		sb.append(line);
	    }

	    json = sb.toString();
	} catch (MalformedURLException e) {
	    //	    e.printStackTrace();
	} catch (ProtocolException e) {
	    //  e.printStackTrace();
	} catch (IOException e) {
	    //  e.printStackTrace();
	} finally {
	    connection.disconnect();
	    rd = null;
	    sb = null;
	    connection = null;
	}
	return (json);
    }
}