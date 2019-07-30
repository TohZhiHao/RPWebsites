package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnGo;
    String url;

    ArrayList<String> alSub;
    ArrayAdapter<String> aaSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinnerCategory);
        spn2 = findViewById(R.id.spinnerSubCategory);
        btnGo = findViewById(R.id.buttonGo);

        alSub = new ArrayList<>();
        aaSub = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, alSub);
        spn2.setAdapter(aaSub);

        String[] strSub = getResources().getStringArray(R.array.spSubCatRP);

        alSub.addAll(Arrays.asList(strSub));
        aaSub.notifyDataSetChanged();


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] strNumbers;
                alSub.clear();
                switch (position){
                    case 0:
                        strNumbers = getResources().getStringArray(R.array.spSubCatRP);
                        alSub.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(0);
                        break;
                    case 1:
                        strNumbers = getResources().getStringArray(R.array.spSubCatSOI);
                        alSub.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(0);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spn2.getSelectedItem().equals("Homepage")){
                    url = "https://www.rp.edu.sg/";
                }
                if (spn2.getSelectedItem().equals("Student Life")){
                    url = "https://www.rp.edu.sg/student-life";
                }
                if (spn2.getSelectedItem().equals("DMSD")){
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                }
                if (spn2.getSelectedItem().equals("DIT")){
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                }


                Intent intent = new Intent(getBaseContext(),WebViewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

    }
}
