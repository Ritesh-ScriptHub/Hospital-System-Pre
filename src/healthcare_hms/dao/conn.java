// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
   Connection connection;
   Statement statement;

   public conn() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_management_system", "root", "ScriptHub#246");
         this.statement = this.connection.createStatement();
         System.out.println("Database Connected Successfully");
      } catch (Exception var2) {
         System.out.println("Database Connection not established");
         var2.printStackTrace();
      }

   }
}