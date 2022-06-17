import java.util.*;
import java.io.*;

public class baek_1759 {
	static int L;
	static int C;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[] alphabet = new char[C];
		char[] pwd = new char[L];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);

		password(alphabet, pwd, 0, 0, 0);
		System.out.println(sb);
	}

	static void password(char[] alphabet, char[] pwd, int index, int count, int vowel) {

		if (count == L) {
			if (vowel >= 1 && L - vowel >= 2) {
				for (int i = 0; i < L; i++)
					sb.append(pwd[i]);
				sb.append('\n');
			}
			return;
		}
		for (int i = index; i < C; i++) {
			pwd[count] = alphabet[i];

			if (alphabet[i] == 'a' || alphabet[i] == 'e' || alphabet[i] == 'i' || alphabet[i] == 'o'
					|| alphabet[i] == 'u')
				password(alphabet, pwd, i + 1, count + 1, vowel + 1);
			else
				password(alphabet, pwd, i + 1, count + 1, vowel);
		}
	}
}
