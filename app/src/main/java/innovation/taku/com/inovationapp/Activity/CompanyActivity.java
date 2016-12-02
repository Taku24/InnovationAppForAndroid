package innovation.taku.com.inovationapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/11/30.
 */
public class CompanyActivity extends AppCompatActivity {

    @BindView(R.id.next)
    Button mNext;

    @BindView(R.id.back)
    Button mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next)
    void moveWriteCompanyActivity(){
        Intent intent = new Intent(this, WriteCompanyActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.back)
    void finishActivity(){
        finish();
    }
}
