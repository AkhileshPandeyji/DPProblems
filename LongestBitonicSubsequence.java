package dynamicProgCodes;

import java.util.Scanner;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int vals[] = new int[n];
		
		for(int i=0;i<n;i++) {
			vals[i] = scn.nextInt();
		}
		
		int lisdp[] = new int[n];
		int ldsdp[] = new int[n];
		
		int max = 0;
		
		for(int i=0;i<n;i++) {
			max = 0;
			for(int j=0;j<i;j++) {
				if(vals[i]>vals[j]) {
					if(max<lisdp[j]) {
						max = lisdp[j];
					}
				}
			}
			lisdp[i] = 1+max;
		}
		
		for(int i=n-1;i>=0;i--) {
			max = 0;
			for(int j=i+1;j<=n-1;j++) {
				if(vals[i]>vals[j]) {
					if(max<ldsdp[j]) {
						max = ldsdp[j];
					}
				}
			}
			ldsdp[i] = 1+max;
		}
		
		int ans = lisdp[0]+ldsdp[0]-1;
		
		for(int i=1;i<n;i++) {
			if(ans<lisdp[i]+ldsdp[i]-1) {
				ans = lisdp[i]+ldsdp[i]-1;
			}
		}
		
		System.out.println(ans);
		scn.close();
	}

}
