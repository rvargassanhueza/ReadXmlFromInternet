package cl.cooperativa.readxmlfrominternetmaterial.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import cl.cooperativa.readxmlfrominternetmaterial.R;
import cl.cooperativa.readxmlfrominternetmaterial.Reproductor;
import cl.cooperativa.readxmlfrominternetmaterial.view.fragment.DeportesFragment;
import cl.cooperativa.readxmlfrominternetmaterial.view.fragment.HomeFragment;
import cl.cooperativa.readxmlfrominternetmaterial.view.fragment.PoliticaFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottonbar);
        bottomBar.setDefaultTab(R.id.portada);

        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Reproductor reproductor = new Reproductor();
                System.out.println("HomeFragment, Reproductor cargaMedia()");
                reproductor.reproduceMedia();

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }


        });

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId){
            case R.id.portada:
                HomeFragment homeFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                break;
           case R.id.deportes:
                DeportesFragment deportesFragment = new DeportesFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,deportesFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                break;
            case R.id.politica:
                PoliticaFragment politicaFragment = new PoliticaFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,politicaFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                break;
        }
    }
});

    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }
    protected void onResume() {

        super.onResume();
    }
    protected void onDestroy() {
        super.onDestroy();

    }
}
