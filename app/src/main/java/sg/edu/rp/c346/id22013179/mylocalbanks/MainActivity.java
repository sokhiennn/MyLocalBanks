package sg.edu.rp.c346.id22013179.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewDBS;
    TextView textViewOCBC;
    TextView textViewUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDBS = findViewById(R.id.textViewDBS);
        textViewOCBC = findViewById(R.id.textViewOCBC);
        textViewUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(textViewDBS);
        registerForContextMenu(textViewOCBC);
        registerForContextMenu(textViewUOB);


    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == textViewDBS) {
            wordClicked = "DBS";
        } else if (v == textViewOCBC) {
            wordClicked = "OCBC";
        } else if ( v == textViewUOB) {
            wordClicked = "UOB";
        }


    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            }
            else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                startActivity(intentCall);
                return true;
            }

        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(intentCall);
                return true;
            }

        }

        return super.onContextItemSelected(item);//pass menu item to the superclass implementation
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            textViewDBS.setText("DBS");
            textViewOCBC.setText("OCBC");
            textViewUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            textViewDBS.setText("星展银行");
            textViewOCBC.setText("华侨银行");
            textViewUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}