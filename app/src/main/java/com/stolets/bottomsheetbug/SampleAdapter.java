package com.stolets.bottomsheetbug;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * A RecyclerView adapter which is used just for bug demonstration purpose.
 */
final class SampleAdapter extends
        RecyclerView.Adapter<SampleAdapter.ViewHolder> {
    @NonNull
    private List<String> mRows;
    @NonNull
    private Context mContext;

    SampleAdapter(@NonNull Context context, @NonNull List<String> contacts) {
        mRows = contacts;
        mContext = context;
    }

    @Override
    public SampleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        final View view = inflater.inflate(R.layout.rv_row, parent, false);

        // Return a new holder instance
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SampleAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final String row = mRows.get(position);

        // Set item views based on your views and data model
        final TextView textView = viewHolder.mTextView;
        if (textView != null) {
            textView.setText(row);
        }
    }

    @Override
    public int getItemCount() {
        return mRows.size();
    }

    /**
     * Easy access to the context object in the {@link RecyclerView}.
     * @return A context object.
     */
    @NonNull
    private Context getContext() {
        return mContext;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        TextView mTextView;

        /**
         * A constructor that accepts the entire item row and does the view lookups to find each subview.
         */
        ViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.address_segment_text_view);
        }
    }
}
