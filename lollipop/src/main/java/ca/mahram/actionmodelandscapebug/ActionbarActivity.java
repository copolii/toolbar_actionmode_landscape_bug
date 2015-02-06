package ca.mahram.actionmodelandscapebug;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import ca.mahram.actionmodelandscapebug.base.BaseActivity;

/**
 Created by mahramf on 15-02-05.
 */
public class ActionbarActivity
  extends BaseActivity {

    protected Button toolbarButton;
    protected Button barlessButton;

    public ActionbarActivity () {
        super (R.layout.activity_main);
    }

    @Override protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        toolbarButton = (Button) findViewById (R.id.go_toolbar);
        toolbarButton.setOnClickListener (new View.OnClickListener () {
            @Override public void onClick (final View v) {
                startActivity (new Intent (ActionbarActivity.this, ToolbarActivity.class));
            }
        });

        barlessButton = (Button) findViewById (R.id.go_barless);
        barlessButton.setOnClickListener (new View.OnClickListener () {
            @Override public void onClick (final View v) {
                startActivity (new Intent (ActionbarActivity.this, BarlessActivity.class));
            }
        });
    }

    @Override public boolean onCreateActionMode (final ActionMode mode, final Menu menu) {
        super.onCreateActionMode (mode, menu);
        toolbarButton.setVisibility (View.GONE);
        barlessButton.setVisibility (View.GONE);
        return true;
    }

    @Override public void onDestroyActionMode (final ActionMode mode) {
        super.onDestroyActionMode (mode);
        toolbarButton.setVisibility (View.VISIBLE);
        barlessButton.setVisibility (View.VISIBLE);
    }
}
