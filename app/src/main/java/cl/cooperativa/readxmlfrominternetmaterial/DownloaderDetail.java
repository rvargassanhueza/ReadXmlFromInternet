package cl.cooperativa.readxmlfrominternetmaterial;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by innova6 on 24-05-2017.
 */

public class DownloaderDetail extends AsyncTask<Void,Void,Object> {
    Context c;
    String urlAddress;
    ProgressDialog pd;

    public DownloaderDetail(Context c, String urlAddress) {
        this.c = c;
        this.urlAddress = urlAddress;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Cargando XML");
        pd.setMessage("Parseando...Un Momento Por Favor");
        pd.show();
    }
    @Override
    protected Object doInBackground(Void... params) {
        return downloadData();
    }
    @Override
    protected void onPostExecute(Object data) {
        super.onPostExecute(data);
        pd.dismiss();
        if(data.toString().startsWith("Error"))
        {
            Toast.makeText(c, data.toString(), Toast.LENGTH_SHORT).show();
        }else {
            //PARSE
         //   new RSSParserDetail(c, (InputStream) data).execute();

        }
    }
    private Object downloadData()
    {
        Object connection=Connector.connect(urlAddress);
        if(connection.toString().startsWith("Error"))
        {
            return connection.toString();
        }
        try
        {
            System.out.println("estoy en DownloaderDetail, con la URL:"+urlAddress);

            HttpURLConnection con= (HttpURLConnection) connection;
            int responseCode=con.getResponseCode();
            if(responseCode==con.HTTP_OK)
            {
                InputStream is=new BufferedInputStream(con.getInputStream());
                return is;
            }
            return ErrorTracker.RESPONSE_EROR+con.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return ErrorTracker.IO_EROR;
        }
    }
}
