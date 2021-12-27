package ma.ensaf.sqlitelogin.Database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import ma.ensaf.sqlitelogin.R;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        DataBaseHandler db = new DataBaseHandler(this);
        Log.d("INSERT","INSERTING");

        db.AddClient(new Client(1,"Omar","0653686584",null));
        db.AddClient(new Client(1,"Karim","0664989548",null));


        Log.d("Reading...","Reading one client");
        Client client = db.getClient(1);

    }

}