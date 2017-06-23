package cl.cooperativa.readxmlfrominternetmaterial;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.io.DataOutputStream;
import javax.net.ssl.HttpsURLConnection;

import cl.cooperativa.readxmlfrominternetmaterial.model.ArticleDetail;

/**
 * Created by innova6 on 24-05-2017.
 */

public class RSSParserDetail implements Serializable{

    private static Context context;
    //Context context;

    private InputStream urlStream;
    private XmlPullParserFactory factory;
    private XmlPullParser parser;

    private List<ArticleDetail> rssFeedList;
    private ArticleDetail rssFeed;

    private String urlString;
    private String tagName;

    private  String title;
    private String link;
    private String description;

    public static final String ITEM = "artic_data";
    public static final String CHANNEL = "private";
    public static final String TITLE = "_txt_titular";
    public static final String LINK = "fotofija_port_649x365";
    public static final String DESCRIPTION = "vtxt_cuerpo";


      public RSSParserDetail( String urlString ) {
          this.urlString=urlString;
    }
    public static InputStream downloadUrl(String urlString) throws IOException, NoSuchAlgorithmException, KeyManagementException {

               /* URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

                InputStream stream = conn.getInputStream();
                return stream;*/

    URL url = new URL(urlString);
    HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
    String urlParameters ="";
    connection.setRequestMethod("POST");
    connection.setRequestProperty("USER-AGENT","Mozilla/S.O");
    connection.setRequestProperty("ACCEPT-LANGUAGE","en-us,en;O.S");
    connection.setDoOutput(true);
    DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());
    dStream.writeBytes(urlParameters);
    dStream.flush();
    dStream.close();

    int responseCode = connection.getResponseCode();
    String output ="Request URL "+urlString;
    output+= System.getProperty("line.separator")+"Request Parameters"+urlParameters;
    output+= System.getProperty("line.separator")+"Response Code "+responseCode;

    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String line ="";
    StringBuilder responseOutput = new StringBuilder();

    while ((line=br.readLine())!=null){
        responseOutput.append(line);
            }
    br.close();
    output+= System.getProperty("line.separator")+responseOutput.toString();

       }

    public List<ArticleDetail> parse() {
        try {
            int count = 0;
            factory = XmlPullParserFactory.newInstance();
            parser = factory.newPullParser();
            urlStream = downloadUrl(urlString);
           // parser.setInput(urlStream, null);
            int eventType = parser.getEventType();
            boolean done = false;
            rssFeed = new ArticleDetail();
            rssFeedList = new ArrayList<ArticleDetail>();
            while (eventType != XmlPullParser.END_DOCUMENT && !done) {
                tagName = parser.getName();

                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if (tagName.equals(ITEM)) {
                            rssFeed = new ArticleDetail();
                        }
                        if (tagName.equals(TITLE)) {
                            title = parser.nextText().toString();

                        }
                        if (tagName.equals(LINK)) {
                            link = parser.nextText().toString();
                        }
                        if (tagName.equals(DESCRIPTION)) {
                            description = parser.nextText().toString();
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (tagName.equals(CHANNEL)) {
                            done = true;
                        } else if (tagName.equals(ITEM)) {
                            System.out.println("RSSParserDetail, em case XmlPullParser.END_TAG");
                            rssFeed=new ArticleDetail(title,description,link);
                            rssFeedList.add(rssFeed);
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rssFeedList;
    }

}
