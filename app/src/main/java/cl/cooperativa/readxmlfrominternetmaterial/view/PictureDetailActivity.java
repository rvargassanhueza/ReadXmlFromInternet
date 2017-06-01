package cl.cooperativa.readxmlfrominternetmaterial.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;

import cl.cooperativa.readxmlfrominternetmaterial.R;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar("",true);
        getWindow().setEnterTransition(new Fade());
       /* if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){


        }*/
    }

    public void showToolbar(String tittle, boolean upButton/*, View view*/){
        /*se crea el metodo showtoolbar para traer toolbar según maqueta de diseño*/
        /*este metodo no debe llevar View porque estamos en cotexto de activity*/

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
