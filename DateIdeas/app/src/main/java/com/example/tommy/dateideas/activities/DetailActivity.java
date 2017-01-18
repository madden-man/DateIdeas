package com.example.tommy.dateideas.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.tommy.dateideas.R;
import com.example.tommy.dateideas.models.DateIdea;
import com.example.tommy.dateideas.models.DateIdeaCollection;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    private DateIdea idea;
    private TextView titleTV;
    private TextView descriptionTV;
    private CircleImageView imageView;
    private CircleImageView accept;
    private CircleImageView reject;
    private CircleImageView check;
    private int[] indices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        indices = getIntent().getIntArrayExtra("indices");

        findViewById(R.id.detail_layout).setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        titleTV = (TextView) findViewById(R.id.tv_title);
        descriptionTV = (TextView) findViewById(R.id.tv_description);

        imageView = (CircleImageView) findViewById(R.id.civ_idea);

        accept = (CircleImageView) findViewById(R.id.btn_accept);
        reject = (CircleImageView) findViewById(R.id.btn_reject);
        check = (CircleImageView) findViewById(R.id.img_check);

        if (indices == null) {
            noMoreIdeas();
        } else {
            moveToNextIdea(true);
        }
    }

    private void moveToNextIdea(boolean first) {
        if (!first) {
            int[] newIndices = new int[indices.length - 1];
            for (int i = 0; i < indices.length - 1; ++i) {
                newIndices[i] = indices[i + 1];
            }
            indices = newIndices;
        } if (indices.length > 0) {
            idea = DateIdeaCollection.getInstance().getIdea(indices[0]);
            if (idea != null) {
                populateIdea();
            } else {
                moveToNextIdea(false);
            }
        } else {
            finish();
        }
    }

    public void noMoreIdeas() {
        titleTV.setText(R.string.no_more_ideas);
        accept.setVisibility(View.GONE);
        reject.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();
            }
        }, 1000);
    }

    private void populateIdea() {
        titleTV.setText(idea.getM_title());
        descriptionTV.setText(idea.getM_description());

        imageView.setImageDrawable(getDrawable(idea.getM_drawable()));

        imageView.invalidate();

    }

    @Override
    public void onDestroy() {
        imageView.setImageDrawable(null);
        super.onDestroy();
    }

    public void accept(View view) {
        titleTV.setVisibility(View.GONE);
        descriptionTV.setVisibility(View.GONE);
        accept.setVisibility(View.GONE);
        reject.setVisibility(View.GONE);
        DateIdeaCollection.getInstance().removeIdea(idea.getIndex());
        check.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();
            }
        }, 1000);
    }

    public void reject(View view) {
        DateIdeaCollection.getInstance().removeIdea(idea.getIndex());
        moveToNextIdea(false);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
