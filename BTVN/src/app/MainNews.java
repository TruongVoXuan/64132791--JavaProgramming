package app;

import java.util.ArrayList;
import java.util.Scanner;

public class MainNews {
	private static ArrayList<News> newsList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("Menu:");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
                insertNews();
                break;
            case 2:
                viewListNews();
                break;
            case 3:
                averageRate();
                break;
            case 4:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

private static void insertNews() {
    System.out.print("Enter Title: ");
    String title = scanner.nextLine();

    System.out.print("Enter Publish Date: ");
    String publishDate = scanner.nextLine();

    System.out.print("Enter Author: ");
    String author = scanner.nextLine();

    System.out.print("Enter Content: ");
    String content = scanner.nextLine();

    int[] rateList = new int[3];
    for (int i = 0; i < rateList.length; i++) {
        System.out.print("Enter rate " + (i + 1) + ": ");
        rateList[i] = scanner.nextInt();
    }
    scanner.nextLine(); // Consume newline

    News news = new News(0, title, publishDate, author, content, 0);
    news.setRateList(rateList);
    news.Calculate(); // Tính AverageRate ngay sau khi nhập RateList
    newsList.add(news);
    System.out.println("News inserted successfully.");
}

private static void viewListNews() {
    for (News news : newsList) {
        news.Display();
        System.out.println();
    }
}

private static void averageRate() {
    for (News news : newsList) {
        news.Calculate();
        news.Display();
        System.out.println();
    }
}
}
