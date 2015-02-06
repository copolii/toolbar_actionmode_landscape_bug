package ca.mahram.actionmodelandscapebug.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ca.mahram.actionmodelandscapebug.ActionbarActivity;
import ca.mahram.actionmodelandscapebug.R;

/**
 Created by mahramf on 15-02-05.
 */
public class BaseActivity
  extends Activity
  implements ActionMode.Callback, View.OnClickListener {

    @LayoutRes private final int layoutId;

    protected Button actionModeButton;

    protected BaseActivity (@LayoutRes final int layout) {
        layoutId = layout;
    }

    @Override protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (layoutId);

        actionModeButton = (Button) findViewById (R.id.am_button);
        actionModeButton.setOnClickListener (this);
    }

    @Override public void onClick (final View v) {
        defaultStartActionMode ();
    }

    protected void defaultStartActionMode () {
        startActionMode (BaseActivity.this);
    }

    @Override public boolean onCreateActionMode (final ActionMode mode, final Menu menu) {
        getMenuInflater ().inflate (R.menu.main, menu);
        actionModeButton.setVisibility (View.GONE);
        return true;
    }

    @Override public boolean onPrepareActionMode (final ActionMode mode, final Menu menu) {
        return false;
    }

    @Override public boolean onActionItemClicked (final ActionMode mode, final MenuItem item) {
        final String prompt = getString (R.string.menu_pressed, item.getTitle ());
        Toast.makeText (this, prompt, Toast.LENGTH_LONG).show ();
        mode.finish ();
        return true;
    }

    @Override public void onDestroyActionMode (final ActionMode mode) {
        actionModeButton.setVisibility (View.VISIBLE);
    }
}
