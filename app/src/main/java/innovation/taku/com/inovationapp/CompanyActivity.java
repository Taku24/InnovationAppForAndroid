package innovation.taku.com.inovationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by TAKU on 2016/11/30.
 */
public class CompanyActivity extends AppCompatActivity implements View.OnClickListener{

    Button mNext;
    Button mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        mNext = (Button)findViewById(R.id.next);
        mBack = (Button)findViewById(R.id.back);
        mNext.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next:
                break;

            case R.id.back:
                finish();
                break;

            default:
                break;
        }
    }
}
