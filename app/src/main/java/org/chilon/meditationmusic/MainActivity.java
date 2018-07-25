package org.chilon.meditationmusic;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    ListView lst;
    String[] musicType = {"Lake","Monk","Flower","Moon","Bird","Water","Wind","Lake","Monk","Flower","Moon","Bird","Water","Wind"};
    //String[] musicType;
    Integer[] image = {R.drawable.lake_small_squere,R.drawable.monk_smal_squerel,R.drawable.flower_small_squere,R.drawable.moon_small,
                        R.drawable.lake_small_squere,R.drawable.monk_smal_squerel,R.drawable.flower_small_squere,R.drawable.lake_small_squere,
                        R.drawable.monk_smal_squerel,R.drawable.flower_small_squere,R.drawable.moon_small,
                        R.drawable.lake_small_squere,R.drawable.monk_smal_squerel,R.drawable.flower_small_squere};
    String [] itemColor = {"#d7e4f5","#b3cde0","#6497b1","#708090","#006666","#008080","#66b2b2","#b2d8d8","#b3cde0","#6497b1","#005b96","#03396c","#011f4b","#b3cde0"};
    String musicTypeItem;
    public static final String MAIN_RESPONSE = "main_response";
    Integer [] quotation = {R.string.quot_1,R.string.quot_2,R.string.quot_3,R.string.quot_4,R.string.quot_5,R.string.quot_6,R.string.quot_7,R.string.quot_8,R.string.quot_9,
            R.string.quot_10,R.string.quot_11,R.string.quot_12,R.string.quot_13,R.string.quot_14,R.string.quot_15,R.string.quot_16,R.string.quot_17,R.string.quot_18,
            R.string.quot_19,R.string.quot_20};
    TextView quotSentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //musicType=getResources().getStringArray(R.array.text_listView);

        lst = (ListView) findViewById(R.id.listview);
        CustomListView customListView=new CustomListView(this,musicType,image,itemColor);
        lst.setAdapter(customListView);

        quotSentence = (TextView) findViewById(R.id.wise_sentence);
        Random random = new Random();
        int rnd = random.nextInt(20);
        quotSentence.setText(quotation[rnd]);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(getApplicationContext(), PlayMusicOne.class);
                    intent.putExtra(MAIN_RESPONSE,position);
                    setResult(RESULT_OK,intent);
                    startActivity(intent);
            }
        });

        //Settings on main View
        Button settings = (Button) findViewById(R.id.settingsbutton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivityMainSetup.class);
                startActivity(intent);
            }
        });
    }

    public String getMusicTypeItem(int position) {
        musicTypeItem = musicType[position];
        return musicTypeItem;
    }
}
