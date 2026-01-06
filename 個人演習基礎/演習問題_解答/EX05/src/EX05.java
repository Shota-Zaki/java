
public class EX05 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		for(int i = 3; i >= -3; i--){
			int n;
			if(i < 0){
				n = i * -1;
			}
			else{
				n = i;
			}
			for(int j = 0; j < n; j++){
				System.out.print("〇");
			}
			System.out.println();
		}
	}

}
