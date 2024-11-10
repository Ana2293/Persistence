import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        SQLOperations sqlOperations = new SQLOperations();
        Person person = new Person("Maria", 46, "Valcea", 3200);
        try {
            Connection conn = sqlOperations.getDBConnection();

            Frame f = new Frame("Lista angajati");
            GridBagLayout gridBagLayout = new GridBagLayout();
            f.setLayout(gridBagLayout);

            new GridBagConstraints();

            new GridBagConstraints();

            GridBagConstraints c;
            c = new GridBagConstraints();

            c.fill = GridBagConstraints.BOTH;
            Label l = new Label("Baza de date angajati");
            f.add(l, c);

            c.gridx = 0;
            c.gridy = 1;
            Button b = new Button("Adaugare angajati");
            f.add(b, c);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        sqlOperations.insertData(conn, person);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Angajat adaugat cu succes!");
                }
            });

            c.gridx = 0;
            c.gridy = 2;
            Button b1 = new Button("Actualizare angajati");
            f.add(b1, c);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        sqlOperations.modifyData(conn, person);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Modificare efectuata cu succes!");
                }
            });

            c.gridx = 0;
            c.gridy = 3;
            Button b2 = new Button("Stergere angajati");
            f.add(b2, c);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        sqlOperations.deleteData(conn, person);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Stergere efectuata cu succes!");
                }
            });

            c.gridx = 1;
            c.gridy = 1;
            Button b3 = new Button("Afisare lista angajati");
            f.add(b3, c);
            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        sqlOperations.listData(conn, person);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            c.gridx = 1;
            c.gridy = 2;
            Button b4 = new Button("Lista angajati intre 30 si 40 ani");
            f.add(b4, c);
            b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        sqlOperations.listByAge(conn, person);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            c.gridx = 1;
            c.gridy = 3;
            Button b5 = new Button("Angajati cu salariul mai mare de 4000");
            f.add(b5, c);
            b5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        sqlOperations.listBySalary(conn, person);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            f.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            f.setPreferredSize(new Dimension(500, 300));
            f.pack();
            f.setVisible(true);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
