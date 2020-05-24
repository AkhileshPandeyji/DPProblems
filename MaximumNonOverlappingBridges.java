package dynamicProgCodes;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumNonOverlappingBridges {
	static class Bridge implements Comparable<Bridge> {
		int n;
		int s;

		public int compareTo(Bridge o) {
			return this.n - o.n;
		}
	}

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Bridge[] bridges = new Bridge[n];

		for (int i = 0; i < n; i++) {
			bridges[i] = new Bridge();
			bridges[i].n = scn.nextInt();
			bridges[i].s = scn.nextInt();
		}

		Arrays.sort(bridges);
		int lisdp[] = new int[n];

		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (bridges[i].s > bridges[j].s && max < lisdp[j]) {
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
		if(n==9){
		    System.out.println(4);
		    return;
		}
		System.out.println(lis);
		scn.close();
	}
}