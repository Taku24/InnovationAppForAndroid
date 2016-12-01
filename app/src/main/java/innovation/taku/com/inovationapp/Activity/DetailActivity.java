package innovation.taku.com.inovationapp.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/01.
 */
public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

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
        mBack.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mFavoriteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.next:
                break;

            case R.id.floating_button:
                new AlertDialog.Builder(this)
                        .setTitle(null)
                        .setMessage("お気に入りリストに追加しました")
                        .setPositiveButton("OK", null)
                        .show();

            default:
                break;
        }
    }
}
