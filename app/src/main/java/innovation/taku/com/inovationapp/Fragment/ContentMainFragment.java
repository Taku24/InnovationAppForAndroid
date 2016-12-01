package innovation.taku.com.inovationapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import innovation.taku.com.inovationapp.Activity.CompanyActivity;
import innovation.taku.com.inovationapp.Activity.FindJobActivity;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/01.
 */
public class ContentMainFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.user_action)
    Button mUserAction;

    @BindView(R.id.company_action)
    Button mCompanyAction;

    private Context mContext;

    public ContentMainFragment(Context context){
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        mUserAction.setOnClickListener(this);
        mCompanyAction.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_action:
                Intent intent  = new Intent(mContext, FindJobActivity.class);
                startActivity(intent);
                break;

            case R.id.company_action:
                Intent intent1  = new Intent(mContext, CompanyActivity.class);
                startActivity(intent1);
                break;

            default:
                break;
        }
    }

}
