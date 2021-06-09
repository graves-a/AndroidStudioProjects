package com.zybooks.to_dolist;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ToDoList mToDoList;
    private EditText mItemEditText;
    private TextView mItemListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemEditText = findViewById(R.id.toDoItem);
        mItemListTextView = findViewById(R.id.itemList);

        mToDoList = new ToDoList(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            // Attempt to load a previously saved list
            mToDoList.readFromFile();
            displayList();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        try {
            // Save list for later
            mToDoList.saveToFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addButtonClick(View view) {

        // Ignore any leading or trailing spaces
        String item = mItemEditText.getText().toString().trim();

        // Clear the EditText so it's ready for another item
        mItemEditText.setText("");

        // Add the item to the list and display it
        if (item.length() > 0) {
            mToDoList.addItem(item);
            displayList();
        }
    }

    private void displayList() {

        // Display a numbered list of items
        StringBuffer itemText = new StringBuffer();
        String[] items = mToDoList.getItems();
        for (int i = 0; i < items.length; i++) {
            itemText.append((i + 1) + ". " + items[i] + "\n");
        }

        mItemListTextView.setText(itemText);
    }

    public void clearButtonClick(View view) {
        mToDoList.clear();
        displayList();
    }

    private final int REQUEST_WRITE_CODE = 0;

//    public void downloadButtonClick(View view) {
//        // check for write permissions
//        if (PermissionsUtil.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                R.string.write_rationale, REQUEST_WRITE_CODE)) {
//            try {
//                if (mToDoList.downloadFile()) {
//                    Toast.makeText(this, R.string.download_successful, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(this, R.string.download_failed, Toast.LENGTH_LONG).show();
//                }
//            } catch (IOException e) {
//                    Toast.makeText(this, R.string.download_failed, Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//
//            }
//        }
//    }
//
//    @Override
//    public void onRequestPermissionResult(int requestCode,
//                                          String[] permissions, int[] grantResults) {
//        switch (requestCode) {
//            case REQUEST_WRITE_CODE: {
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // Permission granted, so download the list to SD card
//                    downloadButtonClick(null);
//                }
//                return;
//            }
//        }
//    }
}