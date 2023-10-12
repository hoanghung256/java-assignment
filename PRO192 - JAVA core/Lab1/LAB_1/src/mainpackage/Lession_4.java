/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainpackage;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Lession_4 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int student_num = sc.nextInt();
        sc.nextLine(); // take the \n character that nextInt() did not

        String[] student_name = new String[student_num];
        double[] student_score = new double[student_num];

        getStudentName(student_name, student_score, student_num);

        sortStudentList(student_name, student_score, student_num);

        printStudentInfor(student_name, student_score, student_num);

        printHighestStudent(student_name[0], student_score[0]);
    }

    private static void sortStudentList(String[] student_name, double[] student_score, int student_num) {
        // Sort student list in decreasing order
        for (int i = 0; i < student_num - 1; i++) {
            for (int j = 0; j < student_num - i - 1; j++) {
                if (student_score[j] < student_score[j + 1]) {
                    swap(student_score, j, j + 1);
                    swap(student_name, j, j + 1);
                }
            }
        }
    }

    private static void printStudentInfor(String[] student_name, double[] student_score, int student_num) {
        // Print students' information
        for (int i = 0; i < student_num; i++) {
            System.out.println("\nName of student " + (i + 1) + ": " + normalizeName(student_name[i]));
            System.out.printf("Score: %.2f", student_score[i]);
            System.out.println("\nAcademic ability: " + getAcademicAbility(student_score[i]));
        }
    }

    private static void printHighestStudent(String name, double score) {
        // Print the information of the Student with the highest score
        System.out.printf("\nThe student with the highest score is %s with a score of %.2f (%s).\n", normalizeName(name), score, getAcademicAbility(score));
    }

    private static String getAcademicAbility(double score) {
        if (score < 5) {
            return "Weak";
        } else if (score < 6.5) {
            return "Average";
        } else if (score < 7.5) {
            return "Good";
        } else {
            return "Excellent";
        }
    }

    private static String normalizeName(String input) {
        input = input.trim().toLowerCase();
        input = input.replaceAll("[^a-z0-9\\s+]", "");
        input = input.replaceAll("\\s+", " ");
        String[] split_input = input.split(" ");

        for (int i = 0; i < split_input.length; i++) {
            String first_char = split_input[i].substring(0, 1);
            String remaining = split_input[i].substring(1);
            split_input[i] = first_char.toUpperCase() + remaining;
        }
        String normalized = String.join(" ", split_input);
        return normalized;
    }

    private static void getStudentName(String[] student_name, double[] student_score, int student_num) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < student_num; i++) {
            System.out.print("Name of student [" + (i + 1) + "]: ");
            student_name[i] = sc.nextLine();
            student_score[i] = Math.random() * 9;
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
