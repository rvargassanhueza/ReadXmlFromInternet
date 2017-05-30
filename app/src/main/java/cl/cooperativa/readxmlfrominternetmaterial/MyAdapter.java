package cl.cooperativa.readxmlfrominternetmaterial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cl.cooperativa.readxmlfrominternetmaterial.view.PictureDetailActivity;

/**
 * Created by innova6 on 24-05-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context c;
    ArrayList<Article> articles;
    Activity activity;

    public MyAdapter(Context c, ArrayList<Article> articles, Activity activity) {
        this.c = c;
        this.articles = articles;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article article=articles.get(position);
        String title=article.getTitle();
        //String desc=article.getDescription();
        String dateFecha=article.getTsFecha();
        String dateHora=article.getTsHora();
        String imageUrl=article.getImageUrl();

        holder.titleTxt.setText(title);
        holder.dateFechaTxt.setText(dateFecha);
        holder.dateHoraTxt.setText(dateHora);

        String baseUrl = "http://www.cooperativa.cl";
        String cadenaUrl = baseUrl+imageUrl;

       // Log.i("valor total cadena",": "+cadenaUrl);
      Picasso.with(c).load(cadenaUrl).into(holder.img);


        holder.img.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getAtivity, PictureDetailActivity.class);
                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){

                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    //si estuvieramos en una actividad no sería necesario agregar activity.getWindow, solo getWindow
                    //activity.getWindow()

                    //como personalizamos la duración de la transición(el objeto Explode), debemos colocar el nombre de la clase instanciada,
                    // .setExitTransition(explode);
                    // de lo contrario solo sería .setExitTransition(new Explode()); y toma los valores por defecto de Explode.

                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.
                            makeSceneTransitionAnimation(activity,v,activity.getString(R.string.transitonname_picture))
                            .toBundle());
                }else {

                    activity.startActivity(intent);

                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return articles.size();
    }
}
