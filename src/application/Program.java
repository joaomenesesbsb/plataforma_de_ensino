package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Lesson;
import model.entities.Task;
import model.entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso?");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados da " + i + "a aula: ");
			System.out.print("Conteúdo ou tarefa (c/t)?");
			char classType = sc.next().charAt(0);
			System.out.print("Título: ");
			String title = sc.next();
			if (classType == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				System.out.println();
				
				Lesson lesson = new Video(title, url, seconds);
				list.add(lesson);
				
			}
			else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				System.out.println();
				
				Lesson lesson = new Task(title, description, questionCount);
				list.add(lesson);
			}
		}
		int sum = 0;
		for(Lesson l : list) {
			sum += l.Duration();
		}
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos ");
		

		sc.close();
	}
}
