package com.example.Budgetmanager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanChecker implements CommandLineRunner {
    private final ApplicationContext applicationContext;

    public BeanChecker(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) {
        System.out.println("------ Registrerede Beans ------");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println("--------------------------------");

        if (applicationContext.containsBean("budgetManager")) {
            System.out.println("✅ BudgetManager er registreret som en bean!");
        } else {
            System.out.println("❌ BudgetManager er IKKE registreret som en bean!");
        }
    }
}

