package brickBreaker;

import brickBreaker.view.View;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static brickBreaker.gamePlay.GamePlayProperties.gameHeight;
import static brickBreaker.gamePlay.GamePlayProperties.gameWidth;

public class JavaFXRoot extends Application {

    @Autowired
    View view;

    ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        ApplicationContextInitializer<GenericApplicationContext> initializer =
                applicationContext -> {
                           applicationContext.registerBean(Application.class, () -> JavaFXRoot.this);
                           applicationContext.registerBean(Parameters.class, () -> getParameters());
                           applicationContext.registerBean(HostServices.class, () -> getHostServices());
                    };

        this.applicationContext = new SpringApplicationBuilder()
                .sources(Main.class)
                .initializers(initializer)
                .run(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(view, gameWidth, gameHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Brick Breaker");
        primaryStage.show();

        view.requestFocus();
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
}
