<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance</title>
    <script>
        // Validate attendance form before submission
        function validateAttendance() {
            const id = document.getElementById("studentId").value.trim();
            const date = document.getElementById("date").value.trim();
            const status = document.getElementById("status").value;

            if (id === "" || date === "" || status === "") {
                alert("All fields are required!");
                return false;
            }

            if (isNaN(id)) {
                alert("Student ID must be a number!");
                return false;
            }

            return true;
        }

        // Optional: Reset form fields
        function resetForm() {
            document.getElementById("attendanceForm").reset();
        }
    </script>
</head>
<body>
    <h2>Student Attendance Portal</h2>

    <form id="attendanceForm" action="AttendanceServlet" method="post" onsubmit="return validateAttendance()">
        <label>Student ID:</label>
        <input type="text" id="studentId" name="studentId"><br><br>

        <label>Date:</label>
        <input type="date" id="date" name="date"><br><br>

        <label>Status:</label>
        <select id="status" name="status">
            <option value="">--Select--</option>
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
            <option value="Late">Late</option>
        </select><br><br>

        <input type="submit" value="Submit Attendance">
        <input type="button" value="Reset" onclick="resetForm()">
    </form>
</body>
</html>
