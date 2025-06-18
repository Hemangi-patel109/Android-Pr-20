package com.example.smsapp;
import androidx.appcompat.app.AppCompatActivity; 
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager; 
import android.view.View;
import android.widget.Button;
import android.widget.EditText; 
import android.widget.Toast;
public class MainActivity extends AppCompatActivity { EditText phonenumber,message;
Button send; @Override
protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main); send=findViewById(R.id.button); phonenumber=findViewById(R.id.editText); message=findViewById(R.id.editText2);
send.setOnClickListener(new View.OnClickListener() { @Override
public void onClick(View view) {
String number = phonenumber.getText().toString().trim(); String msg = message.getText().toString().trim();
if (number.isEmpty()) {
Toast.makeText(getApplicationContext(), "Please enter a phone number", Toast.LENGTH_LONG).show();
return;
}
if (msg.isEmpty()) {
Toast.makeText(getApplicationContext(), "Please enter a message", Toast.LENGTH_LONG).show();
return;
}
if (checkSelfPermission(android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
requestPermissions(new String[]{android.Manifest.permission.SEND_SMS}, 1); return;
}
try {
SmsManager smsManager = SmsManager.getDefault(); smsManager.sendTextMessage(number, null, msg, null, null);
Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
} catch (Exception e) {
Toast.makeText(getApplicationContext(), "Failed to send message", Toast.LENGTH_LONG).show();
e.printStackTrace();
}}
});
}
}
