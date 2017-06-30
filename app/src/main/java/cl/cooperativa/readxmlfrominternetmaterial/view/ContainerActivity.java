package cl.cooperativa.readxmlfrominternetmaterial.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import cl.cooperativa.readxmlfrominternetmaterial.R;
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
}
