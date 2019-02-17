
package healthy.banker;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.json.*;

public class HealthyBanker extends javax.swing.JFrame implements java.awt.event.ActionListener{

javax.swing.JLabel type = new javax.swing.JLabel("Please enter your account type"); //GUI component that commands user to enter exam score
javax.swing.JLabel nickname  = new javax.swing.JLabel("Please enter your account nickname"); //GUI component that commands user to enter exam score
javax.swing.JLabel id  = new javax.swing.JLabel("Please enter your id number"); //GUI component that commands user to enter exam score
//javax.swing.JLabel stepInput  = new javax.swing.JLabel("Enter the number of steps you completed today"); //GUI component that commands user to enter exam score
JTextField typefield = new JTextField(12); //GUI component that holds score
JTextField nnamefield = new JTextField(12);
JTextField idfield = new JTextField(12);
//JTextField stepfield = new JTextField(12);
javax.swing.JButton button = new javax.swing.JButton("Submit"); //GUI component that calls action performer
javax.swing.JLabel answer = new javax.swing.JLabel(" "); //GUI that presents user letter grade


public HealthyBanker(){ //GUI initialization 
setSize(500,500); //GUI window size
java.awt.Container pane = getContentPane();
javax.swing.BoxLayout box = new
javax.swing.BoxLayout(pane,javax.swing.BoxLayout.X_AXIS);
setLayout( new FlowLayout() );
pane.add(id);
pane.add(idfield);
pane.add(type); //ask for score
pane.add(typefield);
pane.add(nickname); //holds score
pane.add(nnamefield);
//pane.add(stepInput);
//pane.add(stepfield);
pane.add(button); //shows button
pane.add(answer); //shows letter grade
button.addActionListener(this); //calls button to action
setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
setVisible( true );
}


public void actionPerformed(java.awt.event.ActionEvent thing){
HashMap<String, String> hashMap= new HashMap<String, String>();;
System.out.print("work:");
    try{

URL url;
url = new URL("http://api.reimaginebanking.com/accounts?key=56dcff8bcced8a8e11779c0c24fddc63");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("GET");
int status = con.getResponseCode();
BufferedReader in = new BufferedReader(
  new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer content = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    content.append(inputLine);
    hashMap = new HashMap<String, String>();
String string = "{\"_id\":\"type\",\"nickname\":\"rewards\":\"balance\":\"account_number\":\"customer_id\"}";



}
//System.out.print(content);
//java.util.Hashtable<String, HealthyBanker> dict = new java.util.Hashtable<>(18000);
//HashMap<String, String> hashMap = new HashMap<String, String>();
//String string = "{\"_id\":\"type\",\"nickname\":\"rewards\":\"balance\":\"account_number\":\"customer_id\"}";
try {
    JSONObject json = new JSONObject(content);

    hashMap.put("_id", json.getString("_id"));
    hashMap.put("type", json.getString("type"));
    hashMap.put("nickname", json.getString("nickname"));
    //hashMap.put("reward", json.getString("reward"));
    //hashMap.put("balance", json.getString("balance"));
    if(hashMap.containsKey(idfield)){
    //return map.get(userInput);
        System.out.print("true");
}
} catch (JSONException e) {
     System.err.printf("dont work");
}
/*
HashMap<String, String> map = new HashMap<String, String>();
JSONObject obj = new JSONObject(content);
Iterator<?> keys = obj.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = obj.getString(key); 
            map.put(key, value);

        }

        System.out.println("json : "+obj);
        System.out.println("map : "+map);
    }


*/
in.close();
} catch(Exception err){
System.err.printf("DONT WORK");
System.exit(-1);
//in.close();
} 

 
    
    
    
    

}

public static void main (String[] args){

HealthyBanker program = new HealthyBanker();


}}

