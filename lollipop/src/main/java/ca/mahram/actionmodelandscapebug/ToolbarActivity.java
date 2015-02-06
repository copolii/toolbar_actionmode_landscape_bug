package ca.mahram.actionmodelandscapebug;

import android.os.Bundle;
import android.widget.Toolbar;

import ca.mahram.actionmodelandscapebug.base.BaseActivity;

/**
 Created by mahramf on 15-02-05.
 */
public class ToolbarActivity
  extends BaseActivity {

    private Toolbar toolbar;

    public ToolbarActivity () {
        super (R.layout.activity_toolbar);
    }

    @Override protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        toolbar = (Toolbar) findViewById (R.id.toolbar);
        setActionBar (toolbar);
    }
}
