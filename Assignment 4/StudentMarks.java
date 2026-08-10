class StudentMarks {

    public static void main(String[] args) {

        // Marks stored in String format
        String mark1 = "85";
        String mark2 = "90";
        String mark3 = "78";

        // Converting String values into Integer wrapper objects
        Integer m1 = Integer.valueOf(mark1);
        Integer m2 = Integer.valueOf(mark2);
        Integer m3 = Integer.valueOf(mark3);

        // Calculating total marks using unboxing
        int total = m1 + m2 + m3;

        // Displaying student marks
        System.out.println("===== STUDENT MARKS =====");
        System.out.println("Subject 1 Marks: " + m1);
        System.out.println("Subject 2 Marks: " + m2);
        System.out.println("Subject 3 Marks: " + m3);

        // Displaying total marks
        System.out.println("Total Marks: " + total);
    }
}
