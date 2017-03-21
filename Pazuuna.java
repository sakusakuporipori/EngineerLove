package エンジニアでも恋がしたい;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Pazuuna {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String line = br.readLine();     //区間の長さとコマの長さを入力

		String[] length_koma = line.split(" ", 2);     //半角スペース区切り　領域は2
		int length = Integer.parseInt(length_koma[0]);     //区間の長さ
		int koma = Integer.parseInt(length_koma[1]);     //コマの長さ

		int[] komaScoreArray = new int[koma];      //区間ごとのコマの長さを格納する配列

		for (int i = 0; i < koma; i++) {
			String line2 = br.readLine();
			komaScoreArray[i] = Integer.parseInt(line2);
		}

		int[] lengthArray = new int[length];     //区間の長さだけコマの点数を格納する配列
		ArrayList<Integer> sumlengthArray = new ArrayList<Integer>();     //区間ごとのコマの合計点を格納する配列
		int sum = 0;     //コマの合計値を0で初期化しておく

		for (int j = 0; j < komaScoreArray.length; j++) {
			System.arraycopy(komaScoreArray, j, lengthArray, 0, length);     //komaScoreArrayの値をlengthArrayにコピー
			for (int a = 0; a < lengthArray.length; a++) {
				sum = sum + lengthArray[a];
			}
			sumlengthArray.add(sum);
			sum = 0;     //合計を0にすることでfor文の先頭に戻った時に続きから計算するのを回避する
			if (j == koma - length) {
				break;
			}
		}

		Collections.sort(sumlengthArray);     //最大値を出すためにソートする

		System.out.println(sumlengthArray.get(sumlengthArray.size()-1));
	}
}
