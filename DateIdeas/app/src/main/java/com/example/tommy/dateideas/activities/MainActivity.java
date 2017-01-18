package com.example.tommy.dateideas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.tommy.dateideas.R;
import com.example.tommy.dateideas.models.Circle;
import com.example.tommy.dateideas.models.DateIdea;
import com.example.tommy.dateideas.models.DateIdeaCollection;

import java.util.Collections;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    /*

    DATE IDEAS:

    0. Ice Skating                          Good
    1. Mini Golf                            Good
    2. Walk Around Circle                   Good, Anxious
    3. Movie                                Good, Anxious
    4. Boat Parade of Lights                Serene
    5. Ronald Raegan Library                Adventurous
    ?. Art Museums                          Serene
    6. Ballroom Dance Lessons               Daring, Restless
    7. Stargazing                           Spontaneous, Adventurous
    8. Hike w/ Disposable Camera           Frustrated, Spontaneous, Adventurous
    9. Flea market w/ $10 each             Spontaneous, Adventurous
    10. Kayaking                            Adventurous
    11. Scrabble/Board Game Night           Social
    12. Volunteer for homeless              Inspired, Restless
    13. Slam Poetry Night                   Daring
    ?. Scavenger Hunt                      Adventurous
    14. Cook dinner for her/Bake            Serene
    15. Improv Show??                       Daring
    16. Concert                             Inspired, Anxious
    17. Make Music together                 Inspired, Playful
    18. Find unexpected food                Spontaneous, Adventurous
    19. Opera/Musical/Play                  Serene
    20. Beach!                              Playful, Adventurous
    21. Paper Airplane Contest              Frustrated, Playful, Spontaneous
    22. Study party!                        Productive
    23. Whale Watching Cruise               Playful, Adventurous
    24. Bowling                             Good
    25. Reading Party!                      Productive
    26. Paddle boarding!                    Spontaneous
    27. Pool Party                          Social

     */

    private DateIdeaCollection collection;
    private Stack<DateIdea> dateIdeas;

    private boolean skipToHome;

    public static final int SKIP_TO_HOME_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateIdeas = new Stack<DateIdea>();

        fillDateIdeaCollection();
    }

    private void fillDateIdeaCollection() {
        collection = DateIdeaCollection.getInstance();
        collection.addIdea(getString(R.string.ice_skating_title),
                getString(R.string.ice_skating_desc), R.drawable.ice_skating);
        collection.addIdea(getString(R.string.mini_golf_title),
                getString(R.string.mini_golf_desc), R.drawable.mini_golf);
        collection.addIdea(getString(R.string.walk_around_circle_title),
                getString(R.string.walk_around_circle_desc), R.drawable.walking_around_circle);
        collection.addIdea(getString(R.string.movie_title),
                getString(R.string.movie_desc), R.drawable.movie);
        collection.addIdea(getString(R.string.boat_parade_title),
                getString(R.string.boat_parade_desc), R.drawable.boat_parade);
        collection.addIdea(getString(R.string.raegan_library_title),
                getString(R.string.raegan_library_desc), R.drawable.reagan_library);
     /*   collection.addIdea(getString(R.string.art_museum_title),
                getString(R.string.art_museum_desc), R.drawable.art_museum)); */
        collection.addIdea(getString(R.string.ballroom_dance_title),
                getString(R.string.ballroom_dance_desc), R.drawable.ballroom_dancing);
        collection.addIdea(getString(R.string.stargazing_title),
                getString(R.string.stargazing_desc), R.drawable.stargazing);
        collection.addIdea(getString(R.string.camera_hike_title),
                getString(R.string.camera_hike_desc), R.drawable.camera_hike);
        collection.addIdea(getString(R.string.flea_market_title),
                getString(R.string.flea_market_desc), R.drawable.flea_market);
        collection.addIdea(getString(R.string.kayak_title),
                getString(R.string.kayak_desc), R.drawable.kayak);
        collection.addIdea(getString(R.string.board_game_title),
                getString(R.string.board_game_desc), R.drawable.board_game);
        collection.addIdea(getString(R.string.volunteer_title),
                getString(R.string.volunteer_desc), R.drawable.volunteer);
        collection.addIdea(getString(R.string.slam_poetry_title),
                getString(R.string.slam_poetry_desc), R.drawable.slam_poetry);
/*        collection.addIdea(getString(R.string.scavenger_hunt_title),
                getString(R.string.scavenger_hunt_desc), R.drawable.scavenger_hunt)); */
        collection.addIdea(getString(R.string.chef_tommy_title),
                getString(R.string.chef_tommy_desc), R.drawable.chef_tommy);
        collection.addIdea(getString(R.string.improv_title),
                getString(R.string.improv_desc), R.drawable.improv);
        collection.addIdea(getString(R.string.concert_title),
                getString(R.string.concert_desc), R.drawable.concert);
        collection.addIdea(getString(R.string.guitar_night_title),
                getString(R.string.guitar_night_desc), R.drawable.guitar_night);
        collection.addIdea(getString(R.string.find_food_title),
                getString(R.string.find_food_desc), R.drawable.find_food);
        collection.addIdea(getString(R.string.musical_play_opera_title),
                getString(R.string.musical_play_opera_desc), R.drawable.musical_play_opera);
        collection.addIdea(getString(R.string.beach_title),
                getString(R.string.beach_desc), R.drawable.beach);
        collection.addIdea(getString(R.string.paper_airplane_title),
                getString(R.string.paper_airplane_desc), R.drawable.paper_airplane);
        collection.addIdea(getString(R.string.study_party_title),
                getString(R.string.study_party_desc), R.drawable.study_party);
        collection.addIdea(getString(R.string.whale_cruise_title),
                getString(R.string.whale_cruise_desc), R.drawable.whale_cruise);
        collection.addIdea(getString(R.string.bowling_title),
                getString(R.string.bowling_desc), R.drawable.bowling);
        collection.addIdea(getString(R.string.reading_party_title),
                getString(R.string.reading_party_desc), R.drawable.reading_party);
        collection.addIdea(getString(R.string.paddleboarding_title),
                getString(R.string.paddleboarding_desc), R.drawable.paddleboarding);
        collection.addIdea(getString(R.string.pool_party_title),
                getString(R.string.pool_party_desc), R.drawable.pool_party);

        collection.addCircle(0, R.id.btn_good);
        collection.addCircle(1, R.id.btn_adventurous);
        collection.addCircle(2, R.id.btn_serene);
        collection.addCircle(3, R.id.btn_anxious);
        collection.addCircle(4, R.id.btn_daring);
        collection.addCircle(5, R.id.btn_spontaneous);
        collection.addCircle(6, R.id.btn_frustrated);
        collection.addCircle(7, R.id.btn_social);
        collection.addCircle(8, R.id.btn_inspired);
        collection.addCircle(9, R.id.btn_playful);
        collection.addCircle(10, R.id.btn_productive);
        collection.addCircle(11, R.id.btn_restless);

        Circle good = collection.getCircle(0);
        good.addDateIdea(0);
        good.addDateIdea(1);
        good.addDateIdea(2);
        good.addDateIdea(3);
        good.addDateIdea(24);

        Circle adventurous = collection.getCircle(1);
        adventurous.addDateIdea(5);
        adventurous.addDateIdea(7);
        adventurous.addDateIdea(8);
        adventurous.addDateIdea(9);
        adventurous.addDateIdea(10);
        adventurous.addDateIdea(18);
        adventurous.addDateIdea(20);
        adventurous.addDateIdea(23);

        Circle serene = collection.getCircle(2);
        serene.addDateIdea(4);
        serene.addDateIdea(14);
        serene.addDateIdea(19);

        Circle anxious = collection.getCircle(3);
        anxious.addDateIdea(2);
        anxious.addDateIdea(3);
        anxious.addDateIdea(16);

        Circle daring = collection.getCircle(4);
        daring.addDateIdea(6);
        daring.addDateIdea(13);
        daring.addDateIdea(15);

        Circle spontaneous = collection.getCircle(5);
        spontaneous.addDateIdea(7);
        spontaneous.addDateIdea(8);
        spontaneous.addDateIdea(9);
        spontaneous.addDateIdea(18);
        spontaneous.addDateIdea(21);
        spontaneous.addDateIdea(26);

        Circle frustrated = collection.getCircle(6);
        frustrated.addDateIdea(8);
        frustrated.addDateIdea(21);

        Circle social = collection.getCircle(7);
        social.addDateIdea(11);
        social.addDateIdea(27);

        Circle inspired = collection.getCircle(8);
        inspired.addDateIdea(12);
        inspired.addDateIdea(16);
        inspired.addDateIdea(17);

        Circle playful = collection.getCircle(9);
        playful.addDateIdea(17);
        playful.addDateIdea(20);
        playful.addDateIdea(21);
        playful.addDateIdea(23);

        Circle productive = collection.getCircle(10);
        productive.addDateIdea(22);
        productive.addDateIdea(25);

        Circle restless = collection.getCircle(11);
        restless.addDateIdea(6);
        restless.addDateIdea(12);
    }

    public void generateDateIdeas(View view) {
        Circle circle = collection.getCircleById(view.getId());
        dateIdeas = circle.pushStack();

        Collections.shuffle(dateIdeas);

        Intent intent = new Intent(this, DetailActivity.class);
        if (circle.getNumIdeas() != 0) {
            int[] ideaIndices = new int[circle.getNumIdeas()];

            for (int i = 0; i < ideaIndices.length; ++i) {
                ideaIndices[i] = dateIdeas.pop().getIndex();
            }
            intent.putExtra("indices", ideaIndices);
        }
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_idea:
                startActivity(new Intent(this, ItemAdderActivity.class));
                return true;
            case R.id.editor_mode:
                startActivity(new Intent(this, EditorActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_topbar, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
