package com.example.litepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;


public class MainActivity extends AppCompatActivity {


public static final String TAG="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_createDatabase= (Button) findViewById(R.id.Create_Database);
        btn_createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
            }
        });

        Button btn_addDatabase= (Button) findViewById(R.id.add_data);
        btn_addDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book=new Book();
                book.setAuthor("Jiangnan");
                book.setName("Dragon Raja");
                book.setPress("Unknown");
                book.setPrice(50.43);
                book.setPages(4562);
                book.save();
            }
        });
        Button btn_updateData= (Button) findViewById(R.id.update_data);
        btn_updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Book book=new Book();
//                book.setAuthor("玄色");
//                book.setName("哑舍");
//                book.setPress("Unknown");
//                book.setPages(5000);
//                book.setPrice(490.2);
//                book.save();
//                book.setPrice(200);
//                book.save();
                /**
                 * Litepal的update方式
                 */
//                Book book=new Book();
//                book.setPrice(154);
//                book.setPress("Anchor");
//                book.updateAll("name= ? and author= ?","哑舍","玄色");
                /**
                 * Litepal的默认数据update方式
                 */
                Book book=new Book();
                book.setToDefault("pages");
                book.updateAll();



            }
        });

        Button btn_deleteData= (Button) findViewById(R.id.delete_data);
        btn_deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(Book.class,"Price>?","100");
            }
        });

        Button btn_queryData= (Button) findViewById(R.id.query_data);
        btn_queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> books=DataSupport.findAll(Book.class);
                for(Book book:books){
                    Log.d(TAG, "onClick:book name is "+book.getName());
                    Log.d(TAG, "onClick:book author is "+book.getAuthor());
                    Log.d(TAG, "onClick:book pages is"+book.getPages());
                    Log.d(TAG, "onClick:book price is"+book.getPrice());
                    Log.d(TAG, "onClick:book press is "+book.getPress());
                }
            }
        });



    }

}
