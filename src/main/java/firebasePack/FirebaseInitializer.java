/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firebasePack;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class FirebaseInitializer {
    private static boolean initialized = false;

    public static void initialize() throws IOException {
        if (!initialized) {
            FileInputStream serviceAccount = new FileInputStream("geo-farmacia-firebase-adminsdk-nz64y-50e8c999a6.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            initialized = true;
        }
    }
}
