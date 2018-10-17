package blutechnologies.com.parentalcontrol.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import blutechnologies.com.parentalcontrol.R;

public class ChildMessagingVH extends RecyclerView.ViewHolder {
    public TextView tv_message;

    public ChildMessagingVH(@NonNull View itemView) {
        super(itemView);
        tv_message = itemView.findViewById(R.id.message_body);
    }
}
