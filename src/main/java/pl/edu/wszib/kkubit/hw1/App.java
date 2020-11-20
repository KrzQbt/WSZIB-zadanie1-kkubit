package pl.edu.wszib.kkubit.hw1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.edu.wszib.kkubit.hw1.gui.GUI;
import pl.edu.wszib.kkubit.hw1.gui.IGui;

public class App {
    public static void main(String[] args) {

        new AnnotationConfigApplicationContext(AppConfiguration.class).getBean(IGui.class).showMainMenu();

    }
}
