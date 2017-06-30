package cl.cooperativa.readxmlfrominternetmaterial;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by innova6 on 30-06-2017.
 */

public class Reproductor extends Activity {
   public String urlMediaPlayer ="http://unlimited3-cl.dps.live/cooperativafm/aac/icecast.audio";
   public MediaPlayer mediaPlayer = new MediaPlayer();
    Context context;


    public Context getContext() {
        return context;
    }

    //public  progressBarr;

    //progressBarr = (ProgressBar) progressBarr.findViewById(R.id.fabProgressBar);
    public Reproductor() {

    }

    //progressBarr
    public void reproduceMedia()
    {
            cargaMedia cmedia = new cargaMedia();
            cmedia.execute();
    }


    public class cargaMedia extends AsyncTask<Void,Integer,Boolean> {


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
        @Override
        protected void onPreExecute() {


        }
        @Override
        protected void onPostExecute(Boolean aBoolean) {

         //   progressBarr.setVisibility(View.INVISIBLE);
        }
        @Override
        protected Boolean doInBackground(Void... params) {

            try{
               mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
               mediaPlayer.setDataSource(urlMediaPlayer);
               mediaPlayer.prepare();
               mediaPlayer.setVolume(1,1);
               mediaPlayer.start();
           }catch (IOException e)

           {
               e.printStackTrace();
           }

               return true;

        }


    }

    public void pausaMedia() throws IOException{

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDataSource(urlMediaPlayer);
        mediaPlayer.setVolume(0,0);
        mediaPlayer.pause();


    }



}
