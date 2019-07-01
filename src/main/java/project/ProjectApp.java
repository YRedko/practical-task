package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjectApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProjectApp.class, args);
        System.out.println("Hello!");
    }
}
