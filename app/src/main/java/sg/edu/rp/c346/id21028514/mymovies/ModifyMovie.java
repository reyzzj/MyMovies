package sg.edu.rp.c346.id21028514.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyMovie extends AppCompatActivity {

    TextView tvID;
    EditText etEditContent, etEditContent2, etEditContent3;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rgEditContent;
    Movies data;
    Spinner spinGenreEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movie);

        //initialize the variables with UI here

        tvID = findViewById(R.id.tvID);
        etEditContent = findViewById(R.id.etEditContent);
        etEditContent2 = findViewById(R.id.etEditContent2);
        etEditContent3 = findViewById(R.id.etEditContent3);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        spinGenreEdit = findViewById(R.id.spinnerGenreEdit);

        Intent i = getIntent();
        data = (Movies) i.getSerializableExtra("data");

        etEditContent.setText(data.getTitle());
        etEditContent2.setText(data.getGenre());
        etEditContent3.setText(data.getYear());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyMovie.this);
                data.setTitle(etEditContent.getText().toString());
                data.setGenre(etEditContent2.getText().toString());
                data.setYear(Integer.parseInt(etEditContent3.getText().toString()));
                String movieRatingE = spinGenreEdit.getSelectedItem().toString();


                data.setRating(movieRatingE);

                dbh.updateMovie(data);
                dbh.close();
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyMovie.this);
                dbh.deleteMovie(data.getId());
                finish();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
