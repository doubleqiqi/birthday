package com.crdc.qi.birthdayreminder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crdc.qi.birthdayreminder.ContactBirdayFragment.OnListFragmentInteractionListener;
import com.crdc.qi.birthdayreminder.dummy.DummyContent.ContactBirthday;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ContactBirthday} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyContactBirdayRecyclerViewAdapter extends RecyclerView.Adapter<MyContactBirdayRecyclerViewAdapter.ViewHolder> {

    private final List<Contact> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyContactBirdayRecyclerViewAdapter(List<Contact> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contactbirday, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mPhoneView.setText(mValues.get(position).phoneNum);
        holder.mCardView.setText(mValues.get(position).cardNum);
        holder.mNameView.setText(mValues.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mPhoneView;
        public final TextView mCardView;
        public Contact mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPhoneView = (TextView) view.findViewById(R.id.id);
            mCardView = (TextView) view.findViewById(R.id.content);
            mNameView = (TextView) view.findViewById(R.id.name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mCardView.getText() + "'";
        }
    }
}
