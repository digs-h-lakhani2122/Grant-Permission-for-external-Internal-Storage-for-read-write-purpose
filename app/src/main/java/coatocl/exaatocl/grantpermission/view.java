package coatocl.exaatocl.grantpermission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class view extends AppCompatActivity {

    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        textView3=findViewById(R.id.textView3);
    }

    public void showPublic(View view) 
    {

        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        File file = new File(folder, "digal.txt");
        String data = getdata(file);
        if (data != null)
        {
            textView3.setText(data);
        } else {
            textView3.setText("No Data Found");
        }
    }

    public void showPrivate(View view)
    {

        File folder = getExternalFilesDir("check");

        File file = new File(folder, "digal2.txt");
        String data = getdata(file);
        if (data != null) {
            textView3.setText(data);
        } else {
            textView3.setText("No Data Found");
        }

    }

    public void showInformation(View view)
    {
        Intent intent2=new Intent(view.this,MainActivity.class);
        startActivity(intent2);
    }

    private String getdata(File file)
    {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
