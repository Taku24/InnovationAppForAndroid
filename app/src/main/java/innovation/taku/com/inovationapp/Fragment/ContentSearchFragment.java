package innovation.taku.com.inovationapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import innovation.taku.com.inovationapp.Adapter.ListAdapter;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/01.
 */
public class ContentSearchFragment extends Fragment{

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.search)
    EditText mEditText;

    private ListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        mListAdapter = new ListAdapter(getActivity());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mListAdapter);
        mRecyclerView.setVisibility(View.INVISIBLE);
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(textView.getText().toString().trim().length() == 0){
                    mRecyclerView.setVisibility(View.INVISIBLE);
                }
                else {
                    mRecyclerView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
        return view;
    }

}
