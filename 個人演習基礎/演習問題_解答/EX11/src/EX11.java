import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX11 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		//入力の準備
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// スケジュールのデータ
		String[][] schedule = null;

		//個人情報入力画面
		System.out.println("スケジュール管理アプリケーションへようこそ。");


		while(true){
			//メニューを表示
			System.out.println("**********メニュー**********");
			System.out.print("1)スケジュール追加\t2)スケジュール修正\t3)スケジュール削除\t4)スケジュール表示\t9)終了:");
			int menu = Integer.parseInt(br.readLine());

			switch(menu){
			case 1:
				//各データを入力
				System.out.println("スケジュールに登録するデータを入力してください。");
				System.out.print("日付(年/月/日 時:分)：");
				String datetime = br.readLine();
				System.out.print("スケジュール：");
				String contents = br.readLine();

				if(contents.length() > 0){
					//データを登録
					schedule = addSchedule(schedule, datetime, contents);
					System.out.println("登録しました。");
				}
				else{
					System.out.println("スケジュールの内容を入力してください。");
				}
				break;
			case 2:
				//各データを入力
				if(length(schedule) > 0){
					System.out.println("スケジュールを変更する内容を入力してください。");
					System.out.print("スケジュール番号：");
					String uid = br.readLine();

					//データを修正
					if(checkID(schedule, uid)){
						System.out.print("日付(年/月/日 時:分)：");
						String udatetime = br.readLine();
						System.out.print("スケジュール：");
						String ucontents = br.readLine();
						if(ucontents.length() > 0){
						schedule = updateSchedule(schedule, uid, udatetime, ucontents);
						System.out.println("修正しました。");
						}
						else{
							System.out.println("スケジュールの内容を入力してください。");
						}
					}
					else{
						System.out.println("IDが不正です。");
					}
				}
				else{
					System.out.println("スケジュールがありません。");
				}
				break;
			case 3:
				//削除するデータのIDを入力
				if(length(schedule) > 0){
					System.out.print("削除するスケジュールのIDを入力してください：");
					String did = br.readLine();

					//データを削除
					if(checkID(schedule, did)){
						schedule = deleteSchedule(schedule, did);
						System.out.println("削除しました。");
					}
					else{
						System.out.println("IDが不正です。");
					}
				}
				else{
					System.out.println("スケジュールがありません。");
				}
				break;
			case 4:
				//表示メニューを表示
				if(length(schedule) > 0){
					System.out.print("1)全件表示\t2)指定表示：");
					menu = Integer.parseInt(br.readLine());

					switch(menu){
					case 1:
						for(int i = 1; i <= schedule.length; i++){
							showSchedule(schedule, Integer.toString(i));
						}
						break;
					case 2:
						System.out.print("スケジュールIDを指定してください：");
						String id = br.readLine();
						if(checkID(schedule, id)){
							showSchedule(schedule, id);
						}
						else{
							System.out.println("IDが不正です。");
						}
						break;
					}
				}
				else{
					System.out.println("スケジュールがありません。");
				}
				break;
			case 9:
				//メッセージを表示して終了
				System.out.println("ありがとうございました。");
				System.exit(0);
				break;
			}
			//改行
			System.out.println();
		}
	}

	//1件分のデータを表示
	public static void showSchedule(String[][] data, String id){
		int i = Integer.parseInt(id) - 1;
		System.out.println();
		System.out.println("ID：" + id);
		System.out.println("日時：" + data[i][0]);
		System.out.println("スケジュール：" + data[i][1]);
	}

	// スケジュールを追加する
	private static String[][] addSchedule(String[][] schedule, String datetime, String contents) {
		// TODO 自動生成されたメソッド・スタブ
		schedule = upgrade(schedule);
		schedule[schedule.length - 1][0] = datetime;
		schedule[schedule.length - 1][1] = contents;
		return schedule;
	}

	// スケジュールを更新する
	private static String[][] updateSchedule(String[][] schedule, String uid, String udatetime, String ucontents) {
		// TODO 自動生成されたメソッド・スタブ
		schedule[Integer.parseInt(uid) - 1][0] = udatetime;
		schedule[Integer.parseInt(uid) - 1][1] = ucontents;
		return schedule;
	}

	// スケジュールを削除する
	private static String[][] deleteSchedule(String[][] schedule, String did) {
		// TODO 自動生成されたメソッド・スタブ
		String[][] newlist = schedule;
		newlist = new String[schedule.length - 1][2];
		int i = 0;
		int i2 = 0;
		while(i < schedule.length){
			if(i != Integer.parseInt(did) - 1){
				newlist[i2] = schedule[i];
				i2++;
			}
			i++;
		}
		return newlist;
	}

	// IDチェック
	public static boolean checkID(String[][] schedule, String id){
		boolean flg = false;

		if(length(schedule) > Integer.parseInt(id) - 1){
			flg = true;
		}

		return flg;
	}

	// 件数取得
	public static int length(String[][] list){
		int c = 0;
		if(list != null){
			c = list.length;
		}
		return c;
	}

	// 配列要素更新
	public static String[][] upgrade(String[][] list){
		String[][] newlist = null;
		if(length(list) == 0){
			newlist = new String[1][2];
		}
		else{
			newlist = new String[list.length + 1][2];
			for(int i = 0; i < list.length; i++){
				for(int j = 0; j < 2; j++){
					newlist[i][j] = list[i][j];
				}
			}
		}
		return newlist;
	}
}
