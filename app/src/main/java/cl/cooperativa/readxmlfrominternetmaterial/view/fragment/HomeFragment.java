package cl.cooperativa.readxmlfrominternetmaterial.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.cooperativa.readxmlfrominternetmaterial.Downloader;
import cl.cooperativa.readxmlfrominternetmaterial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    final static String urlAddress="http://especiales2.cooperativa.cl/2017/pruebas/rvargas/rss____1.xml";


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        RecyclerView pictureRecycler=(RecyclerView) view.findViewById(R.id.pictureRecycler);


        new Downloader(this.getActivity(),urlAddress,pictureRecycler).execute();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pictureRecycler.setLayoutManager(linearLayoutManager);
        return view;


       /* PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buidPictures(),R.layout.model,getActivity());

        pictureRecycler.setAdapter(pictureAdapterRecyclerView);*/


    }

   /* public ArrayList<Picture> buidPictures(){

        ArrayList<Picture> pictures= new ArrayList<>();

        pictures.add(new Picture("http://www.cooperativa.cl/noticias/site/artic/20170321/imag/foto_0000001120170321085609.jpg","Beatriz Sánchez","1 días","10 like"));
        pictures.add(new Picture("http://www.cooperativa.cl/noticias/site/artic/20170321/imag/foto_0000001020170321105605.jpg","Salud Pública","2 días","11 like"));
        pictures.add(new Picture("http://www.cooperativa.cl/noticias/site/artic/20170321/imag/foto_0000001020170321110458.jpg","Claudio Bravo","3 días","12 like"));
        pictures.add(new Picture("http://www.cooperativa.cl/noticias/site/artic/20170321/imag/foto_0000001020170321100515.jpg","Arturo Vidal","4 días","13 like"));

        return  pictures;
    }*/



    public void showToolbar(String tittle, boolean upButton, View view){
        /*Estamos en contexto de Fragment, es por eso que debe de llevar el código ((AppCompatActivity)getActivity())
        al llevar este código a un activity no debe llevar ese codigo
         */
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()). getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()). getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
