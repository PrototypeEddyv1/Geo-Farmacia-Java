/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firebasePack;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import com.google.cloud.firestore.Firestore;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class FirebaseExample {
    
    public Firestore iniciarFirebase(){
        
        FirebaseOptions options;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(getClass().getResourceAsStream("geo-farmacia-firebase-adminsdk-nz64y-50e8c999a6.json")))
                    .setDatabaseUrl("https://geo-farmacia-default-rtdb.firebaseio.com")
                    .build();
            
            FirebaseApp.initializeApp(options);
        } catch (IOException ex) {
            Logger.getLogger(FirebaseExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FirestoreClient.getFirestore();
    }
}
