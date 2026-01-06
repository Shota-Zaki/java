import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EX12 {

	public static void main(String[] args) throws  Exception {
		// TODO 自動生成されたメソッド・スタブ

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("タテ：");
		int y = Integer.parseInt(br.readLine());
		System.out.print("ヨコ：");
		int x = Integer.parseInt(br.readLine());

		System.out.println("模様を入力してください（空白を入力して終了）");

		String[] sl = null;
		String str;
		int max = 0;
		while((str = br.readLine()).length() > 0){
			if(sl == null){
				sl = new String[1];
			}
			else{
				String[] nsl = new String[sl.length + 1];
				for(int i = 0; i < sl.length; i++){
					nsl[i] = sl[i];
				}
				sl = nsl;
			}
			sl[sl.length - 1] = str;
			if(max < str.length()){
				max = str.length();
			}
		}

		String[][] tex = new String[sl.length][max];
		for(int i = 0; i < tex.length; i++){
			for(int j = 0; j < max; j++){
				if(j < sl[i].length()){
					tex[i][j] = sl[i].substring(j, j + 1);
				}
				else{
					tex[i][j] = "　";
				}
			}
		}

		// デバッグ
		/*
		System.out.println("x=" + x + " y=" + y);
		for(int i = 0; i < tex.length; i++){
			for(int j = 0; j < max; j++){
				System.out.print(tex[i][j]);
			}
			System.out.println();
		}
		// */

		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				System.out.print(tex[i % tex.length][j % tex[0].length]);
			}
			System.out.println();
		}


	}

}
