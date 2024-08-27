package javaQues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class CSVFileWriter {

	private String writeFileName;

	public CSVFileWriter(String writeFileName) {
		this.writeFileName = writeFileName;
	}

	public void write(ArrayList<Person> people) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(writeFileName));

			for (Person human : people) {
				bw.write(human.getName());
				bw.write(",");
				bw.write(human.getAge());
				bw.write(",");
				bw.write(human.getGender());
				bw.write(",");
				bw.write(human.getAddress());
				bw.write(",");
				bw.write(human.getJob());
				bw.write(",");
				bw.newLine();
			}
			bw.close();

			System.out.println("書き込みが完了しました");
		} catch (IOException e) {
			System.out.println("ファイルの書き込みに失敗しました。");
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.out.println("ファイルをクローズ出来ませんでした。");
			}
		}
	}

}
