import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLOperations {

        public Connection getDBConnection() throws SQLException {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test",
                    "root", "TeasaAnaMaria2293");
            return conn;
        }

             //Introducerea unui angajat in baza de date
        public void insertData (Connection conn, Person person) throws SQLException {
            PreparedStatement st = conn.prepareStatement("insert into person values(null, ?, ?, ?, ?)");
            st.setString(1, person.getSurname());
            st.setString(2, String.valueOf(person.getAge()));
            st.setString(3, person.getAddress());
            st.setString(4, String.valueOf(person.getSalary()));
            st.execute();
        }

            //Schimbarea datelor despre angajat pe baza ID-ului
        public void modifyData(Connection conn, Person person) throws SQLException {
            Statement st = conn.createStatement();
            st.execute("update person set surname='Mioara' where id=1");
        }

           //Stergerea unui angajat pe baza ID-ului
        public void deleteData(Connection conn, Person person) throws SQLException {
            PreparedStatement st = conn.prepareStatement("delete from person where id=?");
            st.setString(1, "10");
            System.out.println(st.executeUpdate());
        }
          //Afisarea tuturor angajatilor din baza de date
        public void listData(Connection conn, Person person) throws SQLException {
            List<Person> person_collection = new ArrayList();
            Statement st = conn.createStatement();
            st.executeQuery("select * from person;");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                person = new Person(rs.getInt("ID"), rs.getString("surname"),
                        rs.getInt("age"), rs.getString("address"),
                        rs.getDouble("salary"));
                person_collection.add(person);
            }
            for (Person p : person_collection) {
                System.out.println(p);
            }
        }

            //Afisarea angatilor cu varsta cuprinsa intre 30 si 40 ani
        public void listByAge(Connection conn, Person person) throws SQLException {
            List<Person> person_collection = new ArrayList();
            Statement st = conn.createStatement();
            st.executeQuery("select * from person where age>30 and age<40;");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                person = new Person(rs.getInt("ID"), rs.getString("surname"),
                        rs.getInt("age"), rs.getString("address"),
                        rs.getDouble("salary"));
                person_collection.add(person);
                System.out.println(person);
                }
            }

             //Afisarea angatilor cu salariul mai mare de 4000
    public void listBySalary(Connection conn, Person person) throws SQLException {
        List<Person> person_collection = new ArrayList();
        Statement st = conn.createStatement();
        st.executeQuery("select * from person where salary>4000;");
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            person = new Person(rs.getInt("ID"), rs.getString("surname"),
                    rs.getInt("age"), rs.getString("address"),
                    rs.getDouble("salary"));
            person_collection.add(person);
                System.out.println(person);

        }
    }
}

