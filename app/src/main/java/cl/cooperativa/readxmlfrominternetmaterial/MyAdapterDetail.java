package cl.cooperativa.readxmlfrominternetmaterial;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

import cl.cooperativa.readxmlfrominternetmaterial.model.ArticleDetail;

/**
 * Created by innova6 on 06-06-2017.
 */
public class MyAdapterDetail extends AppCompatActivity implements Serializable {
    //ArrayList<RSSParserDetail> articles;

   //ArticleDetail articles = new ArticleDetail();
    //ArrayList<ArticleDetail> articles;
    Context c;
    ArrayList<ArticleDetail> articles;


   // MyViewHolderDetail myViewHolderDetail;
//TextView  titleDetail = (TextView) findViewById(R.id.userNameDatail);
    public TextView titleDetail,descDetail;
    public ImageView imageDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // ArticleDetail article=articles.get(0);
       // ArticleDetail articles = (ArticleDetail) getIntent().getSerializableExtra("_objeto");

      // System.out.println("MyAdapterDetail tamaño de arreglo que llega es de: "+articles.size());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar("",true);
        System.out.println("Estoy en el AdapterDetail");
        setElementDetail();
    }

    public void setElementDetail(){
//        System.out.println("MyAdapterDetail en setElemetDetail, el tamaño de arreglo es: "+articles.size());
        articles= (ArrayList<ArticleDetail>) getIntent().getSerializableExtra("_objeto");

        ArticleDetail article = articles.get(0);
        String imageUrl=article.getImageUrlDetail();
        String titledet=article.getTitleDetail();
        String desc=article.getContDetail();

        String baseUrl = "http://www.cooperativa.cl";
        String cadenaUrl = baseUrl+imageUrl;

        //Picasso.with(c).load(cadenaUrl).into((ImageView) img.findViewById(R.id.imageHeader));
        imageDetail=(ImageView) findViewById(R.id.imageHeader);
        Picasso.with(c).load(cadenaUrl).into(imageDetail);
        titleDetail = (TextView) findViewById(R.id.userNameDatail);
        titleDetail.setText(titledet);
        descDetail =(TextView) findViewById(R.id.textContentImageDetail) ;
        descDetail.setText(desc);

        System.out.println("Mi cadena URL es: "+cadenaUrl);
       // System.out.println("Mi titulo es: "+titledet);
      //  System.out.println("Mi Detalle es: "+desc);

    }

    public void showToolbar(String tittle, boolean upButton/*, View view*/){
        /*se crea el metodo showtoolbar para traer toolbar según maqueta de diseño*/
        /*este metodo no debe llevar view porque estamos en cotexto de activity*/

        /*Estamos en contexto de Activity, es por eso que no debe de llevar el código ((AppCompatActivity)getActivity())
        al llevar este código a un fragment si debe llevar ese codigo
         */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingtoolbarlayout =  (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);/*aún no funcional, sea crea para el proximo curso*/

    }

}
