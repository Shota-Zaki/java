import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX09 {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		//入力の準備
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//個人情報入力画面
		System.out.println("住所管理アプリケーションへようこそ。");

		// 住所情報保存用配列
		String[][] list = new String[10][4];

		// 登録件数
		int count = 0;

		while(true){
			//メニューを表示
			System.out.println("**********メニュー**********");
			System.out.print("1)住所録追加\t2)住所録表示\t3)住所録検索\t9)終了:");
			int menu = Integer.parseInt(br.readLine());

			switch(menu){
			case 1:
				if(count == 10){
					System.out.println("これ以上登録できません。");
					break;
				}
				//各データを入力
				System.out.println("住所録に登録するデータを入力してください。");
				System.out.print("名前：");
				String name = br.readLine();
				System.out.print("住所：");
				String address = br.readLine();
				System.out.print("電話番号：");
				String tel = br.readLine();
				System.out.print("メールアドレス：");
				String mail = br.readLine();

				//データを登録
				setAddress(list, count, name, address, tel, mail);
				count++;
				System.out.println("登録しました。");
				break;
			case 2:
				//表示するデータを入力
				System.out.print("表示するアドレスの番号を入力してください。(1-"+ count + ")：");
				int index = Integer.parseInt(br.readLine()) - 1;
				if(index < count){
					//取得したデータを表示
					showAddress(list[index]);
				}
				else{
					System.out.println("範囲内の番号を指定してください。");
				}
				break;
			case 3:
				//検索するデータを入力
				System.out.print("検索するデータを入力してください：");
				String search = br.readLine();

				//データを検索
				int[] ilist = getAddress(list, search);

				//取得したデータを表示
				if(ilist != null){
					for(int i : ilist){
						showAddress(list[i]);
					}
				}
				else{
					System.out.println("該当するデータがありませんでした。");
				}
				break;
			case 9:
				//メッセージを表示して終了
				System.out.println("ありがとうございました。");
				System.exit(0);
			}
			//改行
			System.out.println();
		}
	}

	//住所データ追加
	public static void setAddress(String[][] list, int count, String name, String address, String tel, String mail) {
		list[count][0] = name;
		list[count][1] = address;
		list[count][2] = tel;
		list[count][3] = mail;
	}

	//住所録を表示する
	private static void showAddress(String[] data){
		System.out.println();
		System.out.println("名前：" + data[0]);
		System.out.println("住所：" + data[1]);
		System.out.println("電話番号：" + data[2]);
		System.out.println("メールアドレス：" + data[3]);
	}

	//住所データを検索する
	public static int[] getAddress(String[][] list, String search){
		int[] index = new int[list.length];
		int c = 0;
		for(int i = 0; i < 10; i++){
			if(list[i][0] == null){
				break;
			}
			for(int j = 0; j < 4; j++){
				if(list[i][j].indexOf(search) != -1){
					index[c] = i;
					c++;
					break;
				}
			}
		}
		int[] re = null;
		if(c != 0){
			re = new int[c];
			for(int i = 0; i < c; i++){
				re[i] = index[i];
			}
		}

		return re;
	}
}
