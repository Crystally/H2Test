import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import po.Foo;


public class Main {
	public static void main(String[] args) throws Exception {
		/*Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/WTF", "sa", "");

		Statement stmt = conn.createStatement();
		try {
			stmt.execute("create table Foo (ID VARCHAR(36), NAME VARCHAR)");
			//用 try-catch 來解決重複 create table 的問題 [逃]
		} catch (Exception e) {}*/
		ApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/java/applicationContext.xml");
		SessionFactory sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Foo foo=new Foo("1","1");
		session.save(foo);
		transaction.commit();
		List<Foo> list=session.createQuery("from Foo").list();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId()+"\t"+list.get(i).getName());
		}
		session.close();
		 //创建一个可重用固定线程数的线程池 
	}
}