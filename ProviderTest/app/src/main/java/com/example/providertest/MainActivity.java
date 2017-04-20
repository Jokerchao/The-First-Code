package com.example.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String newId;
    public static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_addData= (Button) findViewById(R.id.add_data);
        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("content://com.example.databasetest.provider/book");
                ContentValues contentValues=new ContentValues();
                contentValues.put("name","Dragon Raja");
                contentValues.put("author","Jiang Nan");
                contentValues.put("pages",264);
                contentValues.put("price",414);
                Uri newUri=getContentResolver().insert(uri,contentValues);
                newId=newUri.getPathSegments().get(1);
            }
        });

        Button btn_queryData= (Button) findViewById(R.id.query_data);
        btn_queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("content://com.example.databasetest.provider/book");
                Cursor cursor=getContentResolver().query(uri,null,null,null,null);
                if(cursor!=null){
                    while(cursor.moveToNext()){
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG, "onClick: Book name is :"+name);
                        Log.d(TAG, "onClick: Book author is :"+author);
                        Log.d(TAG, "onClick: Book pages is :"+pages);
                        Log.d(TAG, "onClick: Book price is :"+price);

                    }
                    cursor.close();
                }

            }
        });

        Button btn_updateData= (Button) findViewById(R.id.update_data);
        btn_updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("content://com.example.databasetest.provider/book/"+newId);
                ContentValues contentValues=new ContentValues();
                contentValues.put("name","死亡笔记");
                contentValues.put("author","mu cun");
                contentValues.put("pages",131);
                contentValues.put("price",123.1);
                getContentResolver().update(uri,contentValues,null,null);
            }
        });
        Button btn_deleteData= (Button) findViewById(R.id.delete_data);
        btn_deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("content://com.example.databasetest.provider/book/"+newId);
                getContentResolver().delete(uri,null,null);
            }
        });
    }
}
