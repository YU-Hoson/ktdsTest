package lotto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSV {
	public static void main(String[] args) {

		//파일을 읽어 온다.
		try {
			List<String> csv = Files.readAllLines(Paths.get
					("C:\\Users\\Administrator\\점수표_2.CSV"));
			for(int i=0; i<csv.size(); i+=1) {
				if(i==0) {
					continue;
				}
				String[] strArr = csv.get(i).split(",");
				//for(String word: strArr) {
				//System.out.println();
				//}

				System.out.println(strArr[0]+ "과목의 점수는");
			}


		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

