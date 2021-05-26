package com.example.percobaandua.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

 public class DBMahasiswa extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Mahasiswa.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_NAME = "tb_mhs";
    private static final String NIM = "nim";
    private static final String NAMA = "nama";
    private static final String KELAS = "kelas";
    private static final String PROGRAM_STUDI = "programstudi";

    public DBMahasiswa(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + NIM + " TEXT PRIMARY KEY, " +
                        NAMA + " TEXT, " +
                        KELAS + " TEXT, " +
                        PROGRAM_STUDI + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addMhs(String nim, String nama, String kelas, String programstudi){
          SQLiteDatabase db = this.getWritableDatabase();
          ContentValues  cv = new ContentValues();

          cv.put(NIM, nim);
          cv.put(NAMA, nama);
          cv.put(KELAS, kelas);
          cv.put(PROGRAM_STUDI, programstudi);

          boolean validasi = false;

          long result = db.insert(TABLE_NAME, null, cv);
            if(result < 1){
                validasi = false;
            } else {
                validasi = true;
            }

            return validasi;
    }

    public Cursor readDataMhs(){
//        String query = "SELECT * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = null;
//        if (db != null){
//            db.rawQuery(query, null);
//        }
//
//        return cursor;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

     public boolean updateData(String nim, String nama, String kelas, String programstudi){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues cv = new ContentValues();

         cv.put(NIM, nim);
         cv.put(NAMA, nama);
         cv.put(KELAS, kelas);
         cv.put(PROGRAM_STUDI, programstudi);

         db.update(TABLE_NAME, cv, "nim=?", new String[]{nim});

         return true;
     }

     public int deleteData(String nim){
         SQLiteDatabase db = this.getWritableDatabase();
         return db.delete(TABLE_NAME, "nim = ?", new String[]{nim});
     }

}
