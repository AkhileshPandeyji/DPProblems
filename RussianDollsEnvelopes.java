package dynamicProgCodes;

import java.util.Arrays;
import java.util.Scanner;

public class RussianDollsEnvelopes {
	static class Elope implements Comparable<Elope> {
		int w;
		int h;

		public int compareTo(Elope o) {
			return this.w - o.w;
		}
	}

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Elope[] elopes = new Elope[n];

		for (int i = 0; i < n; i++) {
			elopes[i] = new Elope();
			elopes[i].w = scn.nextInt();
			elopes[i].h = scn.nextInt();
		}

		Arrays.sort(elopes);
		int lisdp[] = new int[n];

		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (elopes[i].h > elopes[j].h && max < lisdp[j]) {
					max = lisdp[j];
				}
			}
			lisdp[i] = max + 1;
		}
		
		int lis=lisdp[0];
		
		for(int i=1;i<n;i++) {
			if(lisdp[i]>lis) {
				lis = lisdp[i];
			}
		}
		System.out.println(lis);
		scn.close();
	}
}
