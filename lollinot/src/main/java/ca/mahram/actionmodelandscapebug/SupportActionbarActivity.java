package ca.mahram.actionmodelandscapebug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import ca.mahram.actionmodelandscapebug.base.BaseActivity;

/**
 Created by mahramf on 15-02-05.
 */
public class SupportActionbarActivity
  extends BaseActivity {

    protected Button toolbarButton;
    protected Button barlessButton;

    public SupportActionbarActivity () {
        super (R.layout.activity_main);
    }

    @Override protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        toolbarButton = (Button) findViewById (R.id.go_toolbar);
        toolbarButton.setOnClickListener (new View.OnClickListener () {
            @Override public void onClick (final View v) {
                startActivity (new Intent (SupportActionbarActivity.this, ToolbarActivity.class));
            }
        });

        barlessButton = (Button) findViewById (R.id.go_barless);
        barlessButton.setOnClickListener (new View.OnClickListener () {
            @Override public void onClick (final View v) {
                startActivity (new Intent (SupportActionbarActivity.this, BarlessActivity.class));
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
