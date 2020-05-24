package dynamicProgCodes;

import java.util.Scanner;

public class PaintFence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		
		int same[] = new int[n+1];
		int diff[] = new int[n+1];
		int tot[] = new int[n+1];
		
		diff[1] = k;
		tot[1]=k;		
		
		for(int i=2;i<=n;i++) {			
			same[i] = diff[i-1];
			diff[i] = tot[i-1]*(k-1);
			tot[i] = same[i]+diff[i];			
		}
		
		System.out.println(tot[n]);	
		scn.close();
	}
}
