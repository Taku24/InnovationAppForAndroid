package innovation.taku.com.inovationapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import innovation.taku.com.inovationapp.Activity.DetailActivity;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/01.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    Context mContext;

    private String[] jobList = {
            "CA Tech Kids",
            "関西大学事務局",
            "農業体験",
            "支援学校でのサポート",
            "サーバー作り",
            "APIの作成",
            "試験監督",
            "ゲーム制作",
            "ハッカソンのメンター",
            "イベント制作の企画・提案"};

    private String[] jobGenreList = {
            "プログラミング",
            "事務作業",
            "農業",
            "支援",
            "技術系",
            "技術系",
            "その他",
            "ゲーム制作",
            "イベント・技術系",
            "企画・提案"
    };

    public ListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job, parent, false);
        return new ListAdapter.ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.mContent.setText(jobList[position]);
        holder.mJobGenre.setText("職業：" + jobGenreList[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.content)
        TextView mContent;

        @BindView(R.id.job_genre)
        TextView mJobGenre;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
