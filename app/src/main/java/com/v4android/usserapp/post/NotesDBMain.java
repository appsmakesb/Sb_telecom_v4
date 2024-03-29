package com.v4android.usserapp.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.v4android.usserapp.R;

public class NotesDBMain extends AppCompatActivity implements View.OnClickListener {

    CardView var_upload, var_getAlldata, var_Category, var_post_byCategory, var_sell_list, var_sell_byCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ft_main);

        var_upload = findViewById(R.id.cv_upload);
        var_getAlldata = findViewById(R.id.cv_getAlldata);
        var_Category = findViewById(R.id.cv_Category);
        var_post_byCategory = findViewById(R.id.cv_post_byCategory);
        var_sell_list = findViewById(R.id.cv_sell_list);
        var_sell_byCategory = findViewById(R.id.cv_sell_byCategory);

        var_upload.setOnClickListener(this);
        var_getAlldata.setOnClickListener(this);
        var_Category.setOnClickListener(this);
        var_post_byCategory.setOnClickListener(this);
        var_sell_list.setOnClickListener(this);
        var_sell_byCategory.setOnClickListener(this);

        String pref = SessionHandler.getPref("phone", NotesDBMain.this);
        String pref2 = SessionHandler.getPref("pass", NotesDBMain.this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cv_upload) {
            startActivity(new Intent(NotesDBMain.this, UploadPost.class));
        } else if (v.getId() == R.id.cv_getAlldata) {
            Intent intent = new Intent(NotesDBMain.this, GetPosts.class);
            intent.putExtra("allorSell", "/get_posts.php");
            startActivity(intent);
        } else if (v.getId() == R.id.cv_Category) {
            startActivity(new Intent(NotesDBMain.this, CategoryActivity.class));
        } else if (v.getId() == R.id.cv_post_byCategory) {
            Intent intent = new Intent(NotesDBMain.this, UserCategory.class);
            intent.putExtra("category", "/displaying_category.php");
            intent.putExtra("allorSell", "/get_posts_two.php");
            intent.putExtra("sellPost", "/get_posts.php");
            startActivity(intent);
        } else if (v.getId() == R.id.cv_sell_list) {
            Intent intent = new Intent(NotesDBMain.this, GetPosts.class);
            intent.putExtra("allorSell", "/sell_post.php");
            startActivity(intent);
        } else if (v.getId() == R.id.cv_sell_byCategory) {
            Intent intent = new Intent(NotesDBMain.this, UserCategory.class);
            intent.putExtra("category", "/sell_category.php");
            intent.putExtra("allorSell", "/sell_two.php");
            intent.putExtra("sellPost", "/sell_post.php");
            startActivity(intent);
        }
    }
}