package sg.edu.rp.c346.id21023701.movieapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowMovies extends AppCompatActivity {

   ListView lvShow;
   ArrayList<movie>alMovieList;
   CustomerAdapter caMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        lvShow =findViewById(R.id.lvShow);
        alMovieList = new ArrayList<movie>();

        caMovie = new CustomerAdapter(this.R.layout.row,alMovieList);
        lvShow.setAdapter(caMovie);
    }
}