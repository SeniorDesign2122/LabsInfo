package wmu.parkview.labsinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * This activity gets titles for the current qr string and adds them to its recycler view
 */
public class ListActivity extends AppCompatActivity {
    private RecyclerView mRView;

    private List<String> mTitles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (getIntent().getStringExtra("qRString") != null)
            DBHelper.currentQRString = getIntent().getStringExtra("qRString");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRView = findViewById(R.id.recycler_view);
        mRView.setLayoutManager(new LinearLayoutManager(this));

        mTitles = DBHelper.getTitles(this, null);
    }

    /**
     * Expects to be called by DBHelper when titles loaded from database are ready to use
     */
    void titlesLoaded() {

    }

    private class Adapter extends RecyclerView.Adapter<ViewHolder> {
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(ListActivity.this).inflate(
                    R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.mTView.setText(mTitles.get(position));
        }

        @Override
        public int getItemCount() {
            return mTitles.size();
        }
    }
    
    private class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTView = itemView.findViewById(R.id.list_item_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ListActivity.this,
                            DetailActivity.class);
                    intent.putExtra("title", mTView.getText());
                    startActivity(intent);
                }
            });
        }
    }
}