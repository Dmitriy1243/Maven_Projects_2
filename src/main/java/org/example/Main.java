package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

import static org.example.StudyProfile.*;


public class Main {
    public static void main(String[] args) throws IOException {

        FileOutputStream fis = new FileOutputStream("University.xlsx"); // создание нового файла
        XSSFWorkbook book = new XSSFWorkbook(); // создание новой книги
        XSSFSheet sheet = book.createSheet("Student"); // создание нового листа
        System.out.println(" quantity student ");
        Scanner scan = new Scanner(System.in);
        int j = scan.nextInt();
        for ( int i = 0; i < j; i++ ){
            Row row = sheet.createRow(i); //создание строки

                System.out.println("Name student; universityId student; Number Course student; Exam Score student.");
                Scanner scanner = new Scanner(System.in);
                Student student = new Student(scanner.nextLine(), scanner.nextLine(),scanner.nextInt(), scanner.nextInt());

                System.out.println( student );
                Cell cell2 = row.createCell(1);  // создание ечейки в сроке row
                cell2.setCellValue( student.fullName );

                Cell cell3 = row.createCell(2);
                cell3.setCellValue( student.universityId );

                Cell cell4 = row.createCell(3);
                cell4.setCellValue( student.currentCourseNumber );

                Cell cell5 = row.createCell(4);
                cell5.setCellValue( student.avgExamScore  );

        }

        XSSFSheet sheet1 = book.createSheet("University"); // создание нового листа

        Row row0 = sheet1.createRow(0); // создание строки

        Cell cell1 = row0.createCell(1);  // создание ечейки в сроке row
        cell1.setCellValue( " направление " );

        Cell cell2 = row0.createCell(2);  // создание ечейки в сроке row
        cell2.setCellValue( " id  направление " );

        Cell cell3 = row0.createCell(3);  // создание ечейки в сроке row
        cell3.setCellValue( " полное имя направления " );

        Cell cell4 = row0.createCell(4);  // создание ечейки в сроке row
        cell4.setCellValue( " короткое имя направления " );

        Cell cell5 = row0.createCell(5);  // создание ечейки в сроке row
        cell5.setCellValue( " время обучения " );

        Row row1 = sheet1.createRow(1); // создание строки
        University university = new University("123", "dispatcher", "dis", 4, dispatcher);

        Cell cell11 = row1.createCell(1);  // создание ечейки в сроке row

        cell11.setCellValue(dispatcher.gettranscripts());

        Cell cell12 = row1.createCell(2);  // создание ечейки в сроке row
        cell12.setCellValue( university.id );

        Cell cell13 = row1.createCell(3);  // создание ечейки в сроке row
        cell13.setCellValue( university.fullName );

        Cell cell14 = row1.createCell(4);  // создание ечейки в сроке row
        cell14.setCellValue( university.shortName );

        Cell cell15 = row1.createCell(5);  // создание ечейки в сроке row
        cell15.setCellValue( university.yearOfFoundation );

        Row row2 = sheet1.createRow(2); // создание строки
        University university2 = new University("124", "constructor", "con", 4, constructor);

        Cell cell21 = row2.createCell(1);  // создание ечейки в сроке row

        cell21.setCellValue(constructor.gettranscripts());

        Cell cell22 = row2.createCell(2);  // создание ечейки в сроке row
        cell22.setCellValue( university2.id );

        Cell cell23 = row2.createCell(3);  // создание ечейки в сроке row
        cell23.setCellValue( university2.fullName );

        Cell cell24 = row2.createCell(4);  // создание ечейки в сроке row
        cell24.setCellValue( university2.shortName );

        Cell cell25 = row2.createCell(5);  // создание ечейки в сроке row
        cell25.setCellValue( university2.yearOfFoundation );

        Row row3 = sheet1.createRow(3); // создание строки
        University university3 = new University("145", "engineer", "eng", 3, engineer);

        Cell cell31 = row3.createCell(1);  // создание ечейки в сроке row
        cell31.setCellValue(engineer.gettranscripts());

        Cell cell32 = row3.createCell(2);  // создание ечейки в сроке row
        cell32.setCellValue( university2.id );

        Cell cell33 = row3.createCell(3);  // создание ечейки в сроке row
        cell33.setCellValue( university2.fullName );

        Cell cell34 = row3.createCell(4);  // создание ечейки в сроке row
        cell34.setCellValue( university2.shortName );

        Cell cell35 = row3.createCell(5);  // создание ечейки в сроке row
        cell35.setCellValue( university2.yearOfFoundation );


        // Iterating over each column of Excel file  ( Итерация по каждому столбцу файла Excel )
        System.out.println( " sheet student" );

        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()) {
             Row row = itr.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    default:

                }
            }
            System.out.println("");
        }
        System.out.println( " sheet University" );

        Iterator<Row> itr1 = sheet1.iterator();
        while (itr1.hasNext()) {
             Row row = itr1.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    default:

                }
            }
            System.out.println("");
        }

        // закрытие книги и файла

        book.write(fis);
        book.close();
        fis.close();

    }
}