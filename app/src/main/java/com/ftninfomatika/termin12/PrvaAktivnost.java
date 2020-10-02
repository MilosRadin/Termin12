package com.ftninfomatika.termin12;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class PrvaAktivnost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prva_aktivnost);
        if (savedInstanceState != null)
            brojac = savedInstanceState.getInt("brojac");
    }

    public PrvaAktivnost() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Prva aktivnost", "Ovo je onStart metoda");
        Toast.makeText(this, "Ovo je onStart metoda", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Prva aktivnost", "Ovo je onStop metoda");
        Toast.makeText(this, "Ovo je onStop metoda", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Prva aktivnost", "Ovo je onRestart metoda");
        Toast.makeText(this, "Ovo je onRestart metoda", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Prva aktivnost", "Ovo je onDestroy metoda");
        Toast.makeText(this, "Ovo je onDestroy metoda", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Prva aktivnost", "Ovo je onPause metoda");
        Toast.makeText(this, "Ovo je onPause metoda", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Prva aktivnost", "Ovo je onResume metoda");
        Toast.makeText(this, "Ovo je onResume metoda", Toast.LENGTH_SHORT).show();

    }

    private int brojac = 1;

    public void klik(View v) {
        Toast.makeText(this, "Klik na dugme" + brojac++, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("brojac", brojac);
    }

    public void klikDrugaAktivnost(View v) {
        Intent i = new Intent(this, DrugaAktivnost.class);
        startActivity(i);
    }

    private static final int REQUEST_SELECT_CONTACT = 0;


    public void izaberiKontakt(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            Toast.makeText(this, "" + contactUri, Toast.LENGTH_SHORT).show();

        }

    }
}