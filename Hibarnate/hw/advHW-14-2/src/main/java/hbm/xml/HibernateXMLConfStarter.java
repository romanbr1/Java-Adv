package hbm.xml;

import java.util.Arrays;
import java.util.HashSet;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateXMLConfStarter {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

     
		Item person = new Item("xxx", "xxx", 99);
		Cart car = new Cart("qqq");
		Cart car2 = new Cart("aaa");
		person.setCarts(new HashSet<>(Arrays.asList(car, car2)));
		session.persist(person);
		
		
		Cart cart0 = new Cart("ooo");
		Cart cart1 = new Cart("111");
		HashSet<Item> items = new HashSet<>();

			for (int i = 0; i < 4; i++) {
				Item item = new Item();
				item.setItemId("id"+i);
				item.setItemTotal("total"+i);
				item.setQuantity(i*i);
				items.add(item);
				session.persist(item);
				
			}
			cart0.setItems(items);
			cart1.setItems(items);
		session.persist(cart0);
		session.persist(cart1);
		
		
			
		
		transaction.commit();
		session.close();

	}

}
