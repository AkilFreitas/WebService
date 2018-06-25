
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.ws.rs.ApplicationPath;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pronatec
 */
public class MyApplication {
    @ApplicationPath("/") 
public class JerseyTestApp extends Application {     
        
public Set<Class<?>> getClasses()     {         
final Set<Class<?>> classes = new HashSet<>();         
classes.add(MyApplicationController.class);         
return classes;     
}

        @Override
        public void start(Stage primaryStage) throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
 }
}
