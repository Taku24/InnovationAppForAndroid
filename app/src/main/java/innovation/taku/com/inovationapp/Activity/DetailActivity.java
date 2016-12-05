package innovation.taku.com.inovationapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

import butterknife.OnClick;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/01.
 */
public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.back)
    Button mBack;

    @BindView(R.id.next)
    Button mNext;

    @BindView(R.id.floating_button)
    FloatingActionButton mFavoriteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back)
    void finishActivity(){
        finish();
    }

    @OnClick(R.id.next)
    void movePostUserActivity(){
        Intent intent = new Intent(this, PostUserActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.floating_button)
    void addFavoriteList(){
        new AlertDialog.Builder(this)
                .setTitle(null)
                .setMessage("お気に入りリストに追加しました")
                .setPositiveButton("OK", null)
                .show();
    }

}
