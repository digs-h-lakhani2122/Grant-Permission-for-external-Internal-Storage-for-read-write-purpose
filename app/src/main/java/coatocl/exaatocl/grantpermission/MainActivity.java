package coatocl.exaatocl.grantpermission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    int EXTERNAL_STORAGE_PERMISSION=29;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);

    }


    public void publicly(View view) throws IOException
    {

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},EXTERNAL_STORAGE_PERMISSION);
        String editTextData=editText.getText().toString();

        File folder=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        File file=new File(folder,"digal.txt");
//        boolean check = file.createNewFile();
        WriteTextData(file,editTextData);
        editText.setText("");
    }

    public void privately(View view)
    {

     String  editTextData=editText.getText().toString();
     File folder=getExternalFilesDir("check");
     File file=new File(folder,"digal2.txt");
     WriteTextData(file,editTextData);
     editText.setText("");
    }

    public void viewInformation(View view)
    {
        Intent intent=new Intent(this,view.class);
        startActivity(intent);
    }

    private void WriteTextData(File file, String data)
    {
        FileOutputStream fileOutputStream=null;
        try {
            {
                fileOutputStream=new FileOutputStream(file);
                fileOutputStream.write(data.getBytes());
                Toast.makeText(this, "Done" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileOutputStream!=null)
            {
                try
                {
                    fileOutputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
