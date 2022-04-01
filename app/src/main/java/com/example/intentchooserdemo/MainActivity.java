package com.example.intentchooserdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_OEM_chooser).setOnClickListener(v -> share("The title"));
        findViewById(R.id.button_stock_chooser).setOnClickListener(v -> share(null));
    }

    private void share(final String title) {
        final Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://example.com"));
        final Intent[] extraIntents = { new Intent(this, AnotherActivity.class) };
        final Intent shareIntent = Intent.createChooser(sendIntent, title);
        shareIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);
        startActivity(shareIntent);
    }
}
