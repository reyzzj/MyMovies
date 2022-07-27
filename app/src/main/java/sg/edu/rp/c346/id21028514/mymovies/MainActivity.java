package sg.edu.rp.c346.id21028514.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnRetrieve;
    EditText etContent;
    EditText etContent2;
    EditText etContent3;
    ArrayList<Movies> al;
    Spinner spinGenre;
    ListView lv;
    ArrayAdapter<Movies> aa;
    Movies data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize the variables with UI here
        btnAdd = findViewById(R.id.btnAdd);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        lv = findViewById(R.id.lv);
        etContent = findViewById(R.id.etContent);
        etContent2 = findViewById(R.id.etContent2);
        etContent3 = findViewById(R.id.etContent3);
        spinGenre = findViewById(R.id.spinnerGenre);
        //rgContent = findViewById(R.id.groupradio);
        //star1 = findViewById(R.id.radioButton1);
        //star2 = findViewById(R.id.radioButton2);
        //star3 = findViewById(R.id.radioButton3);
        //star4 = findViewById(R.id.radioButton4);
        //star5 = findViewById(R.id.radioButton5);
        Intent i = getIntent();
        data = (Movies) i.getSerializableExtra("data");


        al = new ArrayList<Movies>();
        aa = new ArrayAdapter<Movies>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data  = etContent.getText().toString();
                String data1 = etContent2.getText().toString();
                String data2 = etContent3.getText().toString();
                int data3 = rgContent.getCheckedRadioButtonId();
                rb = findViewById(data3);
                int rating = Integer.parseInt(rb.getText().toString());
                Log.d("result",rating+"");

                Log.d("result",data3+"");
//                String data3 = "";
//
//                if(star == R.id.radioButton1) {
//
//                    data3 = "*";
//                } else if(star == R.id.radioButton2) {
//                    data3 = "**";
//                } else if(star == R.id.radioButton3) {
//                    data3 = "***";
//                } else if(star == R.id.radioButton4) {
//                    data3 = "****";
//                } else if(star == R.id.radioButton5) {
//                    data3 = "*****";
//                } else {
//                    Toast.makeText(MainActivity.this, "Wrong star",
//                            Toast.LENGTH_SHORT).show();
//                }
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertNote(data,data1,data2,rating);

                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ShowMovie.class);
                startActivity(i);

            }
        });
    }
}
// hello world