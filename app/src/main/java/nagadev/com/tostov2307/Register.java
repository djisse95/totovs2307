package nagadev.com.tostov2307;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    //"extends" means the son of a parent, "login" is a son of the "AppCompatActivity"

    private EditText inputPhoneNum;
    private EditText inputUsername;
    private EditText inputPass;

    private Button register;
    private Editable phoneNum;
    private String regexStr = "^0(?!0)[0-9]{8,10}$";

    private String myPhone = "";
    private String myUsername = "";
    private String myPassword = "";

    private boolean checkSuccess = false;
    public Intent intent;

    @Override // just to alert the android
    protected void onCreate(Bundle savedInstanceState) {
        //"savedInstanceState" builded function that import datas from our father
        /* protected = only in the package
         * private = only in the class
         * public = every class can use it
        */
        super.onCreate(savedInstanceState); //proud of the father
        setContentView(R.layout.activity_register); //getting the data from the xml file
        //get the intend
        Intent next = getIntent();

        inputPhoneNum = (EditText) findViewById(R.id.txtBoxPhoneNum);
        inputUsername = (EditText) findViewById(R.id.txtBoxUser);
        inputPass = (EditText) findViewById(R.id.txtBoxpss);


        register = (Button) findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // register.setText(String.valueOf(counter));
                myPhone = String.valueOf(inputPhoneNum.getText());
                myUsername = String.valueOf(inputUsername.getText());
                myPassword = String.valueOf(inputPass.getText());
                checkSuccess = false;
                try{
                    Integer.parseInt(myPhone);
                    if(myPhone.matches(regexStr) && !myUsername.equals(" ") && !myUsername.equals("")  && !myPassword.equals("") || !myPassword.equals(" ")){
                        Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
                        checkSuccess = true;
                    } else {
                        Toast.makeText(getApplicationContext(), "Not match phone number", Toast.LENGTH_SHORT).show();
                    }
                } catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Error don't understand", Toast.LENGTH_SHORT).show();
                }
                if(checkSuccess == true){
                    intent = new Intent(Register.this, Homepage.class);
                    startActivity(intent);
                }
            }
        });
    }
}
