
    import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

    public class StudentDAO {

        public void addStudent(Student s) {
            try {
                Connection con = DBConnection.getConnection();
                String query = "INSERT INTO student VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, s.getId());
                ps.setString(2, s.getName());
                ps.setString(3, s.getCourse());
                ps.setInt(4, s.getAge());
                ps.executeUpdate();
                System.out.println("Student Added Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void viewStudents() {
            try {
                Connection con = DBConnection.getConnection();
                String query = "SELECT * FROM student";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    System.out.println(
                            rs.getInt(1) + " " +
                                    rs.getString(2) + " " +
                                    rs.getString(3) + " " +
                                    rs.getInt(4)
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

