package innovation.taku.com.inovationapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import innovation.taku.com.inovationapp.Adapter.ListAdapter;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/01.
 */
public class ContentListFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        mListAdapter = new ListAdapter(getActivity());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mListAdapter);
        return view;
    }

}
