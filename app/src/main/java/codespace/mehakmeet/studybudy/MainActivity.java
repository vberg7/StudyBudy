package codespace.mehakmeet.studybudy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.github.fabtransitionactivity.SheetLayout;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingMenuLayout;

public class MainActivity extends AppCompatActivity implements SheetLayout.OnFabAnimationEndListener{

    ImageView drawer_btn;

    Context context=this;
    Activity activity=this;
    FlowingMenuLayout fml;
    FrameLayout fl_fd;
    public static FlowingDrawer mDrawer;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   setTitleColor(R.color.blue_shade);
        drawer_btn=findViewById(R.id.drawer_btn);
        fl_fd=findViewById(R.id.fd_container);
        fml=findViewById(R.id.menulayout);

       /* final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        *//*navigationView.setNavigationItemSelectedListener(this);
*/
        mDrawer = findViewById(R.id.drawerlayout);

        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
                if(openRatio==1){
                    flag=1;
                }
                else
                    flag=0;
            }
        });
        drawer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDrawer.openMenu();

            }
        });
        floating_main fm1=new floating_main();
        home fm=new home();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_container,fm).replace(R.id.fd_container,fm1).commit();


    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();
        if (flag==1) {
            mDrawer.closeMenu(true);
        }
        Log.i("COUNT",String.valueOf(count));
        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStackImmediate();
        }

    }

    @Override
    public void onFabAnimationEnd() {

    }
}
