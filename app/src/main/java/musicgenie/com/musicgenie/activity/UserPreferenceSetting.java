package musicgenie.com.musicgenie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import org.w3c.dom.UserDataHandler;

import musicgenie.com.musicgenie.R;
import musicgenie.com.musicgenie.utilities.SharedPrefrenceUtils;

public class UserPreferenceSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preference_setting);

        CheckBox trendingChoice = (CheckBox) findViewById(R.id.trendingChoice);
        trendingChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean needTrending) {
                if(needTrending){
                    SharedPrefrenceUtils.getInstance(UserPreferenceSetting.this).setOptionsForTrendingAudio(needTrending);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_preference_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_downloads) {
            Intent i= new Intent(UserPreferenceSetting.this,DowloadsActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}