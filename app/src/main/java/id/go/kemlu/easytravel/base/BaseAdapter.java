package id.go.kemlu.easytravel.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public abstract class BaseAdapter<T, VH extends BaseHolder> extends RecyclerView.Adapter<VH> {

    private List<T> mListData = new ArrayList<>();

    protected Context mContext;
    protected LayoutInflater mInflater;

    private int mResId;

    protected OnItemClickListener mListener;

    public BaseAdapter(Context mContext) {
        this(mContext, 0);
    }

    public BaseAdapter(Context mContext, int resId) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mResId = resId;
    }

    public void setListener(BaseFragment baseFragment){
        mListener = (OnItemClickListener) baseFragment;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mResId == 0)
            return onCreate(null, viewType);
        else
            return onCreate(mInflater.inflate(mResId, parent, false), viewType);
    }

    public abstract VH onCreate(View view, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBind(holder, mListData.get(position), position);
    }

    protected abstract void onBind(VH vh, T t, int position);

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public List<T> getListData() {
        return mListData;
    }

    public T getItem(int position) {
        return mListData.get(position);
    }

    public void pushData(List<T> listData) {
        mListData.clear();
        mListData.addAll(listData);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);
    }
}