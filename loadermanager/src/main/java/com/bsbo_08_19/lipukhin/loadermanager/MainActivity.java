package com.bsbo_08_19.lipukhin.loadermanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bsbo_08_19.lipukhin.looper.MyLoader;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    public final String TAG = this.getClass().getSimpleName();
    EditText editText;
    private final int LoaderID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString(MyLoader.ARG_WORD, editText.getText().toString());
            getSupportLoaderManager().initLoader(LoaderID, bundle, this);
        });
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == LoaderID) {
            Toast.makeText(this, "onCreateLoader:" + id, Toast.LENGTH_SHORT).show();
            return new MyLoader(this, args);
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        if (loader.getId() == LoaderID) {
            Log.d(TAG, "onLoadFinished" + s);
            Toast.makeText(this, "onLoadFinished: " + s, Toast.LENGTH_SHORT).show();
            editText.setText(s);
        }


    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        Log.d(TAG, "onLoaderReset");

    }
}