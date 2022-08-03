package sg.edu.rp.c346.id21023701.movieapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyMovie extends AppCompatActivity {
    TextView tvTitle,tvId,tvGenere,tvYear,TvRating,tvSpinner;
    EditText etTitle,etId,etGenere,etYear,etRating;
    Spinner spinRating;
    Button btnDelete,btnCancel,btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movie);

      //setMovie(getMovie().toString() + " ~ "+ "Modify Movie");
     btnCancel = findViewById(R.id.btnCancel);
     btnUpdate = findViewById(R.id.btnUpdate);
     btnDelete = findViewById(R.id.btnDelete);
     etTitle = findViewById(R.id.etTitle);
     etId = findViewById(R.id.etID);
     etGenere=findViewById(R.id.etGenre);
     etYear = findViewById(R.id.etYear);
     spinRating= findViewById(R.id.spinRating2);

        Intent i = getIntent();
        final movie  currentMovie = (movie) i.getSerializableExtra("movie");
        etId.setText(currentMovie.getId()+" ");
        etTitle.setText(currentMovie.getTitle());
        etGenere.setText(currentMovie.getGenre());
        //spinRating.setAdapter(currentMovie.getRating());
        etYear.setText(currentMovie.getYear()+" ");



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyMovie.this);

                currentMovie.setTitle(etTitle.getText().toString().trim());
                currentMovie.setGenre(etGenere.getText().toString().trim());
                int Year = 0;
                try {
                    Year = Integer.valueOf(etYear.getText().toString().trim());
                }catch (Exception e){
                    Toast.makeText(ModifyMovie.this, "Invalid year", Toast.LENGTH_SHORT).show();
                    return;
                }
                currentMovie.setYear(Year);
                int result= dbh.updateMovie(currentMovie);

                if (result>0){
                    Toast.makeText(ModifyMovie.this, "Song updated", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ModifyMovie.this, "Update failed", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ModifyMovie.this);
                int result =dbh.deleteMovie(currentMovie.getId());
                if(result>0){
                    Toast.makeText(ModifyMovie.this,"Movie deleted",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(ModifyMovie.this,"Delete failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}