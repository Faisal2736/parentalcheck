package blutechnologies.com.parentalcontrol.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import blutechnologies.com.parentalcontrol.R;
import blutechnologies.com.parentalcontrol.dataModels.ChildMessagingDm;
import blutechnologies.com.parentalcontrol.viewHolders.ChildMessagingVH;


/**
 * Created by GEO on 3/30/2018.
 */

public class ChildMessagingAdap extends RecyclerView.Adapter<ChildMessagingVH> {
    private static final String TAG = "ChildMessagingAdap";
    private List<ChildMessagingDm> childMessagingDmArrayList = new ArrayList<>();
    private Context context;


    public ChildMessagingAdap(Context context) {
        this.context = context;

    }

    @Override
    public ChildMessagingVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.temp_finn_messaging, parent, false);
        ChildMessagingVH categoriesListVH = new ChildMessagingVH(view);
        return categoriesListVH;
    }

    @Override
    public void onBindViewHolder(ChildMessagingVH holder, int position) {
        ChildMessagingDm messagingDm = childMessagingDmArrayList.get(position);
        holder.tv_message.setText(messagingDm.getMessage());


    }

    @Override
    public int getItemCount() {
        return childMessagingDmArrayList.size();
    }

    public void LoadNewData(List<ChildMessagingDm> categoriesListDMList) {
        this.childMessagingDmArrayList = categoriesListDMList;
        notifyDataSetChanged();
    }

    public ChildMessagingDm getDataObject(int position) {
        return childMessagingDmArrayList.get(position);
    }

}
