package sg.edu.rp.c346.id21023701.movieapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ModifyMovie extends AppCompatActivity {
    TextView tvTitle,tvId,tvGenere,tvYear,TvRating,tvSpinner;
    EditText etTitle,etId,etGenere,etYear,etRating;
    Spinner spinRating;
    Button btnDelete,btnCancel,btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movie);

        btnUpdate =findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancel);
        btnDelete = findViewById(R.id.btnDelete);
        etId = findViewById(R.id.etID);
        etTitle = findViewById(R.id.etTitile2);
        etGenere = findViewById(R.id.etGenere2);
        etYear = findViewById(R.id.etYear2);
     spinRating = findViewById(R.id.spinRating2);

    }


}