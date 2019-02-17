package ua.lviv.lgs.one_to_manyHW;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("/META-INF/hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Post post = new Post();
		post.setTitle("custom post");

			
		Comment comment = new Comment();
		comment.setAuthorName("author1");
		comment.setPost(post);

		Comment comment2 = new Comment();
		comment2.setAuthorName("author2");
		comment2.setPost(post);

		Set<Comment> comments = new HashSet<>();
		comments.add(comment);
		comments.add(comment2);

		post.setComments(comments);

		// save to DB
		Transaction transaction = session.beginTransaction();
		session.save(post);
		transaction.commit();

		// read from DB
		Post postDB = (Post) session.get(Post.class, 1);
		System.out.println(postDB + "---->" + postDB.getComments());

		Comment commentDB = (Comment) session.get(Comment.class, 2);
		System.out.println(commentDB + "---->" + commentDB.getPost());

	}
}
