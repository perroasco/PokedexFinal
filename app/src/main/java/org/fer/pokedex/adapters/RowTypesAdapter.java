package org.fer.pokedex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.fer.pokedex.R;
import org.fer.pokedex.activities.PokemonTypeActivity;
import org.fer.pokedex.utils.Utils;

import java.util.List;

public class RowTypesAdapter extends RecyclerView.Adapter<RowTypesAdapter.ViewHolder> {

    private List<String> types;
    private LayoutInflater mInflater;
    private Context mContext;

    // data is passed into the constructor
    public RowTypesAdapter(Context context, List<String> types) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.types = types;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_types_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String type = types.get(position);

        Glide.with(mContext).load(Utils.getDrawable(mContext, type)).into(holder.typeImage);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView typeImage;

        ViewHolder(View itemView) {
            super(itemView);
            typeImage = itemView.findViewById(R.id.type_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, PokemonTypeActivity.class);
            String type = types.get(getAdapterPosition());
            intent.putExtra("TYPE", type);
            mContext.startActivity(intent);
        }
    }
}