package sg.edu.rp.c346.id21023701.movieapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etYear,etMovieTitle, etGenre;
    Spinner spinner;
    Button btnInsert, btnList;
    ArrayList <String> al;
    ArrayAdapter <String> aa;
    movie data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMovieTitle = findViewById(R.id.editTextMovieTitle);
        etGenre = findViewById(R.id.editTextGenre);
        etYear = findViewById(R.id.editTextYear);
        spinner = findViewById(R.id.spinner);
        btnInsert = findViewById(R.id.buttonInsert);
        btnList = findViewById(R.id.buttonList);


        al = new ArrayList<>(Arrays.asList("Select movie rating","G", "PG", "PG13", "NC16", "M18", "R21"));
        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, al);

        spinner.setAdapter(aa);

        Intent i = getIntent();
        data = (movie) i.getSerializableExtra("data");

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                String title = etMovieTitle.getText().toString();
                String genre = etGenre.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                String rating =spinner.getSelectedItem().toString();
                if (title.length() == 0 || genre.length() == 0){
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }
                long inserted_id = dbh.insertMovie(title,genre,year,rating);
                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Insert unsuccessful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ShowMovies.class);
                startActivity(i);
            }
        });
    }
}