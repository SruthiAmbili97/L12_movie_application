package sg.edu.rp.c346.id21023701.movieapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ModifyMovie extends AppCompatActivity {
    TextView tvTitle,tvId,tvGenere,tvYear,TvRating,tvSpinner;
    EditText etTitle,etId,etGenere,etYear,etRating;
    Spinner spinRating;
    Button btnDelete,btnClose,btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movie);

    }
}