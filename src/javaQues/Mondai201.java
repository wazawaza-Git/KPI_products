package javaQues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Mondai201 {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String inputFileName = br.readLine();

			ArrayList<Person> people = new ArrayList<>();

			CSVFileReader csfr = new CSVFileReader();

			people = csfr.read(inputFileName);

			for (Person human : people) {
				System.out.println("*********************************");
				System.out.println("氏名：" + human.getName());
				System.out.println("年齢：" + human.getAge());
				System.out.println("性別：" + human.getGender());
				System.out.println("住所：" + human.getAddress());
				System.out.println("職業：" + human.getJob());
				System.out.println("*********************************");
			}

		} catch (IOException e) {

		}

	}

}
