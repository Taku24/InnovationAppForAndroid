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
import butterknife.OnClick;
import innovation.taku.com.inovationapp.Activity.CompanyActivity;
import innovation.taku.com.inovationapp.Activity.FindJobActivity;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/01.
 */
public class ContentMainFragment extends Fragment {

    @BindView(R.id.user_action)
    Button mUserAction;

    @BindView(R.id.company_action)
    Button mCompanyAction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.user_action)
    void moveFindJobActivity(){
        Intent intent = new Intent(getActivity(), FindJobActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.company_action)
    void moveCompanyActivity(){
        Intent intent = new Intent(getActivity(), CompanyActivity.class);
        startActivity(intent);
    }

}
