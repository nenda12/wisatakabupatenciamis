package com.example.wisatakabupatenciamis2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.wisatakabupatenciamis2.adapter.MovieAdapter;
import com.example.wisatakabupatenciamis2.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MovieAdapter adapter;
    RecyclerView rv;
    List<MovieModel> listMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    public void initRecyclerView(){
        adapter = new MovieAdapter(this);
        rv = findViewById(R.id.rv_movie);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setNestedScrollingEnabled(false);
        rv.hasFixedSize();
        adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
               @Override
               public void onClick(int position) {
                   Intent i = new Intent(MainActivity.this,
                           DetailActivity.class);
                   i.putExtra("name",listMovie.get(position).getName());
                   i.putExtra("rating",listMovie.get(position).getRating());
                   i.putExtra("jadwal",listMovie.get(position).getJadwal());
                   i.putExtra("deskripsi",listMovie.get(position).getDesCription());
                   startActivity(i);
               }
           });
        loadItem();
    }

    public void loadItem(){
        listMovie.add(new MovieModel("Nama: Situ Lengkong","Panjalu","Ciamis","Wisata Religi dan Budaya"));
        listMovie.add(new MovieModel("Nama: Asatana Gede","Kawali","Ciamis","Wisata Alam dan Budaya"));
        listMovie.add(new MovieModel("Nama: Karangkamulyan","Cijeungjing","Ciamis","Wisata Alam dan Budaya"));
        listMovie.add(new MovieModel("Nama: Jatisewu Cibungbang","Cipaku","Ciamis","Wisata alam dan air"));
        listMovie.add(new MovieModel("Nama: Puncak Puspa","Panumbangan","Ciamis","Wisata Alam"));
        listMovie.add(new MovieModel("Nama: Hutan Pinus Darmacaang","Cikoneng","Ciamis","Wisata Alam"));

        adapter.addAll(listMovie);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.profil){
            startActivity(new Intent(this, ProfilActivity.class));
        } else if (item.getItemId() == R.id.languange) {
            startActivity(new Intent(this, LanguageActivity.class));
        }

        return true;
    }
}