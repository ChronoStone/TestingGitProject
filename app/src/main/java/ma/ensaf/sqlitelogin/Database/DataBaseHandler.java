package ma.ensaf.sqlitelogin.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CLient.db";
    private static final String TABLE_CLIENT = "CLient";
    private static final String KEY_ID = "id";
    private static final String KEY_LOGIN = "Login";
    private static final String KEY_PASSWORD = "Password";
    private static final String KEY_LAST_LOGIN = "LastLogin";


    public DataBaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLIENT_TABLE = " CREATE TABLE "+TABLE_CLIENT+"("+KEY_ID+"INTEGER PRIMARY KEY, "
                +KEY_LOGIN+"TEXT,"+KEY_PASSWORD+"TEXT)";
        db.execSQL(CREATE_CLIENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CLIENT);
        onCreate(db);
    }

    public void AddClient(Client client){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put(KEY_LOGIN,client.getLogin());
        Values.put(KEY_PASSWORD,client.getPassword());
        db.insert(TABLE_CLIENT,null,Values);
        db.close();
    }

    Client getClient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.query(TABLE_CLIENT, new String[]{KEY_ID, KEY_LOGIN, KEY_PASSWORD, KEY_LAST_LOGIN}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
            Client client = new Client(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            null /* last login */ );
            return client;
        }else{
            return null;
        }
    }

    public int UpdateClient(Client client){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, client.getLogin());
        values.put(KEY_PASSWORD, client.getPassword());

        return db.update(TABLE_CLIENT, values, KEY_ID + "=?", new String[] {String.valueOf(client.getId())});

    }

}
