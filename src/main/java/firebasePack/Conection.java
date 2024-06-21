/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firebasePack;


import com.google.api.core.ApiFuture;
import jakarta.servlet.UnavailableException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.JsonElement;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.io.BufferedReader;
/**
 *
 * @author Usuario
 */
public class Conection {
    public static Firestore db;
    public static FirebaseApp fp;
    private static final Logger LOGGER = Logger.getLogger(Conection.class.getName());

    public static void connectToFirebase() {
        FileInputStream serviceAccount = null;
        try {
            String workingDir = Paths.get("").toAbsolutePath().toString();
            LOGGER.info("El proyecto se está ejecutando en el directorio: " + workingDir);

            serviceAccount = new FileInputStream("geo-farmacia-firebase-adminsdk-nz64y-50e8c999a6.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            LOGGER.info("Credenciales cargadas correctamente");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .setProjectId("geo-farmacia")
                    .setDatabaseUrl("https://geo-farmacia-default-rtdb.firebaseio.com")
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                LOGGER.info("Firebase inicializado correctamente");
            }

            db = FirestoreClient.getFirestore();
            LOGGER.info("Conectado a Firestore correctamente");

            // Probar la obtención de datos
            LOGGER.info("Obteniendo datos");
            ApiFuture<QuerySnapshot> query = db.collection("users").get();
            QuerySnapshot querySnapShot = query.get();
            LOGGER.info("Datos obtenidos correctamente: " + querySnapShot.getDocuments().size() + " documentos encontrados");

        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Archivo de cuenta de servicio no encontrado: " + e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al leer el archivo de cuenta de servicio: " + e.getMessage(), e);
        } catch (ExecutionException e) {
            LOGGER.log(Level.SEVERE, "Excepción de ejecución: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Excepción de interrupción: " + e.getMessage(), e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Excepción inesperada: " + e.getMessage(), e);
        } finally {
            if (serviceAccount != null) {
                try {
                    serviceAccount.close();
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar el FileInputStream: " + e.getMessage(), e);
                }
            }
        }
    } 
    public static void tryToConnect(){
        try {
            // Ruta al archivo JSON de las credenciales
            FileInputStream serviceAccount = new FileInputStream("geo-farmacia-firebase-adminsdk-nz64y-50e8c999a6.json");
            
            
            // Inicializar Firebase
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://geo-farmacia-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

            // Obtener Firestore client
            Firestore db = FirestoreClient.getFirestore();

            // Obtener referencia a la colección
            getDocumentsFromCollection(db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getDocumentsFromCollection(Firestore db) {
    // Obtener referencia a la colección 'usersTest'
    CollectionReference usersCollection = db.collection("usersTest");

    // Obtener todos los documentos de la colección
    ApiFuture<QuerySnapshot> query = usersCollection.get();

    try {
        // Obtener los documentos
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        // Iterar sobre los documentos e imprimir los datos
        for (QueryDocumentSnapshot document : documents) {
            System.out.println("User ID: " + document.getId());
            System.out.println("User Data: " + document.getData());
            System.out.println("--------------");
        }
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
}
    
    public static void guardarDato(){
        //final FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference ref = database.getReference("server/saving-data/fireblog");
        //DatabaseReference usersRef = ref.child("users");
        if (db == null){
            System.out.println("No hay base de datos");
        }else{
            Map<String, Object> users = new HashMap<>();
            users.put("saludo", "Hola");
            users.put("despedida", "Adios");
            try {
                WriteResult wr = db.collection("usersTest").document(UUID.randomUUID().toString()).set(users).get();
                /*
                while(!wr.isDone()){
                
                }
                if (wr.isDone()){
                System.out.println("Valor de wr: "+wr);
                try{
                WriteResult result = wr.get();
                System.out.println("Result: "+result.toString());
                System.out.println("Funcion de guardar datos termino correctamente");
                System.out.println("Documento escrito en: "+result.getUpdateTime());
                }catch(Exception e){
                System.out.println("ERROR: "+e.getMessage());
                //e.printStackTrace();
                }
                }else{
                System.out.println("WR no ha terminado aun");
                }*/
            } catch (InterruptedException ex) {
                Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /*
        try{
            usersRef.setValueAsync(users).get();
            //System.out.println(usersRef.child("lol").setValueAsync("hola2").get());
            //System.out.println(usersRef.child("calcio").setValueAsync("Adios2").get());
        }catch(Exception e){
            System.out.println("Hubo una excepcion: "+e.getMessage());
        }*/
        //System.out.println("ref: "+ref);
        //System.out.println("usersRef: "+usersRef);
        //System.out.println("usersRef database: "+usersRef.);
    }
}
