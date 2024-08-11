package product1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.print("Tell me your name! : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			System.out.println("Hello! Nice to meet you : " + str);
		} catch (IOException e) {
			System.out.println("何らかのエラーが発生しました。");
		}
	}

}
