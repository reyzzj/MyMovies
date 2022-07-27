package sg.edu.rp.c346.id21028514.mymovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "simplenotes.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NOTE = "note";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOTE_CONTENT = "note_content";
    private static final String COLUMN_NOTE_CONTENT2 = "note_content2";
    private static final String COLUMN_NOTE_CONTENT3 = "note_content3";
    private static final String COLUMN_NOTE_CONTENT4 = "note_content4";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_NOTE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NOTE_CONTENT + " TEXT,"
                + COLUMN_NOTE_CONTENT2 + " TEXT2,"
                + COLUMN_NOTE_CONTENT3 + " TEXT3,"
                + COLUMN_NOTE_CONTENT4 + " INTEGER )";

        db.execSQL(createNoteTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
        */
        db.execSQL("ALTER TABLE " + TABLE_NOTE + " ADD COLUMN  module_name TEXT ");
        db.execSQL("ALTER TABLE " + TABLE_NOTE + " ADD COLUMN  module_name TEXT2 ");
        db.execSQL("ALTER TABLE " + TABLE_NOTE + " ADD COLUMN  module_name TEXT3 ");
        db.execSQL("ALTER TABLE " + TABLE_NOTE + " ADD COLUMN  module_name TEXT4 ");
    }

    public long insertNote(String noteContent, String noteContent2, int noteContent3, String noteContent4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_CONTENT, noteContent);
        values.put(COLUMN_NOTE_CONTENT2, noteContent2);
        values.put(COLUMN_NOTE_CONTENT3, noteContent3);
        values.put(COLUMN_NOTE_CONTENT4, noteContent4);
        long result = db.insert(TABLE_NOTE, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }
    public ArrayList<Movies> getAllNotes() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns= {COLUMN_ID, COLUMN_NOTE_CONTENT, COLUMN_NOTE_CONTENT2,COLUMN_NOTE_CONTENT3, COLUMN_NOTE_CONTENT4};
        Cursor cursor = db.query(TABLE_NOTE, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }

    public ArrayList<Movies> getAll5StarSongs() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_NOTE_CONTENT, COLUMN_NOTE_CONTENT2, COLUMN_NOTE_CONTENT3, COLUMN_NOTE_CONTENT4};
        String condition = COLUMN_NOTE_CONTENT4 + " Like ?";
        String[] args = { "%" + 5  + "%"};
        Cursor cursor = db.query(TABLE_NOTE, columns, condition, args,null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }
    public int updateNote(Movies data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_CONTENT, data.getTitle());
        values.put(COLUMN_NOTE_CONTENT2 , data.getGenre());
        values.put(COLUMN_NOTE_CONTENT3 , data.getYear());
        values.put(COLUMN_NOTE_CONTENT4 , data.getRating());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        int result = db.update(TABLE_NOTE, values, condition, args);
        db.close();
        return result;
    }
    public int deleteNote(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_NOTE, condition, args);
        db.close();
        return result;
    }

}