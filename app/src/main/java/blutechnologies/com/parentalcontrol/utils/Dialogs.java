package blutechnologies.com.parentalcontrol.utils;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


public class Dialogs {


    @SuppressLint("ValidFragment")
    public static class DialogPositiveButton extends DialogFragment {
        public Context context;
        public DialogInterface.OnClickListener positiveButtonOnClickListener;
        public DialogInterface.OnClickListener negativeButtonOnClickListener;
        private String message;
        private String positiveActionText;
        private String negativeActionText;

        @SuppressLint("ValidFragment")
        public DialogPositiveButton(Context context, String message, String positiveActionText, DialogInterface.OnClickListener positiveButtonOnClickListener) {
            this.message = message;
            this.positiveActionText = positiveActionText;
            this.positiveButtonOnClickListener = positiveButtonOnClickListener;
            this.context = context;
        }


        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(message).setPositiveButton(positiveActionText, positiveButtonOnClickListener).setCancelable(false);
            // Create the AlertDialog object and return it
            return builder.create();
        }


    }


    @SuppressLint("ValidFragment")
    public static class CustomDialog extends DialogFragment {

        public DialogInterface.OnClickListener positiveButtonOnClickListener;
        public DialogInterface.OnClickListener negativeButtonOnClickListener;
        private LayoutInflater inflater;
        private String positiveActionText;
        private String negativeActionText;
        private View view;
        private int resourceId;


        public CustomDialog(int resourceId, String positiveActionText, String negativeActionText, DialogInterface.OnClickListener positiveButtonOnClickListener, DialogInterface.OnClickListener negativeButtonOnclickListener) {
            this.positiveActionText = positiveActionText;
            this.negativeActionText = negativeActionText;
            this.resourceId = resourceId;
            this.positiveButtonOnClickListener = positiveButtonOnClickListener;
            this.negativeButtonOnClickListener = negativeButtonOnclickListener;
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


            // Get the layout inflater


            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(view);


            // Add action buttons
            builder.setPositiveButton(positiveActionText, positiveButtonOnClickListener);
            builder.setNegativeButton(negativeActionText, negativeButtonOnClickListener);
            return builder.create();


        }

        public View getCustomView() {
            return this.view;
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            inflater = getActivity().getLayoutInflater();
            view = inflater.inflate(resourceId, new LinearLayout(context));
        }
    }


}
