package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Random;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration().addAnnotatedClass(org.example.Student.class).configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t1 = session.beginTransaction();

    /*    Random r = new Random();
        for(int i=1; i<=50; i++){
            Student s = new Student();
            s.setRollno(i);
            s.setName("Name "+ i);
            s.setMarks(r.nextInt(100));
            session.persist(s);
        }  */
        //this Student in the query is not the table name it is the entity name


   /*    Query q = session.createQuery("from Student");
        List<Student> students = q.list();   // use list when you are fetching list of rows with foreach loop to print the output
        for(Student s : students){
            System.out.println(s);
        }    */

 /*      Query q = session.createQuery("from Student where rollno = 25");
         Student student = (Student) q.uniqueResult();   // use this while fetching a single row with print statement
         System.out.println(student);

  */
        // the above will work while fetching the rows as it returns the object of Student or the entity but while fetching columns
        // it will not return the complete object of the Student we have to use the Object[] the object array consist of list of
        // objects i.e. rollno , name , marks in case of Student

    /*    Query q = session.createQuery("select rollno , name , marks from Student  where rollno = 20");
          Object[] student = (Object[]) q.uniqueResult();    //we are using a single object[] in case of a single row of columns
          for(Object o : student){
            System.out.println(o);
        }
*/
    /*
        Query q = session.createQuery("select rollno , name ,marks from Student s where s.marks>80");
        List<Object[]> students = (List<Object[]>) q.list();   //we are using a List of object[] in case of multiple column values at a time (many rows)
        for(Object[] student : students){
            System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
        }
*/

/*      Query q = session.createQuery("select sum(marks) from Student where marks>60");
        //we are using s.marks instead of marks as it will remove any confusion between multiple tables having same columns
        Long mark = (Long)q.uniqueResult();
        System.out.println(mark);
*/

 /*     //Here we are trying sql in hibernate but SQLQuery is deprecated in hibernate6 so we are using NativeQuery instead
        NativeQuery<Student> query = session.createNativeQuery("select * from student where marks > 60" , Student.class);
        List<Student> students = query.getResultList();
        for(Student o : students){
            System.out.println(o);
        }
*/
       //Here we are not selecting the entire student table but some specific elements - SQL
        NativeQuery<Object[]> query = session.createNativeQuery("select name , rollno  from student where marks > 60");
        List<Object[]> students = query.getResultList();
        for(Object[] student : students){
            System.out.println("Name: " + student[0] + ", Rollno: "+ student[1]);
        }
        t1.commit();
    }
}

// *******Difference btw get() and load()*************
//there are 2 types of methods to fetch one is get() and other is load()
//get() will give you the object whereas load() will give you the Proxy object
//get() will fire the query even if you don't use it or print it whereas load will not fire the query untill you use it or print it
//that Proxy object is a blank object there is no actual object
//this is helpful when your object is dependent on another object here we can use load
//while fetching a value which does not really exist , get() gives null value whereas load() will give you objectNotFound exception thus we can handle that exception using try catch in load
//normally we use get but for certain conditions we use load()