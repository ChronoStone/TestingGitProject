package ma.ensaf.sqlitelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    Button ResultButton;
    EditText Prix,Qte,TVA;
    Double Resultvalue,Prixvalue,Qtevalue,TVAvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        ResultButton = (Button) findViewById(R.id.Resultbutt);
        Prix = (EditText) findViewById(R.id.prixtext);
        Qte = (EditText) findViewById(R.id.prixtext);
        TVA = (EditText) findViewById(R.id.prixtext);

        ResultButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Prixvalue = Double.parseDouble(String.valueOf(Prix.getText()));
                Qtevalue = Double.parseDouble(String.valueOf(Qte.getText()));
                TVAvalue = Double.parseDouble(String.valueOf(TVA.getText()));
                if(Prix.getText().toString().isEmpty() && Qte.getText().toString().isEmpty() &&
                        TVA.getText().toString().isEmpty() )
                {
                    Resultvalue = (1+TVAvalue/100)*(Prixvalue * Qtevalue) ;
                    // Return the value in the second activity result //
                }
            }
        });

    }


    public void GetResult(View view) {

    }
}