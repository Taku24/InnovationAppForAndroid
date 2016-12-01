package innovation.taku.com.inovationapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/11/30.
 */
public class CompanyActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.next)
    Button mNext;

    @BindView(R.id.back)
    Button mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        ButterKnife.bind(this);
        mNext.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next:
                Intent intent = new Intent(this, WriteCompanyActivity.class);
                startActivity(intent);
                break;

            case R.id.back:
                finish();
                break;

            default:
                break;
        }
    }
}
