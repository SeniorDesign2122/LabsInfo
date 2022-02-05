package wmu.parkview.labsinfo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;

/**
 * This activity gets titles and their corresponding thumbnails for the current qr string and adds
 * them to its recycler view
 */
public class ListActivity extends AppCompatActivity {
    private RecyclerView mRView;

    private List<HashMap<String, String>> mTitles;

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
        mRView.setAdapter(new Adapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.send_email) {
            new EmailDialog().show(getSupportFragmentManager(), "EmailDialog");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
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
            holder.mTView.setText(mTitles.get(position).get("title"));

            if (!mTitles.get(position).get("thumb_address").equals("")) {
                Glide.with(ListActivity.this).load(mTitles.get(position).
                        get("thumb_address")).into(holder.mIView);
            } else {
                holder.mIView.setImageResource(R.drawable.wmu_logo);
            }
        }

        @Override
        public int getItemCount() {
            return mTitles.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTView;
        ImageView mIView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTView = itemView.findViewById(R.id.list_item_text);
            mIView = itemView.findViewById(R.id.list_item_img);

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