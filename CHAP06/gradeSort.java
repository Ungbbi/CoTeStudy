package CHAP06;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;


class Student{
    String name;
    int grade;

    Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }
    public int getGrade(){
        return this.grade;
    }
    public String getName(){
        return this.name;
    }
}
public class gradeSort {
    public static void quickSort(Student[] students, int start, int end){
        if(start>=end) return;
        int pivot = start;
        int left = start+1;
        int right = end;

        while(left<=right){
            while(left<=end && students[left].getGrade() <= students[pivot].getGrade()){
                left++;
            }
            while(right>start && students[right].getGrade() >= students[pivot].getGrade()){
                right--;
            }
            if(left > right){
                Student temp = students[right];
                students[right] = students[pivot];
                students[pivot] = temp;
            }
            else{
                Student temp = students[left];
                students[left] = students[right];
                students[right] = temp;
            }
        }
        quickSort(students, start, right-1);
        quickSort(students, right+1, end);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;
        Student[] students = new Student[N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            students[i] = new Student(input[0], Integer.parseInt(input[1]));
        }
        quickSort(students, 0, students.length-1);
        for(int i=0; i<N; i++){
            System.out.print(students[i].getName() + " ");
        }
    }
}
