package innovation.taku.com.inovationapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/02.
 */
public class ContentMyPageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
