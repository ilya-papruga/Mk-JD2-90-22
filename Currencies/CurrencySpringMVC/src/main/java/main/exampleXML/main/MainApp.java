package main.exampleXML.main;

import main.exampleXML.api.IA;
import main.exampleXML.api.IB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("exampleXML/app.xml");

        IB beanB1 = context.getBean(IB.class);
        IB beanB2 = context.getBean(IB.class);
        IB beanB3 = context.getBean(IB.class);
        IB beanB4 = context.getBean(IB.class);
        IB beanB5 = context.getBean(IB.class);

        System.out.println(beanB1.toString());
        System.out.println(beanB2.toString());
        System.out.println(beanB3.toString());
        System.out.println(beanB4.toString());
        System.out.println(beanB5.toString());

        System.out.println("_______________");

        IA bean = context.getBean(IA.class);

        bean.print();



    }

}
