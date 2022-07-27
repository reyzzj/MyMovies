package sg.edu.rp.c346.id21028514.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyMovie extends AppCompatActivity {

    TextView tvID;
    EditText etEditContent, etEditContent2, etEditContent3;
    Button btnUpdate, btnDelete, btnCancel;
    RadioButton rbEdit,starEdit1,starEdit2,starEdit3,starEdit4,starEdit5;
    RadioGroup rgEditContent;
    Movies data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movie);

        //initialize the variables with UI here

        tvID = findViewById(R.id.tvID);
        etEditContent = findViewById(R.id.etEditContent);
        etEditContent2 = findViewById(R.id.etEditContent2);
        etEditContent3 = findViewById(R.id.etEditContent3);

        //starEdit1 = findViewById(R.id.radioButton1);
        //starEdit2 = findViewById(R.id.radioButton2);
        //starEdit3 = findViewById(R.id.radioButton3);
        //starEdit4 = findViewById(R.id.radioButton4);
        //starEdit5 = findViewById(R.id.radioButton5);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        rgEditContent = findViewById(R.id.rgEditContent);


        Intent i = getIntent();
        data = (Movies) i.getSerializableExtra("data");

        etEditContent.setText(data.getNoteContent());
        etEditContent2.setText(data.getNoteContent2());
        etEditContent3.setText(data.getNoteContent3());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyMovie.this);
                data.setNoteContent(etEditContent.getText().toString());
                data.setNoteContent2(etEditContent2.getText().toString());
                data.setNoteContent3(etEditContent3.getText().toString());
                int data3 = rgEditContent.getCheckedRadioButtonId();
                rbEdit = findViewById(data3);
                int rating = Integer.parseInt(rbEdit.getText().toString());
                Log.d("result",rating+"");

                Log.d("result",data3+"");
//                int star = rgEditContent.getCheckedRadioButtonId();
//                String radio = "";
//
//                if(star == R.id.radioEditButton1) {
//                    radio = "*";
//                } else if(star == R.id.radioEditButton2) {
//                    radio = "**";
//                } else if(star == R.id.radioEditButton3) {
//                    radio = "***";
//                } else if(star == R.id.radioEditButton4) {
//                    radio = "****";
//                } else if(star == R.id.radioEditButton5) {
//                    radio = "*****";
//                } else {
//                    Toast.makeText(EditActivity.this, "Wrong star",
//                            Toast.LENGTH_SHORT).show();
//                }

                data.setNoteContent4(rating);

                dbh.updateNote(data);
                dbh.close();
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyMovie.this);
                dbh.deleteNote(data.getId());
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
